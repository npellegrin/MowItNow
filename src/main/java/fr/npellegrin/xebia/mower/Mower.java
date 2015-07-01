package fr.npellegrin.xebia.mower;

import fr.npellegrin.xebia.mower.environment.EastOrientation;
import fr.npellegrin.xebia.mower.environment.NorthOrientation;
import fr.npellegrin.xebia.mower.environment.Orientation;
import fr.npellegrin.xebia.mower.environment.Position;
import fr.npellegrin.xebia.mower.environment.SouthOrientation;
import fr.npellegrin.xebia.mower.environment.WestOrientation;

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
		case "G":
			rotateLeft();
			break;
		}
	}

	/**
	 * Rotate mower on right.
	 */
	private void rotateRight() {
		if (NorthOrientation.getInstance().equals(orientation)) {
			orientation = EastOrientation.getInstance();
		} else if (EastOrientation.getInstance().equals(orientation)) {
			orientation = SouthOrientation.getInstance();
		} else if (SouthOrientation.getInstance().equals(orientation)) {
			orientation = WestOrientation.getInstance();
		} else if (WestOrientation.getInstance().equals(orientation)) {
			orientation = NorthOrientation.getInstance();
		}
	}

	/**
	 * Rotate mower on left.
	 */
	private void rotateLeft() {
		if (NorthOrientation.getInstance().equals(orientation)) {
			orientation = WestOrientation.getInstance();
		} else if (WestOrientation.getInstance().equals(orientation)) {
			orientation = SouthOrientation.getInstance();
		} else if (SouthOrientation.getInstance().equals(orientation)) {
			orientation = EastOrientation.getInstance();
		} else if (EastOrientation.getInstance().equals(orientation)) {
			orientation = NorthOrientation.getInstance();
		}
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
