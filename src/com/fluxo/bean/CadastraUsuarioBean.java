package com.fluxo.bean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.fluxo.controller.UsuarioController;
import com.fluxo.model.Usuario;

@ManagedBean(name="cadastraUsuarioBean")
@RequestScoped
public class CadastraUsuarioBean {

	private String login;
	private String nome;
	private String senha;
	private UsuarioController usuarioController;
	
	public void salvarUsuario() {
		
		Usuario usuario = new Usuario();
		usuarioController = new UsuarioController();
		usuario.setLogin(this.login);
		usuario.setNome(this.nome);
		usuario.setSenha(this.senha);
		
		usuarioController.salvarUsuario(usuario);
		
		limparCampos();
	}

	private void limparCampos() {
		
		this.login = null;
		this.nome = null;
		this.senha = null;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
