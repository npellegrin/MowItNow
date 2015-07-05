package fr.npellegrin.xebia.mower;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import fr.npellegrin.xebia.mower.controls.MoveForwardInstruction;
import fr.npellegrin.xebia.mower.controls.RotateLeftInstruction;
import fr.npellegrin.xebia.mower.controls.RotateRightInstruction;
import fr.npellegrin.xebia.mower.environment.Position;
import fr.npellegrin.xebia.mower.environment.Yard;
import fr.npellegrin.xebia.mower.orientation.EastDirection;
import fr.npellegrin.xebia.mower.orientation.NorthDirection;
import fr.npellegrin.xebia.mower.orientation.Orientation;
import fr.npellegrin.xebia.mower.orientation.SouthDirection;
import fr.npellegrin.xebia.mower.orientation.WestDirection;

public class MowerTest {

	@Test
	public void should_move_north_when_oriented_north_and_accept_move_forward() {
		Yard yard = new Yard(7, 5);
		Mower mower = new Mower(yard, new Position(0, 0), new Orientation(NorthDirection.getInstance()));
		mower.accept(new MoveForwardInstruction());
		assertThat(mower.getPosition().getX()).isEqualTo(0);
		assertThat(mower.getPosition().getY()).isEqualTo(1);
		assertThat(mower.getOrientation().getXVector()).isEqualTo(0);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(1);
	}

	@Test
	public void should_move_south_when_oriented_south_and_accept_move_forward() {
		Yard yard = new Yard(7, 5);
		Mower mower = new Mower(yard, new Position(3, 3), new Orientation(SouthDirection.getInstance()));
		mower.accept(new MoveForwardInstruction());
		assertThat(mower.getPosition().getX()).isEqualTo(3);
		assertThat(mower.getPosition().getY()).isEqualTo(2);
		assertThat(mower.getOrientation().getXVector()).isEqualTo(0);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(-1);
	}

	@Test
	public void should_move_east_when_oriented_east_and_accept_move_forward() {
		Yard yard = new Yard(7, 5);
		Mower mower = new Mower(yard, new Position(0, 0), new Orientation(EastDirection.getInstance()));
		mower.accept(new MoveForwardInstruction());
		assertThat(mower.getPosition().getX()).isEqualTo(1);
		assertThat(mower.getPosition().getY()).isEqualTo(0);
		assertThat(mower.getOrientation().getXVector()).isEqualTo(1);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(0);
	}

	@Test
	public void should_move_west_when_oriented_west_and_accept_move_forward() {
		Yard yard = new Yard(7, 5);
		Mower mower = new Mower(yard, new Position(3, 3), new Orientation(WestDirection.getInstance()));
		mower.accept(new MoveForwardInstruction());
		assertThat(mower.getPosition().getX()).isEqualTo(2);
		assertThat(mower.getPosition().getY()).isEqualTo(3);
		assertThat(mower.getOrientation().getXVector()).isEqualTo(-1);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(0);
	}

	@Test
	public void should_be_oriented_east_when_oriented_north_and_accept_rotate_right() {
		Yard yard = new Yard(7, 5);
		Mower mower = new Mower(yard, new Position(0, 0), new Orientation(NorthDirection.getInstance()));
		mower.accept(new RotateRightInstruction());
		assertThat(mower.getOrientation().getXVector()).isEqualTo(1);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(0);
	}

	@Test
	public void should_be_oriented_south_when_oriented_east_and_accept_rotate_right() {
		Yard yard = new Yard(7, 5);
		Mower mower = new Mower(yard, new Position(0, 0), new Orientation(EastDirection.getInstance()));
		mower.accept(new RotateRightInstruction());
		assertThat(mower.getOrientation().getXVector()).isEqualTo(0);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(-1);
	}

	@Test
	public void should_be_oriented_west_when_oriented_south_and_accept_rotate_right() {
		Yard yard = new Yard(7, 5);
		Mower mower = new Mower(yard, new Position(0, 0), new Orientation(SouthDirection.getInstance()));
		mower.accept(new RotateRightInstruction());
		assertThat(mower.getOrientation().getXVector()).isEqualTo(-1);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(0);
	}

