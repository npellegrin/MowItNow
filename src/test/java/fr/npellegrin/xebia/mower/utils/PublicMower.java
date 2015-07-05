package fr.npellegrin.xebia.mower.utils;

import fr.npellegrin.xebia.mower.Mower;
import fr.npellegrin.xebia.mower.environment.Position;
import fr.npellegrin.xebia.mower.orientation.Orientation;

/**
 * Mower subclass to access private attributes.
 */
public class PublicMower extends Mower {

	public PublicMower(final Mower mower) {
		super(mower);
	}

	public Position getPosition() {
		return position;
	}

	public Orientation getOrientation() {
		return orientation;
	}

}
