package Exceptions;

@SuppressWarnings("serial")
public class ProductInexistentOnCartException extends Exception {
	
	public static final String MESSAGE = "Artigo inexistente no carrinho!";
	
	public ProductInexistentOnCartException() {
		super(MESSAGE);
	}
}