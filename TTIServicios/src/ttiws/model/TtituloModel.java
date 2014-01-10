package ttiws.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ttitulo database table.
 * 
 */
@Entity
@Table(name="ttitulo")
public class TtituloModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int TTi_Id;

	@Column(length=1024)
	private String TTi_Descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date TTi_Fecha_Inscripcion;

	@Column(nullable=false, length=256)
	private String TTi_Nombre;

	@Column(nullable=false, length=256)
	private String TTi_Tema;

	private boolean TTi_Tit1;

	private boolean TTi_Tit2;

	//bi-directional many-to-one association to PersonaHasTtituloModel
	@OneToMany(mappedBy="ttitulo")
	private List<PersonaHasTtituloModel> personaHasTtitulos;

	//bi-directional many-to-many association to PersonaModel
	@ManyToMany(mappedBy="ttitulos")
	private List<PersonaModel> personas;

	public TtituloModel() {
	}

	public int getTTi_Id() {
		return this.TTi_Id;
	}

	public void setTTi_Id(int TTi_Id) {
		this.TTi_Id = TTi_Id;
	}

	public String getTTi_Descripcion() {
		return this.TTi_Descripcion;
	}

	public void setTTi_Descripcion(String TTi_Descripcion) {
		this.TTi_Descripcion = TTi_Descripcion;
	}

	public Date getTTi_Fecha_Inscripcion() {
		return this.TTi_Fecha_Inscripcion;
	}

	public void setTTi_Fecha_Inscripcion(Date TTi_Fecha_Inscripcion) {
		this.TTi_Fecha_Inscripcion = TTi_Fecha_Inscripcion;
	}

	public String getTTi_Nombre() {
		return this.TTi_Nombre;
	}

	public void setTTi_Nombre(String TTi_Nombre) {
		this.TTi_Nombre = TTi_Nombre;
	}

	public String getTTi_Tema() {
		return this.TTi_Tema;
	}

	public void setTTi_Tema(String TTi_Tema) {
		this.TTi_Tema = TTi_Tema;
	}

	public boolean getTTi_Tit1() {
		return this.TTi_Tit1;
	}

	public void setTTi_Tit1(boolean TTi_Tit1) {
		this.TTi_Tit1 = TTi_Tit1;
	}

	public boolean getTTi_Tit2() {
		return this.TTi_Tit2;
	}

	public void setTTi_Tit2(boolean TTi_Tit2) {
		this.TTi_Tit2 = TTi_Tit2;
	}

	public List<PersonaHasTtituloModel> getPersonaHasTtitulos() {
		return this.personaHasTtitulos;
	}

	public void setPersonaHasTtitulos(List<PersonaHasTtituloModel> personaHasTtitulos) {
		this.personaHasTtitulos = personaHasTtitulos;
	}

	public PersonaHasTtituloModel addPersonaHasTtitulo(PersonaHasTtituloModel personaHasTtitulo) {
		getPersonaHasTtitulos().add(personaHasTtitulo);
		personaHasTtitulo.setTtitulo(this);

		return personaHasTtitulo;
	}

	public PersonaHasTtituloModel removePersonaHasTtitulo(PersonaHasTtituloModel personaHasTtitulo) {
		getPersonaHasTtitulos().remove(personaHasTtitulo);
		personaHasTtitulo.setTtitulo(null);

		return personaHasTtitulo;
	}

	public List<PersonaModel> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<PersonaModel> personas) {
		this.personas = personas;
	}

}