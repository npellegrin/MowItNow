package fr.npellegrin.xebia.mower.parser.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Parsed instruction.
 */
public enum InstructionDefinition {
	A("A"), G("G"), D("D");

	private String value;

	private InstructionDefinition(String value) {
		this.value = value;
	}

	/**
	 * Map of String representation -> instruction.
	 */
	public static Map<String, InstructionDefinition> instructionMap() {
		Map<String, InstructionDefinition> result = new HashMap<String, InstructionDefinition>();
		for (InstructionDefinition instruction : InstructionDefinition.values()) {
			result.put(instruction.value, instruction);
		}
		return result;
	}

	public String getValue() {
		return value;
	}

}
