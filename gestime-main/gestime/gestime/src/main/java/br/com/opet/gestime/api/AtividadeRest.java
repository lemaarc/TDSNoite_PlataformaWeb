package br.com.opet.gestime.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.opet.gestime.model.Atividade;
import br.com.opet.gestime.repository.AtividadeRepository;

@RestController
@RequestMapping("/api")
public class AtividadeRest {

	@Autowired
	private AtividadeRepository atividadeRepository;
	
	@GetMapping("atividade")
	public List<Atividade> getAtividade(){
		return atividadeRepository.findAll();
	}
	
}
