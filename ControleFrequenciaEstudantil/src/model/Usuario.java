package model;

import dao.UsuarioDao;
import dto.UsuarioDto;

/*
 * FAZER VERIFICAR DISPONIBILIDADE DE USUARIO PARA O SISTEMA.
 * USUARIO VAI SER CHAVE PRIMARIA;
 */

public class Usuario {
	
	private static UsuarioDao dao = new UsuarioDao();
	
	private String login;
	private String senha;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	private UsuarioDto getUsuarioDto(){
		UsuarioDto dto = new UsuarioDto();
		dto.setLogin(login);
		dto.setSenha(senha);
		return dto;
	}
	
	private void setUsuario(UsuarioDto dto){
		setLogin(dto.getLogin());
		setSenha(dto.getSenha());
	}
	
	public void salvarUsuario(){
		dao.salvarUsuario(getUsuarioDto());
	}
	
	public void excluirUsuario(){
		dao.excluirUsuario(getUsuarioDto());
	}
	
	public void alterarUsuario(){
		dao.alterarUsuario(getUsuarioDto());
	}
	
	public static Usuario buscarUsuario(String login){
		UsuarioDto dtoConsulta = new UsuarioDto();
		dtoConsulta.setLogin(login);
		
		UsuarioDto dtoRetornado = dao.buscarUsuario(login);
		if(dtoRetornado == null)
		{
			return null;
		}
		
		Usuario u = new Usuario();
		u.setUsuario(dtoRetornado);
		return u;
	}
}