package ttiws.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Table(name="persona")
public class PersonaModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int per_Id;

	private String per_Ano_IngresoAlu;

	private String per_Apellido_Materno;

	private String per_Apellido_Paterno;

	private String per_Dirección;

	private String per_Email;

	private String per_Nombre;

	private String per_Notas;

	private String per_Password;

	private String per_Run;

	private String per_Telefono_Celular;

	private String per_Usuario;

	//bi-directional many-to-one association to DepartamentoModel
	@ManyToOne
	private DepartamentoModel departamento;

	//bi-directional many-to-one association to PersonaHasCarreraModel
	@OneToMany(mappedBy="persona")
	private List<PersonaHasCarreraModel> personaHasCarreras;

	//bi-directional many-to-one association to PersonaHasPersonaModel
	@OneToMany(mappedBy="persona1")
	private List<PersonaHasPersonaModel> personaHasPersonas1;

	//bi-directional many-to-one association to PersonaHasPersonaModel
	@OneToMany(mappedBy="persona2")
	private List<PersonaHasPersonaModel> personaHasPersonas2;

	//bi-directional many-to-one association to PersonaHasRolModel
	@OneToMany(mappedBy="persona")
	private List<PersonaHasRolModel> personaHasRols;

	//bi-directional many-to-one association to PersonaHasTtituloModel
	@OneToMany(mappedBy="persona")
	private List<PersonaHasTtituloModel> personaHasTtitulos;

	//bi-directional many-to-one association to ArchivoModel
	@OneToMany(mappedBy="persona")
	private List<ArchivoModel> archivos;

	//bi-directional many-to-one association to CalificacionModel
	@OneToMany(mappedBy="persona")
	private List<CalificacionModel> calificacions;

	//bi-directional many-to-one association to ReunionModel
	@OneToMany(mappedBy="persona")
	private List<ReunionModel> reunions;

	public PersonaModel() {
	}

	public int getPer_Id() {
		return this.per_Id;
	}

	public void setPer_Id(int per_Id) {
		this.per_Id = per_Id;
	}

	public String getPer_Ano_IngresoAlu() {
		return this.per_Ano_IngresoAlu;
	}

	public void setPer_Ano_IngresoAlu(String per_Ano_IngresoAlu) {
		this.per_Ano_IngresoAlu = per_Ano_IngresoAlu;
	}

	public String getPer_Apellido_Materno() {
		return this.per_Apellido_Materno;
	}

	public void setPer_Apellido_Materno(String per_Apellido_Materno) {
		this.per_Apellido_Materno = per_Apellido_Materno;
	}

	public String getPer_Apellido_Paterno() {
		return this.per_Apellido_Paterno;
	}

	public void setPer_Apellido_Paterno(String per_Apellido_Paterno) {
		this.per_Apellido_Paterno = per_Apellido_Paterno;
	}

	public String getPer_Dirección() {
		return this.per_Dirección;
	}

	public void setPer_Dirección(String per_Dirección) {
		this.per_Dirección = per_Dirección;
	}

	public String getPer_Email() {
		return this.per_Email;
	}

	public void setPer_Email(String per_Email) {
		this.per_Email = per_Email;
	}

	public String getPer_Nombre() {
		return this.per_Nombre;
	}

	public void setPer_Nombre(String per_Nombre) {
		this.per_Nombre = per_Nombre;
	}

	public String getPer_Notas() {
		return this.per_Notas;
	}

	public void setPer_Notas(String per_Notas) {
		this.per_Notas = per_Notas;
	}

	public String getPer_Password() {
		return this.per_Password;
	}

	public void setPer_Password(String per_Password) {
		this.per_Password = per_Password;
	}

	public String getPer_Run() {
		return this.per_Run;
	}

	public void setPer_Run(String per_Run) {
		this.per_Run = per_Run;
	}

	public String getPer_Telefono_Celular() {
		return this.per_Telefono_Celular;
	}

	public void setPer_Telefono_Celular(String per_Telefono_Celular) {
		this.per_Telefono_Celular = per_Telefono_Celular;
	}

	public String getPer_Usuario() {
		return this.per_Usuario;
	}

	public void setPer_Usuario(String per_Usuario) {
		this.per_Usuario = per_Usuario;
	}

	public DepartamentoModel getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(DepartamentoModel departamento) {
		this.departamento = departamento;
	}

	public List<PersonaHasCarreraModel> getPersonaHasCarreras() {
		return this.personaHasCarreras;
	}

	public void setPersonaHasCarreras(List<PersonaHasCarreraModel> personaHasCarreras) {
		this.personaHasCarreras = personaHasCarreras;
	}

	public PersonaHasCarreraModel addPersonaHasCarrera(PersonaHasCarreraModel personaHasCarrera) {
		getPersonaHasCarreras().add(personaHasCarrera);
		personaHasCarrera.setPersona(this);

		return personaHasCarrera;
	}

	public PersonaHasCarreraModel removePersonaHasCarrera(PersonaHasCarreraModel personaHasCarrera) {
		getPersonaHasCarreras().remove(personaHasCarrera);
		personaHasCarrera.setPersona(null);

		return personaHasCarrera;
	}

	public List<PersonaHasPersonaModel> getPersonaHasPersonas1() {
		return this.personaHasPersonas1;
	}

	public void setPersonaHasPersonas1(List<PersonaHasPersonaModel> personaHasPersonas1) {
		this.personaHasPersonas1 = personaHasPersonas1;
	}

	public PersonaHasPersonaModel addPersonaHasPersonas1(PersonaHasPersonaModel personaHasPersonas1) {
		getPersonaHasPersonas1().add(personaHasPersonas1);
		personaHasPersonas1.setPersona1(this);

		return personaHasPersonas1;
	}

	public PersonaHasPersonaModel removePersonaHasPersonas1(PersonaHasPersonaModel personaHasPersonas1) {
		getPersonaHasPersonas1().remove(personaHasPersonas1);
		personaHasPersonas1.setPersona1(null);

		return personaHasPersonas1;
	}

	public List<PersonaHasPersonaModel> getPersonaHasPersonas2() {
		return this.personaHasPersonas2;
	}

	public void setPersonaHasPersonas2(List<PersonaHasPersonaModel> personaHasPersonas2) {
		this.personaHasPersonas2 = personaHasPersonas2;
	}

	public PersonaHasPersonaModel addPersonaHasPersonas2(PersonaHasPersonaModel personaHasPersonas2) {
		getPersonaHasPersonas2().add(personaHasPersonas2);
		personaHasPersonas2.setPersona2(this);

		return personaHasPersonas2;
	}

	public PersonaHasPersonaModel removePersonaHasPersonas2(PersonaHasPersonaModel personaHasPersonas2) {
		getPersonaHasPersonas2().remove(personaHasPersonas2);
		personaHasPersonas2.setPersona2(null);

		return personaHasPersonas2;
	}

	public List<PersonaHasRolModel> getPersonaHasRols() {
		return this.personaHasRols;
	}

	public void setPersonaHasRols(List<PersonaHasRolModel> personaHasRols) {
		this.personaHasRols = personaHasRols;
	}

	public PersonaHasRolModel addPersonaHasRol(PersonaHasRolModel personaHasRol) {
		getPersonaHasRols().add(personaHasRol);
		personaHasRol.setPersona(this);

		return personaHasRol;
	}

	public PersonaHasRolModel removePersonaHasRol(PersonaHasRolModel personaHasRol) {
		getPersonaHasRols().remove(personaHasRol);
		personaHasRol.setPersona(null);

		return personaHasRol;
	}

	public List<PersonaHasTtituloModel> getPersonaHasTtitulos() {
		return this.personaHasTtitulos;
	}

	public void setPersonaHasTtitulos(List<PersonaHasTtituloModel> personaHasTtitulos) {
		this.personaHasTtitulos = personaHasTtitulos;
	}

	public PersonaHasTtituloModel addPersonaHasTtitulo(PersonaHasTtituloModel personaHasTtitulo) {
		getPersonaHasTtitulos().add(personaHasTtitulo);
		personaHasTtitulo.setPersona(this);

		return personaHasTtitulo;
	}

	public PersonaHasTtituloModel removePersonaHasTtitulo(PersonaHasTtituloModel personaHasTtitulo) {
		getPersonaHasTtitulos().remove(personaHasTtitulo);
		personaHasTtitulo.setPersona(null);

		return personaHasTtitulo;
	}

	public List<ArchivoModel> getArchivos() {
		return this.archivos;
	}

	public void setArchivos(List<ArchivoModel> archivos) {
		this.archivos = archivos;
	}

	public ArchivoModel addArchivo(ArchivoModel archivo) {
		getArchivos().add(archivo);
		archivo.setPersona(this);

		return archivo;
	}

	public ArchivoModel removeArchivo(ArchivoModel archivo) {
		getArchivos().remove(archivo);
		archivo.setPersona(null);

		return archivo;
	}

	public List<CalificacionModel> getCalificacions() {
		return this.calificacions;
	}

	public void setCalificacions(List<CalificacionModel> calificacions) {
		this.calificacions = calificacions;
	}

	public CalificacionModel addCalificacion(CalificacionModel calificacion) {
		getCalificacions().add(calificacion);
		calificacion.setPersona(this);

		return calificacion;
	}

	public CalificacionModel removeCalificacion(CalificacionModel calificacion) {
		getCalificacions().remove(calificacion);
		calificacion.setPersona(null);

		return calificacion;
	}

	public List<ReunionModel> getReunions() {
		return this.reunions;
	}

	public void setReunions(List<ReunionModel> reunions) {
		this.reunions = reunions;
	}

	public ReunionModel addReunion(ReunionModel reunion) {
		getReunions().add(reunion);
		reunion.setPersona(this);

		return reunion;
	}

	public ReunionModel removeReunion(ReunionModel reunion) {
		getReunions().remove(reunion);
		reunion.setPersona(null);

		return reunion;
	}

}