package fr.npellegrin.xebia.mower.runner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

import fr.npellegrin.xebia.mower.orientation.SouthDirection;
import fr.npellegrin.xebia.mower.parser.model.InstructionDefinition;
import fr.npellegrin.xebia.mower.parser.model.MowerDefinition;
import fr.npellegrin.xebia.mower.parser.model.OrientationDefinition;
import fr.npellegrin.xebia.mower.parser.model.ParserDefinition;
import fr.npellegrin.xebia.mower.parser.model.PositionDefinition;
import fr.npellegrin.xebia.mower.parser.model.YardDefinition;
import fr.npellegrin.xebia.mower.utils.MowerTestListener;
import fr.npellegrin.xebia.mower.utils.PublicOrientation;

public class MowerRunnerTest {

	private ParserDefinition buildParserDefinitionStub() {
		ParserDefinition result = new ParserDefinition();
		YardDefinition yardDefinition = new YardDefinition();
		yardDefinition.setLastCoordX(5);
		yardDefinition.setLastCoordY(7);
		result.setYardDefinition(yardDefinition);
		MowerDefinition mowerDefinition = new MowerDefinition();
		PositionDefinition initialPosition = new PositionDefinition();
		initialPosition.setX(1);
		initialPosition.setY(3);
		initialPosition.setOrientation(OrientationDefinition.N);
		mowerDefinition.setInitialPosition(initialPosition);
		mowerDefinition.addInstructionDefinition(InstructionDefinition.A);
		mowerDefinition.addInstructionDefinition(InstructionDefinition.D);
		mowerDefinition.addInstructionDefinition(InstructionDefinition.A);
		mowerDefinition.addInstructionDefinition(InstructionDefinition.D);
		result.setMowerDefinitions(Arrays.asList(new MowerDefinition[] { mowerDefinition }));
		return result;
	}

	@Test
	public void should_run_simple_definition() {
		MowerRunner runner = new MowerRunner();
		MowerTestListener listener = new MowerTestListener();
		runner.addMowerListener(listener);
		runner.execute(buildParserDefinitionStub());
		assertThat(listener.getMessageList().get(0).getPosition().getX()).isEqualTo(2);
		assertThat(listener.getMessageList().get(0).getPosition().getY()).isEqualTo(4);
		PublicOrientation orientation = new PublicOrientation(listener.getMessageList().get(0).getOrientation());
		assertThat(orientation.getDirection()).isEqualTo(SouthDirection.getInstance());
	}
}
