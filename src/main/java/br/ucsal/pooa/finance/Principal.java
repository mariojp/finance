package br.ucsal.pooa.finance;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;

import br.ucsal.pooa.finance.controller.Controller;
import br.ucsal.pooa.finance.controller.LancamentoController;
import br.ucsal.pooa.finance.exceptions.ErroConecaoBancoDeDados;
import br.ucsal.pooa.finance.model.Lancamento;
import br.ucsal.pooa.finance.persistencia.Banco;
import br.ucsal.pooa.finance.persistencia.GenericoDAO;
import br.ucsal.pooa.finance.persistencia.LancamentoDAO;
import br.ucsal.pooa.finance.persistencia.Pessistencia;
import br.ucsal.pooa.finance.view.Janela;
import br.ucsal.pooa.finance.view.JanelaDestop;

public class Principal {

	public static void main(String[] args) {
	
	
	//M V C
	//
		//Banco banco;
		//try {
			//banco = new Banco();
			Pessistencia dao = new GenericoDAO();		
			Controller controller = new LancamentoController(dao);
			//Janela janela = new Janela(controller);
			JanelaDestop janela = new JanelaDestop(controller);
		//} catch (ErroConecaoBancoDeDados e) {
		//	System.out.println(e.getMessage());
			
		//}
		
		

	}
	
	
	

}
