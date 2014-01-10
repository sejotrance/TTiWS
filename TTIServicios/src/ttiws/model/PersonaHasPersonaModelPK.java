package ttiws.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the persona_has_persona database table.
 * 
 */
@Embeddable
public class PersonaHasPersonaModelPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int per_Per_Id;

	@Column(unique=true, nullable=false)
	private int persona_Per_Id;

	@Column(unique=true, nullable=false)
	private int persona_Per_Id1;

	public PersonaHasPersonaModelPK() {
	}
	public int getPer_Per_Id() {
		return this.per_Per_Id;
	}
	public void setPer_Per_Id(int per_Per_Id) {
		this.per_Per_Id = per_Per_Id;
	}
	public int getPersona_Per_Id() {
		return this.persona_Per_Id;
	}
	public void setPersona_Per_Id(int persona_Per_Id) {
		this.persona_Per_Id = persona_Per_Id;
	}
	public int getPersona_Per_Id1() {
		return this.persona_Per_Id1;
	}
	public void setPersona_Per_Id1(int persona_Per_Id1) {
		this.persona_Per_Id1 = persona_Per_Id1;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonaHasPersonaModelPK)) {
			return false;
		}
		PersonaHasPersonaModelPK castOther = (PersonaHasPersonaModelPK)other;
		return 
			(this.per_Per_Id == castOther.per_Per_Id)
			&& (this.persona_Per_Id == castOther.persona_Per_Id)
			&& (this.persona_Per_Id1 == castOther.persona_Per_Id1);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.per_Per_Id;
		hash = hash * prime + this.persona_Per_Id;
		hash = hash * prime + this.persona_Per_Id1;
		
		return hash;
	}
}