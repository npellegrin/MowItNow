package fr.npellegrin.xebia.mower.exceptions;

public class InvalidInstructionException extends IllegalArgumentException {
	private static final long serialVersionUID = -4836035788054880194L;

	public InvalidInstructionException() {
		super();
	}

	public InvalidInstructionException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidInstructionException(String s) {
		super(s);
	}

	public InvalidInstructionException(Throwable cause) {
		super(cause);
	}

}
