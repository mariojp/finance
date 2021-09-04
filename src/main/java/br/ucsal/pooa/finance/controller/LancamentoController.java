package br.ucsal.pooa.finance.controller;

import java.util.List;

import br.ucsal.pooa.finance.model.Entidade;
import br.ucsal.pooa.finance.persistencia.Pessistencia;

public class LancamentoController implements Controller {

	
	private Pessistencia dao;
	
	
	public LancamentoController(Pessistencia dao) {
		this.dao = dao;
	}
	


	@Override
	public void add(Entidade lancamento) {
		dao.inserir(lancamento);
	}

	public List<Entidade> lista() {
		return dao.listar();
	}
	
	
}
