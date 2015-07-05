package fr.npellegrin.xebia.mower.converter;

import fr.npellegrin.xebia.mower.orientation.Orientation;
import fr.npellegrin.xebia.mower.parser.model.PositionDefinition;

/**
 * MAp a position definition to an orientation.
 */
public class PositionDefinitionToOrientationMapper implements Mapper<PositionDefinition, Orientation> {
	private static final OrientationDefinitionToDirectionMapper MAPPER = new OrientationDefinitionToDirectionMapper();

	@Override
	public Orientation map(final PositionDefinition input) {
		return new Orientation(MAPPER.map(input.getOrientation()));
	}

}
