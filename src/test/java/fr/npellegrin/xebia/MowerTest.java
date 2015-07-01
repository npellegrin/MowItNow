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
	public void should_move_north_when_oriented_north_and_accept_A() {
		Mower mower = new Mower(new Position(0, 0), NorthOrientation.getInstance());
		mower.accept("A");
		assertThat(mower.getPosition().getX()).isEqualTo(0);
		assertThat(mower.getPosition().getY()).isEqualTo(1);
		assertThat(mower.getOrientation()).isEqualTo(NorthOrientation.getInstance());
	}

	@Test
	public void should_move_south_when_oriented_south_and_accept_A() {
		Mower mower = new Mower(new Position(0, 0), SouthOrientation.getInstance());
		mower.accept("A");
		assertThat(mower.getPosition().getX()).isEqualTo(0);
		assertThat(mower.getPosition().getY()).isEqualTo(-1);
		assertThat(mower.getOrientation()).isEqualTo(SouthOrientation.getInstance());
	}

	@Test
	public void should_move_east_when_oriented_east_and_accept_A() {
		Mower mower = new Mower(new Position(0, 0), EastOrientation.getInstance());
		mower.accept("A");
		assertThat(mower.getPosition().getX()).isEqualTo(1);
		assertThat(mower.getPosition().getY()).isEqualTo(0);
		assertThat(mower.getOrientation()).isEqualTo(EastOrientation.getInstance());
	}

	@Test
	public void should_move_west_when_oriented_west_and_accept_A() {
		Mower mower = new Mower(new Position(0, 0), WestOrientation.getInstance());
		mower.accept("A");
		assertThat(mower.getPosition().getX()).isEqualTo(-1);
		assertThat(mower.getPosition().getY()).isEqualTo(0);
		assertThat(mower.getOrientation()).isEqualTo(WestOrientation.getInstance());
	}

	@Test
	public void should_be_oriented_east_when_oriented_north_and_accept_D() {
		Mower mower = new Mower(new Position(0, 0), NorthOrientation.getInstance());
		mower.accept("D");
		assertThat(mower.getOrientation()).isEqualTo(EastOrientation.getInstance());
	}

	@Test
	public void should_be_oriented_south_when_oriented_east_and_accept_D() {
		Mower mower = new Mower(new Position(0, 0), EastOrientation.getInstance());
		mower.accept("D");
		assertThat(mower.getOrientation()).isEqualTo(SouthOrientation.getInstance());
	}

	@Test
	public void should_be_oriented_west_when_oriented_south_and_accept_D() {
		Mower mower = new Mower(new Position(0, 0), SouthOrientation.getInstance());
		mower.accept("D");
		assertThat(mower.getOrientation()).isEqualTo(WestOrientation.getInstance());
	}

	@Test
	public void should_be_oriented_north_when_oriented_west_and_accept_D() {
		Mower mower = new Mower(new Position(0, 0), WestOrientation.getInstance());
		mower.accept("D");
		assertThat(mower.getOrientation()).isEqualTo(NorthOrientation.getInstance());
	}

	@Test
	public void should_be_oriented_west_when_oriented_north_and_accept_G() {
		Mower mower = new Mower(new Position(0, 0), NorthOrientation.getInstance());
		mower.accept("G");
		assertThat(mower.getOrientation()).isEqualTo(WestOrientation.getInstance());
	}

	@Test
	public void should_be_oriented_north_when_oriented_east_and_accept_G() {
		Mower mower = new Mower(new Position(0, 0), EastOrientation.getInstance());
		mower.accept("G");
		assertThat(mower.getOrientation()).isEqualTo(NorthOrientation.getInstance());
	}

	@Test
	public void should_be_oriented_east_when_oriented_south_and_accept_G() {
		Mower mower = new Mower(new Position(0, 0), SouthOrientation.getInstance());
		mower.accept("G");
		assertThat(mower.getOrientation()).isEqualTo(EastOrientation.getInstance());
	}

	@Test
	public void should_be_oriented_south_when_oriented_west_and_accept_G() {
		Mower mower = new Mower(new Position(0, 0), WestOrientation.getInstance());
		mower.accept("G");
		assertThat(mower.getOrientation()).isEqualTo(SouthOrientation.getInstance());
	}

}
