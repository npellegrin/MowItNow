package fr.npellegrin.xebia.mower.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import fr.npellegrin.xebia.mower.environment.Position;
import fr.npellegrin.xebia.mower.parser.model.PositionDefinition;

public class PositionDefinitionToPositionMapperTest {

	@Test
	public void should_map_parameters() {
		PositionDefinition input = new PositionDefinition();
		input.setX(13);
		input.setY(23);
		PositionDefinitionToPositionMapper mapper = new PositionDefinitionToPositionMapper();
		Position result = mapper.map(input);
		assertThat(result.getX()).isEqualTo(13);
		assertThat(result.getY()).isEqualTo(23);
	}

}
