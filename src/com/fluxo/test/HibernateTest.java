package com.fluxo.test;

import com.fluxo.controller.UsuarioController;

public class HibernateTest {

	public static void main(String[] args) {
		
		UsuarioController usuarioController = new UsuarioController();
		usuarioController.setup();
		usuarioController.create();
		usuarioController.exit();
	}
}
