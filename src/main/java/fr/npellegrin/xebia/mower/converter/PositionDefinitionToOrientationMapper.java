package fr.npellegrin.xebia.mower.converter;

import fr.npellegrin.xebia.mower.orientation.Orientation;
import fr.npellegrin.xebia.mower.parser.model.PositionDefinition;

public class PositionDefinitionToOrientationMapper implements Mapper<PositionDefinition, Orientation> {
	private OrientationDefinitionToDirectionMapper orientationDefinitionToDirectionMapper;

	public PositionDefinitionToOrientationMapper() {
		orientationDefinitionToDirectionMapper = new OrientationDefinitionToDirectionMapper();
	}

	@Override
	public Orientation map(PositionDefinition input) {
		return new Orientation(orientationDefinitionToDirectionMapper.map(input.getOrientation()));
	}

}
