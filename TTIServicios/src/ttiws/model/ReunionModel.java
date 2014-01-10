package ttiws.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the reunion database table.
 * 
 */
@Entity
@Table(name="reunion")
public class ReunionModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int reu_Id;

	@Column(nullable=false, length=45)
	private String reu_Asunto;

	@Column(length=1024)
	private String reu_Descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date reu_Fecha_Desde;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date reu_Fecha_Hasta;

	@Column(length=45)
	private String reu_Style;

	//bi-directional many-to-one association to RegistroreunionModel
	@OneToMany(mappedBy="reunion")
	private List<RegistroreunionModel> registroreunions;

	//bi-directional many-to-one association to PersonaModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Persona_Per_Id", nullable=false)
	private PersonaModel persona;

	public ReunionModel() {
	}

	public int getReu_Id() {
		return this.reu_Id;
	}

	public void setReu_Id(int reu_Id) {
		this.reu_Id = reu_Id;
	}

	public String getReu_Asunto() {
		return this.reu_Asunto;
	}

	public void setReu_Asunto(String reu_Asunto) {
		this.reu_Asunto = reu_Asunto;
	}

	public String getReu_Descripcion() {
		return this.reu_Descripcion;
	}

	public void setReu_Descripcion(String reu_Descripcion) {
		this.reu_Descripcion = reu_Descripcion;
	}

	public Date getReu_Fecha_Desde() {
		return this.reu_Fecha_Desde;
	}

	public void setReu_Fecha_Desde(Date reu_Fecha_Desde) {
		this.reu_Fecha_Desde = reu_Fecha_Desde;
	}

	public Date getReu_Fecha_Hasta() {
		return this.reu_Fecha_Hasta;
	}

	public void setReu_Fecha_Hasta(Date reu_Fecha_Hasta) {
		this.reu_Fecha_Hasta = reu_Fecha_Hasta;
	}

	public String getReu_Style() {
		return this.reu_Style;
	}

	public void setReu_Style(String reu_Style) {
		this.reu_Style = reu_Style;
	}

	public List<RegistroreunionModel> getRegistroreunions() {
		return this.registroreunions;
	}

	public void setRegistroreunions(List<RegistroreunionModel> registroreunions) {
		this.registroreunions = registroreunions;
	}

	public RegistroreunionModel addRegistroreunion(RegistroreunionModel registroreunion) {
		getRegistroreunions().add(registroreunion);
		registroreunion.setReunion(this);

		return registroreunion;
	}

	public RegistroreunionModel removeRegistroreunion(RegistroreunionModel registroreunion) {
		getRegistroreunions().remove(registroreunion);
		registroreunion.setReunion(null);

		return registroreunion;
	}

	public PersonaModel getPersona() {
		return this.persona;
	}

	public void setPersona(PersonaModel persona) {
		this.persona = persona;
	}

}