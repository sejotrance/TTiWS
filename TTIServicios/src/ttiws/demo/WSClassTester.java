package ttiws.demo;

import java.util.List;

import ttiws.model.CarreraModel;
import ttiws.model.PersonaModel;
import ttiws.serviciosAlumno.WSAlumnoCarreraAgregar;
import ttiws.serviciosCarrera.WSCarreraListar;
import ttiws.serviciosPersona.WSPersonaConsultar;
import ttiws.serviciosPersona.WSPersonaCrear;
import ttiws.serviciosPersona.WSPersonaListar;

public class WSClassTester {

	public static void main(String[] args) {
//		WSPersonaListar ws = new WSPersonaListar();
//		List<PersonaModel> listaPersonas = ws.listarPersonas("3");
//		for (PersonaModel persona : listaPersonas) {
//			System.out.println(persona.getPer_Id()+":"+persona.getPer_Nombre()+":"+persona.getPersonaHasRols().size());
//		}
		
		
//		List<CarreraModel> listaCarreras = WSCarreraListar.listarCarreras(1);
//		for (CarreraModel carrera : listaCarreras) {
//			System.out.println(carrera.getCar_Id()+":"+carrera.getCar_Codigo()+":"+carrera.getCar_Nombre());
//		}
		
//		WSPersonaConsultar ws = new WSPersonaConsultar();
//		PersonaModel persona = ws.consultarPorRun("166638275");
//			System.out.println(persona.getPer_Id()+":"+persona.getPer_Nombre()+":" + persona.getRols().size() +":"+persona.getPersonaHasRols().size());
		
//		WSPersonaCrear ws = new WSPersonaCrear();
//		String codTipoPersona = "6";
//		String password = "1234";
//		String email = "sejo1234@gmail.com";
//		String username = email;
//		String run = "123456";
//		String nombre = "Sejo";
//		String apellidoPaterno = "Trance";
//		String apellidoMaterno = "asdsadsa";
//		String direccion = "casa";
//		String telefono = "837276123";
//		String codCarrera = "";
//		int idDepartamento = 1;
//		ws.crearPersona(codTipoPersona, username, password, email, run, nombre, apellidoPaterno, apellidoMaterno, direccion, telefono, codCarrera, idDepartamento);
		
		
		WSAlumnoCarreraAgregar.agregarCarrera(72, 1);
	}
}
