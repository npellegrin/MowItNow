package fr.npellegrin.xebia.mower.parser;

import java.util.List;

import fr.npellegrin.xebia.mower.parser.model.MowerDefinition;
import fr.npellegrin.xebia.mower.parser.model.YardDefinition;

/**
 * Mower definition parser.
 */
public class Parser {
	private YardDefinition yardDefinition;
	private List<MowerDefinition> mowerDefinitions;

	/**
	 * Parse a file and build a parser model definition.
	 */
	public void parse(String inputFile) {
		// TODO Auto-generated method stub
	}

	public YardDefinition getYardDefinition() {
		return yardDefinition;
	}

	public List<MowerDefinition> getMowerDefinitions() {
		return mowerDefinitions;
	}

}
