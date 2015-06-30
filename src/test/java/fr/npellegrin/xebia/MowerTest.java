package fr.npellegrin.xebia;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import fr.npellegrin.xebia.environment.EastOrientation;
import fr.npellegrin.xebia.environment.NorthOrientation;
import fr.npellegrin.xebia.environment.Position;
import fr.npellegrin.xebia.environment.SouthOrientation;
import fr.npellegrin.xebia.environment.WestOrientation;

public class MowerTest {

	@Test
	public void should_rotate_north() {
		Mower mower = new Mower();
		mower.rotate(NorthOrientation.getInstance());
		assertThat(mower.getOrientation()).isEqualTo(NorthOrientation.getInstance());
	}

	@Test
	public void should_rotate_south() {
		Mower mower = new Mower();
		mower.rotate(SouthOrientation.getInstance());
		assertThat(mower.getOrientation()).isEqualTo(SouthOrientation.getInstance());
	}

	@Test
	public void should_rotate_east() {
		Mower mower = new Mower();
		mower.rotate(EastOrientation.getInstance());
		assertThat(mower.getOrientation()).isEqualTo(EastOrientation.getInstance());
	}

	@Test
	public void should_rotate_west() {
		Mower mower = new Mower();
		mower.rotate(WestOrientation.getInstance());
		assertThat(mower.getOrientation()).isEqualTo(WestOrientation.getInstance());
	}

	@Test
	public void should_move_north() {
		Mower mower = new Mower(new Position(0, 0), NorthOrientation.getInstance());
		mower.move();
		assertThat(mower.getPosition().getX()).isEqualTo(0);
		assertThat(mower.getPosition().getY()).isEqualTo(1);
	}

	@Test
	public void should_move_south() {
		Mower mower = new Mower(new Position(0, 0), SouthOrientation.getInstance());
		mower.move();
		assertThat(mower.getPosition().getX()).isEqualTo(0);
		assertThat(mower.getPosition().getY()).isEqualTo(-1);
	}

	@Test
	public void should_move_east() {
		Mower mower = new Mower(new Position(0, 0), EastOrientation.getInstance());
		mower.move();
		assertThat(mower.getPosition().getX()).isEqualTo(1);
		assertThat(mower.getPosition().getY()).isEqualTo(0);
	}

	@Test
	public void should_move_west() {
		Mower mower = new Mower(new Position(0, 0), WestOrientation.getInstance());
		mower.move();
		assertThat(mower.getPosition().getX()).isEqualTo(-1);
		assertThat(mower.getPosition().getY()).isEqualTo(0);
	}

}
