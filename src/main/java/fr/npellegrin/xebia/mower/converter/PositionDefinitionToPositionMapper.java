package fr.npellegrin.xebia.mower.converter;

import fr.npellegrin.xebia.mower.environment.Position;
import fr.npellegrin.xebia.mower.parser.model.PositionDefinition;

public class PositionDefinitionToPositionMapper implements Mapper<PositionDefinition, Position> {

	@Override
	public Position map(final PositionDefinition input) {
		return new Position(input.getX(), input.getY());
	}

}
