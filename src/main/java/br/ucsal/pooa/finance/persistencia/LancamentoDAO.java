package br.ucsal.pooa.finance.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.ucsal.pooa.finance.model.Lancamento;

public class LancamentoDAO {

	private List<Lancamento> lista = new ArrayList<>();
	
	
	public LancamentoDAO() {
		
	}
	
	public List<Lancamento> listar(){
		//TODO ver boas praticas
		return lista;
	}
	
	public void inserir(Lancamento lancamento){
		lista.add(lancamento);
	}
	
}
