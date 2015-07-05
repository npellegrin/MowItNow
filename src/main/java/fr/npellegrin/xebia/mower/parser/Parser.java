package fr.npellegrin.xebia.mower.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import fr.npellegrin.xebia.mower.parser.model.InstructionDefinition;
import fr.npellegrin.xebia.mower.parser.model.MowerDefinition;
import fr.npellegrin.xebia.mower.parser.model.OrientationDefinition;
import fr.npellegrin.xebia.mower.parser.model.ParserDefinition;
import fr.npellegrin.xebia.mower.parser.model.PositionDefinition;
import fr.npellegrin.xebia.mower.parser.model.YardDefinition;

/**
 * Mower definition parser.
 */
public class Parser {
	/**
	 * Parse a file and build a parser model definition.
	 *
	 * @throws FileNotFoundException
	 */
	public ParserDefinition parse(final String inputFile) throws FileNotFoundException {
		final ParserDefinition result = new ParserDefinition();
		final Scanner scanner = new Scanner(new File(inputFile));
		try {
			// Yard definition
			final String[] yardTokens = this.tokenize(scanner.nextLine());
			final YardDefinition yardDefinition = new YardDefinition();
			yardDefinition.setLastCoordX(Integer.valueOf(yardTokens[0]));
			yardDefinition.setLastCoordY(Integer.valueOf(yardTokens[1]));
			result.setYardDefinition(yardDefinition);

			// For each mower, build mower definition
			final List<MowerDefinition> mowerDefinitions = new ArrayList<MowerDefinition>();
			final Map<String, OrientationDefinition> orientationDefinitionMap = OrientationDefinition.orientationMap();
			final Map<String, InstructionDefinition> instructionDefinitionMap = InstructionDefinition.instructionMap();
			while (scanner.hasNextLine()) {
				// Current mower
				final MowerDefinition mowerDefinition = new MowerDefinition();

				// Initial mower definition
				final String[] positionTokens = this.tokenize(scanner.nextLine());
				final PositionDefinition positionDefinition = new PositionDefinition();
				positionDefinition.setX(Integer.valueOf(positionTokens[0]));
				positionDefinition.setY(Integer.valueOf(positionTokens[1]));
				positionDefinition.setOrientation(orientationDefinitionMap.get(positionTokens[2]));
				mowerDefinition.setInitialPosition(positionDefinition);

				// Mower instructions
				final String instructionLine = scanner.nextLine();
				for (int i = 0; i < instructionLine.length(); i++) {
					final InstructionDefinition instructionDefinition = instructionDefinitionMap
							.get(String.valueOf(instructionLine.charAt(i)));
					mowerDefinition.addInstructionDefinition(instructionDefinition);
				}
				mowerDefinitions.add(mowerDefinition);
			}
			result.setMowerDefinitions(mowerDefinitions);
		} finally {
			// End
			scanner.close();
		}

		// End
		return result;
	}

	/**
	 * Split line into an array of tokens.
	 */
	private String[] tokenize(final String line) {
		if (line != null) {
			return line.split(" ");
		}
		return new String[0];
	}

}
