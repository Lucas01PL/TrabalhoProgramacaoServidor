package model;

import java.util.ArrayList;
import java.util.List;

import dao.AlunoDao;
import dto.AlunoDto;
public class Aluno{
	
	public static AlunoDao dao = new AlunoDao();
	
	private int matricula;
	private String nomeCompleto;
	private List<FrequenciaAluno> frequenciaAlunoList;
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public List<FrequenciaAluno> getFrequenciaAlunoList() {
		return frequenciaAlunoList;
	}
	public void setFrequencia(List<FrequenciaAluno> frequenciaAlunoList) {
		this.frequenciaAlunoList = frequenciaAlunoList;
	}
	public AlunoDto getAlunoDto(){
		AlunoDto dto = new AlunoDto();
		dto.setMatricula(matricula);
		dto.setNomeCompleto(nomeCompleto);
		//dto.setFrequenciaAlunoList(frequenciaAlunoList);
		return dto;
	}
	
	private void setAluno(AlunoDto dto){
		setMatricula(dto.getMatricula());
		setNomeCompleto(dto.getNomeCompleto());
		//setFrequencia(dto.getFrequenciaAlunoList());
	}
	
	public void salvarAluno(){
		dao.salvarAluno(getAlunoDto());
	}
	
	public void excluirAluno(){
		dao.excluirAluno(getAlunoDto());
	}
	
	public void alterarAluno(){
		dao.alterarAluno(getAlunoDto());
	}
	
	public Aluno buscarAluno(){
		AlunoDto dtoConsulta = new AlunoDto();
		dtoConsulta.setMatricula(matricula);
		
		AlunoDto dtoRetornado = dao.buscarAlunoMatricula(dtoConsulta.getMatricula());
		if(dtoRetornado == null)
		{
			return null;
		}
		
		Aluno a = new Aluno();
		a.setAluno(dtoRetornado);
		return a;
	}
	
	public static List<Aluno> listarTodosAlunos(){
		List<Aluno> listaAlunos = new ArrayList<Aluno>();
		List<AlunoDto> listaAlunosDto = dao.listarTodosAlunos();
		if(listaAlunosDto == null){
			return null;
		}
		for (AlunoDto dto : listaAlunosDto) {
			Aluno aluno = new Aluno();
			aluno.setAluno(dto);
			listaAlunos.add(aluno);
		}
		return listaAlunos;
	}
}