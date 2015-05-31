package dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * FAZER VALIDAÇÃO DAS COLUNAS DAS TABELAS APOS TESTE.
 * @COLUMN(VALIDACOES)
 */
@Entity
@Table(name="Usuarios")
public class UsuarioDto{
	@Id
	@Column(unique=true, length=50, nullable=true)
	private String login;
	@Column(nullable=true, length=50)
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
}