package fr.npellegrin.xebia.mower;

import fr.npellegrin.xebia.mower.orientation.Position;

/**
 * Yard description.
 */
public class Yard {
	private int lastCoordX;
	private int lastCoordY;

	public Yard(int lastCoordX, int lastCoordY) {
		this.lastCoordX = lastCoordX;
		this.lastCoordY = lastCoordY;
	}

	public boolean isIn(Position position) {
		return position.getX() >= 0
			&& position.getY() >= 0
			&& position.getX() <= lastCoordX
			&& position.getY() <= lastCoordY;
	}
}
