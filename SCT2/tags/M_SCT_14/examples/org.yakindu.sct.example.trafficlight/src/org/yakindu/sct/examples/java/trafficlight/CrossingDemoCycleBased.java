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
package org.yakindu.sct.examples.java.trafficlight;

/**
 * Example to show how to integrate the generated statemachine code into existing projects.
 * 
 * @author a.nyssen - initial API and implementation
 * @author m.muehlbrandt - adaptions to new statemachine code.
 * @author terfloth - refactoring
 */
import org.yakindu.sct.runtime.java.TimerService;
import org.yakindu.sct.runtime.java.trafficlightwaiting.TrafficLightWaitingCycleBasedStatemachine;

public class CrossingDemoCycleBased extends CrossingDemoBase {

	
	public static void main(String[] args) {
		
		new CrossingDemoCycleBased().runTrafficLight();
	}

	
	@Override
	protected void setUpAndRunStatemachine() {
		
		statemachine = new TrafficLightWaitingCycleBasedStatemachine();
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				// Initialize the statemachine. Define TimerHandler and
				// enterSequence. A default TimerHandler generated by the Java
				// Generator is used in this case. You can add your own
				// implementation of a TimerHandler. It has to implement the
				// ITimerHandler interface.
				statemachine.setTimerService(new TimerService());
				statemachine.enter();
				while (!isInterrupted()) {
					statemachine.runCycle();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						interrupt();
					}
				}
			}
		};
		thread.start();
	}


	@Override
	protected void tearDownStatemachine() {
		// End TimerHandler and timing thread.
		statemachine.getTimerService() .cancel();
	}


	@Override
	protected void readStatemachineOutput() {
		trafficLightFigure.setRed(statemachine.getInterfaceTrafficLight().getVarRed());
		trafficLightFigure.setYellow(statemachine.getInterfaceTrafficLight().getVarYellow());
		trafficLightFigure.setGreen(statemachine.getInterfaceTrafficLight().getVarGreen());
	
		pedestrianLightFigure.setWhite(statemachine.getInterfacePedestrian().getVarRequest());
		pedestrianLightFigure.setRed(statemachine.getInterfacePedestrian().getVarRed());
		pedestrianLightFigure.setGreen(statemachine.getInterfacePedestrian().getVarGreen());
	}


	@Override
	protected void pedestrianRequestButtonClicked() {
		statemachine.raisePedestrianRequest(); // raise event in statemachine
	}


	@Override
	protected void onOffButtonClicked() {
		statemachine.raiseOnOff(); // raise event in statemachine
	}
	
	
	
	
}
