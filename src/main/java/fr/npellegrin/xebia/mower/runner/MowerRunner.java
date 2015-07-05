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
	private final List<MowerListener> listeners;

	public MowerRunner() {
		listeners = new ArrayList<MowerListener>();
	}

	public void execute(final ParserDefinition definition) {
		// Mappers
		final YardDefinitionToYardMapper yardMapper = new YardDefinitionToYardMapper();
		final PositionDefinitionToOrientationMapper orientationMapper = new PositionDefinitionToOrientationMapper();
		final PositionDefinitionToPositionMapper positionMapper = new PositionDefinitionToPositionMapper();
		final InstructionDefinitionListToInstructionListMapper instructionsMapper = new InstructionDefinitionListToInstructionListMapper();

		// Current yard
		final Yard yard = yardMapper.map(definition.getYardDefinition());

		// All mowers
		final List<MowerDefinition> mowerDefinitions = definition.getMowerDefinitions();
		for (final MowerDefinition mowerDefinition : mowerDefinitions) {
			final Position initialPosition = positionMapper.map(mowerDefinition.getInitialPosition());
			final Orientation initialOrientation = orientationMapper.map(mowerDefinition.getInitialPosition());

			// Current mower
			final Mower mower = new Mower(yard, initialPosition, initialOrientation);
			mower.addMowerListeners(listeners);

			// Execute all instructions
			// (mowers will broadcast the final position after move).
			mower.accept(instructionsMapper.map(mowerDefinition.getInstructionDefinitions()));
		}
	}

	public void addMowerListener(final MowerListener listener) {
		listeners.add(listener);
	}
}
