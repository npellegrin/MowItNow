package fr.npellegrin.xebia.mower.orientation;

/**
 * North direction singleton.
 */
public final class NorthDirection implements Direction {
	private static Direction instance = new NorthDirection();

	public static Direction getInstance() {
		return instance;
	}

	@Override
	public int getXVector() {
		return 0;
	}

	@Override
	public int getYVector() {
		return 1;
	}

	@Override
	public Direction getLeft() {
		return WestDirection.getInstance();
	}

	@Override
	public Direction getRight() {
		return EastDirection.getInstance();
	}

}
