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
	@Column(unique=true, nullable=false)
	private int per_Id;

	@Column(length=45)
	private String per_Ano_IngresoAlu;

	@Column(nullable=false, length=45)
	private String per_Apellido_Materno;

	@Column(nullable=false, length=45)
	private String per_Apellido_Paterno;

	@Column(length=256)
	private String per_Dirección;

	@Column(nullable=false, length=45)
	private String per_Email;

	@Column(nullable=false, length=45)
	private String per_Nombre;

	@Column(length=1024)
	private String per_Notas;

	@Column(nullable=false, length=64)
	private String per_Password;

	@Column(nullable=false, length=45)
	private String per_Run;

	@Column(nullable=false, length=45)
	private String per_Telefono_Celular;

	@Column(nullable=false, length=45)
	private String per_Usuario;

	//bi-directional many-to-one association to ArchivoModel
	@OneToMany(mappedBy="persona")
	private List<ArchivoModel> archivos;

	//bi-directional many-to-one association to CalificacionModel
	@OneToMany(mappedBy="persona")
	private List<CalificacionModel> calificacions;

	//bi-directional many-to-one association to DepartamentoModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Departamento_Dep_Id", nullable=false)
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

	//bi-directional many-to-one association to ReunionModel
	@OneToMany(mappedBy="persona")
	private List<ReunionModel> reunions;

	//bi-directional many-to-many association to CarreraModel
	@ManyToMany
	@JoinTable(
		name="persona_has_carrera"
		, joinColumns={
			@JoinColumn(name="Persona_Per_Id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="Carrera_Car_Id", nullable=false)
			}
		)
	private List<CarreraModel> carreras;

	//bi-directional many-to-many association to PersonaModel
	@ManyToMany
	@JoinTable(
		name="persona_has_persona"
		, joinColumns={
			@JoinColumn(name="Persona_Per_Id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="Persona_Per_Id1", nullable=false)
			}
		)
	private List<PersonaModel> personas1;

	//bi-directional many-to-many association to PersonaModel
	@ManyToMany(mappedBy="personas1")
	private List<PersonaModel> personas2;

	//bi-directional many-to-many association to RolModel
	@ManyToMany
	@JoinTable(
		name="persona_has_rol"
		, joinColumns={
			@JoinColumn(name="Persona_Per_Id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="Rol_Rol_Id", nullable=false)
			}
		)
	private List<RolModel> rols;

	//bi-directional many-to-many association to TtituloModel
	@ManyToMany
	@JoinTable(
		name="persona_has_ttitulo"
		, joinColumns={
			@JoinColumn(name="Persona_Per_Id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="TTitulo_TTi_Id", nullable=false)
			}
		)
	private List<TtituloModel> ttitulos;

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

	public List<CarreraModel> getCarreras() {
		return this.carreras;
	}

	public void setCarreras(List<CarreraModel> carreras) {
		this.carreras = carreras;
	}

	public List<PersonaModel> getPersonas1() {
		return this.personas1;
	}

	public void setPersonas1(List<PersonaModel> personas1) {
		this.personas1 = personas1;
	}

	public List<PersonaModel> getPersonas2() {
		return this.personas2;
	}

	public void setPersonas2(List<PersonaModel> personas2) {
		this.personas2 = personas2;
	}

	public List<RolModel> getRols() {
		return this.rols;
	}

	public void setRols(List<RolModel> rols) {
		this.rols = rols;
	}

	public List<TtituloModel> getTtitulos() {
		return this.ttitulos;
	}

	public void setTtitulos(List<TtituloModel> ttitulos) {
		this.ttitulos = ttitulos;
	}

}