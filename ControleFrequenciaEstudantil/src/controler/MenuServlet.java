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

@WebServlet(name="Menu", value="/Menu")
public class MenuServlet extends HttpServlet{
	
	private static final long serialVersionUID = 7605410315658800588L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		if(usuarioLogado != null)
		{
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/menu.jsp");
			rd.forward(req, resp);
		}
		else
		{
			new UsuarioNaoLogadoException();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
