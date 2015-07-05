package fr.npellegrin.xebia.mower.converter;

import fr.npellegrin.xebia.mower.environment.Yard;
import fr.npellegrin.xebia.mower.parser.model.YardDefinition;

public class YardDefinitionToYardMapper implements Mapper<YardDefinition, Yard> {

	@Override
	public Yard map(final YardDefinition input) {
		return new Yard(input.getLastCoordX(), input.getLastCoordY());
	}

}
