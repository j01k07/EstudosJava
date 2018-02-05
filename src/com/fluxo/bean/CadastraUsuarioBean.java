package com.fluxo.bean;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
		
		if(!validaDadosPreenchidos()) {
			return;
		}
		Usuario usuario = new Usuario();
		usuarioController = new UsuarioController();
		usuario.setLogin(this.login);
		usuario.setNome(this.nome);
		usuario.setSenha(this.senha);
		
		usuarioController.salvarUsuario(usuario);
		
		limparCampos();
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Usuário salvo com sucesso."));
	}

	private boolean validaDadosPreenchidos() {
		
		if(this.nome.equals("")) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The message to display"));
			return false;
		}
		return true;
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
