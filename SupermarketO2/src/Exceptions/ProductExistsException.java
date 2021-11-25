package Exceptions;

@SuppressWarnings("serial")
public class ProductExistsException extends Exception {
	
	public static final String MESSAGE = "Artigo existente!";
	
	public ProductExistsException() {
		super(MESSAGE);
	}
}