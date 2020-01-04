package com.saalamsaifi.uiautomation.js;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Timing {
	private long connectEnd;
	private long connectStart;
	private long domComplete;
	private long domContentLoadedEventEnd;
	private long domContentLoadedEventStart;
	private long domInteractive;
	private long domLoading;
	private long domainLookupEnd;
	private long domainLookupStart;
	private long fetchStart;
	private long loadEventEnd;
	private long loadEventStart;
	private long navigationStart;
	private long redirectEnd;
	private long redirectStart;
	private long requestStart;
	private long responseEnd;
	private long responseStart;
	private long secureConnectionStart;
	private long unloadEventEnd;
	private long unloadEventStart;

	public long getConnectEnd() {
		return connectEnd;
	}

	public void setConnectEnd(long connectEnd) {
		this.connectEnd = connectEnd;
	}

	public long getConnectStart() {
		return connectStart;
	}

	public void setConnectStart(long connectStart) {
		this.connectStart = connectStart;
	}

	public long getDomComplete() {
		return domComplete;
	}

	public void setDomComplete(long domComplete) {
		this.domComplete = domComplete;
	}

	public long getDomContentLoadedEventEnd() {
		return domContentLoadedEventEnd;
	}

	public void setDomContentLoadedEventEnd(long domContentLoadedEventEnd) {
		this.domContentLoadedEventEnd = domContentLoadedEventEnd;
	}

	public long getDomContentLoadedEventStart() {
		return domContentLoadedEventStart;
	}

	public void setDomContentLoadedEventStart(long domContentLoadedEventStart) {
		this.domContentLoadedEventStart = domContentLoadedEventStart;
	}

	public long getDomInteractive() {
		return domInteractive;
	}

	public void setDomInteractive(long domInteractive) {
		this.domInteractive = domInteractive;
	}

	public long getDomLoading() {
		return domLoading;
	}

	public void setDomLoading(long domLoading) {
		this.domLoading = domLoading;
	}

	public long getDomainLookupEnd() {
		return domainLookupEnd;
	}

	public void setDomainLookupEnd(long domainLookupEnd) {
		this.domainLookupEnd = domainLookupEnd;
	}

	public long getDomainLookupStart() {
		return domainLookupStart;
	}

	public void setDomainLookupStart(long domainLookupStart) {
		this.domainLookupStart = domainLookupStart;
	}

	public long getFetchStart() {
		return fetchStart;
	}

	public void setFetchStart(long fetchStart) {
		this.fetchStart = fetchStart;
	}

	public long getLoadEventEnd() {
		return loadEventEnd;
	}

	public void setLoadEventEnd(long loadEventEnd) {
		this.loadEventEnd = loadEventEnd;
	}

	public long getLoadEventStart() {
		return loadEventStart;
	}

	public void setLoadEventStart(long loadEventStart) {
		this.loadEventStart = loadEventStart;
	}

	public long getNavigationStart() {
		return navigationStart;
	}

	public void setNavigationStart(long navigationStart) {
		this.navigationStart = navigationStart;
	}

	public long getRedirectEnd() {
		return redirectEnd;
	}

	public void setRedirectEnd(long redirectEnd) {
		this.redirectEnd = redirectEnd;
	}

	public long getRedirectStart() {
		return redirectStart;
	}

	public void setRedirectStart(long redirectStart) {
		this.redirectStart = redirectStart;
	}

	public long getRequestStart() {
		return requestStart;
	}

	public void setRequestStart(long requestStart) {
		this.requestStart = requestStart;
	}

	public long getResponseEnd() {
		return responseEnd;
	}

	public void setResponseEnd(long responseEnd) {
		this.responseEnd = responseEnd;
	}

	public long getResponseStart() {
		return responseStart;
	}

	public void setResponseStart(long responseStart) {
		this.responseStart = responseStart;
	}

	public long getSecureConnectionStart() {
		return secureConnectionStart;
	}

	public void setSecureConnectionStart(long secureConnectionStart) {
		this.secureConnectionStart = secureConnectionStart;
	}

	public long getUnloadEventEnd() {
		return unloadEventEnd;
	}

	public void setUnloadEventEnd(long unloadEventEnd) {
		this.unloadEventEnd = unloadEventEnd;
	}

	public long getUnloadEventStart() {
		return unloadEventStart;
	}

	public void setUnloadEventStart(long unloadEventStart) {
		this.unloadEventStart = unloadEventStart;
	}

	@Override
	public String toString() {
		return "Timing [connectEnd=" + connectEnd + ", connectStart=" + connectStart + ", domComplete=" + domComplete
				+ ", domContentLoadedEventEnd=" + domContentLoadedEventEnd + ", domContentLoadedEventStart="
				+ domContentLoadedEventStart + ", domInteractive=" + domInteractive + ", domLoading=" + domLoading
				+ ", domainLookupEnd=" + domainLookupEnd + ", domainLookupStart=" + domainLookupStart + ", fetchStart="
				+ fetchStart + ", loadEventEnd=" + loadEventEnd + ", loadEventStart=" + loadEventStart
				+ ", navigationStart=" + navigationStart + ", redirectEnd=" + redirectEnd + ", redirectStart="
				+ redirectStart + ", requestStart=" + requestStart + ", responseEnd=" + responseEnd + ", responseStart="
				+ responseStart + ", secureConnectionStart=" + secureConnectionStart + ", unloadEventEnd="
				+ unloadEventEnd + ", unloadEventStart=" + unloadEventStart + "]";
	}
}
