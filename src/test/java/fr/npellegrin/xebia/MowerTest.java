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

	@Test
	public void should_rotate_south() {
		Mower mower = new Mower();
		mower.rotate(Orientation.South);
		assertThat(mower.getOrientation()).isEqualTo(Orientation.South);
	}

	@Test
	public void should_rotate_east() {
		Mower mower = new Mower();
		mower.rotate(Orientation.East);
		assertThat(mower.getOrientation()).isEqualTo(Orientation.East);
	}

	@Test
	public void should_rotate_west() {
		Mower mower = new Mower();
		mower.rotate(Orientation.West);
		assertThat(mower.getOrientation()).isEqualTo(Orientation.West);
	}

}
