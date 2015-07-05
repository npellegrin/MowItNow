package fr.npellegrin.xebia.mower.controls;

import fr.npellegrin.xebia.mower.Mower;

/**
 * Move mower forward.
 */
public class RotateLeftInstruction implements Instruction {
	@Override
	public void applyOn(final Mower mower) {
		mower.rotateLeft();
	}
}
