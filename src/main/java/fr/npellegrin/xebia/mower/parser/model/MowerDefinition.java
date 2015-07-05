package fr.npellegrin.xebia.mower.parser.model;

import java.util.ArrayList;
import java.util.List;

public class MowerDefinition {
	private PositionDefinition initialPosition;
	private final List<InstructionDefinition> instructionDefinitions;

	public MowerDefinition() {
		instructionDefinitions = new ArrayList<InstructionDefinition>();
	}

	public PositionDefinition getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(final PositionDefinition initialPosition) {
		this.initialPosition = initialPosition;
	}

	public List<InstructionDefinition> getInstructionDefinitions() {
		return instructionDefinitions;
	}

	public void addInstructionDefinition(final InstructionDefinition instruction) {
		instructionDefinitions.add(instruction);
	}
}
