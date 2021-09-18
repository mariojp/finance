package br.ucsal.pooa.finance.exceptions;

public class ErroConecaoBancoDeDados extends Exception {

	
	public ErroConecaoBancoDeDados(Throwable t) {
		super("Ocorreu um Erro ao tentar acessar o Banco de Dados", t);
	}
}
