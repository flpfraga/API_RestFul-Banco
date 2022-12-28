package br.com.banco.interfaces.validy;

public interface ValidyParams<T, D> extends ValidyEntity<D>{

	void paramsIsValid(T params);

}