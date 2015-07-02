package fr.npellegrin.xebia.mower.orientation;

public class Position {
	private int x;
	private int y;

	public Position(int x, int y) {
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
	public Position tryPush(Orientation orientation) {
		return new Position(x + orientation.getXVector(), y + orientation.getYVector());
	}

}
