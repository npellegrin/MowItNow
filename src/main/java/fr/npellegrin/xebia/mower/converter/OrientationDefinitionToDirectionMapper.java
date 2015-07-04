package fr.npellegrin.xebia.mower.converter;

import fr.npellegrin.xebia.mower.orientation.Direction;
import fr.npellegrin.xebia.mower.orientation.EastDirection;
import fr.npellegrin.xebia.mower.orientation.NorthDirection;
import fr.npellegrin.xebia.mower.orientation.SouthDirection;
import fr.npellegrin.xebia.mower.orientation.WestDirection;
import fr.npellegrin.xebia.mower.parser.model.OrientationDefinition;

public class OrientationDefinitionToDirectionMapper implements Mapper<OrientationDefinition, Direction> {

	@Override
	public Direction map(OrientationDefinition input) {
		switch (input) {
		case N:
			return NorthDirection.getInstance();
		case E:
			return EastDirection.getInstance();
		case O:
			return WestDirection.getInstance();
		case S:
			return SouthDirection.getInstance();
		default:
			return null;
		}
	}

}
