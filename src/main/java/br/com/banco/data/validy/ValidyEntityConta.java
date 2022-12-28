package br.com.banco.data.validy;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import br.com.banco.data.dto.ContaDto;
import br.com.banco.exception.InvalidParamsException;
import br.com.banco.interfaces.validy.ValidyEntity;

@Component
public class ValidyEntityConta implements Serializable, ValidyEntity<ContaDto>{

	private static final long serialVersionUID = 1L;
	

	@Override
	public void entityIsValid(ContaDto entity) {
		if (entity.getNome() == null) {
			throw new InvalidParamsException("Param name is null");
		}
		if (entity.getNome().equals("")) {
			throw new InvalidParamsException("Param name is null");
		}
		
	}

}
