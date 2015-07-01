package fr.npellegrin.xebia.mower.environment;

/**
 * East orientation singleton.
 */
public class WestOrientation implements Orientation {
	private static WestOrientation instance;
	private Direction vector;

	private WestOrientation() {
		this.vector = new Direction(-1, 0);
	}

	public static Orientation getInstance() {
		if (instance == null) {
			instance = new WestOrientation();
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
