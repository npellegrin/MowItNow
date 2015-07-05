package fr.npellegrin.xebia.mower.converter;

import fr.npellegrin.xebia.mower.controls.Instruction;
import fr.npellegrin.xebia.mower.controls.MoveForwardInstruction;
import fr.npellegrin.xebia.mower.controls.RotateLeftInstruction;
import fr.npellegrin.xebia.mower.controls.RotateRightInstruction;
import fr.npellegrin.xebia.mower.exceptions.InvalidInstructionException;
import fr.npellegrin.xebia.mower.parser.model.InstructionDefinition;

public class InstructionDefinitionToInstructionMapper implements Mapper<InstructionDefinition, Instruction> {

	@Override
	public Instruction map(InstructionDefinition input) {
		switch (input) {
		case A:
			return new MoveForwardInstruction();
		case D:
			return new RotateRightInstruction();
		case G:
			return new RotateLeftInstruction();
		default:
			throw new InvalidInstructionException(String.format("Instruction %s is invalid", input));
		}
	}

}
