package br.ucsal.pooa.finance.controller;

import java.util.List;

import br.ucsal.pooa.finance.model.Entidade;

public interface Controller {

	void add(Entidade lancamento);

	public List<Entidade> lista();
}