package fr.npellegrin.xebia.mower.converter;

/**
 * Mapper interface.
 */
// FIXME: Switch to Java 8 interface when available
public interface Mapper<T, R> {
	R map(T input);
}
