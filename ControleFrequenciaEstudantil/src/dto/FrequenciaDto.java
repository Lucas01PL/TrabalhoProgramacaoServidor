package dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Frequencia")
public class FrequenciaDto{
	
	@Id
	@GeneratedValue
	private int id;
	@Temporal(TemporalType.DATE)
	@Column(nullable=true)
	private Date data;
	@OneToMany(mappedBy = "id.frequencia")
	private List<FrequenciaAlunoDto> frequenciaAlunosList;
	
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
	public List<FrequenciaAlunoDto> getFrequenciaAlunosList() {
		return frequenciaAlunosList;
	}
	public void setFrequenciaAlunosList(
			List<FrequenciaAlunoDto> frequenciaAlunosList) {
		this.frequenciaAlunosList = frequenciaAlunosList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		FrequenciaDto other = (FrequenciaDto) obj;
		if (id != other.id)
			return false;
		return true;
	}	
}
