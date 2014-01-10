package ttiws.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the escuela database table.
 * 
 */
@Entity
@Table(name="escuela")
public class EscuelaModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int esc_Id;

	@Column(nullable=false, length=45)
	private String esc_Nombre;

	//bi-directional many-to-one association to CarreraModel
	@OneToMany(mappedBy="escuela")
	private List<CarreraModel> carreras;

	public EscuelaModel() {
	}

	public int getEsc_Id() {
		return this.esc_Id;
	}

	public void setEsc_Id(int esc_Id) {
		this.esc_Id = esc_Id;
	}

	public String getEsc_Nombre() {
		return this.esc_Nombre;
	}

	public void setEsc_Nombre(String esc_Nombre) {
		this.esc_Nombre = esc_Nombre;
	}

	public List<CarreraModel> getCarreras() {
		return this.carreras;
	}

	public void setCarreras(List<CarreraModel> carreras) {
		this.carreras = carreras;
	}

	public CarreraModel addCarrera(CarreraModel carrera) {
		getCarreras().add(carrera);
		carrera.setEscuela(this);

		return carrera;
	}

	public CarreraModel removeCarrera(CarreraModel carrera) {
		getCarreras().remove(carrera);
		carrera.setEscuela(null);

		return carrera;
	}

}