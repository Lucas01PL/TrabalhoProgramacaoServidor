package dto;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Embeddable
public class FrequenciaAlunoId implements Serializable{

	private static final long serialVersionUID = 6100715038333454305L;

	@ManyToOne(fetch=FetchType.LAZY)
	private AlunoDto aluno;
	@ManyToOne(fetch=FetchType.LAZY)
	private FrequenciaDto frequencia;
	
	public AlunoDto getAluno() {
		return aluno;
	}
	public void setAluno(AlunoDto aluno) {
		this.aluno = aluno;
	}
	public FrequenciaDto getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(FrequenciaDto frequencia) {
		this.frequencia = frequencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result
				+ ((frequencia == null) ? 0 : frequencia.hashCode());
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
		FrequenciaAlunoId other = (FrequenciaAlunoId) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (frequencia == null) {
			if (other.frequencia != null)
				return false;
		} else if (!frequencia.equals(other.frequencia))
			return false;
		return true;
	}
}
