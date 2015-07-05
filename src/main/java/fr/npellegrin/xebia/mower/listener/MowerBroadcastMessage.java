package fr.npellegrin.xebia.mower.listener;

import fr.npellegrin.xebia.mower.environment.Position;
import fr.npellegrin.xebia.mower.orientation.Orientation;

public class MowerBroadcastMessage {
	private Position position;
	private Orientation orientation;

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

}
