package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import util.JPAUtil;
import dto.UsuarioDto;

public class UsuarioDao {
	
	private EntityManager em = JPAUtil.getEntityManager();
	
	public void salvarUsuario(UsuarioDto u){
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
	}
	
	public void excluirUsuario(UsuarioDto a){
		em.getTransaction().begin();
		em.remove(a);
		em.getTransaction().commit();
	}
	
	public void alterarUsuario(UsuarioDto a){
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<UsuarioDto> listarTodosUsuario(){
		em.getTransaction().begin();
		List<UsuarioDto> usuariosDto = em.createNativeQuery("SELECT U FROM USUARIOS U", UsuarioDto.class).getResultList();
		em.getTransaction().commit();
		return usuariosDto;
	}
	
	public UsuarioDto buscarUsuario(String login){
		UsuarioDto dto = null;
		String sql = "SELECT U FROM UsuarioDto U WHERE U.login = :login";
		em.getTransaction().begin();
		Query query = em.createQuery(sql, UsuarioDto.class);
		query.setParameter("login", login);
		dto = (UsuarioDto) query.getSingleResult();
		em.getTransaction().commit();
		return dto;
	}	
}