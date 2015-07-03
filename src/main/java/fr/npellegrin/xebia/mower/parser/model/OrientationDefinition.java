package fr.npellegrin.xebia.mower.parser.model;

import java.util.HashMap;
import java.util.Map;

public enum OrientationDefinition {
	N("N"), S("S"), E("E"), O("O");

	private String value;

	private OrientationDefinition(String value) {
		this.value = value;
	}

	/**
	 * Map of String representation -> instruction.
	 */
	public static Map<String, OrientationDefinition> orientationMap() {
		Map<String, OrientationDefinition> result = new HashMap<String, OrientationDefinition>();
		for (OrientationDefinition orientation : OrientationDefinition.values()) {
			result.put(orientation.value, orientation);
		}
		return result;
	}
}
