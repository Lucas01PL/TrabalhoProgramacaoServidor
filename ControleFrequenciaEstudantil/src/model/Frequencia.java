package model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import dao.FrequenciaDao;
import dto.FrequenciaDto;
public class Frequencia{
	
	private static FrequenciaDao dao = new FrequenciaDao();
	
	private int id;
	private Date data;
	private List<FrequenciaAluno> frequenciaAlunoList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<FrequenciaAluno> getFrequenciaAlunoList() {
		return frequenciaAlunoList;
	}
	public void setFrequenciaAlunoList(List<FrequenciaAluno> frequenciaAlunoList) {
		this.frequenciaAlunoList = frequenciaAlunoList;
	}

	private FrequenciaDto getFrequenciaDto(){
		FrequenciaDto dto = new FrequenciaDto();
		dto.setData(data);
		dto.setId(id);
		//dto.setFrequenciaAlunosList(frequenciaAlunoList);
		return dto;
	}
	
	private void setFrequencia(FrequenciaDto dto){
		setData(dto.getData());
		setId(dto.getId());
		//setFrequenciaAlunoList();
	}
	
	public void salvarFrequencia(){
		dao.salvarFrequencia(getFrequenciaDto());
	}
	
	public void excluirFrequencia(){
		dao.excluirFrequencia(getFrequenciaDto());
	}
	
	public void alterarFrequencia(){
		dao.alterarFrequencia(getFrequenciaDto());
	}
	
	public Frequencia buscarFrequencia(){
		FrequenciaDto dtoConsulta = new FrequenciaDto();
		dtoConsulta.setId(id);
		FrequenciaDto dtoRetornado = dao.buscarFrequenciaId(dtoConsulta.getId());
		if(dtoRetornado == null)
		{
			return null;
		}
		Frequencia f = new Frequencia();
		f.setFrequencia(dtoRetornado);
		return f;
	}
	
	public List<Frequencia> listarTodasFrequencias(){
		List<FrequenciaDto> listaFrequenciaDto = dao.listarTodasFrequencias();
		List<Frequencia> listaFrequencia = new ArrayList<Frequencia>();
		
		if(listaFrequenciaDto == null)
		{
			return null;
		}
		
		for (FrequenciaDto frequenciaDto : listaFrequenciaDto) {
			Frequencia f = new Frequencia();
			f.setFrequencia(frequenciaDto);
			listaFrequencia.add(f);
		}
		return listaFrequencia;
	}
}
