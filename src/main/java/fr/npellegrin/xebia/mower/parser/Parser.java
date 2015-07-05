package fr.npellegrin.xebia.mower.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import fr.npellegrin.xebia.mower.exceptions.ParserException;
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
	 * @throws ParserException
	 */
	public ParserDefinition parse(final String inputFile) throws FileNotFoundException, ParserException {
		final ParserDefinition result = new ParserDefinition();
		final Scanner scanner = new Scanner(new File(inputFile));
		try {
			// Yard definition
			final String[] yardTokens = this.tokenize(scanner.nextLine(), 2);
			final YardDefinition yardDefinition = new YardDefinition();
			yardDefinition.setLastCoordX(this.getInteger(yardTokens, 0));
			yardDefinition.setLastCoordY(this.getInteger(yardTokens, 1));
			result.setYardDefinition(yardDefinition);

			// For each mower, build mower definition
			final List<MowerDefinition> mowerDefinitions = new ArrayList<MowerDefinition>();
			final Map<String, OrientationDefinition> orientationDefinitionMap = OrientationDefinition.orientationMap();
			final Map<String, InstructionDefinition> instructionDefinitionMap = InstructionDefinition.instructionMap();
			while (scanner.hasNextLine()) {
				// Current mower
				final MowerDefinition mowerDefinition = new MowerDefinition();

				// Initial mower definition
				final String[] positionTokens = this.tokenize(scanner.nextLine(), 3);
				final PositionDefinition positionDefinition = new PositionDefinition();
				positionDefinition.setX(this.getInteger(positionTokens, 0));
				positionDefinition.setY(this.getInteger(positionTokens, 1));
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
	 * Get an integer from the specified token.
	 *
	 * @throws ParserException
	 */
	private int getInteger(final String[] tokens, final int n) throws ParserException {
		try {
			return Integer.valueOf(tokens[n]);
		} catch (final NumberFormatException e) {
			throw new ParserException(String.format("Cannot convert %s to integer", tokens[n]), e);
		}
	}

	/**
	 * Split line into an array of tokens.
	 *
	 * @throws ParserException
	 */
	private String[] tokenize(final String line, final int expectedTokens) throws ParserException {
		// Error: unexpected parameter
		if (line == null) {
			throw new ParserException("Empty line");
		}

		// Tokenize
		final String tokens[] = line.split(" ");

		// Error: no enough tokens
		if (tokens.length < expectedTokens) {
			throw new ParserException(
					String.format("Line [%s] does not contain enough tokens, %s expected", line, expectedTokens));
		}

		// Error: too much tokens
		if (tokens.length > expectedTokens) {
			throw new ParserException(
					String.format("Line [%s] have too much tokens, %s expected", line, expectedTokens));
		}

		// Ok, it's fine
		return tokens;
	}

}
