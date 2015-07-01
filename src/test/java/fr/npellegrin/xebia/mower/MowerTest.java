package fr.npellegrin.xebia.mower;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import fr.npellegrin.xebia.mower.controls.InstructionFactory;
import fr.npellegrin.xebia.mower.orientation.EastDirection;
import fr.npellegrin.xebia.mower.orientation.NorthDirection;
import fr.npellegrin.xebia.mower.orientation.Orientation;
import fr.npellegrin.xebia.mower.orientation.Position;
import fr.npellegrin.xebia.mower.orientation.SouthDirection;
import fr.npellegrin.xebia.mower.orientation.WestDirection;

public class MowerTest {

	@Test
	public void should_move_north_when_oriented_north_and_accept_A() {
		InstructionFactory factory = new InstructionFactory();
		Mower mower = new Mower(new Position(0, 0), new Orientation(NorthDirection.getInstance()));
		mower.accept(factory.buildFromString("A"));
		assertThat(mower.getPosition().getX()).isEqualTo(0);
		assertThat(mower.getPosition().getY()).isEqualTo(1);
		assertThat(mower.getOrientation().getXVector()).isEqualTo(0);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(1);
	}

	@Test
	public void should_move_south_when_oriented_south_and_accept_A() {
		InstructionFactory factory = new InstructionFactory();
		Mower mower = new Mower(new Position(0, 0), new Orientation(SouthDirection.getInstance()));
		mower.accept(factory.buildFromString("A"));
		assertThat(mower.getPosition().getX()).isEqualTo(0);
		assertThat(mower.getPosition().getY()).isEqualTo(-1);
		assertThat(mower.getOrientation().getXVector()).isEqualTo(0);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(-1);
	}

	@Test
	public void should_move_east_when_oriented_east_and_accept_A() {
		InstructionFactory factory = new InstructionFactory();
		Mower mower = new Mower(new Position(0, 0), new Orientation(EastDirection.getInstance()));
		mower.accept(factory.buildFromString("A"));
		assertThat(mower.getPosition().getX()).isEqualTo(1);
		assertThat(mower.getPosition().getY()).isEqualTo(0);
		assertThat(mower.getOrientation().getXVector()).isEqualTo(1);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(0);
	}

	@Test
	public void should_move_west_when_oriented_west_and_accept_A() {
		InstructionFactory factory = new InstructionFactory();
		Mower mower = new Mower(new Position(0, 0), new Orientation(WestDirection.getInstance()));
		mower.accept(factory.buildFromString("A"));
		assertThat(mower.getPosition().getX()).isEqualTo(-1);
		assertThat(mower.getPosition().getY()).isEqualTo(0);
		assertThat(mower.getOrientation().getXVector()).isEqualTo(-1);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(0);
	}

	@Test
	public void should_be_oriented_east_when_oriented_north_and_accept_D() {
		InstructionFactory factory = new InstructionFactory();
		Mower mower = new Mower(new Position(0, 0), new Orientation(NorthDirection.getInstance()));
		mower.accept(factory.buildFromString("D"));
		assertThat(mower.getOrientation().getXVector()).isEqualTo(1);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(0);
	}

	@Test
	public void should_be_oriented_south_when_oriented_east_and_accept_D() {
		InstructionFactory factory = new InstructionFactory();
		Mower mower = new Mower(new Position(0, 0), new Orientation(EastDirection.getInstance()));
		mower.accept(factory.buildFromString("D"));
		assertThat(mower.getOrientation().getXVector()).isEqualTo(0);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(-1);
	}

	@Test
	public void should_be_oriented_west_when_oriented_south_and_accept_D() {
		InstructionFactory factory = new InstructionFactory();
		Mower mower = new Mower(new Position(0, 0), new Orientation(SouthDirection.getInstance()));
		mower.accept(factory.buildFromString("D"));
		assertThat(mower.getOrientation().getXVector()).isEqualTo(-1);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(0);
	}

	@Test
	public void should_be_oriented_north_when_oriented_west_and_accept_D() {
		InstructionFactory factory = new InstructionFactory();
		Mower mower = new Mower(new Position(0, 0), new Orientation(WestDirection.getInstance()));
		mower.accept(factory.buildFromString("D"));
		assertThat(mower.getOrientation().getXVector()).isEqualTo(0);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(1);
	}

	@Test
	public void should_be_oriented_west_when_oriented_north_and_accept_G() {
		InstructionFactory factory = new InstructionFactory();
		Mower mower = new Mower(new Position(0, 0), new Orientation(NorthDirection.getInstance()));
		mower.accept(factory.buildFromString("G"));
		assertThat(mower.getOrientation().getXVector()).isEqualTo(-1);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(0);
	}

	@Test
	public void should_be_oriented_north_when_oriented_east_and_accept_G() {
		InstructionFactory factory = new InstructionFactory();
		Mower mower = new Mower(new Position(0, 0), new Orientation(EastDirection.getInstance()));
		mower.accept(factory.buildFromString("G"));
		assertThat(mower.getOrientation().getXVector()).isEqualTo(0);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(1);
	}

	@Test
	public void should_be_oriented_east_when_oriented_south_and_accept_G() {
		InstructionFactory factory = new InstructionFactory();
		Mower mower = new Mower(new Position(0, 0), new Orientation(SouthDirection.getInstance()));
		mower.accept(factory.buildFromString("G"));
		assertThat(mower.getOrientation().getXVector()).isEqualTo(1);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(0);
	}

	@Test
	public void should_be_oriented_south_when_oriented_west_and_accept_G() {
		InstructionFactory factory = new InstructionFactory();
		Mower mower = new Mower(new Position(0, 0), new Orientation(WestDirection.getInstance()));
		mower.accept(factory.buildFromString("G"));
		assertThat(mower.getOrientation().getXVector()).isEqualTo(0);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(-1);
	}

}
