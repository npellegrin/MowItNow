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
	public ParserDefinition parse(String inputFile) throws FileNotFoundException {
		ParserDefinition result = new ParserDefinition();
		Scanner scanner = new Scanner(new File(inputFile));
		try {
			// Yard definition
			String[] yardLine = scanner.nextLine().split(" ");
			YardDefinition yardDefinition = new YardDefinition();
			yardDefinition.setLastCoordX(Integer.valueOf(yardLine[0]));
			yardDefinition.setLastCoordY(Integer.valueOf(yardLine[1]));
			result.setYardDefinition(yardDefinition);

			// For each mower, build mower definition
			List<MowerDefinition> mowerDefinitions = new ArrayList<MowerDefinition>();
			Map<String, OrientationDefinition> orientationDefinitionMap = OrientationDefinition.orientationMap();
			Map<String, InstructionDefinition> instructionDefinitionMap = InstructionDefinition.instructionMap();
			while (scanner.hasNextLine()) {
				// Current mower
				MowerDefinition mowerDefinition = new MowerDefinition();

				// Initial mower definition
				String[] positionLine = scanner.nextLine().split(" ");
				PositionDefinition positionDefinition = new PositionDefinition();
				positionDefinition.setX(Integer.valueOf(positionLine[0]));
				positionDefinition.setY(Integer.valueOf(positionLine[1]));
				positionDefinition.setOrientation(orientationDefinitionMap.get(positionLine[2]));
				mowerDefinition.setInitialPosition(positionDefinition);

				// Mower instructions
				String instructionLine = scanner.nextLine();
				for (int i = 0; i < instructionLine.length(); i++) {
					InstructionDefinition instructionDefinition = instructionDefinitionMap
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

}
