package fr.npellegrin.xebia.mower;

import fr.npellegrin.xebia.mower.exceptions.InvalidInstructionException;
import fr.npellegrin.xebia.mower.orientation.Orientation;
import fr.npellegrin.xebia.mower.orientation.Position;

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
	public void accept(String instruction) throws InvalidInstructionException {
		switch (instruction) {
		case "A":
			move();
			break;
		case "D":
			rotateRight();
			break;
		case "G":
			rotateLeft();
			break;
		default:
			throw new InvalidInstructionException(String.format("Instruction %s is invalid for mower", instruction));
		}
	}

	/**
	 * Rotate mower on right.
	 */
	private void rotateRight() {
		orientation.rotateRight();
	}

	/**
	 * Rotate mower on left.
	 */
	private void rotateLeft() {
		orientation.rotateLeft();
	}

	/**
	 * Move mower forward (depends orientation).
	 */
	private void move() {
		position.push(orientation);
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
