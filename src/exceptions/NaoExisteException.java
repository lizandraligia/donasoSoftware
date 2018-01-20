package exceptions;

public class NaoExisteException extends Exception{

	public NaoExisteException(){
		super("Nao encontrado. Tente novamente.");
	}
}
