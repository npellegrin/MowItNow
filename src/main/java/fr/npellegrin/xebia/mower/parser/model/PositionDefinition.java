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

	public void setX(final int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(final int y) {
		this.y = y;
	}

	public OrientationDefinition getOrientation() {
		return orientation;
	}

	public void setOrientation(final OrientationDefinition orientation) {
		this.orientation = orientation;
	}

}
