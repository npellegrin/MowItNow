package fr.npellegrin.xebia.mower;

import java.util.ArrayList;
import java.util.List;

import fr.npellegrin.xebia.mower.controls.Instruction;
import fr.npellegrin.xebia.mower.environment.Position;
import fr.npellegrin.xebia.mower.environment.Yard;
import fr.npellegrin.xebia.mower.listener.MowerBroadcastMessage;
import fr.npellegrin.xebia.mower.listener.MowerListener;
import fr.npellegrin.xebia.mower.orientation.Orientation;

public class Mower {
	private final Yard yard;
	// Protected for tests purposes
	protected Position position;
	// Protected for tests purposes
	protected Orientation orientation;
	private final List<MowerListener> listeners;

	public Mower(final Yard yard, final Position position, final Orientation orientation) {
		this.yard = yard;
		this.position = position;
		this.orientation = orientation;
		this.listeners = new ArrayList<MowerListener>();
	}

	/**
	 * Constructor for test purposes.
	 */
	protected Mower(final Mower mower) {
		this.yard = mower.yard;
		this.position = mower.position;
		this.orientation = mower.orientation;
		this.listeners = mower.listeners;
	}

	/**
	 * Move mower according a list of instructions.
	 */
	public void accept(final List<Instruction> instructionList) {
		// Execute all instructions
		for (final Instruction instruction : instructionList) {
			instruction.applyOn(this);
		}
		// Notify final position
		this.broadcastPosition();
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
		// Compute next position
		final Position nextPosition = position.tryPush(orientation);

		// Set position if valid
		if (yard.isIn(nextPosition)) {
			position = nextPosition;
		}
	}

	/**
	 * Add a listener to mower (will receive final position).
	 */
	public void addMowerListener(final MowerListener listener) {
		listeners.add(listener);
	}

	/**
	 * Add a list of listeners to mower.
	 */
	public void addMowerListeners(final List<MowerListener> listenerList) {
		listeners.addAll(listenerList);
	}

	/**
	 * Send the position to ass listeners.
	 */
	private void broadcastPosition() {
		final MowerBroadcastMessage message = new MowerBroadcastMessage();
		message.setOrientation(orientation);
		message.setPosition(position);
		notifyListeners(message);
	}

	/**
	 * Notify all listeners with a message.
	 */
	private void notifyListeners(final MowerBroadcastMessage message) {
		for (final MowerListener listener : listeners) {
			listener.messageReceived(message);
		}
	}

}
