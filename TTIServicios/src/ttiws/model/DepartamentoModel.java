package ttiws.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
@Table(name="departamento")
public class DepartamentoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int dep_Id;

	private String dep_Nombre;

	//bi-directional many-to-one association to PersonaModel
	@OneToMany(mappedBy="departamento")
	private List<PersonaModel> personas;

	public DepartamentoModel() {
	}

	public int getDep_Id() {
		return this.dep_Id;
	}

	public void setDep_Id(int dep_Id) {
		this.dep_Id = dep_Id;
	}

	public String getDep_Nombre() {
		return this.dep_Nombre;
	}

	public void setDep_Nombre(String dep_Nombre) {
		this.dep_Nombre = dep_Nombre;
	}

	public List<PersonaModel> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<PersonaModel> personas) {
		this.personas = personas;
	}

	public PersonaModel addPersona(PersonaModel persona) {
		getPersonas().add(persona);
		persona.setDepartamento(this);

		return persona;
	}

	public PersonaModel removePersona(PersonaModel persona) {
		getPersonas().remove(persona);
		persona.setDepartamento(null);

		return persona;
	}

}