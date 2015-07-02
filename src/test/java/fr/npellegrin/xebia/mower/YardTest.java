package fr.npellegrin.xebia.mower;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.Test;

import fr.npellegrin.xebia.mower.environment.Position;
import fr.npellegrin.xebia.mower.environment.Position;
import fr.npellegrin.xebia.mower.environment.Yard;
import fr.npellegrin.xebia.mower.environment.Yard;

public class YardTest {

	@Test
	public void should_have_true_if_position_in_yard() {
		Yard yard = new Yard(7, 5);
		assertThat(yard.isIn(new Position(0, 0))).isTrue();
		assertThat(yard.isIn(new Position(3, 4))).isTrue();
		assertThat(yard.isIn(new Position(7, 0))).isTrue();
		assertThat(yard.isIn(new Position(0, 5))).isTrue();
		assertThat(yard.isIn(new Position(7, 5))).isTrue();
		yard = new Yard(0, 0);
		assertThat(yard.isIn(new Position(0, 0))).isTrue();
		yard = new Yard(0, 3);
		assertThat(yard.isIn(new Position(0, 0))).isTrue();
		assertThat(yard.isIn(new Position(0, 3))).isTrue();
	}

	@Test
	public void should_have_false_if_position_not_in_yard() {
		Yard yard = new Yard(7, 5);
		assertThat(yard.isIn(new Position(-1, 0))).isFalse();
		assertThat(yard.isIn(new Position(0, -1))).isFalse();
		assertThat(yard.isIn(new Position(-1, -1))).isFalse();
		assertThat(yard.isIn(new Position(8, 0))).isFalse();
		assertThat(yard.isIn(new Position(8, 5))).isFalse();
		assertThat(yard.isIn(new Position(7, 6))).isFalse();
		assertThat(yard.isIn(new Position(8, 6))).isFalse();
		yard = new Yard(0, 0);
		assertThat(yard.isIn(new Position(0, -1))).isFalse();
		assertThat(yard.isIn(new Position(1, 0))).isFalse();
		assertThat(yard.isIn(new Position(0, 1))).isFalse();
		yard = new Yard(0, 3);
		assertThat(yard.isIn(new Position(-1, 0))).isFalse();
		assertThat(yard.isIn(new Position(0, 4))).isFalse();
		assertThat(yard.isIn(new Position(1, 2))).isFalse();
	}

}
