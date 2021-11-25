package Exceptions;

@SuppressWarnings("serial")
public class EmptyCartException extends Exception {
	
	public static final String MESSAGE = "Carrinho vazio!";
	
	public EmptyCartException() {
		super(MESSAGE);
	}
}