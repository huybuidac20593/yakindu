package com.yakindu.statechart.runtime;

public class ConstantTimeEvent extends TimeEvent {
	private long duration = -1;

	public ConstantTimeEvent(String id, long duration) {
		super(id);
		this.duration = duration;
	}

	public long getDuration() {
		return duration;
	}
}
