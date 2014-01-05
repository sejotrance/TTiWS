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
	private int cal_Id;

	private String cal_Calificacion;

	private String cal_Descripcion;

	private byte cal_Es_Informe;

	@Temporal(TemporalType.TIMESTAMP)
	private Date cal_Fecha;

	private String cal_Porcentaje;

	//bi-directional many-to-one association to PersonaModel
	@ManyToOne
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

	public byte getCal_Es_Informe() {
		return this.cal_Es_Informe;
	}

	public void setCal_Es_Informe(byte cal_Es_Informe) {
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