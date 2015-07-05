package fr.npellegrin.xebia.mower.utils;

import fr.npellegrin.xebia.mower.orientation.Direction;
import fr.npellegrin.xebia.mower.orientation.Orientation;

/**
 * Test class to increase visibility of direction.
 */
public class PublicOrientation extends Orientation {

	public PublicOrientation(final Direction initialDirection) {
		super(initialDirection);
	}

	public PublicOrientation(final Orientation orientation) {
		super(orientation);
	}

	public Direction getDirection() {
		return direction;
	}
}