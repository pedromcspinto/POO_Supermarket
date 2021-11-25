package Exceptions;

@SuppressWarnings("serial")
public class CartExistsException extends Exception {
	
	public static final String MESSAGE = "Carrinho existente!";
	
	public CartExistsException() {
		super(MESSAGE);
	}
}