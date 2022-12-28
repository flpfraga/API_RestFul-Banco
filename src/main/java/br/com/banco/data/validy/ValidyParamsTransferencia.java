package br.com.banco.data.validy;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import br.com.banco.data.dto.TransferenciaDto;
import br.com.banco.data.model.Transferencia;
import br.com.banco.exception.InvalidParamsException;
import br.com.banco.interfaces.query.QueryExampleParams;
import br.com.banco.interfaces.validy.ValidyParams;

@Component
public class ValidyParamsTransferencia
		implements Serializable, ValidyParams<QueryExampleParams<Transferencia>, TransferenciaDto> {

	private static final long serialVersionUID = 1L;

	@Override
	public void entityIsValid(TransferenciaDto entity) {
		if (entity.getData() == null || entity.getTipo() == null || entity.getValor() == null) {
			throw new InvalidParamsException("Invalid null entity data!");
		}
		if (entity.getData().equals("") || entity.getTipo().equals("") || entity.getValor() == 0) {
			throw new InvalidParamsException("Invalid null entity data!");
		}

	}

	@Override
	public void paramsIsValid(QueryExampleParams<Transferencia> params) {
		if (params.getDataInicio() == null || params.getDataFim() == null) {
			throw new InvalidParamsException("Invalid null params!");
		}
		if (params.getDataInicio().equals("") || params.getDataFim().equals("")) {
			throw new InvalidParamsException("Invalid null params!");
		}

	}

}
