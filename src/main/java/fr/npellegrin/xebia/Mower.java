package fr.npellegrin.xebia;

public class Mower {
	private Orientation orientation;
	private Position position;

	public Mower() {
	}

	public Mower(Position position, Orientation orientation) {
		this.position = position;
		this.orientation = orientation;
	}

	public void move() {
		switch (orientation) {
		case North:
			this.position = new Position(position.getX(), position.getY() + 1);
			break;
		case South:
			this.position = new Position(position.getX(), position.getY() - 1);
			break;
		case East:
			this.position = new Position(position.getX() + 1, position.getY());
			break;
		case West:
			this.position = new Position(position.getX() - 1, position.getY());
			break;
		}
	}

	public void rotate(Orientation orientation) {
		this.orientation = orientation;
	}

	Orientation getOrientation() {
		return orientation;
	}

	public Position getPosition() {
		return position;
	}
}
