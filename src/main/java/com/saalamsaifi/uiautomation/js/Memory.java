package com.saalamsaifi.uiautomation.js;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Memory {
	private long jsHeapSizeLimit;
	private long totalJSHeapSize;
	private long usedJSHeapSize;

	public long getJsHeapSizeLimit() {
		return jsHeapSizeLimit;
	}

	public void setJsHeapSizeLimit(long jsHeapSizeLimit) {
		this.jsHeapSizeLimit = jsHeapSizeLimit;
	}

	public long getTotalJSHeapSize() {
		return totalJSHeapSize;
	}

	public void setTotalJSHeapSize(long totalJSHeapSize) {
		this.totalJSHeapSize = totalJSHeapSize;
	}

	public long getUsedJSHeapSize() {
		return usedJSHeapSize;
	}

	public void setUsedJSHeapSize(long usedJSHeapSize) {
		this.usedJSHeapSize = usedJSHeapSize;
	}

	@Override
	public String toString() {
		return "Memory [jsHeapSizeLimit=" + jsHeapSizeLimit + ", totalJSHeapSize=" + totalJSHeapSize
				+ ", usedJSHeapSize=" + usedJSHeapSize + "]";
	}

}
