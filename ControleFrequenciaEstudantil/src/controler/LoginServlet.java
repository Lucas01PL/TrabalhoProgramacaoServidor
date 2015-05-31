package controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import excecao.UsuarioNaoLogadoException;

@WebServlet(name="Login", value="/Login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = -6685291958554341233L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario usu = new Usuario();
		usu.setLogin("admin");
		usu.setSenha("admin");
		usu.salvarUsuario();
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		Usuario u = new Usuario();
		u = Usuario.buscarUsuario(login);
		
		if (u != null)
		{
			if (u.getSenha().equals(senha))
			{
				HttpSession session = req.getSession();
				session.setAttribute("usuarioLogado", u);
				
				RequestDispatcher rd = req.getRequestDispatcher("/Menu");
				rd.forward(req, resp);
			}
			else
			{
				new UsuarioNaoLogadoException();
			}
		}
		else
		{
			new UsuarioNaoLogadoException();
		}
	}

}
