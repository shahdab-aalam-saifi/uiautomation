package com.saalamsaifi.uiautomation.js;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Performance {
	private Memory memory;
	private Navigation navigation;
	private double timeOrigin;
	private Timing timing;

	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	public Navigation getNavigation() {
		return navigation;
	}

	public void setNavigation(Navigation navigation) {
		this.navigation = navigation;
	}

	public double getTimeOrigin() {
		return timeOrigin;
	}

	public void setTimeOrigin(double timeOrigin) {
		this.timeOrigin = timeOrigin;
	}

	public Timing getTiming() {
		return timing;
	}

	public void setTiming(Timing timing) {
		this.timing = timing;
	}
	
	@Override
	public String toString() {
		return "Performance [" + (memory != null ? "memory=" + memory + ", " : "")
				+ (navigation != null ? "navigation=" + navigation + ", " : "") + "timeOrigin=" + timeOrigin + ", "
				+ (timing != null ? "timing=" + timing : "") + "]";
	}

}
