package fr.npellegrin.xebia.mower.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import fr.npellegrin.xebia.mower.orientation.Orientation;
import fr.npellegrin.xebia.mower.parser.model.OrientationDefinition;
import fr.npellegrin.xebia.mower.parser.model.PositionDefinition;

public class PositionDefinitionToOrientationMapperTest {

	@Test
	public void should_map_north_parameters() {
		final PositionDefinition input = new PositionDefinition();
		input.setOrientation(OrientationDefinition.N);
		final PositionDefinitionToOrientationMapper mapper = new PositionDefinitionToOrientationMapper();
		final Orientation result = mapper.map(input);
		assertThat(result.getXVector()).isEqualTo(0);
		assertThat(result.getYVector()).isEqualTo(1);
	}

	@Test
	public void should_map_south_parameters() {
		final PositionDefinition input = new PositionDefinition();
		input.setOrientation(OrientationDefinition.S);
		final PositionDefinitionToOrientationMapper mapper = new PositionDefinitionToOrientationMapper();
		final Orientation result = mapper.map(input);
		assertThat(result.getXVector()).isEqualTo(0);
		assertThat(result.getYVector()).isEqualTo(-1);
	}

	@Test
	public void should_map_east_parameters() {
		final PositionDefinition input = new PositionDefinition();
		input.setOrientation(OrientationDefinition.E);
		final PositionDefinitionToOrientationMapper mapper = new PositionDefinitionToOrientationMapper();
		final Orientation result = mapper.map(input);
		assertThat(result.getXVector()).isEqualTo(1);
		assertThat(result.getYVector()).isEqualTo(0);
	}

	@Test
	public void should_map_west_parameters() {
		final PositionDefinition input = new PositionDefinition();
		input.setOrientation(OrientationDefinition.W);
		final PositionDefinitionToOrientationMapper mapper = new PositionDefinitionToOrientationMapper();
		final Orientation result = mapper.map(input);
		assertThat(result.getXVector()).isEqualTo(-1);
		assertThat(result.getYVector()).isEqualTo(0);
	}

}
