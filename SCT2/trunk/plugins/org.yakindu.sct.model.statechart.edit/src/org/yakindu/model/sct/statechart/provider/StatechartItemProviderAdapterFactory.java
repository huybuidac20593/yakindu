/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.model.sct.statechart.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.yakindu.model.sct.statechart.util.StatechartAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StatechartItemProviderAdapterFactory extends StatechartAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatechartItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.Region} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegionItemProvider regionItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.Region}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRegionAdapter() {
		if (regionItemProvider == null) {
			regionItemProvider = new RegionItemProvider(this);
		}

		return regionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.Transition} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionItemProvider transitionItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.Transition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTransitionAdapter() {
		if (transitionItemProvider == null) {
			transitionItemProvider = new TransitionItemProvider(this);
		}

		return transitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.FinalState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FinalStateItemProvider finalStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.FinalState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFinalStateAdapter() {
		if (finalStateItemProvider == null) {
			finalStateItemProvider = new FinalStateItemProvider(this);
		}

		return finalStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.State} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateItemProvider stateItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.State}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStateAdapter() {
		if (stateItemProvider == null) {
			stateItemProvider = new StateItemProvider(this);
		}

		return stateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.RealVariableValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RealVariableValueItemProvider realVariableValueItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.RealVariableValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRealVariableValueAdapter() {
		if (realVariableValueItemProvider == null) {
			realVariableValueItemProvider = new RealVariableValueItemProvider(this);
		}

		return realVariableValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.RealVariable} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RealVariableItemProvider realVariableItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.RealVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRealVariableAdapter() {
		if (realVariableItemProvider == null) {
			realVariableItemProvider = new RealVariableItemProvider(this);
		}

		return realVariableItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.ShallowHistoryState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ShallowHistoryStateItemProvider shallowHistoryStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.ShallowHistoryState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createShallowHistoryStateAdapter() {
		if (shallowHistoryStateItemProvider == null) {
			shallowHistoryStateItemProvider = new ShallowHistoryStateItemProvider(this);
		}

		return shallowHistoryStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.HistoryState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HistoryStateItemProvider historyStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.HistoryState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createHistoryStateAdapter() {
		if (historyStateItemProvider == null) {
			historyStateItemProvider = new HistoryStateItemProvider(this);
		}

		return historyStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.Junction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JunctionItemProvider junctionItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.Junction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJunctionAdapter() {
		if (junctionItemProvider == null) {
			junctionItemProvider = new JunctionItemProvider(this);
		}

		return junctionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.DeepHistoryState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeepHistoryStateItemProvider deepHistoryStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.DeepHistoryState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDeepHistoryStateAdapter() {
		if (deepHistoryStateItemProvider == null) {
			deepHistoryStateItemProvider = new DeepHistoryStateItemProvider(this);
		}

		return deepHistoryStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.BooleanVariable} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanVariableItemProvider booleanVariableItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.BooleanVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBooleanVariableAdapter() {
		if (booleanVariableItemProvider == null) {
			booleanVariableItemProvider = new BooleanVariableItemProvider(this);
		}

		return booleanVariableItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.BooleanVariableValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanVariableValueItemProvider booleanVariableValueItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.BooleanVariableValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBooleanVariableValueAdapter() {
		if (booleanVariableValueItemProvider == null) {
			booleanVariableValueItemProvider = new BooleanVariableValueItemProvider(this);
		}

		return booleanVariableValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.Join} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JoinItemProvider joinItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.Join}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJoinAdapter() {
		if (joinItemProvider == null) {
			joinItemProvider = new JoinItemProvider(this);
		}

		return joinItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.IntegerVariable} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerVariableItemProvider integerVariableItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.IntegerVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIntegerVariableAdapter() {
		if (integerVariableItemProvider == null) {
			integerVariableItemProvider = new IntegerVariableItemProvider(this);
		}

		return integerVariableItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.IntegerVariableValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerVariableValueItemProvider integerVariableValueItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.IntegerVariableValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIntegerVariableValueAdapter() {
		if (integerVariableValueItemProvider == null) {
			integerVariableValueItemProvider = new IntegerVariableValueItemProvider(this);
		}

		return integerVariableValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.Event} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventItemProvider eventItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.Event}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEventAdapter() {
		if (eventItemProvider == null) {
			eventItemProvider = new EventItemProvider(this);
		}

		return eventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.Choice} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChoiceItemProvider choiceItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.Choice}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createChoiceAdapter() {
		if (choiceItemProvider == null) {
			choiceItemProvider = new ChoiceItemProvider(this);
		}

		return choiceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.Statechart} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatechartItemProvider statechartItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.Statechart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStatechartAdapter() {
		if (statechartItemProvider == null) {
			statechartItemProvider = new StatechartItemProvider(this);
		}

		return statechartItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.Fork} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForkItemProvider forkItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.Fork}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createForkAdapter() {
		if (forkItemProvider == null) {
			forkItemProvider = new ForkItemProvider(this);
		}

		return forkItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.InitialState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InitialStateItemProvider initialStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.InitialState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInitialStateAdapter() {
		if (initialStateItemProvider == null) {
			initialStateItemProvider = new InitialStateItemProvider(this);
		}

		return initialStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.TimeEvent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeEventItemProvider timeEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.TimeEvent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTimeEventAdapter() {
		if (timeEventItemProvider == null) {
			timeEventItemProvider = new TimeEventItemProvider(this);
		}

		return timeEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.model.sct.statechart.ExpressionElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionElementItemProvider expressionElementItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.model.sct.statechart.ExpressionElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExpressionElementAdapter() {
		if (expressionElementItemProvider == null) {
			expressionElementItemProvider = new ExpressionElementItemProvider(this);
		}

		return expressionElementItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (regionItemProvider != null) regionItemProvider.dispose();
		if (transitionItemProvider != null) transitionItemProvider.dispose();
		if (finalStateItemProvider != null) finalStateItemProvider.dispose();
		if (stateItemProvider != null) stateItemProvider.dispose();
		if (realVariableValueItemProvider != null) realVariableValueItemProvider.dispose();
		if (realVariableItemProvider != null) realVariableItemProvider.dispose();
		if (shallowHistoryStateItemProvider != null) shallowHistoryStateItemProvider.dispose();
		if (historyStateItemProvider != null) historyStateItemProvider.dispose();
		if (junctionItemProvider != null) junctionItemProvider.dispose();
		if (deepHistoryStateItemProvider != null) deepHistoryStateItemProvider.dispose();
		if (booleanVariableItemProvider != null) booleanVariableItemProvider.dispose();
		if (booleanVariableValueItemProvider != null) booleanVariableValueItemProvider.dispose();
		if (joinItemProvider != null) joinItemProvider.dispose();
		if (integerVariableItemProvider != null) integerVariableItemProvider.dispose();
		if (integerVariableValueItemProvider != null) integerVariableValueItemProvider.dispose();
		if (eventItemProvider != null) eventItemProvider.dispose();
		if (choiceItemProvider != null) choiceItemProvider.dispose();
		if (statechartItemProvider != null) statechartItemProvider.dispose();
		if (forkItemProvider != null) forkItemProvider.dispose();
		if (initialStateItemProvider != null) initialStateItemProvider.dispose();
		if (timeEventItemProvider != null) timeEventItemProvider.dispose();
		if (expressionElementItemProvider != null) expressionElementItemProvider.dispose();
	}

}
