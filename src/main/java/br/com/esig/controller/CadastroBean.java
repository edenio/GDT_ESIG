package br.com.esig.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.esig.model.cadastro;
import br.com.esig.service.CadastroService;
import br.com.esig.utility.CadastroExceptions;
import br.com.esig.utility.Message;

@Named
@ViewScoped
public class CadastroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private cadastro cadastro;

	@Inject
	private CadastroService service;

	private List<cadastro> cadastros;

	@PostConstruct
	public void carregar() {

		cadastros = service.todosOsCadastros();

	}

	public CadastroService getService() {
		return service;
	}

	public void setService(CadastroService service) {
		this.service = service;
	}

	public void setCadastros(List<cadastro> cadastros) {
		this.cadastros = cadastros;
	}

	public void adicionar() {

		try {

			service.salvar(cadastro);
			cadastro = new cadastro();
			carregar();
			Message.info("Salvo com sucesso");

		} catch (CadastroExceptions e) {
			Message.erro(e.getMessage());
		}

	}

	public void Excluir() {

		try {

			service.remover(cadastro);
			carregar();

			Message.info(cadastro.getTitulo() + "foi removido");

		} catch (CadastroExceptions e) {
			Message.erro(e.getMessage());
		}

	}
	
	public void Remover() {

		try {

			service.remover(cadastro);
			carregar();

			Message.info(cadastro.getTitulo() + "Tarefa Concluída");

		} catch (CadastroExceptions e) {
			Message.erro(e.getMessage());
		}

	}

	public cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public List<cadastro> getCadastros() {
		return cadastros;
	}

}
