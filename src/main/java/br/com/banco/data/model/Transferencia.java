package br.com.banco.data.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transferencia implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "data_transferencia", nullable = false)
	private Date data;
	
	@Column(precision = 2, nullable = false)
	private Float valor;
	
	@Column(length = 15, nullable = false)
	private String tipo;
	
	@Column(name = "nome_operador_transacao", length = 50)
	private String operador;
	
	@ManyToOne
	@JoinColumn(name = "conta_id")
	private Conta conta;
	
	
	public Transferencia() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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
		return Objects.hash(conta, data, id, operador, tipo, valor);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transferencia other = (Transferencia) obj;
		return Objects.equals(conta, other.conta) && Objects.equals(data, other.data) && Objects.equals(id, other.id)
				&& Objects.equals(operador, other.operador) && Objects.equals(tipo, other.tipo)
				&& Objects.equals(valor, other.valor);
	}

	@Override
	public String toString() {
		return "Transferencia [id=" + id + ", data=" + data + ", valor=" + valor + ", tipo=" + tipo + ", operador="
				+ operador + ", conta=" + conta + "]";
	}
}
