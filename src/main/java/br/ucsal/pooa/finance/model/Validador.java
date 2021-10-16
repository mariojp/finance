package br.ucsal.pooa.finance.model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Validador {

	private Object object;
	
	public Validador(Object object) {
		this.object = object;
	}
	
	
	public List<String> validar() {
		List<String> erros = new ArrayList<>();
		Class<?> classe =  object.getClass();
		Field[] atributos = classe.getDeclaredFields();
		for (Field atributo : atributos) {
			atributo.setAccessible(true);
			if(atributo.isAnnotationPresent(Validacao.class)) {
				Validacao validacao = atributo.getAnnotation(Validacao.class);
				Object valor = null;
				try {
					valor = atributo.get(object);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				
				if(valor == null ||
						valor.toString().isEmpty()) {	
						erros.add("Preecha "+validacao.descricao());	
				}
			}
		}
//		if(lancamento.getTipo() == null ||
//				lancamento.getTipo().isEmpty()) {
//			
//		}
//		if(lancamento.getDescricao() == null ||
//				lancamento.getDescricao().isEmpty()) {
//			erros.add("Preencha Descricao");
//		}
//		if(lancamento.getValor() == null ||
//				lancamento.getValor().equals(BigDecimal.ZERO) ) {
//			erros.add("Preencha Valor");
//		}
		return erros;
	}
}
