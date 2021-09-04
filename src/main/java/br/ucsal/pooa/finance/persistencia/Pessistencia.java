package br.ucsal.pooa.finance.persistencia;

import java.util.List;

import br.ucsal.pooa.finance.model.Entidade;

public interface Pessistencia {

	
	public void inserir(Entidade lancamento);
		
	public List<Entidade> listar();
	
	public int count();
}
