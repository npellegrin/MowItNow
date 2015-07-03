package fr.npellegrin.xebia.mower.parser.model;

/**
 * Parsed position.
 */
public class PositionDefinition {
	private int x;
	private int y;
	private OrientationDefinition orientation;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public OrientationDefinition getOrientation() {
		return orientation;
	}

}
