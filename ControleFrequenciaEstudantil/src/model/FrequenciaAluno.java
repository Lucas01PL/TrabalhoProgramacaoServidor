package model;

import java.util.ArrayList;
import java.util.List;

import dto.FrequenciaAlunoDto;
import dto.FrequenciaDto;

public class FrequenciaAluno {
	
	
	private Aluno aluno;
	private Frequencia frequencia;
	private boolean status;

	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Frequencia getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(Frequencia frequencia) {
		this.frequencia = frequencia;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	private FrequenciaAlunoDto getFrequenciaAlunoDto(){
		FrequenciaAlunoDto dto = new FrequenciaAlunoDto();
		dto.se
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
