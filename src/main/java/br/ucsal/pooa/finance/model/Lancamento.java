package br.ucsal.pooa.finance.model;

import java.math.BigDecimal;

/**
 * Model Anemico
 * 
 * 
 * @author mariojp
 *
 */
public class Lancamento implements Entidade {
	
	public static final String DESPESA = "DESPESA";
	public static final String RECEITA = "RECEITA";

	private String tipo;
	private BigDecimal valor;
	private String descricao;
	public Lancamento(String tipo, BigDecimal valor, String descricao) {
		super();
		this.tipo = tipo;
		this.valor = valor;
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Lancamento [");
		if (tipo != null) {
			builder.append("tipo=");
			builder.append(tipo);
			builder.append(", ");
		}
		if (valor != null) {
			builder.append("valor=");
			builder.append(valor);
			builder.append(", ");
		}
		if (descricao != null) {
			builder.append("descricao=");
			builder.append(descricao);
		}
		builder.append("]");
		return builder.toString();
	}
	public String getTipo() {
		return tipo;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
	
	
}
