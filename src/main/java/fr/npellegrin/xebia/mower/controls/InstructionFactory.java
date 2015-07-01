package fr.npellegrin.xebia.mower.controls;

import fr.npellegrin.xebia.mower.exceptions.InvalidInstructionException;

public class InstructionFactory {

	public Instruction buildFromString(String instruction) throws InvalidInstructionException {
		switch (instruction) {
		case "A":
			return new MoveForwardInstruction();
		case "D":
			return new RotateRightInstruction();
		case "G":
			return new RotateLeftInstruction();
		default:
			throw new InvalidInstructionException(String.format("Instruction %s is invalid for mower", instruction));
		}
	}

}
