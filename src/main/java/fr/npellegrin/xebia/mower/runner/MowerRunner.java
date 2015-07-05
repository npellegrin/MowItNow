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

	public void execute(ParserDefinition definition) {
		// Mappers
		YardDefinitionToYardMapper yardMapper = new YardDefinitionToYardMapper();
		PositionDefinitionToOrientationMapper orientationMapper = new PositionDefinitionToOrientationMapper();
		PositionDefinitionToPositionMapper positionMapper = new PositionDefinitionToPositionMapper();
		InstructionDefinitionListToInstructionListMapper instructionsMapper = new InstructionDefinitionListToInstructionListMapper();

		// Current yard
		Yard yard = yardMapper.map(definition.getYardDefinition());

		// All mowers
		List<MowerDefinition> mowerDefinitions = definition.getMowerDefinitions();
		for (MowerDefinition mowerDefinition : mowerDefinitions) {
			Position initialPosition = positionMapper.map(mowerDefinition.getInitialPosition());
			Orientation initialOrientation = orientationMapper.map(mowerDefinition.getInitialPosition());

			// Current mower
			Mower mower = new Mower(yard, initialPosition, initialOrientation);
			mower.addMowerListeners(listeners);

			// Execute all instructions
			// (mowers will broadcast the final position after move).
			mower.accept(instructionsMapper.map(mowerDefinition.getInstructionDefinitions()));
		}
	}

	public void addMowerListener(MowerListener listener) {
		listeners.add(listener);
	}
}
