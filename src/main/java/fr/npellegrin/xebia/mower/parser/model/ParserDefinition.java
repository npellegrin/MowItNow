package fr.npellegrin.xebia.mower.parser.model;

import java.util.List;

public class ParserDefinition {
	private YardDefinition yardDefinition;
	private List<MowerDefinition> mowerDefinitions;

	public YardDefinition getYardDefinition() {
		return yardDefinition;
	}

	public void setYardDefinition(YardDefinition yardDefinition) {
		this.yardDefinition = yardDefinition;
	}

	public List<MowerDefinition> getMowerDefinitions() {
		return mowerDefinitions;
	}

	public void setMowerDefinitions(List<MowerDefinition> mowerDefinitions) {
		this.mowerDefinitions = mowerDefinitions;
	}

}
