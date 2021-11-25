package br.com.opet.gestime.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.opet.gestime.dto.RespAtividade;
import br.com.opet.gestime.model.Atividade;
import br.com.opet.gestime.model.StatusAtividade;
import br.com.opet.gestime.repository.AtividadeRepository;

@Controller
@RequestMapping("atividade")
public class AtividadeController {
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	@GetMapping("formulario")
	public String formulario(RespAtividade requisicao) {
		return "atividade/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RespAtividade requisicao, BindingResult result) {
		if(result.hasErrors()) {
			return "atividade/formulario";
		}
		Atividade atividade = requisicao.toAtividade();
		atividade.setStatus(StatusAtividade.CRIADO);
		atividadeRepository.save(atividade);
		return"redirect:/home";
	}

}
