package ttiws.demo;

import java.util.Date;
import java.util.List;

import ttiws.entidades.ResultReporteAlumnoTT;
import ttiws.model.CalificacionModel;
import ttiws.model.CarreraModel;
import ttiws.model.PersonaModel;
import ttiws.model.TtituloModel;
import ttiws.serviciosAlumno.WSAlumnoCalificacionCrear;
import ttiws.serviciosAlumno.WSAlumnoCalificacionListar;
import ttiws.serviciosAlumno.WSAlumnoCarreraAgregar;
import ttiws.serviciosCarrera.WSCarreraConsultar;
import ttiws.serviciosCarrera.WSCarreraListar;
import ttiws.serviciosPersona.WSPersonaConsultar;
import ttiws.serviciosPersona.WSPersonaCrear;
import ttiws.serviciosPersona.WSPersonaListar;
import ttiws.serviciosReportes.WSReporteAlumnoTT;

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
////		PersonaModel persona = ws.consultarPorRun("166638275");
//		PersonaModel persona = WSPersonaConsultar.consultarPorId(14);
//		List<CarreraModel> carrerasPersona = persona.getCarreras();
//		List<TtituloModel> ttituloPersona = persona.getTtitulos();
//			System.out.println(persona.getPer_Id()+":"+persona.getPer_Nombre()+":" + persona.getRols().size() +":"+persona.getPersonaHasRols().size());
//		for (CarreraModel carreraModel : carrerasPersona) {
//			System.out.println(carreraModel.getCar_Codigo() + ":" + carreraModel.getCar_Nombre());
//		}
//		for (TtituloModel ttituloModel : ttituloPersona) {
//			System.out.println("TTITULO 1 = " + ttituloModel.getTTi_Tit1() + ":" + "TTITULO 2 = " + ttituloModel.getTTi_Tit2());
//		}
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
		
		
//		WSAlumnoCarreraAgregar.agregarCarrera(72, 1);
//		WSAlumnoCalificacionCrear.crearCalificacion(1, "", new Date(), "30", "Descripcion de prueba", false);
//		List<CalificacionModel> listaCalificacion = WSAlumnoCalificacionListar.listarCalificaciones(14);
//		for (CalificacionModel calificacion : listaCalificacion) {
//			System.out.println(calificacion.getCal_Id() + ":" + calificacion.getCal_Calificacion());
//		}
//		
//		List<ResultReporteAlumnoTT> resultadoReporte = WSReporteAlumnoTT.listarReporteAlumnoPorProfesor(3);
//		for (ResultReporteAlumnoTT resultReporteAlumnoTT : resultadoReporte) {
//			System.out.println(resultReporteAlumnoTT.getPer_Nombre() + " " + resultReporteAlumnoTT.getPer_Id());
//		}
		
		List<ResultReporteAlumnoTT> resultadoReporte = WSReporteAlumnoTT.listarReporteAlumnoTT(1);
		for (ResultReporteAlumnoTT resultReporteAlumnoTT : resultadoReporte) {
			System.out.println(resultReporteAlumnoTT.getPer_Nombre() + " " + resultReporteAlumnoTT.getPer_Id() + " " + resultReporteAlumnoTT.getNombreProfesor());
		}
	}
}
