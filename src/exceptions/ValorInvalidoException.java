package exceptions;

public class ValorInvalidoException extends Exception{

	public ValorInvalidoException(){
		super("Informacao invalida ou campo obrigatorio em branco. Por favor verifique e tente novamente.");
	}
}
