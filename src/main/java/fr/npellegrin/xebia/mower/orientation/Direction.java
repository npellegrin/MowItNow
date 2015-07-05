package fr.npellegrin.xebia.mower.orientation;

/**
 * Represents the mower direction.
 */
public interface Direction {
	/**
	 * Get force on X axis.
	 */
	int getXVector();

	/**
	 * Get force on Y axis.
	 */
	int getYVector();

	/**
	 * Get the direction at the left.
	 */
	Direction getLeft();

	/**
	 * Get the direction at the right.
	 */
	Direction getRight();
}
