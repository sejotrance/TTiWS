package ttiws.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the persona_has_carrera database table.
 * 
 */
@Entity
@Table(name="persona_has_carrera")
public class PersonaHasCarreraModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonaHasCarreraModelPK id;

	@Column(length=45)
	private String per_Car_Atributo_Mod;

	@Temporal(TemporalType.TIMESTAMP)
	private Date per_Car_Fecha_Mod;

	@Column(length=45)
	private String per_Car_Valor_Anterior;

	@Column(length=45)
	private String per_Car_Valor_Nuevo;

	//bi-directional many-to-one association to CarreraModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Carrera_Car_Id", nullable=false, insertable=false, updatable=false)
	private CarreraModel carrera;

	//bi-directional many-to-one association to PersonaModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Persona_Per_Id", nullable=false, insertable=false, updatable=false)
	private PersonaModel persona;

	public PersonaHasCarreraModel() {
	}

	public PersonaHasCarreraModelPK getId() {
		return this.id;
	}

	public void setId(PersonaHasCarreraModelPK id) {
		this.id = id;
	}

	public String getPer_Car_Atributo_Mod() {
		return this.per_Car_Atributo_Mod;
	}

	public void setPer_Car_Atributo_Mod(String per_Car_Atributo_Mod) {
		this.per_Car_Atributo_Mod = per_Car_Atributo_Mod;
	}

	public Date getPer_Car_Fecha_Mod() {
		return this.per_Car_Fecha_Mod;
	}

	public void setPer_Car_Fecha_Mod(Date per_Car_Fecha_Mod) {
		this.per_Car_Fecha_Mod = per_Car_Fecha_Mod;
	}

	public String getPer_Car_Valor_Anterior() {
		return this.per_Car_Valor_Anterior;
	}

	public void setPer_Car_Valor_Anterior(String per_Car_Valor_Anterior) {
		this.per_Car_Valor_Anterior = per_Car_Valor_Anterior;
	}

	public String getPer_Car_Valor_Nuevo() {
		return this.per_Car_Valor_Nuevo;
	}

	public void setPer_Car_Valor_Nuevo(String per_Car_Valor_Nuevo) {
		this.per_Car_Valor_Nuevo = per_Car_Valor_Nuevo;
	}

	public CarreraModel getCarrera() {
		return this.carrera;
	}

	public void setCarrera(CarreraModel carrera) {
		this.carrera = carrera;
	}

	public PersonaModel getPersona() {
		return this.persona;
	}

	public void setPersona(PersonaModel persona) {
		this.persona = persona;
	}

}