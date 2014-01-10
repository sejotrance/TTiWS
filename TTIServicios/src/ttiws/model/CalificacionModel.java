package ttiws.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the calificacion database table.
 * 
 */
@Entity
@Table(name="calificacion")
public class CalificacionModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int cal_Id;

	@Column(nullable=false, length=45)
	private String cal_Calificacion;

	@Column(length=1024)
	private String cal_Descripcion;

	@Column(nullable=false)
	private boolean cal_Es_Informe;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date cal_Fecha;

	@Column(nullable=false, length=45)
	private String cal_Porcentaje;

	//bi-directional many-to-one association to PersonaModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Persona_Per_Id", nullable=false)
	private PersonaModel persona;

	public CalificacionModel() {
	}

	public int getCal_Id() {
		return this.cal_Id;
	}

	public void setCal_Id(int cal_Id) {
		this.cal_Id = cal_Id;
	}

	public String getCal_Calificacion() {
		return this.cal_Calificacion;
	}

	public void setCal_Calificacion(String cal_Calificacion) {
		this.cal_Calificacion = cal_Calificacion;
	}

	public String getCal_Descripcion() {
		return this.cal_Descripcion;
	}

	public void setCal_Descripcion(String cal_Descripcion) {
		this.cal_Descripcion = cal_Descripcion;
	}

	public boolean getCal_Es_Informe() {
		return this.cal_Es_Informe;
	}

	public void setCal_Es_Informe(boolean cal_Es_Informe) {
		this.cal_Es_Informe = cal_Es_Informe;
	}

	public Date getCal_Fecha() {
		return this.cal_Fecha;
	}

	public void setCal_Fecha(Date cal_Fecha) {
		this.cal_Fecha = cal_Fecha;
	}

	public String getCal_Porcentaje() {
		return this.cal_Porcentaje;
	}

	public void setCal_Porcentaje(String cal_Porcentaje) {
		this.cal_Porcentaje = cal_Porcentaje;
	}

	public PersonaModel getPersona() {
		return this.persona;
	}

	public void setPersona(PersonaModel persona) {
		this.persona = persona;
	}

}