package br.ucsal.pooa.finance.view;

import java.util.List;
import java.util.Vector;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.ucsal.pooa.finance.model.Entidade;
import br.ucsal.pooa.finance.model.Lancamento;

public class Tabela extends DefaultTableModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
	
	public Tabela(List<Entidade> dados) {
		super(dados(dados), column("Tipo","Descrição","Valor"));
	}
	
	public void setData(List<Entidade> dados) {
		super.setDataVector(dados(dados), column("Tipo","Descrição","Valor"));
	}
	
	
	public static Vector dados(List<Entidade> lancamentos) {
		Vector<Vector<String>> vector = new Vector<>();
		for (Entidade entidade : lancamentos) {
			Vector<String> linha = new Vector<>();
			Lancamento lancamento = (Lancamento) entidade;
			linha.add(lancamento.getTipo());
			linha.add(lancamento.getDescricao());
			linha.add(lancamento.getValor().toPlainString());
			vector.add(linha);
		}
		return vector;
	}
	
	
	public static Vector column(String ... colunas) {
		Vector<String> vector = new Vector<>();
		for (String object : colunas) {
			vector.add(object);
		}
		return vector;
	}
	
//	@Override
//	public int getRowCount() {
//		return dados.size();
//	}
//
//	@Override
//	public int getColumnCount() {
//		return 3;
//	}
//
//	@Override
//	public String getColumnName(int columnIndex) {
//		return colunas[columnIndex];
//	}
//
//	@Override
//	public Class<?> getColumnClass(int columnIndex) {
//		return String.class;
//	}
//
//	public void fireTableDataChanged() {
//		super.fireTableDataChanged();
//		super.fireTableStructureChanged();
//
//	}
//
//
//	@Override
//	public Object getValueAt(int rowIndex, int columnIndex) {
//		Entidade entidade = dados.get(rowIndex);
//		Lancamento lancamento = (Lancamento) entidade;
//		String valor = "";
//		switch (columnIndex) {
//		case 0:
//			valor =  lancamento.getTipo();
//			break;
//			
//		case 1:
//			valor =  lancamento.getDescricao();
//			break;
//			
//		case 2:
//			valor =  lancamento.getValor().toPlainString();
//			break;
//
//		default:
//			break;
//		}
//		return null;
//	}



}
