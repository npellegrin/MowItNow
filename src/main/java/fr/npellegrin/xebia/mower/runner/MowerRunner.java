package fr.npellegrin.xebia.mower.runner;

import java.util.ArrayList;
import java.util.List;

import fr.npellegrin.xebia.mower.Mower;
import fr.npellegrin.xebia.mower.converter.InstructionDefinitionListToInstructionListMapper;
import fr.npellegrin.xebia.mower.converter.PositionDefinitionToOrientationMapper;
import fr.npellegrin.xebia.mower.converter.PositionDefinitionToPositionMapper;
import fr.npellegrin.xebia.mower.converter.YardDefinitionToYardMapper;
import fr.npellegrin.xebia.mower.environment.Position;
import fr.npellegrin.xebia.mower.environment.Yard;
import fr.npellegrin.xebia.mower.listener.MowerListener;
import fr.npellegrin.xebia.mower.orientation.Orientation;
import fr.npellegrin.xebia.mower.parser.model.MowerDefinition;
import fr.npellegrin.xebia.mower.parser.model.ParserDefinition;

public class MowerRunner {
	// Mappers
	private static final YardDefinitionToYardMapper YARD_MAPPER = new YardDefinitionToYardMapper();
	private static final PositionDefinitionToOrientationMapper ORIENTATION_MAPPER = new PositionDefinitionToOrientationMapper();
	private static final PositionDefinitionToPositionMapper POSITION_MAPPER = new PositionDefinitionToPositionMapper();
	private static final InstructionDefinitionListToInstructionListMapper INSTRUCTIONS_MAPPER = new InstructionDefinitionListToInstructionListMapper();

	// Listeners
	private final List<MowerListener> listeners;

	public MowerRunner() {
		listeners = new ArrayList<MowerListener>();
	}

	public void execute(final ParserDefinition definition) {
		// Current yard
		final Yard yard = YARD_MAPPER.map(definition.getYardDefinition());

		// All mowers
		final List<MowerDefinition> mowerDefinitions = definition.getMowerDefinitions();
		for (final MowerDefinition mowerDefinition : mowerDefinitions) {
			final Position initialPosition = POSITION_MAPPER.map(mowerDefinition.getInitialPosition());
			final Orientation initialOrientation = ORIENTATION_MAPPER.map(mowerDefinition.getInitialPosition());

			// Current mower
			final Mower mower = new Mower(yard, initialPosition, initialOrientation);
			mower.addMowerListeners(listeners);

			// Execute all instructions
			// (mowers will broadcast the final position after move).
			mower.accept(INSTRUCTIONS_MAPPER.map(mowerDefinition.getInstructionDefinitions()));
		}
	}

	public void addMowerListener(final MowerListener listener) {
		listeners.add(listener);
	}
}
