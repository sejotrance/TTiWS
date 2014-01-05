package ttiws.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the archivo database table.
 * 
 */
@Entity
@Table(name="archivo")
public class ArchivoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int arch_Id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date arch_Fecha;

	private String arch_Nombre;

	private String arch_Path;

	private String arch_Tipo;

	//bi-directional many-to-one association to PersonaModel
	@ManyToOne
	private PersonaModel persona;

	public ArchivoModel() {
	}

	public int getArch_Id() {
		return this.arch_Id;
	}

	public void setArch_Id(int arch_Id) {
		this.arch_Id = arch_Id;
	}

	public Date getArch_Fecha() {
		return this.arch_Fecha;
	}

	public void setArch_Fecha(Date arch_Fecha) {
		this.arch_Fecha = arch_Fecha;
	}

	public String getArch_Nombre() {
		return this.arch_Nombre;
	}

	public void setArch_Nombre(String arch_Nombre) {
		this.arch_Nombre = arch_Nombre;
	}

	public String getArch_Path() {
		return this.arch_Path;
	}

	public void setArch_Path(String arch_Path) {
		this.arch_Path = arch_Path;
	}

	public String getArch_Tipo() {
		return this.arch_Tipo;
	}

	public void setArch_Tipo(String arch_Tipo) {
		this.arch_Tipo = arch_Tipo;
	}

	public PersonaModel getPersona() {
		return this.persona;
	}

	public void setPersona(PersonaModel persona) {
		this.persona = persona;
	}

}