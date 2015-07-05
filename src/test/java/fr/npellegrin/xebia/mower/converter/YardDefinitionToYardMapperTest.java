package fr.npellegrin.xebia.mower.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import fr.npellegrin.xebia.mower.environment.Yard;
import fr.npellegrin.xebia.mower.parser.model.YardDefinition;

public class YardDefinitionToYardMapperTest {
	@Test
	public void should_map_parameters() {
		final YardDefinition input = new YardDefinition();
		input.setLastCoordX(31);
		input.setLastCoordY(17);
		final YardDefinitionToYardMapper mapper = new YardDefinitionToYardMapper();
		final PublicYard result = new PublicYard(mapper.map(input));
		assertThat(result.getLastCoordX()).isEqualTo(31);
		assertThat(result.getLastCoordY()).isEqualTo(17);
	}

	/**
	 * Yard subclass to get private attributes.
	 */
	class PublicYard extends Yard {
		public PublicYard(final Yard yard) {
			super(yard);
		}

		public PublicYard(final int lastCoordX, final int lastCoordY) {
			super(lastCoordX, lastCoordY);
		}

		public int getLastCoordX() {
			return lastCoordX;
		}

		public int getLastCoordY() {
			return lastCoordY;
		}
	};

}
