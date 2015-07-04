package fr.npellegrin.xebia.mower.runner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.npellegrin.xebia.mower.listener.MowerBroadcastMessage;
import fr.npellegrin.xebia.mower.listener.MowerListener;
import fr.npellegrin.xebia.mower.orientation.Direction;
import fr.npellegrin.xebia.mower.orientation.EastDirection;
import fr.npellegrin.xebia.mower.orientation.Orientation;
import fr.npellegrin.xebia.mower.parser.model.InstructionDefinition;
import fr.npellegrin.xebia.mower.parser.model.MowerDefinition;
import fr.npellegrin.xebia.mower.parser.model.OrientationDefinition;
import fr.npellegrin.xebia.mower.parser.model.ParserDefinition;
import fr.npellegrin.xebia.mower.parser.model.PositionDefinition;
import fr.npellegrin.xebia.mower.parser.model.YardDefinition;

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
		assertThat(orientation.getDirection()).isEqualTo(EastDirection.getInstance());
	}

	/**
	 * Test class to increase visibility of direction.
	 */
	class PublicOrientation extends Orientation {

		public PublicOrientation(Direction initialDirection) {
			super(initialDirection);
		}

		public PublicOrientation(Orientation orientation) {
			super(orientation);
		}

		public Direction getDirection() {
			return direction;
		}
	}

	/**
	 * Test listener to retrieve mower positions.
	 */
	class MowerTestListener implements MowerListener {
		// list of received messages
		private List<MowerBroadcastMessage> messageList = new ArrayList<MowerBroadcastMessage>();

		public List<MowerBroadcastMessage> getMessageList() {
			return messageList;
		}

		@Override
		public void messageReceived(MowerBroadcastMessage message) {
			messageList.add(message);
		}
	}
}
