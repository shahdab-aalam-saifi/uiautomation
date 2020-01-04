package com.saalamsaifi.uiautomation.js;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Navigation {
	@JsonProperty(value = "TYPE_BACK_FORWARD")
	private int typeBackForward;

	@JsonProperty(value = "TYPE_NAVIGATE")
	private int typeNavigate;

	@JsonProperty(value = "TYPE_RELOAD")
	private int typeReload;

	@JsonProperty(value = "TYPE_RESERVED")
	private int typeReserved;

	private int redirectCount;
	private int type;

	public int getTypeBackForward() {
		return typeBackForward;
	}

	public void setTypeBackForward(int typeBackForward) {
		this.typeBackForward = typeBackForward;
	}

	public int getTypeNavigate() {
		return typeNavigate;
	}

	public void setTypeNavigate(int typeNavigate) {
		this.typeNavigate = typeNavigate;
	}

	public int getTypeReload() {
		return typeReload;
	}

	public void setTypeReload(int typeReload) {
		this.typeReload = typeReload;
	}

	public int getTypeReserved() {
		return typeReserved;
	}

	public void setTypeReserved(int typeReserved) {
		this.typeReserved = typeReserved;
	}

	public int getRedirectCount() {
		return redirectCount;
	}

	public void setRedirectCount(int redirectCount) {
		this.redirectCount = redirectCount;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Navigation [typeBackForward=" + typeBackForward + ", typeNavigate=" + typeNavigate + ", typeReload="
				+ typeReload + ", typeReserved=" + typeReserved + ", redirectCount=" + redirectCount + ", type=" + type
				+ "]";
	}

}
