package br.ucsal.pooa.finance.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.ucsal.pooa.finance.model.Entidade;
import br.ucsal.pooa.finance.model.Lancamento;

public class GenericoDAO implements Pessistencia {
	
	private List lista;
	
	protected Banco banco;


	public GenericoDAO() {
		 lista = new ArrayList();
	}
	
	public void inserir(Entidade lancamento) {
		lista.add(lancamento);
	}
		
	public List<Entidade> listar() {
		return lista;
	}

	@Override
	public int count() {
		return lista.size();
	} 
	
	
	
	
}
