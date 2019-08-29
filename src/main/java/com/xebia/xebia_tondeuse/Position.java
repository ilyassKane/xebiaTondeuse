package com.xebia.xebia_tondeuse;

public class Position {

	private int x;

	private int y;

	private OrientationTondeuse orientation;

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

	public OrientationTondeuse getOrientation() {
		return orientation;
	}

	public void setOrientation(OrientationTondeuse orientation) {
		this.orientation = orientation;
	}

	public String changeOrientation(String direction) {
		String typeDirection = orientation.getOrientation() + direction;
		
		if ("ND".equals(typeDirection))
			setOrientation(OrientationTondeuse.EAST);
		else if ("NG".equals(typeDirection))
			setOrientation(OrientationTondeuse.WEST);

		else if ("ED".equals(typeDirection))
			setOrientation(OrientationTondeuse.SOUTH);
		else if ("EG".equals(typeDirection))
			setOrientation(OrientationTondeuse.NORTH);

		else if ("SD".equals(typeDirection))
			setOrientation(OrientationTondeuse.WEST);
		else if ("SG".equals(typeDirection))
			setOrientation(OrientationTondeuse.EAST);

		else if ("WD".equals(typeDirection))
			setOrientation(OrientationTondeuse.NORTH);
		else if ("WG".equals(typeDirection))
			setOrientation(OrientationTondeuse.SOUTH);
		return orientation.getOrientation();
	}

	public void avanceVersDirection(Pelouse pelouse) {
		if (OrientationTondeuse.NORTH.equals(orientation) && y <= pelouse.getLongeur() - 1) {
			y = y + 1;
		}
		if (OrientationTondeuse.EAST.equals(orientation) && x <= pelouse.getLargeur() - 1) {
			x = x + 1;
		}
		if (OrientationTondeuse.SOUTH.equals(orientation) && y >= 1) {
			y = y - 1;
		}
		if (OrientationTondeuse.WEST.equals(orientation) && x >= 1) {
			x = x - 1;
		}
	}

	@Override
	public String toString() {
		return x + " " + y + " " + orientation.getOrientation();
	}
}
