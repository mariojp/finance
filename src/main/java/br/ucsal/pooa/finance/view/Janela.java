package br.ucsal.pooa.finance.view;

import java.math.BigDecimal;
import java.util.Scanner;

import br.ucsal.pooa.finance.controller.Controller;
import br.ucsal.pooa.finance.model.Entidade;
import br.ucsal.pooa.finance.model.Lancamento;

public class Janela {

	private Scanner terminal = new Scanner(System.in);
	private Controller controller;
	
	
	public Janela(Controller controller) {
		this.controller = controller;
		init();
	}
	
	private void init() {
		String op;
		do {
			System.out.println("MENU");
			System.out.println("1-CADASTRAR");
			System.out.println("2-LISTAR");
			System.out.println("3-SALDO");

			System.out.println("S-SAIR");
			System.out.println("OPÇÃO: ");
			op = terminal.nextLine();
		}while (
				!(op.equals("1") ||
				op.equals("2") ||
				op.equals("3") ||
				op.equalsIgnoreCase("S"))
				);
		switch (op) {
			case "1":
				cadastrar();
				break;
			case "2":
				listar();
				break;
			case "3":
				saldo();
				break;
		default:
			System.exit(0);
			break;
		}
	}
	
	public void saldo() {
		BigDecimal saldo = BigDecimal.ZERO;
		for (Entidade entidade : controller.lista()) {
			Lancamento lancamento = (Lancamento) entidade;
			if(lancamento.getTipo().equals("DESPESA")) {
				saldo = saldo.subtract(lancamento.getValor());
				
			}else {
				saldo = saldo.add(lancamento.getValor());
			}
		}
		System.out.println(saldo.toPlainString());
		init();
	}
	
	public void listar() {
		//lista 
		for (Entidade entidade : controller.lista()) {
			System.out.println(entidade);
		}
		init();
	}
	
	public void cadastrar() {
		String tipo;
		do {
			System.out.print("Digite a Tipo 1 - DESPESA ou 2 RECEITA [1 - DESPESA] :");
			tipo = terminal.nextLine();
			tipo = tipo.trim();
			if (tipo.isEmpty() || tipo.equals("1")) {
				tipo = "DESPESA";
			}else if(tipo.equals("2")){
				tipo = "RECEITA";
			}
		} while ( !(tipo.equals("DESPESA") || tipo.equals("RECEITA")));
		
		System.out.print("Digite a Descricão["+tipo+"]:");
		String descricao = terminal.nextLine();
		if(descricao.isEmpty()) {
			descricao = tipo;
		}
		System.out.print("Digite o Valor:");
		String valor = terminal.nextLine();
		BigDecimal amount = new BigDecimal(valor);
		
		Lancamento lancamento = new Lancamento(tipo, amount, descricao);
		
		controller.add(lancamento);
		init();
	}
	
}
