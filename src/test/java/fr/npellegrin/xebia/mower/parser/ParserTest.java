package fr.npellegrin.xebia.mower.parser;

import static org.assertj.core.api.Assertions.assertThat;

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
	public void should_parse_simple_file() {
		Parser parser = new Parser();
		parser.parse("simple_move.txt");
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

}
