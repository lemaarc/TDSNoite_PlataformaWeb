package br.com.opet.gestime.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.opet.gestime.model.Atividade;
import br.com.opet.gestime.model.StatusAtividade;
import br.com.opet.gestime.repository.AtividadeRepository;

@Controller
@RequestMapping("/atividade")
public class FiltroController {

	@Autowired
	private AtividadeRepository atividadeRepository;
	
	
	@GetMapping("/filtro/{status}")
	public String criado(@PathVariable("status") String status, Model model) {
		List<Atividade> atividades = atividadeRepository.findAllByStatus(StatusAtividade.valueOf(status.toUpperCase()));
		model.addAttribute("atividades", atividades);
		return "atividade/filtro";
	}
}
