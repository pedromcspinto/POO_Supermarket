package Exceptions;

@SuppressWarnings("serial")
public class InexistentCartException extends Exception {
	
	public static final String MESSAGE = "Carrinho inexistente!";
	
	public InexistentCartException() {
		super(MESSAGE);
	}
}