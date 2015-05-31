package dto;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * FAZER VALIDAÇÃO DAS COLUNAS DAS TABELAS APOS TESTE.
 * @COLUMN(VALIDACOES)
 */
@Entity
@Table(name="Aluno")
public class AlunoDto{
	@Id
	@GeneratedValue
	private int matricula;
	private String nomeCompleto;
	@OneToMany(mappedBy="id.aluno")
	private List<FrequenciaAlunoDto> frequenciaAlunoList;
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public List<FrequenciaAlunoDto> getFrequenciaAlunoList() {
		return frequenciaAlunoList;
	}
	public void setFrequenciaAlunoList(List<FrequenciaAlunoDto> frequenciaAlunoList) {
		this.frequenciaAlunoList = frequenciaAlunoList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matricula;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoDto other = (AlunoDto) obj;
		if (matricula != other.matricula)
			return false;
		return true;
	}
}
