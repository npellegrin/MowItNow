package fr.npellegrin.xebia.environment;

/**
 * North orientation singleton.
 */
public class NorthOrientation implements Orientation {
	private static NorthOrientation instance;
	private Direction vector;

	private NorthOrientation() {
		this.vector = new Direction(0, 1);
	}

	public static Orientation getInstance() {
		if (instance == null) {
			instance = new NorthOrientation();
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
