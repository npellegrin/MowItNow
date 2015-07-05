package fr.npellegrin.xebia.mower.listener;

/**
 * Listener of mower messages.
 */
public interface MowerListener {
	void messageReceived(MowerBroadcastMessage message);
}
