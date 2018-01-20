package exceptions;

public class UsuarioExistenteException extends Exception{

	public UsuarioExistenteException(){
		super("O usuario informado ja esta cadastrado no sistema.");
	}
}
