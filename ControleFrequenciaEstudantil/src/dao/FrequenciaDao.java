package dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import util.JPAUtil;
import dto.FrequenciaDto;

public class FrequenciaDao {
	
	private EntityManager em = JPAUtil.getEntityManager();
	
	public void salvarFrequencia(FrequenciaDto f){
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
	}
	
	public void excluirFrequencia(FrequenciaDto f){
		em.getTransaction().begin();
		em.remove(f);
		em.getTransaction().commit();
	}
	
	public void alterarFrequencia(FrequenciaDto f){
		em.getTransaction().begin();
		em.merge(f);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<FrequenciaDto> listarTodasFrequencias(){
		em.getTransaction().begin();
		List<FrequenciaDto> frequencias = em.createNativeQuery("SELECT F FROM FREQUENCIAS F", FrequenciaDto.class).getResultList();
		em.getTransaction().commit();
		return frequencias;
	}
	
	public FrequenciaDto buscarFrequenciaId(int id){
		String sql = "SELECT F FROM FREQUENCIAS F WHERE A.ID = id";
		em.getTransaction().begin();
		Query query = em.createQuery(sql, FrequenciaDto.class);
		query.setParameter("id", id);
		FrequenciaDto f = (FrequenciaDto) query.getSingleResult();
		em.getTransaction().commit();
		return f;
	}
	
	public List <FrequenciaDto> buscarFrequenciaData(Date data){
		String sql = "SELECT F FROM FREQUENCIAS F WHERE A.DATA = :data";
		em.getTransaction().begin();
		Query query = em.createQuery(sql, FrequenciaDto.class);
		@SuppressWarnings("unchecked")
		List<FrequenciaDto> listaFrequencias =  query.getResultList();
		query.setParameter("data", data);
		em.getTransaction().commit();
		return listaFrequencias;
	}
}