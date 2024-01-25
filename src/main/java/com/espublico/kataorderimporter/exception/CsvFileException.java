package com.espublico.kataorderimporter.exception;

/**
 * {@code CsvFileException} is a custom runtime exception class used to
 * represent exceptions related to the csv service.
 *
 * @author Andreu Aguilar
 * @version 1.0
 * @since 2024-01-22
 */
public class CsvFileException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new {@code ImporterException} with the specified detail message.
	 *
	 * @param message The detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method).
	 */
	public CsvFileException(String message) {
		super(message);
	}

	/**
	 * Constructs a new {@code ImporterException} with the specified detail message
	 * and cause.
	 *
	 * @param message The detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method).
	 * @param cause   The cause (which is saved for later retrieval by the
	 *                {@link #getCause()} method).
	 */
	public CsvFileException(String message, Throwable cause) {
		super(message, cause);
	}

}
