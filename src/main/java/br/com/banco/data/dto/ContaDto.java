package br.com.banco.data.dto;

import java.io.Serializable;
import java.util.Objects;

import com.github.dozermapper.core.Mapping;

public class ContaDto implements Serializable{
	
	

	private static final long serialVersionUID = 1L;

	@Mapping("id_conta")
	private Integer key;
	
	private String nome;
	
	public ContaDto() {
		// TODO Auto-generated constructor stub
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(key, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaDto other = (ContaDto) obj;
		return Objects.equals(key, other.key) && Objects.equals(nome, other.nome);
	}
	
	
	


}
