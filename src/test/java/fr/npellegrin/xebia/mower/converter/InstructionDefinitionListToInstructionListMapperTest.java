package fr.npellegrin.xebia.mower.converter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fr.npellegrin.xebia.mower.controls.Instruction;
import fr.npellegrin.xebia.mower.controls.MoveForwardInstruction;
import fr.npellegrin.xebia.mower.controls.RotateLeftInstruction;
import fr.npellegrin.xebia.mower.controls.RotateRightInstruction;
import fr.npellegrin.xebia.mower.parser.model.InstructionDefinition;

public class InstructionDefinitionListToInstructionListMapperTest {

	@Test
	public void should_map_parameters() {
		InstructionDefinitionListToInstructionListMapper mapper = new InstructionDefinitionListToInstructionListMapper();
		InstructionDefinition[] input = { InstructionDefinition.A, InstructionDefinition.G, InstructionDefinition.D };
		List<Instruction> result = mapper.map(Arrays.asList(input));
		assertThat(result).hasSize(3);
		assertThat(result.get(0)).isInstanceOf(MoveForwardInstruction.class);
		assertThat(result.get(1)).isInstanceOf(RotateLeftInstruction.class);
		assertThat(result.get(2)).isInstanceOf(RotateRightInstruction.class);
	}

}
