package br.ucsal.pooa.finance.persistencia;

import java.sql.Statement;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.pooa.finance.model.Entidade;
import br.ucsal.pooa.finance.model.Lancamento;

public class LancamentoDAO extends GenericoDAO implements Pessistencia{



	public LancamentoDAO(Banco banco) {
		this.banco = banco;
	}

	public List<Entidade> listar() {
		List<Entidade> lista = new ArrayList<>();
		try {
			Statement select = banco.createStatement();
			ResultSet resultSet = select.executeQuery("SELECT * FROM LANCAMENTOS");
			while (resultSet.next()) {
				String descricao = resultSet.getString("DESCRICAO");
				String c = resultSet.getString("TIPO");
				String tipo = "RECEITA";
				if(c.equals("D")) {
					tipo = "DESPESA";
				}
				String valor = resultSet.getString("VALOR").trim();
				BigDecimal bigDecimal = new BigDecimal(valor);
				Lancamento lancamento = new Lancamento(tipo, bigDecimal, descricao);
				lista.add(lancamento);
			}
			resultSet.close();
			select.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	public void inserir(Lancamento lancamento) {
		PreparedStatement insert;
		
		try {
			insert = banco.prepareStatement("INSERT INTO LANCAMENTOS "
					+ "(TIPO,DESCRICAO,VALOR) VALUES(?,?,?);");
			
			insert.setString(1, lancamento.getTipo().charAt(0)+"");
			insert.setString(2, lancamento.getDescricao().trim());
			insert.setString(3, lancamento.getValor().toPlainString());
			
			insert.execute();
			
			insert.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
