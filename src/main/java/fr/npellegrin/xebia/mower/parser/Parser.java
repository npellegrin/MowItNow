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
	private static final String SPACE_DELIMITER = " ";
	private static final Map<String, OrientationDefinition> ORIENTATION_MAP = OrientationDefinition.orientationMap();
	private static final Map<String, InstructionDefinition> INSTRUCTION_MAP = InstructionDefinition.instructionMap();

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
			final String[] yardTokens = this.tokenizeWithSpace(scanner.nextLine(), 2);
			final YardDefinition yardDefinition = new YardDefinition();
			yardDefinition.setLastCoordX(this.getInteger(yardTokens, 0));
			yardDefinition.setLastCoordY(this.getInteger(yardTokens, 1));
			result.setYardDefinition(yardDefinition);

			// For each mower, build mower definition
			final List<MowerDefinition> mowerDefinitions = new ArrayList<MowerDefinition>();
			while (scanner.hasNextLine()) {
				// Current mower
				final MowerDefinition mowerDefinition = new MowerDefinition();

				// Initial mower definition
				final String[] positionTokens = this.tokenizeWithSpace(scanner.nextLine(), 3);
				final PositionDefinition positionDefinition = new PositionDefinition();
				positionDefinition.setX(this.getInteger(positionTokens, 0));
				positionDefinition.setY(this.getInteger(positionTokens, 1));
				positionDefinition.setOrientation(this.getOrientationDefinition(positionTokens, 2));
				mowerDefinition.setInitialPosition(positionDefinition);

				// Mower instructions
				final char[] instructionTokens = tokenizeCharacter(scanner.nextLine());
				for (final char instruction : instructionTokens) {
					mowerDefinition.addInstructionDefinition(this.getInstructionDefinition(instruction));
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
	 * Get instruction from the specified token.
	 *
	 * @throws ParserException
	 */
	private InstructionDefinition getInstructionDefinition(final char instruction) throws ParserException {
		try {
			return INSTRUCTION_MAP.get(String.valueOf(instruction));
		} catch (final NumberFormatException e) {
			throw new ParserException(String.format("Cannot convert %s to instruction definition", instruction), e);
		}
	}

	/**
	 * Get orientation from the specified token.
	 *
	 * @throws ParserException
	 */
	private OrientationDefinition getOrientationDefinition(final String[] tokens, final int n) throws ParserException {
		try {
			return ORIENTATION_MAP.get(tokens[n]);
		} catch (final NumberFormatException e) {
			throw new ParserException(String.format("Cannot convert %s to orientation definition", tokens[n]), e);
		}
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
	 * Split line into an array of tokens (no delimiter).
	 *
	 * @throws ParserException
	 */
	private char[] tokenizeCharacter(final String line) throws ParserException {
		// Error: unexpected parameter
		if (line == null) {
			throw new ParserException("Empty line");
		}

		// Tokenize
		return line.toCharArray();
	}

	/**
	 * Split line into an array of tokens (split by space).
	 *
	 * @throws ParserException
	 */
	private String[] tokenizeWithSpace(final String line, final int expectedTokens) throws ParserException {
		// Error: unexpected parameter
		if (line == null) {
			throw new ParserException("Empty line");
		}

		// Tokenize
		final String tokens[] = line.split(SPACE_DELIMITER);

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
