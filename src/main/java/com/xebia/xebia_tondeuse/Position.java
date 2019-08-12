package com.xebia.xebia_tondeuse;

public class Position {

	private int x;

	private int y;

	private String orientation;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String changeOrientation(String direction) {
		String typeDirection = orientation + direction;
		if ("ND".equals(typeDirection))
			setOrientation("E");
		else if ("NG".equals(typeDirection))
			setOrientation("W");

		else if ("ED".equals(typeDirection))
			setOrientation("S");
		else if ("EG".equals(typeDirection))
			setOrientation("N");

		else if ("SD".equals(typeDirection))
			setOrientation("W");
		else if ("SG".equals(typeDirection))
			setOrientation("E");

		else if ("WD".equals(typeDirection))
			setOrientation("N");
		else if ("WG".equals(typeDirection))
			setOrientation("S");
		return orientation;
	}

	public void avanceVersDirection(Pelouse pelouse) {
		if ("N".equals(orientation) && y <= pelouse.getLongeur() - 1) {
			y = y + 1;
		}
		if ("E".equals(orientation) && x <= pelouse.getLargeur() - 1) {
			x = x + 1;
		}
		if ("S".equals(orientation) && y >= 1) {
			y = y - 1;
		}
		if ("W".equals(orientation) && x >= 1) {
			x = x - 1;
		}
	}

	@Override
	public String toString() {
		return x + " " + y + " " + orientation;
	}
}
