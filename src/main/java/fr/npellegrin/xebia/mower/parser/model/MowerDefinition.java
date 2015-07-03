package fr.npellegrin.xebia.mower.parser.model;

import java.util.List;

public class MowerDefinition {
	private PositionDefinition initialPosition;
	private List<InstructionDefinition> InstructionDefinitions;

	public PositionDefinition getInitialPosition() {
		return initialPosition;
	}

	public List<InstructionDefinition> getInstructionDefinitions() {
		return InstructionDefinitions;
	}

}
