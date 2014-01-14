package ttiws.entidades;

public class ResultReporteAlumnoTT {
	private int per_Id;
	private String per_Run;
	private String per_Nombre;
	private String Per_Apellido_Paterno;
	private int TTitulo_TTi_Id;
	private String TTi_Nombre;
	private int Car_Id;
	private String  Car_Nombre;
	private boolean TTi_Tit1;
	private boolean TTi_Tit2;
	
	public ResultReporteAlumnoTT(
			int per_Id, 
			String per_Run, 
			String per_Nombre, 
			String Per_Apellido_Paterno,
			int TTitulo_TTi_Id, 
			String TTi_Nombre,
			int Car_Id, 
			String  Car_Nombre,
			boolean TTi_Tit1,
			boolean TTi_Tit2) {
		
		this.per_Id = per_Id;
		this.per_Run = per_Run;
		this.per_Nombre = per_Nombre;
		this.Per_Apellido_Paterno = Per_Apellido_Paterno;
		this.TTitulo_TTi_Id = TTitulo_TTi_Id;
		this.TTi_Nombre = TTi_Nombre;
		this.Car_Id = Car_Id;
		this.Car_Nombre = Car_Nombre;
		this.TTi_Tit1 = TTi_Tit1;
		this.TTi_Tit2 = TTi_Tit2;
	}
	
	public int getPer_Id() {
		return per_Id;
	}
	public void setPer_Id(int per_Id) {
		this.per_Id = per_Id;
	}
	public String getPer_Run() {
		return per_Run;
	}
	public void setPer_Run(String per_Run) {
		this.per_Run = per_Run;
	}
	public String getPer_Nombre() {
		return per_Nombre;
	}
	public void setPer_Nombre(String per_Nombre) {
		this.per_Nombre = per_Nombre;
	}
	public String getPer_Apellido_Paterno() {
		return Per_Apellido_Paterno;
	}
	public void setPer_Apellido_Paterno(String per_Apellido_Paterno) {
		Per_Apellido_Paterno = per_Apellido_Paterno;
	}
	public int getTTitulo_TTi_Id() {
		return TTitulo_TTi_Id;
	}
	public void setTTitulo_TTi_Id(int tTitulo_TTi_Id) {
		TTitulo_TTi_Id = tTitulo_TTi_Id;
	}
	public String getTTi_Nombre() {
		return TTi_Nombre;
	}
	public void setTTi_Nombre(String tTi_Nombre) {
		TTi_Nombre = tTi_Nombre;
	}
	public int getCar_Id() {
		return Car_Id;
	}
	public void setCar_Id(int car_Id) {
		Car_Id = car_Id;
	}
	public String getCar_Nombre() {
		return Car_Nombre;
	}
	public void setCar_Nombre(String car_Nombre) {
		Car_Nombre = car_Nombre;
	}

	public boolean isTTi_Tit1() {
		return TTi_Tit1;
	}

	public void setTTi_Tit1(boolean tTi_Tit1) {
		TTi_Tit1 = tTi_Tit1;
	}

	public boolean isTTi_Tit2() {
		return TTi_Tit2;
	}

	public void setTTi_Tit2(boolean tTi_Tit2) {
		TTi_Tit2 = tTi_Tit2;
	}
	
}
