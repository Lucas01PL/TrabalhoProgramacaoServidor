package excecao;

import javax.servlet.ServletException;

public class UsuarioNaoLogadoException extends ServletException{
	
	private static final long serialVersionUID = -8170389596762356368L;

	public UsuarioNaoLogadoException() {
        super("Usu�rio N�o Logado");
        
    }

}
