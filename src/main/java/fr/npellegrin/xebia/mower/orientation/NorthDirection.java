package fr.npellegrin.xebia.mower.orientation;

/**
 * North direction singleton.
 */
public class NorthDirection implements Direction {
	private static Direction instance;

	private NorthDirection() {
	}

	public static Direction getInstance() {
		if (instance == null) {
			instance = new NorthDirection();
		}
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
