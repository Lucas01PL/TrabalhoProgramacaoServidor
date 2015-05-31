package excecao;

public class LoginException extends SecurityException{
	
	private static final long serialVersionUID = -8629699756523249615L;

	public LoginException() {
        super("Erro de Login");
    }

}
