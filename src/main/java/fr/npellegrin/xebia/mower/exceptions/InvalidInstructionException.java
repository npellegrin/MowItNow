package fr.npellegrin.xebia.mower.exceptions;

public class InvalidInstructionException extends IllegalArgumentException {
	private static final long serialVersionUID = -4836035788054880194L;

	public InvalidInstructionException() {
		super();
	}

	public InvalidInstructionException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public InvalidInstructionException(final String message) {
		super(message);
	}

	public InvalidInstructionException(final Throwable cause) {
		super(cause);
	}

}
