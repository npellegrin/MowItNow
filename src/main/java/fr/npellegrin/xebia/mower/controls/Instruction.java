package fr.npellegrin.xebia.mower.controls;

import fr.npellegrin.xebia.mower.Mower;

/**
 * Represents a mower instruction.
 */
public interface Instruction {
	public void applyOn(Mower mower);

}
