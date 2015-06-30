package fr.npellegrin.xebia;

import fr.npellegrin.xebia.environment.Orientation;
import fr.npellegrin.xebia.environment.Position;

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
		position.push(orientation);
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
