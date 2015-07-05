package fr.npellegrin.xebia.mower.orientation;

/**
 * Represents the mower direction.
 */
public interface Direction {
	/**
	 * Get force on X axis.
	 */
	public int getXVector();

	/**
	 * Get force on Y axis.
	 */
	public int getYVector();

	/**
	 * Get the direction at the left.
	 */
	public Direction getLeft();

	/**
	 * Get the direction at the right.
	 */
	public Direction getRight();

}
