package fr.npellegrin.xebia.mower.orientation;

/**
 * South orientation singleton.
 */
public final class SouthDirection implements Direction {
	private static Direction instance = new SouthDirection();

	public static Direction getInstance() {
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
