package fr.npellegrin.xebia.mower.converter;

import java.util.ArrayList;
import java.util.List;

import fr.npellegrin.xebia.mower.controls.Instruction;
import fr.npellegrin.xebia.mower.parser.model.InstructionDefinition;

/**
 * Map a list of instruction definition to a list of instructions.
 */
public class InstructionDefinitionListToInstructionListMapper
		implements ListMapper<InstructionDefinition, Instruction> {
	private final InstructionDefinitionToInstructionMapper instructionMapper;

	public InstructionDefinitionListToInstructionListMapper() {
		instructionMapper = new InstructionDefinitionToInstructionMapper();
	}

	@Override
	public List<Instruction> map(final List<InstructionDefinition> input) {
		// FIXME: use Java 8 stream() to simplify conversion
		final List<Instruction> result = new ArrayList<Instruction>();
		for (final InstructionDefinition instruction : input) {
			result.add(instructionMapper.map(instruction));
		}
		return result;
	}

}
