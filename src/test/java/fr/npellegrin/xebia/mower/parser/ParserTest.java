package fr.npellegrin.xebia.mower.parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import fr.npellegrin.xebia.mower.parser.model.InstructionDefinition;
import fr.npellegrin.xebia.mower.parser.model.MowerDefinition;
import fr.npellegrin.xebia.mower.parser.model.OrientationDefinition;
import fr.npellegrin.xebia.mower.parser.model.PositionDefinition;

/**
 * Test parser against test files.
 */
public class ParserTest {

	@Test
	public void should_parse_simple_file() throws FileNotFoundException {
		Parser parser = new Parser();
		parser.parse("src/test/resources/simple_move.txt");
		assertThat(parser.getYardDefinition().getLastCoordX()).isEqualTo(5);
		assertThat(parser.getYardDefinition().getLastCoordY()).isEqualTo(7);
		assertThat(parser.getMowerDefinitions()).hasSize(1);
		MowerDefinition mowerDefinition = parser.getMowerDefinitions().get(0);
		PositionDefinition initialPosition = mowerDefinition.getInitialPosition();
		assertThat(initialPosition.getX()).isEqualTo(1);
		assertThat(initialPosition.getY()).isEqualTo(2);
		assertThat(initialPosition.getOrientation()).isEqualTo(OrientationDefinition.N);
		List<InstructionDefinition> instructions = mowerDefinition.getInstructionDefinitions();
		assertThat(instructions.size()).isEqualTo(3);
		assertThat(instructions.get(0)).isEqualTo(InstructionDefinition.A);
		assertThat(instructions.get(1)).isEqualTo(InstructionDefinition.A);
		assertThat(instructions.get(2)).isEqualTo(InstructionDefinition.A);
	}

	@Test
	public void should_parse_complex_file() throws FileNotFoundException {
		Parser parser = new Parser();
		parser.parse("src/test/resources/complex_move.txt");
		// Init
		assertThat(parser.getYardDefinition().getLastCoordX()).isEqualTo(2);
		assertThat(parser.getYardDefinition().getLastCoordY()).isEqualTo(10);
		assertThat(parser.getMowerDefinitions()).hasSize(4);

		// Mower 0
		MowerDefinition mowerDefinition0 = parser.getMowerDefinitions().get(0);
		PositionDefinition initialPosition0 = mowerDefinition0.getInitialPosition();
		assertThat(initialPosition0.getX()).isEqualTo(1);
		assertThat(initialPosition0.getY()).isEqualTo(1);
		assertThat(initialPosition0.getOrientation()).isEqualTo(OrientationDefinition.N);
		List<InstructionDefinition> instructions0 = mowerDefinition0.getInstructionDefinitions();
		assertThat(instructions0.size()).isEqualTo(16);
		assertThat(instructions0.get(0)).isEqualTo(InstructionDefinition.G);
		assertThat(instructions0.get(4)).isEqualTo(InstructionDefinition.A);
		assertThat(instructions0.get(8)).isEqualTo(InstructionDefinition.D);
		assertThat(instructions0.get(15)).isEqualTo(InstructionDefinition.A);

		// Mower 1
		MowerDefinition mowerDefinition1 = parser.getMowerDefinitions().get(1);
		PositionDefinition initialPosition1 = mowerDefinition1.getInitialPosition();
		assertThat(initialPosition1.getX()).isEqualTo(1);
		assertThat(initialPosition1.getY()).isEqualTo(1);
		assertThat(initialPosition1.getOrientation()).isEqualTo(OrientationDefinition.O);
		List<InstructionDefinition> instructions1 = mowerDefinition1.getInstructionDefinitions();
		assertThat(instructions1.size()).isEqualTo(12);
		assertThat(instructions1.get(0)).isEqualTo(InstructionDefinition.A);
		assertThat(instructions1.get(2)).isEqualTo(InstructionDefinition.G);
		assertThat(instructions1.get(6)).isEqualTo(InstructionDefinition.A);
		assertThat(instructions1.get(11)).isEqualTo(InstructionDefinition.D);

		// Mower 2
		MowerDefinition mowerDefinition2 = parser.getMowerDefinitions().get(2);
		PositionDefinition initialPosition2 = mowerDefinition2.getInitialPosition();
		assertThat(initialPosition2.getX()).isEqualTo(1);
		assertThat(initialPosition2.getY()).isEqualTo(1);
		assertThat(initialPosition2.getOrientation()).isEqualTo(OrientationDefinition.S);
		List<InstructionDefinition> instructions2 = mowerDefinition2.getInstructionDefinitions();
		assertThat(instructions2.size()).isEqualTo(15);
		assertThat(instructions2.get(0)).isEqualTo(InstructionDefinition.G);
		assertThat(instructions2.get(2)).isEqualTo(InstructionDefinition.D);
		assertThat(instructions2.get(8)).isEqualTo(InstructionDefinition.A);
		assertThat(instructions2.get(14)).isEqualTo(InstructionDefinition.G);

		// Mower 3
		MowerDefinition mowerDefinition3 = parser.getMowerDefinitions().get(3);
		PositionDefinition initialPosition3 = mowerDefinition3.getInitialPosition();
		assertThat(initialPosition3.getX()).isEqualTo(1);
		assertThat(initialPosition3.getY()).isEqualTo(1);
		assertThat(initialPosition3.getOrientation()).isEqualTo(OrientationDefinition.E);
		List<InstructionDefinition> instructions3 = mowerDefinition3.getInstructionDefinitions();
		assertThat(instructions3.size()).isEqualTo(1);
		assertThat(instructions3.get(0)).isEqualTo(InstructionDefinition.A);
	}

