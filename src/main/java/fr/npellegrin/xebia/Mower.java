package fr.npellegrin.xebia;

import fr.npellegrin.xebia.environment.EastOrientation;
import fr.npellegrin.xebia.environment.Orientation;
import fr.npellegrin.xebia.environment.Position;

public class Mower {
	private Orientation orientation;
	private Position position;

	public Mower(Position position, Orientation orientation) {
		this.position = position;
		this.orientation = orientation;
	}

	/**
	 * Move mower according given instruction.
	 */
	public void accept(String instruction) {
		switch (instruction) {
		case "A":
			move();
			break;
		case "D":
			rotateRight();
			break;
		}
	}

	private void rotateRight() {
		orientation = EastOrientation.getInstance();
	}

	/**
	 * Move mower forward (depends orientation).
	 */
	private void move() {
		position.push(orientation);
	}

	/**
	 * Rotate mower (change orientation).
	 */
	private void rotate(Orientation orientation) {
		this.orientation = orientation;
	}

	/**
	 * Orientation getter.
	 */
	public Orientation getOrientation() {
		return orientation;
	}

	/**
	 * Position getter.
	 */
	public Position getPosition() {
		return position;
	}
}
