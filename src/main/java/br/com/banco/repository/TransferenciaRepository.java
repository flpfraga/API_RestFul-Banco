package br.com.banco.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.banco.data.model.Conta;
import br.com.banco.data.model.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer>{

	@Query("SELECT t FROM Transferencia t WHERE t.conta = :conta_id and t.data BETWEEN :inicio and :termino")
	public List<Transferencia> findByPeriod(Conta conta_id, Date inicio, Date termino);
	
	@Query("SELECT t FROM Transferencia t WHERE t.conta = :conta_id and t.operador = :operador and t.data BETWEEN :inicio and :termino")
	public List<Transferencia> findByPeriod(Conta conta_id, Date inicio, Date termino, String operador);
}
 