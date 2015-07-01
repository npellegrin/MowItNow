package fr.npellegrin.xebia.mower.orientation;

/**
 * East orientation singleton.
 */
public class WestDirection implements Direction {
	private static Direction instance;

	private WestDirection() {
	}

	public static Direction getInstance() {
		if (instance == null) {
			instance = new WestDirection();
		}
		return instance;
	}

	@Override
	public int getXVector() {
		return -1;
	}

	@Override
	public int getYVector() {
		return 0;
	}

	@Override
	public Direction getLeft() {
		return SouthDirection.getInstance();
	}

	@Override
	public Direction getRight() {
		return NorthDirection.getInstance();
	}

}
