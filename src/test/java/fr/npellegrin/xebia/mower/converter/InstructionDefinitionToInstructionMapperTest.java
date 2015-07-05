package fr.npellegrin.xebia.mower.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import fr.npellegrin.xebia.mower.controls.MoveForwardInstruction;
import fr.npellegrin.xebia.mower.controls.RotateLeftInstruction;
import fr.npellegrin.xebia.mower.controls.RotateRightInstruction;
import fr.npellegrin.xebia.mower.parser.model.InstructionDefinition;

public class InstructionDefinitionToInstructionMapperTest {

	@Test
	public void should_map_parameters() {
		final InstructionDefinitionToInstructionMapper mapper = new InstructionDefinitionToInstructionMapper();
		assertThat(mapper.map(InstructionDefinition.A)).isInstanceOf(MoveForwardInstruction.class);
		assertThat(mapper.map(InstructionDefinition.G)).isInstanceOf(RotateLeftInstruction.class);
		assertThat(mapper.map(InstructionDefinition.D)).isInstanceOf(RotateRightInstruction.class);
	}

}
