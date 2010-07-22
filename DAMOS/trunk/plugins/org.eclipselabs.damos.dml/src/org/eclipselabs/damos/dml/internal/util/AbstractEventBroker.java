/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.dml.internal.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.util.DMLUtil;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractEventBroker<L> extends EContentAdapter {
	
	private final WeakReference<AbstractEventBroker<L>> instanceReference = new WeakReference<AbstractEventBroker<L>>(this);
	
	protected Map<EObject, ListenerList> listenerMap = new WeakHashMap<EObject, ListenerList>();
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public final void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		if (!listenerMap.isEmpty()) {
			handleNotification(notification);
		}
	}
	
	protected abstract void handleNotification(Notification notification);
	
	protected static <L> void addListener(EObject eObject, L listener, Map<L, List<WeakReference<AbstractEventBroker<L>>>> instanceMap, Class<? extends AbstractEventBroker<L>> clazz) {
		Adapter adapter = EcoreUtil.getAdapter(eObject.eAdapters(), clazz);
		AbstractEventBroker<L> broker;
		if (adapter == null) {
			try {
				broker = clazz.newInstance();
			} catch (IllegalAccessException e) {
				throw new WrappedException(e);
			} catch (InstantiationException e) {
				throw new WrappedException(e);
			}
			DMLUtil.getRootNotifier(eObject).eAdapters().add(broker);
		} else {
			broker = clazz.cast(adapter);
		}
		broker.addListener(eObject, listener, instanceMap);
	}
	
	protected void addListener(EObject eObject, L listener, Map<L, List<WeakReference<AbstractEventBroker<L>>>> instanceMap) {
		boolean added = false;
		ListenerList listeners = listenerMap.get(eObject);
		if (listeners == null) {
			listeners = new ListenerList();
			listeners.add(listener);
			listenerMap.put(eObject, listeners);
			added = true;
		} else if (!listeners.contains(listener)) {
			listeners.add(listener);
			added = true;
		}
		if (added) {
			synchronized (instanceMap) {
				List<WeakReference<AbstractEventBroker<L>>> brokers = instanceMap.get(listener);
				if (brokers == null) {
					brokers = new ArrayList<WeakReference<AbstractEventBroker<L>>>();
					instanceMap.put(listener, brokers);
				}
				brokers.add(instanceReference);
			}
		}
	}
	
	protected static <L> void removeListener(EObject eObject, L listener, Map<L, List<WeakReference<AbstractEventBroker<L>>>> instanceMap, Class<? extends AbstractEventBroker<L>> clazz) {
		Adapter adapter = EcoreUtil.getAdapter(eObject.eAdapters(), clazz);
		if (adapter != null) {
			clazz.cast(adapter).removeListener(eObject, listener, instanceMap);
		}
	}

	protected void removeListener(EObject eObject, L listener, Map<L, List<WeakReference<AbstractEventBroker<L>>>> instanceMap) {
		ListenerList listeners = listenerMap.get(eObject);
		if (listeners != null) {
			boolean removed = false;
			if (listeners.getSingletonListener() == listener) {
				listenerMap.remove(eObject);
				removed = true;
			} else {
				removed = listeners.remove(listener);
			}
			if (removed) {
				synchronized (instanceMap) {
					List<WeakReference<AbstractEventBroker<L>>> brokers = instanceMap.get(listener);
					if (brokers != null) {
						if (brokers.size() == 1 && brokers.get(0) == instanceReference) {
							instanceMap.remove(listener);
						} else {
							brokers.remove(instanceReference);
						}
					}
				}
			}
		}
	}
	
	protected static <L> void removeListener(L listener, Map<L, List<WeakReference<AbstractEventBroker<L>>>> instanceMap) {
		List<WeakReference<AbstractEventBroker<L>>> brokers;
		synchronized (instanceMap) {
			brokers = instanceMap.remove(listener);
		}
		if (brokers != null) {
			for (WeakReference<AbstractEventBroker<L>> brokerReference : brokers) {
				AbstractEventBroker<L> broker = brokerReference.get();
				if (broker != null) {
					broker.removeListener(listener);
				}
			}
		}
	}
	
	private void removeListener(L listener) {
		for (Iterator<ListenerList> it = listenerMap.values().iterator(); it.hasNext();) {
			ListenerList listeners = it.next();
			if (listeners.getSingletonListener() == listener) {
				it.remove();
			} else {
				listeners.removeAny(listener);
				if (listeners.isEmpty()) {
					it.remove();
				}
			}
		}
	}
		
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == getClass();
	}

	protected class ListenerList extends ArrayList<L> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public L getSingletonListener() {
			return size() == 1 ? get(0) : null;
		}
		
		public void removeAny(L listener) {
			for (Iterator<L> it = iterator(); it.hasNext();) {
				if (it.next() == listener) {
					it.remove();
				}
			}
		}

	}
	
}
