package com.xebia.xebia_tondeuse;

public enum OrientationTondeuse {

	NORTH("N"), EAST("E"), WEST("W"), SOUTH("S");

	private String orientation;

	private OrientationTondeuse(String orientation) {
		this.orientation = orientation;
	}

	public String getOrientation() {
		return orientation;
	}

}
