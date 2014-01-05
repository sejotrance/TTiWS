package ttiws.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the carrera database table.
 * 
 */
@Entity
@Table(name="carrera")
public class CarreraModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int car_Id;

	private String car_Nombre;

	//bi-directional many-to-one association to EscuelaModel
	@ManyToOne
	private EscuelaModel escuela;

	//bi-directional many-to-one association to PersonaHasCarreraModel
	@OneToMany(mappedBy="carrera")
	private List<PersonaHasCarreraModel> personaHasCarreras;

	public CarreraModel() {
	}

	public int getCar_Id() {
		return this.car_Id;
	}

	public void setCar_Id(int car_Id) {
		this.car_Id = car_Id;
	}

	public String getCar_Nombre() {
		return this.car_Nombre;
	}

	public void setCar_Nombre(String car_Nombre) {
		this.car_Nombre = car_Nombre;
	}

	public EscuelaModel getEscuela() {
		return this.escuela;
	}

	public void setEscuela(EscuelaModel escuela) {
		this.escuela = escuela;
	}

	public List<PersonaHasCarreraModel> getPersonaHasCarreras() {
		return this.personaHasCarreras;
	}

	public void setPersonaHasCarreras(List<PersonaHasCarreraModel> personaHasCarreras) {
		this.personaHasCarreras = personaHasCarreras;
	}

	public PersonaHasCarreraModel addPersonaHasCarrera(PersonaHasCarreraModel personaHasCarrera) {
		getPersonaHasCarreras().add(personaHasCarrera);
		personaHasCarrera.setCarrera(this);

		return personaHasCarrera;
	}

	public PersonaHasCarreraModel removePersonaHasCarrera(PersonaHasCarreraModel personaHasCarrera) {
		getPersonaHasCarreras().remove(personaHasCarrera);
		personaHasCarrera.setCarrera(null);

		return personaHasCarrera;
	}

}