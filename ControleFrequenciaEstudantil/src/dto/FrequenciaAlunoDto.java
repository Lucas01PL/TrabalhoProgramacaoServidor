package dto;

import javax.persistence.EmbeddedId;

public class FrequenciaAlunoDto {

	@EmbeddedId
	private FrequenciaAlunoId id;
	
	private boolean status;

	public FrequenciaAlunoId getId() {
		return id;
	}
	public void setId(FrequenciaAlunoId id) {
		this.id = id;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
