package br.com.esig.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.esig.dao.DAO;
import br.com.esig.model.cadastro;
import br.com.esig.utility.CadastroExceptions;

public class CadastroService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DAO<cadastro> dao;

	public void salvar(cadastro c) throws CadastroExceptions {
		
		if(c.getTitulo().length() > 100) {
			throw new CadastroExceptions("O Titulo Não pode ser maior que 100 caracteres");

		}
		
		dao.salvar(c);

	}

	public void remover(cadastro c) throws CadastroExceptions {

		dao.remover(cadastro.class, c.getId());

	}

	public List<cadastro> todosOsCadastros() {

		return dao.buscarTodos("select c from cadastro c order by c.id");

	}

}
