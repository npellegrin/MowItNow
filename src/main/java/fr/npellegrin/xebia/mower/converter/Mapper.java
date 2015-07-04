package fr.npellegrin.xebia.mower.converter;

// FIXME: Switch to Java 8 interface when available
public interface Mapper<T, R> {
	public R map(T input);
}
