package com.fluxo.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.fluxo.model.Usuario;

public class UsuarioController {

	public SessionFactory sessionFactory;
	
	public void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
		        .configure() // configures settings from hibernate.cfg.xml
		        .build();
		try {
		    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			ex.printStackTrace();
		    StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	public void create() {
		
		Usuario usuario = new Usuario();
		
		usuario.setIdUsuario(2);
		usuario.setLogin("marcos");
		usuario.setNome("Marcos");
		usuario.setSenha("123");
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(usuario);
		session.getTransaction().commit();
		session.close();
	}

	public void exit() {
		
		sessionFactory.close();
		
	}
}
