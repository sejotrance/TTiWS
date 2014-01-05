package ttiws.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the persona_has_persona database table.
 * 
 */
@Entity
@Table(name="persona_has_persona")
public class PersonaHasPersonaModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonaHasPersonaModelPK id;

	private String per_Per_Atributo_Mod;

	@Temporal(TemporalType.TIMESTAMP)
	private Date per_Per_Fecha_Mod;

	private String per_Per_Valor_Anterior;

	private String per_Per_Valor_Nuevo;

	//bi-directional many-to-one association to PersonaModel
	@ManyToOne
	@JoinColumn(name = "Persona_Per_Id", referencedColumnName = "Per_Id", insertable=false, updatable=false)
	private PersonaModel persona1;

	//bi-directional many-to-one association to PersonaModel
	@ManyToOne
	@JoinColumn(name = "Persona_Per_Id1", referencedColumnName = "Per_Id", insertable=false, updatable=false)
	private PersonaModel persona2;

	public PersonaHasPersonaModel() {
	}

	public PersonaHasPersonaModelPK getId() {
		return this.id;
	}

	public void setId(PersonaHasPersonaModelPK id) {
		this.id = id;
	}

	public String getPer_Per_Atributo_Mod() {
		return this.per_Per_Atributo_Mod;
	}

	public void setPer_Per_Atributo_Mod(String per_Per_Atributo_Mod) {
		this.per_Per_Atributo_Mod = per_Per_Atributo_Mod;
	}

	public Date getPer_Per_Fecha_Mod() {
		return this.per_Per_Fecha_Mod;
	}

	public void setPer_Per_Fecha_Mod(Date per_Per_Fecha_Mod) {
		this.per_Per_Fecha_Mod = per_Per_Fecha_Mod;
	}

	public String getPer_Per_Valor_Anterior() {
		return this.per_Per_Valor_Anterior;
	}

	public void setPer_Per_Valor_Anterior(String per_Per_Valor_Anterior) {
		this.per_Per_Valor_Anterior = per_Per_Valor_Anterior;
	}

	public String getPer_Per_Valor_Nuevo() {
		return this.per_Per_Valor_Nuevo;
	}

	public void setPer_Per_Valor_Nuevo(String per_Per_Valor_Nuevo) {
		this.per_Per_Valor_Nuevo = per_Per_Valor_Nuevo;
	}

	public PersonaModel getPersona1() {
		return this.persona1;
	}

	public void setPersona1(PersonaModel persona1) {
		this.persona1 = persona1;
	}

	public PersonaModel getPersona2() {
		return this.persona2;
	}

	public void setPersona2(PersonaModel persona2) {
		this.persona2 = persona2;
	}

}