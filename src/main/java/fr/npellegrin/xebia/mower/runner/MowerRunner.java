package fr.npellegrin.xebia.mower.runner;

import java.util.ArrayList;
import java.util.List;

import fr.npellegrin.xebia.mower.listener.MowerListener;
import fr.npellegrin.xebia.mower.parser.model.ParserDefinition;

public class MowerRunner {
	private final List<MowerListener> listeners;

	public MowerRunner() {
		listeners = new ArrayList<MowerListener>();
	}

	public void execute(ParserDefinition definition) {
		// TODO Auto-generated method stub
	}

	public void addMowerListener(MowerListener listener) {
		listeners.add(listener);
	}

}
