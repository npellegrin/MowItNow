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

	/**
	 * Move mower according given instruction.
	 */
	public void accept(String instruction) {
		switch (instruction) {
		case "A":
			move();
		}
	}

	// FIXME: will became private
	public void move() {
		position.push(orientation);
	}

	// FIXME: will became private
	public void rotate(Orientation orientation) {
		this.orientation = orientation;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public Position getPosition() {
		return position;
	}
}
