package ttiws.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the persona_has_ttitulo database table.
 * 
 */
@Embeddable
public class PersonaHasTtituloModelPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int persona_Per_Id;

	private int TTitulo_TTi_Id;

	private int per_TTi_Id;

	public PersonaHasTtituloModelPK() {
	}
	public int getPersona_Per_Id() {
		return this.persona_Per_Id;
	}
	public void setPersona_Per_Id(int persona_Per_Id) {
		this.persona_Per_Id = persona_Per_Id;
	}
	public int getTTitulo_TTi_Id() {
		return this.TTitulo_TTi_Id;
	}
	public void setTTitulo_TTi_Id(int TTitulo_TTi_Id) {
		this.TTitulo_TTi_Id = TTitulo_TTi_Id;
	}
	public int getPer_TTi_Id() {
		return this.per_TTi_Id;
	}
	public void setPer_TTi_Id(int per_TTi_Id) {
		this.per_TTi_Id = per_TTi_Id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonaHasTtituloModelPK)) {
			return false;
		}
		PersonaHasTtituloModelPK castOther = (PersonaHasTtituloModelPK)other;
		return 
			(this.persona_Per_Id == castOther.persona_Per_Id)
			&& (this.TTitulo_TTi_Id == castOther.TTitulo_TTi_Id)
			&& (this.per_TTi_Id == castOther.per_TTi_Id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.persona_Per_Id;
		hash = hash * prime + this.TTitulo_TTi_Id;
		hash = hash * prime + this.per_TTi_Id;
		
		return hash;
	}
}