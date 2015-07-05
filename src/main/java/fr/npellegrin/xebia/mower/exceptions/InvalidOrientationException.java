package fr.npellegrin.xebia.mower.exceptions;

public class InvalidOrientationException extends IllegalArgumentException {
	private static final long serialVersionUID = 4461172506137206599L;

	public InvalidOrientationException() {
		super();
	}

	public InvalidOrientationException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public InvalidOrientationException(final String message) {
		super(message);
	}

	public InvalidOrientationException(final Throwable cause) {
		super(cause);
	}

}
