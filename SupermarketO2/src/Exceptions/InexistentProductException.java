package Exceptions;

@SuppressWarnings("serial")
public class InexistentProductException extends Exception {
	
	public static final String MESSAGE = "Artigo inexistente!";
	
	public InexistentProductException() {
		super(MESSAGE);
	}
}