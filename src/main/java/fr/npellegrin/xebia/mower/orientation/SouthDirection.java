package fr.npellegrin.xebia.mower.orientation;

/**
 * South orientation singleton.
 */
public class SouthDirection implements Direction {
	private static Direction instance;

	private SouthDirection() {
	}

	public static Direction getInstance() {
		if (instance == null) {
			instance = new SouthDirection();
		}
		return instance;
	}

	@Override
	public int getXVector() {
		return 0;
	}

	@Override
	public int getYVector() {
		return -1;
	}

	@Override
	public Direction getLeft() {
		return EastDirection.getInstance();
	}

	@Override
	public Direction getRight() {
		return WestDirection.getInstance();
	}

}
