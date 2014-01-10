package ttiws.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@Table(name="rol")
public class RolModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int rol_Id;

	@Column(nullable=false, length=45)
	private String rol_Nombre;

	//bi-directional many-to-one association to PersonaHasRolModel
	@OneToMany(mappedBy="rol")
	private List<PersonaHasRolModel> personaHasRols;

	//bi-directional many-to-many association to PersonaModel
	@ManyToMany(mappedBy="rols")
	private List<PersonaModel> personas;

	public RolModel() {
	}

	public int getRol_Id() {
		return this.rol_Id;
	}

	public void setRol_Id(int rol_Id) {
		this.rol_Id = rol_Id;
	}

	public String getRol_Nombre() {
		return this.rol_Nombre;
	}

	public void setRol_Nombre(String rol_Nombre) {
		this.rol_Nombre = rol_Nombre;
	}

	public List<PersonaHasRolModel> getPersonaHasRols() {
		return this.personaHasRols;
	}

	public void setPersonaHasRols(List<PersonaHasRolModel> personaHasRols) {
		this.personaHasRols = personaHasRols;
	}

	public PersonaHasRolModel addPersonaHasRol(PersonaHasRolModel personaHasRol) {
		getPersonaHasRols().add(personaHasRol);
		personaHasRol.setRol(this);

		return personaHasRol;
	}

	public PersonaHasRolModel removePersonaHasRol(PersonaHasRolModel personaHasRol) {
		getPersonaHasRols().remove(personaHasRol);
		personaHasRol.setRol(null);

		return personaHasRol;
	}

	public List<PersonaModel> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<PersonaModel> personas) {
		this.personas = personas;
	}

}