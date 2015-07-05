package fr.npellegrin.xebia.mower;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileNotFoundException;

import org.junit.Test;

import fr.npellegrin.xebia.mower.exceptions.ParserException;
import fr.npellegrin.xebia.mower.orientation.EastDirection;
import fr.npellegrin.xebia.mower.orientation.NorthDirection;
import fr.npellegrin.xebia.mower.parser.Parser;
import fr.npellegrin.xebia.mower.parser.model.ParserDefinition;
import fr.npellegrin.xebia.mower.runner.MowerRunner;
import fr.npellegrin.xebia.mower.utils.MowerTestListener;
import fr.npellegrin.xebia.mower.utils.PublicOrientation;

/**
 * Test all chain, from Xebia file to expected result.
 */
public class TestChain {

	@Test
	public void should_run_xebia_file() throws FileNotFoundException, ParserException {
		// Init & run
		final Parser parser = new Parser();
		final ParserDefinition parserDefinition = parser.parse("src/test/resources/xebia_move.txt");
		final MowerRunner runner = new MowerRunner();
		final MowerTestListener listener = new MowerTestListener();
		runner.addMowerListener(listener);
		runner.execute(parserDefinition);

		// Mower 0
		assertThat(listener.getMessageList().get(0).getPosition().getX()).isEqualTo(1);
		assertThat(listener.getMessageList().get(0).getPosition().getY()).isEqualTo(3);
		final PublicOrientation orientation0 = new PublicOrientation(listener.getMessageList().get(0).getOrientation());
		assertThat(orientation0.getDirection()).isEqualTo(NorthDirection.getInstance());

		// Mower 1
		assertThat(listener.getMessageList().get(1).getPosition().getX()).isEqualTo(5);
		assertThat(listener.getMessageList().get(1).getPosition().getY()).isEqualTo(1);
		final PublicOrientation orientation1 = new PublicOrientation(listener.getMessageList().get(1).getOrientation());
		assertThat(orientation1.getDirection()).isEqualTo(EastDirection.getInstance());
	}
}
