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
	@Column(unique=true, nullable=false)
	private int car_Id;

	@Column(nullable=false)
	private int car_Codigo;

	@Column(nullable=false, length=60)
	private String car_Nombre;

	//bi-directional many-to-one association to EscuelaModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Escuela_Esc_Id", nullable=false)
	private EscuelaModel escuela;

	//bi-directional many-to-one association to PersonaHasCarreraModel
	@OneToMany(mappedBy="carrera")
	private List<PersonaHasCarreraModel> personaHasCarreras;

	//bi-directional many-to-many association to PersonaModel
	@ManyToMany(mappedBy="carreras")
	private List<PersonaModel> personas;

	public CarreraModel() {
	}

	public int getCar_Id() {
		return this.car_Id;
	}

	public void setCar_Id(int car_Id) {
		this.car_Id = car_Id;
	}

	public int getCar_Codigo() {
		return this.car_Codigo;
	}

	public void setCar_Codigo(int car_Codigo) {
		this.car_Codigo = car_Codigo;
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

	public List<PersonaModel> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<PersonaModel> personas) {
		this.personas = personas;
	}

}