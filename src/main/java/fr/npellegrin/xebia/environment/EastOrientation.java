package fr.npellegrin.xebia.environment;

/**
 * East orientation singleton.
 */
public class EastOrientation implements Orientation {
	private static EastOrientation instance;
	private Direction vector;

	private EastOrientation() {
		this.vector = new Direction(1, 0);
	}

	public static Orientation getInstance() {
		if (instance == null) {
			instance = new EastOrientation();
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
