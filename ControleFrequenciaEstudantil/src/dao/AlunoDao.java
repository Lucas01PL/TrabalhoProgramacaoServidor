package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import util.JPAUtil;
import dto.AlunoDto;
import dto.UsuarioDto;

public class AlunoDao {
	
	private EntityManager em = JPAUtil.getEntityManager();
	
	public void salvarAluno(AlunoDto a){
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}
	
	public void excluirAluno(AlunoDto a){
		em.getTransaction().begin();
		em.remove(a);
		em.getTransaction().commit();
	}
	
	public void alterarAluno(AlunoDto a){
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<AlunoDto> listarTodosAlunos(){
		em.getTransaction().begin();
		List<AlunoDto> alunosDto = em.createNativeQuery("SELECT A FROM ALUNOS A", AlunoDto.class).getResultList();
		em.getTransaction().commit();
		return alunosDto;
	}
	
	public AlunoDto buscarAlunoMatricula(int matricula){
		String sql = "SELECT A FROM ALUNO A WHERE A.MATRICULA = :matricula";
		em.getTransaction().begin();
		Query query = em.createQuery(sql, UsuarioDto.class);
		query.setParameter("matricula", matricula);
		AlunoDto dto = (AlunoDto) query.getSingleResult();
		em.getTransaction().commit();
		return dto;
	}
}
