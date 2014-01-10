package ttiws.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the registroreunion database table.
 * 
 */
@Entity
@Table(name="registroreunion")
public class RegistroreunionModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int RReu_Id;

	@Column(length=1024)
	private String RReu_Registro_AcuyCom;

	@Column(length=1024)
	private String RReu_Registro_Avances;

	//bi-directional many-to-one association to ReunionModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Reuni�n_Reu_Id", nullable=false)
	private ReunionModel reunion;

	public RegistroreunionModel() {
	}

	public int getRReu_Id() {
		return this.RReu_Id;
	}

	public void setRReu_Id(int RReu_Id) {
		this.RReu_Id = RReu_Id;
	}

	public String getRReu_Registro_AcuyCom() {
		return this.RReu_Registro_AcuyCom;
	}

	public void setRReu_Registro_AcuyCom(String RReu_Registro_AcuyCom) {
		this.RReu_Registro_AcuyCom = RReu_Registro_AcuyCom;
	}

	public String getRReu_Registro_Avances() {
		return this.RReu_Registro_Avances;
	}

	public void setRReu_Registro_Avances(String RReu_Registro_Avances) {
		this.RReu_Registro_Avances = RReu_Registro_Avances;
	}

	public ReunionModel getReunion() {
		return this.reunion;
	}

	public void setReunion(ReunionModel reunion) {
		this.reunion = reunion;
	}

}