	@Test
	public void should_parse_xebia_file() throws FileNotFoundException {
		Parser parser = new Parser();
		parser.parse("src/test/resources/xebia_move.txt");
		// Init
		assertThat(parser.getYardDefinition().getLastCoordX()).isEqualTo(5);
		assertThat(parser.getYardDefinition().getLastCoordY()).isEqualTo(5);
		assertThat(parser.getMowerDefinitions()).hasSize(2);

		// Mower 0
		MowerDefinition mowerDefinition0 = parser.getMowerDefinitions().get(0);
		PositionDefinition initialPosition0 = mowerDefinition0.getInitialPosition();
		assertThat(initialPosition0.getX()).isEqualTo(1);
		assertThat(initialPosition0.getY()).isEqualTo(2);
		assertThat(initialPosition0.getOrientation()).isEqualTo(OrientationDefinition.N);
		List<InstructionDefinition> instructions0 = mowerDefinition0.getInstructionDefinitions();
		assertThat(instructions0.size()).isEqualTo(9);
		assertThat(instructions0.get(0)).isEqualTo(InstructionDefinition.G);
		assertThat(instructions0.get(1)).isEqualTo(InstructionDefinition.A);
		assertThat(instructions0.get(2)).isEqualTo(InstructionDefinition.G);
		assertThat(instructions0.get(3)).isEqualTo(InstructionDefinition.A);
		assertThat(instructions0.get(4)).isEqualTo(InstructionDefinition.G);
		assertThat(instructions0.get(5)).isEqualTo(InstructionDefinition.A);
		assertThat(instructions0.get(6)).isEqualTo(InstructionDefinition.G);
		assertThat(instructions0.get(7)).isEqualTo(InstructionDefinition.A);
		assertThat(instructions0.get(8)).isEqualTo(InstructionDefinition.A);

		// Mower 1
		MowerDefinition mowerDefinition1 = parser.getMowerDefinitions().get(1);
		PositionDefinition initialPosition1 = mowerDefinition1.getInitialPosition();
		assertThat(initialPosition1.getX()).isEqualTo(3);
		assertThat(initialPosition1.getY()).isEqualTo(3);
		assertThat(initialPosition1.getOrientation()).isEqualTo(OrientationDefinition.E);
		List<InstructionDefinition> instructions1 = mowerDefinition1.getInstructionDefinitions();
		assertThat(instructions1.size()).isEqualTo(10);
		assertThat(instructions1.get(0)).isEqualTo(InstructionDefinition.A);
		assertThat(instructions1.get(1)).isEqualTo(InstructionDefinition.A);
		assertThat(instructions1.get(2)).isEqualTo(InstructionDefinition.D);
		assertThat(instructions1.get(3)).isEqualTo(InstructionDefinition.A);
		assertThat(instructions1.get(4)).isEqualTo(InstructionDefinition.A);
		assertThat(instructions1.get(5)).isEqualTo(InstructionDefinition.D);
		assertThat(instructions1.get(6)).isEqualTo(InstructionDefinition.A);
		assertThat(instructions1.get(7)).isEqualTo(InstructionDefinition.D);
		assertThat(instructions1.get(8)).isEqualTo(InstructionDefinition.D);
		assertThat(instructions1.get(9)).isEqualTo(InstructionDefinition.A);
	}
}
