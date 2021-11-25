package br.com.opet.gestime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.opet.gestime.model.Atividade;
import br.com.opet.gestime.model.StatusAtividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

	List<Atividade> findAllByStatus(StatusAtividade status);

}
