/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.runtime.sgraph;

import org.yakindu.sct.simulation.runtime.ExecutionScope;
import org.yakindu.sct.simulation.runtime.stext.RTTriggerEvent;

public class TimeEventExpression extends org.yakindu.sct.simulation.runtime.sgraph.RTTimeEvent {

	protected RTTriggerEvent.TimeEvent timeEvent;
	protected ExecutionScope scope;

	public TimeEventExpression(String id, RTTriggerEvent.TimeEvent timeEvent, ExecutionScope scope) {
		super(id);
		this.timeEvent = timeEvent;
		this.scope = scope;
	}


		
	public RTTriggerEvent.TimeEvent getTimeEvent() {
			return timeEvent;
		}



	public void setTimeEvent(RTTriggerEvent.TimeEvent timeEvent) {
			this.timeEvent = timeEvent;
		}


	@Override
	public long getDuration() {
		return ((Integer)timeEvent.execute(scope)).longValue();
	}

	
}
