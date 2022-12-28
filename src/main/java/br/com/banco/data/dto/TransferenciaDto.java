package br.com.banco.data.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.dozermapper.core.Mapping;

import br.com.banco.data.model.Conta;

public class TransferenciaDto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Mapping("id")
	private Integer key;
	
	private Date data;
	
	private Float valor;
	
	private String tipo;
	
	private String operador;
	
	private Conta conta;

	
	public TransferenciaDto() {
		// TODO Auto-generated constructor stub
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conta, data, key, operador, tipo, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransferenciaDto other = (TransferenciaDto) obj;
		return Objects.equals(conta, other.conta) && Objects.equals(data, other.data) && Objects.equals(key, other.key)
				&& Objects.equals(operador, other.operador) && Objects.equals(tipo, other.tipo)
				&& Objects.equals(valor, other.valor);
	}
	

}
