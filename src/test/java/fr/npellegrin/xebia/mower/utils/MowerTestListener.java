package fr.npellegrin.xebia.mower.utils;

import java.util.ArrayList;
import java.util.List;

import fr.npellegrin.xebia.mower.listener.MowerBroadcastMessage;
import fr.npellegrin.xebia.mower.listener.MowerListener;

/**
 * Test listener to retrieve mower positions.
 */
public class MowerTestListener implements MowerListener {
	// list of received messages
	private final List<MowerBroadcastMessage> messageList = new ArrayList<MowerBroadcastMessage>();

	public List<MowerBroadcastMessage> getMessageList() {
		return messageList;
	}

	@Override
	public void messageReceived(final MowerBroadcastMessage message) {
		messageList.add(message);
	}
}
