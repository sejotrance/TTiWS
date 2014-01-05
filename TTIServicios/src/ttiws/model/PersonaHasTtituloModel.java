package ttiws.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the persona_has_ttitulo database table.
 * 
 */
@Entity
@Table(name="persona_has_ttitulo")
public class PersonaHasTtituloModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonaHasTtituloModelPK id;

	private String per_TTi_Atributo_Mod;

	@Temporal(TemporalType.TIMESTAMP)
	private Date per_TTi_Fecha_Mod;

	private String per_TTi_Valor_Anterior;

	private String per_TTi_Valor_Nuevo;

	//bi-directional many-to-one association to PersonaModel
	@ManyToOne
	@JoinColumn(name = "Persona_Per_Id", referencedColumnName = "Per_Id", insertable=false, updatable=false)
	private PersonaModel persona;

	//bi-directional many-to-one association to TtituloModel
	@ManyToOne
	@JoinColumn(name = "TTitulo_TTi_Id", referencedColumnName = "TTi_Id", insertable=false, updatable=false)
	private TtituloModel ttitulo;

	public PersonaHasTtituloModel() {
	}

	public PersonaHasTtituloModelPK getId() {
		return this.id;
	}

	public void setId(PersonaHasTtituloModelPK id) {
		this.id = id;
	}

	public String getPer_TTi_Atributo_Mod() {
		return this.per_TTi_Atributo_Mod;
	}

	public void setPer_TTi_Atributo_Mod(String per_TTi_Atributo_Mod) {
		this.per_TTi_Atributo_Mod = per_TTi_Atributo_Mod;
	}

	public Date getPer_TTi_Fecha_Mod() {
		return this.per_TTi_Fecha_Mod;
	}

	public void setPer_TTi_Fecha_Mod(Date per_TTi_Fecha_Mod) {
		this.per_TTi_Fecha_Mod = per_TTi_Fecha_Mod;
	}

	public String getPer_TTi_Valor_Anterior() {
		return this.per_TTi_Valor_Anterior;
	}

	public void setPer_TTi_Valor_Anterior(String per_TTi_Valor_Anterior) {
		this.per_TTi_Valor_Anterior = per_TTi_Valor_Anterior;
	}

	public String getPer_TTi_Valor_Nuevo() {
		return this.per_TTi_Valor_Nuevo;
	}

	public void setPer_TTi_Valor_Nuevo(String per_TTi_Valor_Nuevo) {
		this.per_TTi_Valor_Nuevo = per_TTi_Valor_Nuevo;
	}

	public PersonaModel getPersona() {
		return this.persona;
	}

	public void setPersona(PersonaModel persona) {
		this.persona = persona;
	}

	public TtituloModel getTtitulo() {
		return this.ttitulo;
	}

	public void setTtitulo(TtituloModel ttitulo) {
		this.ttitulo = ttitulo;
	}

}