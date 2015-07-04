package fr.npellegrin.xebia.mower.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import fr.npellegrin.xebia.mower.orientation.Orientation;
import fr.npellegrin.xebia.mower.parser.model.OrientationDefinition;
import fr.npellegrin.xebia.mower.parser.model.PositionDefinition;

public class PositionDefinitionToOrientationMapperTest {

	@Test
	public void should_map_north_parameters() {
		PositionDefinition input = new PositionDefinition();
		input.setOrientation(OrientationDefinition.N);
		PositionDefinitionToOrientationMapper mapper = new PositionDefinitionToOrientationMapper();
		Orientation result = mapper.map(input);
		assertThat(result.getXVector()).isEqualTo(0);
		assertThat(result.getYVector()).isEqualTo(1);
	}

	@Test
	public void should_map_south_parameters() {
		PositionDefinition input = new PositionDefinition();
		input.setOrientation(OrientationDefinition.S);
		PositionDefinitionToOrientationMapper mapper = new PositionDefinitionToOrientationMapper();
		Orientation result = mapper.map(input);
		assertThat(result.getXVector()).isEqualTo(0);
		assertThat(result.getYVector()).isEqualTo(-1);
	}

	@Test
	public void should_map_east_parameters() {
		PositionDefinition input = new PositionDefinition();
		input.setOrientation(OrientationDefinition.E);
		PositionDefinitionToOrientationMapper mapper = new PositionDefinitionToOrientationMapper();
		Orientation result = mapper.map(input);
		assertThat(result.getXVector()).isEqualTo(1);
		assertThat(result.getYVector()).isEqualTo(0);
	}

	@Test
	public void should_map_west_parameters() {
		PositionDefinition input = new PositionDefinition();
		input.setOrientation(OrientationDefinition.O);
		PositionDefinitionToOrientationMapper mapper = new PositionDefinitionToOrientationMapper();
		Orientation result = mapper.map(input);
		assertThat(result.getXVector()).isEqualTo(-1);
		assertThat(result.getYVector()).isEqualTo(0);
	}

}
