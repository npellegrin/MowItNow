package fr.npellegrin.xebia.mower.orientation;

/**
 * Represents the orientation of a mower.
 */
public class Orientation {
	/**
	 * Direction vector.
	 */
	// protected for test purposes
	protected Direction direction;

	/**
	 * Instantiates an orientation with an initial direction.
	 */
	public Orientation(final Direction initialDirection) {
		this.direction = initialDirection;
	}

	/**
	 * Instantiates an orientation form another.
	 */
	public Orientation(final Orientation orientation) {
		this.direction = orientation.direction;
	}

	/**
	 * Rotate to left.
	 */
	public void rotateLeft() {
		direction = direction.getLeft();
	}

	/**
	 * Rotate to right.
	 */
	public void rotateRight() {
		direction = direction.getRight();
	}

	public int getXVector() {
		return direction.getXVector();
	}

	public int getYVector() {
		return direction.getYVector();
	}

}
