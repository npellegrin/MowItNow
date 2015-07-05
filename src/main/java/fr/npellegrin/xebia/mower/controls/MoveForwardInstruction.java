package fr.npellegrin.xebia.mower.controls;

import fr.npellegrin.xebia.mower.Mower;

/**
 * Move mower forward.
 */
public class MoveForwardInstruction implements Instruction {
	@Override
	public void applyOn(final Mower mower) {
		mower.move();
	}
}
