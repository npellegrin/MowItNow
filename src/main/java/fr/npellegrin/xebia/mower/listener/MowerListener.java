package fr.npellegrin.xebia.mower.listener;

/**
 * Listener of mower messages.
 */
public interface MowerListener {
	public void messageReceived(MowerBroadcastMessage message);
}
