package ttiws.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the persona_has_rol database table.
 * 
 */
@Embeddable
public class PersonaHasRolModelPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int per_Rol_Id;

	@Column(unique=true, nullable=false)
	private int persona_Per_Id;

	@Column(unique=true, nullable=false)
	private int rol_Rol_Id;

	public PersonaHasRolModelPK() {
	}
	public int getPer_Rol_Id() {
		return this.per_Rol_Id;
	}
	public void setPer_Rol_Id(int per_Rol_Id) {
		this.per_Rol_Id = per_Rol_Id;
	}
	public int getPersona_Per_Id() {
		return this.persona_Per_Id;
	}
	public void setPersona_Per_Id(int persona_Per_Id) {
		this.persona_Per_Id = persona_Per_Id;
	}
	public int getRol_Rol_Id() {
		return this.rol_Rol_Id;
	}
	public void setRol_Rol_Id(int rol_Rol_Id) {
		this.rol_Rol_Id = rol_Rol_Id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonaHasRolModelPK)) {
			return false;
		}
		PersonaHasRolModelPK castOther = (PersonaHasRolModelPK)other;
		return 
			(this.per_Rol_Id == castOther.per_Rol_Id)
			&& (this.persona_Per_Id == castOther.persona_Per_Id)
			&& (this.rol_Rol_Id == castOther.rol_Rol_Id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.per_Rol_Id;
		hash = hash * prime + this.persona_Per_Id;
		hash = hash * prime + this.rol_Rol_Id;
		
		return hash;
	}
}