package fr.npellegrin.xebia;

public class Mower {
	private Orientation orientation;

	public void rotate(Orientation orientation) {
		this.orientation = orientation;
	}

	Orientation getOrientation() {
		return orientation;
	}
}
