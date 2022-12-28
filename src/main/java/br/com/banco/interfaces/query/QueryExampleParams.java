package br.com.banco.interfaces.query;

import org.springframework.data.domain.Example;

public interface QueryExampleParams<T> extends QueryParams{

	Example<T> getExample(T entity);
}
