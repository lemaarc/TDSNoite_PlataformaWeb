package br.com.opet.gestime.dto;

import javax.validation.constraints.NotBlank;

import br.com.opet.gestime.model.Atividade;

public class RespAtividade {
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	private String gerencia;
	
	@NotBlank
	private String coordenador;
	
	@NotBlank
	private String descricao;
	
	@NotBlank
	private String sla;
	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGerencia() {
		return gerencia;
	}

	public void setGerencia(String gerencia) {
		this.gerencia = gerencia;
	}

	public String getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSla() {
		return sla;
	}

	public void setSla(String sla) {
		this.sla = sla;
	}

	public Atividade toAtividade() {
		Atividade atividade = new Atividade();
		atividade.setTitulo(titulo);
		atividade.setCoordenador(coordenador);
		atividade.setGerencia(gerencia);
		atividade.setSla(sla);
		atividade.setDescricao(descricao);
		return atividade;
	}

}
