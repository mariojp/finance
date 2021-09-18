package br.ucsal.pooa.finance.exceptions;

public class ValorInvalidoException extends RuntimeException {

	
	public ValorInvalidoException(Throwable t) {
		super("Valor Invalido");
	}
}
