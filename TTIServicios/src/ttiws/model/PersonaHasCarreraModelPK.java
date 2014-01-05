package ttiws.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the persona_has_carrera database table.
 * 
 */
@Embeddable
public class PersonaHasCarreraModelPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int persona_Per_Id;

	private int carrera_Car_Id;

	private int per_Car_Id;

	public PersonaHasCarreraModelPK() {
	}
	public int getPersona_Per_Id() {
		return this.persona_Per_Id;
	}
	public void setPersona_Per_Id(int persona_Per_Id) {
		this.persona_Per_Id = persona_Per_Id;
	}
	public int getCarrera_Car_Id() {
		return this.carrera_Car_Id;
	}
	public void setCarrera_Car_Id(int carrera_Car_Id) {
		this.carrera_Car_Id = carrera_Car_Id;
	}
	public int getPer_Car_Id() {
		return this.per_Car_Id;
	}
	public void setPer_Car_Id(int per_Car_Id) {
		this.per_Car_Id = per_Car_Id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonaHasCarreraModelPK)) {
			return false;
		}
		PersonaHasCarreraModelPK castOther = (PersonaHasCarreraModelPK)other;
		return 
			(this.persona_Per_Id == castOther.persona_Per_Id)
			&& (this.carrera_Car_Id == castOther.carrera_Car_Id)
			&& (this.per_Car_Id == castOther.per_Car_Id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.persona_Per_Id;
		hash = hash * prime + this.carrera_Car_Id;
		hash = hash * prime + this.per_Car_Id;
		
		return hash;
	}
}