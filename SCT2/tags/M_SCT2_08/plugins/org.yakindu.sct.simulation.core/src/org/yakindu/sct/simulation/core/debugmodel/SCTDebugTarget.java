/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.debugmodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.simulation.core.ISGraphExecutionBuilder;
import org.yakindu.sct.simulation.core.ISGraphExecutionFacade;
import org.yakindu.sct.simulation.core.ISGraphExecutionListener;
import org.yakindu.sct.simulation.core.SGraphSimulationSession;
import org.yakindu.sct.simulation.core.extensions.Extensions;
import org.yakindu.sct.simulation.core.extensions.IExtensionPoints;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTDebugTarget extends SCTDebugElement implements IDebugTarget,
		ISGraphExecutionListener {

	private IProcess process;

	private ILaunch launch;

	private ISGraphExecutionFacade facade;

	private SGraphSimulationSession session;

	private boolean stepping = false;
	private boolean terminated = false;
	private boolean suspended = false;

	private List<Region> activeRegions = new ArrayList<Region>();
	private List<Vertex> activeStates = new ArrayList<Vertex>();

	private final Statechart statechart;

	public SCTDebugTarget(ILaunch launch, Statechart statechart)
			throws CoreException {
		super(null, statechart.eResource().getURI().toPlatformString(true));
		this.launch = launch;
		this.statechart = statechart;

		DebugPlugin.getDefault().getBreakpointManager()
				.addBreakpointListener(this);

		createExecutionModel(statechart);

	}

	private void createExecutionModel(Statechart statechart) {
		ISGraphExecutionBuilder builder = getBuilder(statechart);
		facade = builder.build(statechart);
		facade.addExecutionListener(this);
		session = new SGraphSimulationSession(facade);
		new Thread(session).start();
		session.start();
	}

	protected ISGraphExecutionBuilder getBuilder(EObject context) {
		Extensions<ISGraphExecutionBuilder> extensions = new Extensions<ISGraphExecutionBuilder>(
				IExtensionPoints.EXECUTION_BUILDER);
		return extensions.getRegisteredProvider(context);
	}

	public IProcess getProcess() {
		return process;
	}

	public void stepOver() {
		fireEvent(new DebugEvent(getDebugTarget(), DebugEvent.STEP_OVER));
		session.singleStep();
	}

	public IThread[] getThreads() throws DebugException {
		List<SCTDebugThread> threads = new ArrayList<SCTDebugThread>();
		for (int i = activeRegions.size() - 1; i >= 0; i--) {
			threads.add(new SCTDebugThread(this, facade, getResourceString(),
					activeRegions.get(i)));
		}

		return threads.toArray(new IThread[] {});
	}

	public boolean hasThreads() throws DebugException {
		return true;
	}

	public String getName() throws DebugException {
		return facade.getId();
	}

	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		return false;
	}

	public boolean canTerminate() {
		return !terminated;
	}

	public boolean isTerminated() {
		return terminated;
	}

	public void terminate() throws DebugException {
		facade.removeExecutionListener(this);
		// activeStates = Collections.emptyList();
		fireEvent(new DebugEvent(getDebugTarget(), DebugEvent.TERMINATE));
		terminated = true;
		session.terminate();
	}

	public boolean canResume() {
		return suspended && !terminated;
	}

	public boolean canSuspend() {
		return !suspended && !terminated;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void resume() throws DebugException {
		fireEvent(new DebugEvent(this, DebugEvent.RESUME));
		fireChangeEvent(DebugEvent.CONTENT);
		session.resume();
		suspended = false;
	}

	public void suspend() throws DebugException {
		fireEvent(new DebugEvent(this, DebugEvent.SUSPEND));
		fireChangeEvent(DebugEvent.CONTENT);
		session.suspend();
		suspended = true;
	}

	public void breakpointAdded(IBreakpoint breakpoint) {
	}

	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
	}

	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
	}

	public boolean canDisconnect() {
		return false;
	}

	public void disconnect() throws DebugException {

	}

	public boolean isDisconnected() {
		return false;
	}

	public boolean supportsStorageRetrieval() {
		return false;
	}

	public IMemoryBlock getMemoryBlock(long startAddress, long length)
			throws DebugException {
		return null;
	}

	public ILaunch getLaunch() {
		return launch;
	}

	public IDebugTarget getDebugTarget() {
		return this;
	}

	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == SGraphSimulationSession.class)
			return session;
		if (adapter == ISGraphExecutionFacade.class)
			return facade;
		return super.getAdapter(adapter);
	}

	public boolean canStepOver() {
		return isSuspended() && !isTerminated();
	}

	public void stateEntered(Vertex vertex) {
		if (vertex instanceof State) {
			if (((State) vertex).isLeaf()) {
				activeStates.add(vertex);
				activeRegions.add(vertex.getParentRegion());
			}
		}
		fireChangeEvent(DebugEvent.CONTENT);
	}

	public void stateLeft(Vertex vertex) {
		if (vertex instanceof State) {
			activeStates.remove(vertex);
			if (((State) vertex).isLeaf()) {
				if (activeRegions.contains(vertex.getParentRegion()))
					activeRegions.remove(vertex.getParentRegion());
			}
		}
		fireChangeEvent(DebugEvent.CONTENT);
	}

	public void transitionFired(Transition transition) {
	}

	public void variableValueChanged(String variableName, Object value) {
	}

	public void eventRaised(String eventName) {
	}

	public boolean isStepping() {
		return stepping;
	}

	public List<Region> getActiveRegions() {
		return activeRegions;
	}

	public List<Vertex> getActiveStates() {
		return activeStates;
	}

	public List<Vertex> getActiveStatesForRegion(Region region) {
		List<Vertex> result = new ArrayList<Vertex>();
		for (Vertex vertex : activeStates) {
			if (EcoreUtil.isAncestor(region, vertex)) {
				result.addAll(getActiveHierachy(vertex));
			}

			Collections.reverse(result);
		}
		return result;

	}

	private Collection<? extends Vertex> getActiveHierachy(Vertex vertex) {
		List<Vertex> result = new ArrayList<Vertex>();
		result.add(vertex);
		EObject container = vertex.eContainer();
		while (container != null) {
			if (container instanceof State) {
				result.add((State) container);
			}
			container = container.eContainer();
		}
		return result;
	}

	public Statechart getStatechart() {
		return statechart;
	}

}
