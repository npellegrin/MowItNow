package fr.npellegrin.xebia.mower.controls;

import fr.npellegrin.xebia.mower.Mower;

/**
 * Move mower forward.
 */
public class RotateRightInstruction implements Instruction {
	@Override
	public void applyOn(Mower mower) {
		mower.rotateRight();
	}
}
