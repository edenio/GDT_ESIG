package br.com.esig.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("GerenciadorDeTarefas");
	
	public static EntityManager getEntityManager() {
		
		return factory.createEntityManager();
		
	}

}
