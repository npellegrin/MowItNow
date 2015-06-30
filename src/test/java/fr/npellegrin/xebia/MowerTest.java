package fr.npellegrin.xebia;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MowerTest {

	@Test
	public void should_rotate_north() {
		Mower mower = new Mower();
		mower.rotate(Orientation.North);
		assertThat(mower.getOrientation()).isEqualTo(Orientation.North);
	}

}
