package fr.npellegrin.xebia.mower.exceptions;

/**
 * Represents and exception thrown by the parser.
 */
public class ParserException extends Exception {
	private static final long serialVersionUID = -5690949595972473232L;

	public ParserException() {
		super();
	}

	public ParserException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ParserException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ParserException(final String message) {
		super(message);
	}

	public ParserException(final Throwable cause) {
		super(cause);
	}

}
