package br.com.banco.data.query;

import java.io.Serializable;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Component;

import br.com.banco.data.model.Transferencia;
import br.com.banco.interfaces.query.QueryExampleParams;

@Component
public class QueryExampleParamsTransferencia implements Serializable, QueryExampleParams<Transferencia> {

	private static final long serialVersionUID = 1L;

	private String dataInicio;

	private String dataFim;

	private String operador;

	public QueryExampleParamsTransferencia() {
		// TODO Auto-generated constructor stub
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	@Override
	public Example<Transferencia> getExample(Transferencia entity) {
		if (operador != null) {
			entity.setOperador(operador);
		}
		ExampleMatcher matcher = ExampleMatcher.matchingAll().withStringMatcher(StringMatcher.EXACT);
		Example<Transferencia> example = Example.of(entity, matcher);
		return example;
	}

}
