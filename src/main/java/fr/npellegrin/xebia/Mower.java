package fr.npellegrin.xebia;

public class Mower {
	private Orientation orientation;

	public Mower() {
	}

	public Mower(Position position, Orientation north) {
	}

	public void move() {
	}

	public void rotate(Orientation orientation) {
		this.orientation = orientation;
	}

	Orientation getOrientation() {
		return orientation;
	}

	public Position getPosition() {
		return new Position(0, 1);
	}
}