	@Test
	public void should_be_oriented_north_when_oriented_west_and_accept_rotate_right() {
		Yard yard = new Yard(7, 5);
		Mower mower = new Mower(yard, new Position(0, 0), new Orientation(WestDirection.getInstance()));
		mower.accept(new RotateRightInstruction());
		assertThat(mower.getOrientation().getXVector()).isEqualTo(0);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(1);
	}

	@Test
	public void should_be_oriented_west_when_oriented_north_and_accept_rotate_left() {
		Yard yard = new Yard(7, 5);
		Mower mower = new Mower(yard, new Position(0, 0), new Orientation(NorthDirection.getInstance()));
		mower.accept(new RotateLeftInstruction());
		assertThat(mower.getOrientation().getXVector()).isEqualTo(-1);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(0);
	}

	@Test
	public void should_be_oriented_north_when_oriented_east_and_accept_rotate_left() {
		Yard yard = new Yard(7, 5);
		Mower mower = new Mower(yard, new Position(0, 0), new Orientation(EastDirection.getInstance()));
		mower.accept(new RotateLeftInstruction());
		assertThat(mower.getOrientation().getXVector()).isEqualTo(0);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(1);
	}

	@Test
	public void should_be_oriented_east_when_oriented_south_and_accept_rotate_left() {
		Yard yard = new Yard(7, 5);
		Mower mower = new Mower(yard, new Position(0, 0), new Orientation(SouthDirection.getInstance()));
		mower.accept(new RotateLeftInstruction());
		assertThat(mower.getOrientation().getXVector()).isEqualTo(1);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(0);
	}

	@Test
	public void should_be_oriented_south_when_oriented_west_and_accept_rotate_left() {
		Yard yard = new Yard(7, 5);
		Mower mower = new Mower(yard, new Position(0, 0), new Orientation(WestDirection.getInstance()));
		mower.accept(new RotateLeftInstruction());
		assertThat(mower.getOrientation().getXVector()).isEqualTo(0);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(-1);
	}

	@Test
	public void should_not_move_when_oriented_south_and_position_bottom_and_accept_move_forward() {
		Yard yard = new Yard(7, 5);
		Mower mower = new Mower(yard, new Position(0, 0), new Orientation(SouthDirection.getInstance()));
		mower.accept(new MoveForwardInstruction());
		assertThat(mower.getPosition().getX()).isEqualTo(0);
		assertThat(mower.getPosition().getY()).isEqualTo(0);
		assertThat(mower.getOrientation().getXVector()).isEqualTo(0);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(-1);
	}

	@Test
	public void should_not_move_when_oriented_west_and_position_left_and_accept_move_forward() {
		Yard yard = new Yard(7, 5);
		Mower mower = new Mower(yard, new Position(0, 0), new Orientation(WestDirection.getInstance()));
		mower.accept(new MoveForwardInstruction());
		assertThat(mower.getPosition().getX()).isEqualTo(0);
		assertThat(mower.getPosition().getY()).isEqualTo(0);
		assertThat(mower.getOrientation().getXVector()).isEqualTo(-1);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(0);
	}

	@Test
	public void should_not_move_when_oriented_east_and_position_right_and_accept_move_forward() {
		Yard yard = new Yard(7, 5);
		Mower mower = new Mower(yard, new Position(7, 0), new Orientation(EastDirection.getInstance()));
		mower.accept(new MoveForwardInstruction());
		assertThat(mower.getPosition().getX()).isEqualTo(7);
		assertThat(mower.getPosition().getY()).isEqualTo(0);
		assertThat(mower.getOrientation().getXVector()).isEqualTo(1);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(0);
	}

	@Test
	public void should_not_move_when_oriented_north_and_position_top_and_accept_move_forward() {
		Yard yard = new Yard(7, 5);
		Mower mower = new Mower(yard, new Position(0, 5), new Orientation(NorthDirection.getInstance()));
		mower.accept(new MoveForwardInstruction());
		assertThat(mower.getPosition().getX()).isEqualTo(0);
		assertThat(mower.getPosition().getY()).isEqualTo(5);
		assertThat(mower.getOrientation().getXVector()).isEqualTo(0);
		assertThat(mower.getOrientation().getYVector()).isEqualTo(1);
	}

}
