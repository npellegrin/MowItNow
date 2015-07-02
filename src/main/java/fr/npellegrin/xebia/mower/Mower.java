package fr.npellegrin.xebia.mower;

import fr.npellegrin.xebia.mower.controls.Instruction;
import fr.npellegrin.xebia.mower.orientation.Orientation;
import fr.npellegrin.xebia.mower.orientation.Position;

public class Mower {
	private Yard yard;
	private Orientation orientation;
	private Position position;

	public Mower(Yard yard, Position position, Orientation orientation) {
		this.yard = yard;
		this.position = position;
		this.orientation = orientation;
	}

	/**
	 * Move mower according given instruction.
	 */
	public void accept(Instruction instruction) {
		instruction.applyOn(this);
	}

	/**
	 * Rotate mower on right.
	 */
	public void rotateRight() {
		orientation.rotateRight();
	}

	/**
	 * Rotate mower on left.
	 */
	public void rotateLeft() {
		orientation.rotateLeft();
	}

	/**
	 * Move mower forward (depends orientation).
	 */
	public void move() {
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
