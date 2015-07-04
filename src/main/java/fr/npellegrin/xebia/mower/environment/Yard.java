package fr.npellegrin.xebia.mower.environment;

/**
 * Yard description.
 */
public class Yard {
	// Protected for test purpose
	protected int lastCoordX;
	protected int lastCoordY;

	public Yard(int lastCoordX, int lastCoordY) {
		this.lastCoordX = lastCoordX;
		this.lastCoordY = lastCoordY;
	}

	protected Yard(Yard yard) {
		this.lastCoordX = yard.lastCoordX;
		this.lastCoordY = yard.lastCoordY;
	}

	public boolean isIn(Position position) {
		return position.getX() >= 0
			&& position.getY() >= 0
			&& position.getX() <= lastCoordX
			&& position.getY() <= lastCoordY;
	}
}
