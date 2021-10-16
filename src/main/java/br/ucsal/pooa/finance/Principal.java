package br.ucsal.pooa.finance;

import java.io.IOException;
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
import br.ucsal.pooa.finance.util.DolarServidor;
import br.ucsal.pooa.finance.util.SocketDollar;
import br.ucsal.pooa.finance.view.Console;
import br.ucsal.pooa.finance.view.Destop;

public class Principal {

	public static void main(String[] args) {
	
//		try {
//			DolarServidor dolar = new DolarServidor();
//			new Thread(dolar).start();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		new Thread(new SocketDollar()).start();;
	
	//M V C
	//
		//Banco banco;
		//try {
			//banco = new Banco();
		
			Pessistencia dao = new GenericoDAO();		
			
			Controller controller = new LancamentoController(dao);
			
			controller.add(new Lancamento("D", BigDecimal.ONE, "DESPESA"));
			Destop janela = new Destop(controller);
			
			
			//Console console = new Console(controller);

		//} catch (ErroConecaoBancoDeDados e) {
			//System.out.println(e.getMessage());
			
		//}
			
			

		
		

	}
	
	
	

}
