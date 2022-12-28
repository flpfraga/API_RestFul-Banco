package br.com.banco.data.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta implements Serializable{
	
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_conta;
	
	@Column(name = "nome_responsavel", length = 50, nullable = false )
	private String nome;

	
	public Conta() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId_conta() {
		return id_conta;
	}

	public void setId_conta(Integer id_conta) {
		this.id_conta = id_conta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_conta, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(id_conta, other.id_conta) && Objects.equals(nome, other.nome);
	}
	@Override
	public String toString() {
		return "Conta [id_conta=" + id_conta + ", nome=" + nome + "]";
	}
	
	
}
