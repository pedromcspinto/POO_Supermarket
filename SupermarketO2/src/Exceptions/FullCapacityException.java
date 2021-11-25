package Exceptions;

@SuppressWarnings("serial")
public class FullCapacityException extends Exception {
	
	public static final String MESSAGE = "Capacidade excedida!";
	
	public FullCapacityException() {
		super(MESSAGE);
	}
}