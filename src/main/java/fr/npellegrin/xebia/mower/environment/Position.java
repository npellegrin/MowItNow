package fr.npellegrin.xebia.mower.environment;

import fr.npellegrin.xebia.mower.orientation.Orientation;

/**
 * Represents the mower position.
 */
public class Position {
	private final int x;
	private final int y;

	public Position(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	/**
	 * Get next position when pushing object with a given orientation.
	 */
	public Position tryPush(final Orientation orientation) {
		return new Position(x + orientation.getXVector(), y + orientation.getYVector());
	}

}
