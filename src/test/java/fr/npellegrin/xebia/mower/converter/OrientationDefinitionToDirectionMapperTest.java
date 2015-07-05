package fr.npellegrin.xebia.mower.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import fr.npellegrin.xebia.mower.parser.model.OrientationDefinition;

public class OrientationDefinitionToDirectionMapperTest {

	@Test
	public void should_map_parameters() {
		final OrientationDefinitionToDirectionMapper mapper = new OrientationDefinitionToDirectionMapper();
		assertThat(mapper.map(OrientationDefinition.N).getXVector()).isEqualTo(0);
		assertThat(mapper.map(OrientationDefinition.N).getYVector()).isEqualTo(1);
		assertThat(mapper.map(OrientationDefinition.E).getXVector()).isEqualTo(1);
		assertThat(mapper.map(OrientationDefinition.E).getYVector()).isEqualTo(0);
		assertThat(mapper.map(OrientationDefinition.S).getXVector()).isEqualTo(0);
		assertThat(mapper.map(OrientationDefinition.S).getYVector()).isEqualTo(-1);
		assertThat(mapper.map(OrientationDefinition.O).getXVector()).isEqualTo(-1);
		assertThat(mapper.map(OrientationDefinition.O).getYVector()).isEqualTo(0);
	}

}
