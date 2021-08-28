package br.ucsal.pooa.finance;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;

import br.ucsal.pooa.finance.model.Lancamento;
import br.ucsal.pooa.finance.persistencia.LancamentoDAO;
import br.ucsal.pooa.finance.view.Janela;

public class Principal {

	public static void main(String[] args) {
	
	
	//M V C
	//
		LancamentoDAO dao = new LancamentoDAO();
		Janela janela = new Janela(dao.listar());

	}
	
	
	

}
