package fr.npellegrin.xebia.mower.exceptions;

public class InvalidOrientationException extends IllegalArgumentException {
	private static final long serialVersionUID = 4461172506137206599L;

	public InvalidOrientationException() {
		super();
	}

	public InvalidOrientationException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidOrientationException(String s) {
		super(s);
	}

	public InvalidOrientationException(Throwable cause) {
		super(cause);
	}

}
