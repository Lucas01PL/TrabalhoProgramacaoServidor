package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aluno;

public class SalvarAlunoServlet extends HttpServlet{

	private static final long serialVersionUID = -9211121138600109988L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = req.getParameter("nome");
		if(nome != null)
		{
			Aluno a = new Aluno();
			a.setNomeCompleto(nome);
		}
	}
}
