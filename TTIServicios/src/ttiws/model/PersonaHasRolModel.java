package ttiws.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the persona_has_rol database table.
 * 
 */
@Entity
@Table(name="persona_has_rol")
public class PersonaHasRolModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonaHasRolModelPK id;

	private byte per_Rol_Es_Vigente;

	@Temporal(TemporalType.TIMESTAMP)
	private Date per_Rol_Fecha_Mod;

	//bi-directional many-to-one association to PersonaModel
	@ManyToOne
	@JoinColumn(name = "Persona_Per_Id", referencedColumnName = "Per_Id", insertable=false, updatable=false)
	private PersonaModel persona;

	//bi-directional many-to-one association to RolModel
	@ManyToOne
	@JoinColumn(name = "Rol_Rol_Id", referencedColumnName = "Rol_Id", insertable=false, updatable=false)
	private RolModel rol;

	public PersonaHasRolModel() {
	}

	public PersonaHasRolModelPK getId() {
		return this.id;
	}

	public void setId(PersonaHasRolModelPK id) {
		this.id = id;
	}

	public byte getPer_Rol_Es_Vigente() {
		return this.per_Rol_Es_Vigente;
	}

	public void setPer_Rol_Es_Vigente(byte per_Rol_Es_Vigente) {
		this.per_Rol_Es_Vigente = per_Rol_Es_Vigente;
	}

	public Date getPer_Rol_Fecha_Mod() {
		return this.per_Rol_Fecha_Mod;
	}

	public void setPer_Rol_Fecha_Mod(Date per_Rol_Fecha_Mod) {
		this.per_Rol_Fecha_Mod = per_Rol_Fecha_Mod;
	}

	public PersonaModel getPersona() {
		return this.persona;
	}

	public void setPersona(PersonaModel persona) {
		this.persona = persona;
	}

	public RolModel getRol() {
		return this.rol;
	}

	public void setRol(RolModel rol) {
		this.rol = rol;
	}

}