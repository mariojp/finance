package br.ucsal.pooa.finance;

import br.ucsal.pooa.finance.util.Consumidor;
import br.ucsal.pooa.finance.util.Pilha;
import br.ucsal.pooa.finance.util.Produtor;
import br.ucsal.pooa.finance.util.Trabalhador;
import br.ucsal.pooa.finance.util.TrabalhadorRun;

public class PrincipalThread {

	
	public static void main(String[] args) {
		System.out.println("INICIO DO MAIN");
		Pilha pilha = new Pilha();
		Thread thread = new Thread(new Produtor(pilha));
		Thread cthread = new Thread(new Consumidor(pilha));
		Thread c2thread = new Thread(new Consumidor(pilha));

		thread.start();
		cthread.start();
		c2thread.start();

		System.out.println("FIM DO MAIN");
		
		
		

	}
}
