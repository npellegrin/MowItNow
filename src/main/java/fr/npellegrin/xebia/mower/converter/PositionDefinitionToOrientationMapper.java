package fr.npellegrin.xebia.mower.converter;

import fr.npellegrin.xebia.mower.orientation.Orientation;
import fr.npellegrin.xebia.mower.parser.model.PositionDefinition;

/**
 * MAp a position definition to an orientation.
 */
public class PositionDefinitionToOrientationMapper implements Mapper<PositionDefinition, Orientation> {
	private final OrientationDefinitionToDirectionMapper orientationDefinitionToDirectionMapper;

	public PositionDefinitionToOrientationMapper() {
		orientationDefinitionToDirectionMapper = new OrientationDefinitionToDirectionMapper();
	}

	@Override
	public Orientation map(final PositionDefinition input) {
		return new Orientation(orientationDefinitionToDirectionMapper.map(input.getOrientation()));
	}

}
