package fr.npellegrin.xebia.environment;

/**
 * South orientation singleton.
 */
public class SouthOrientation implements Orientation {
	private static SouthOrientation instance;
	private Direction vector;

	private SouthOrientation() {
		this.vector = new Direction(0, -1);
	}

	public static Orientation getInstance() {
		if (instance == null) {
			instance = new SouthOrientation();
		}
		return instance;
	}

	public int getXVector() {
		return vector.getX();
	}

	public int getYVector() {
		return vector.getY();
	}

}
