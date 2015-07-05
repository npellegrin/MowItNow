package fr.npellegrin.xebia.mower.converter;

import fr.npellegrin.xebia.mower.exceptions.InvalidOrientationException;
import fr.npellegrin.xebia.mower.orientation.Direction;
import fr.npellegrin.xebia.mower.orientation.EastDirection;
import fr.npellegrin.xebia.mower.orientation.NorthDirection;
import fr.npellegrin.xebia.mower.orientation.SouthDirection;
import fr.npellegrin.xebia.mower.orientation.WestDirection;
import fr.npellegrin.xebia.mower.parser.model.OrientationDefinition;

public class OrientationDefinitionToDirectionMapper implements Mapper<OrientationDefinition, Direction> {

	@Override
	public Direction map(final OrientationDefinition input) {
		switch (input) {
		case N:
			return NorthDirection.getInstance();
		case E:
			return EastDirection.getInstance();
		case W:
			return WestDirection.getInstance();
		case S:
			return SouthDirection.getInstance();
		default:
			throw new InvalidOrientationException(String.format("Direction %s is invalid", input));
		}
	}

}
