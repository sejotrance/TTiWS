package ttiws.serviciosReportes;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ttiws.entidades.ResultReporteAlumnoTT;
import ttiws.model.CarreraModel;
import ttiws.model.PersonaHasTtituloModel;
import ttiws.model.PersonaModel;
import ttiws.model.TtituloModel;
import ttiws.serviciosPersona.WSPersonaListar;

public class WSReporteAlumnoTT {
	public static List<ResultReporteAlumnoTT> listarReporteAlumnoTT(int codCarrera){
		List<ResultReporteAlumnoTT> listaResultado = new ArrayList<ResultReporteAlumnoTT>();
		List<PersonaModel> listaAlumnos = WSPersonaListar.listarPersonas("6");
		for (PersonaModel alumno : listaAlumnos) {
			//CARRERA
			int Car_Id = 0;
			String Car_Nombre = "";
			List<CarreraModel> carrerasAlumno = alumno.getCarreras();
			int largoCarreras = carrerasAlumno.size();
			if(largoCarreras > 0){
				Car_Id = carrerasAlumno.get(largoCarreras -1).getCar_Id();
				Car_Nombre = carrerasAlumno.get(largoCarreras -1).getCar_Nombre();
			}
			//if(Car_Id != codCarrera){
				int per_Id = alumno.getPer_Id();
				String per_Run = alumno.getPer_Run();
				String per_Nombre = alumno.getPer_Nombre();
				String Per_Apellido_Paterno = alumno.getPer_Apellido_Paterno();
				//TTITULOS
				int TTitulo_TTi_Id = 0;
				String TTi_Nombre = "";
				boolean TTi_Tit1 = false;
				boolean TTi_Tit2 = false;
				List<TtituloModel> ttitulosAlumno = alumno.getTtitulos();
				int largoTitulos = ttitulosAlumno.size();
				if(largoTitulos > 0){
					TTitulo_TTi_Id = ttitulosAlumno.get(largoTitulos -1).getTTi_Id();
					TTi_Nombre = ttitulosAlumno.get(largoTitulos - 1).getTTi_Nombre();
					TTi_Tit1 =  ttitulosAlumno.get(largoTitulos - 1).getTTi_Tit1();
					TTi_Tit2 =  ttitulosAlumno.get(largoTitulos - 1).getTTi_Tit2();
				}
				
				
				listaResultado.add(new ResultReporteAlumnoTT(per_Id, per_Run, per_Nombre, Per_Apellido_Paterno, TTitulo_TTi_Id, TTi_Nombre, Car_Id, Car_Nombre, TTi_Tit1, TTi_Tit2));
			//}
		}
		System.out.println("[WS-" + "WSReporteAlumnoTT.listarReporteAlumnoTT" + "]: " + new Timestamp(System.currentTimeMillis()) + " Ha finalizado exitosamente" );
		return listaResultado;
	}
	
	public static List<ResultReporteAlumnoTT> listarReporteAlumnoPorProfesor(int codProfesor){
		List<ResultReporteAlumnoTT> listaResultado = new ArrayList<ResultReporteAlumnoTT>();
		List<PersonaModel> listaAlumnos = WSPersonaListar.listarPersonasPorProfesor(codProfesor);
		for (PersonaModel alumno : listaAlumnos) {
			int per_Id = alumno.getPer_Id();
			String per_Run = alumno.getPer_Run();
			String per_Nombre = alumno.getPer_Nombre();
			String Per_Apellido_Paterno = alumno.getPer_Apellido_Paterno();
			//TTITULOS
			int TTitulo_TTi_Id = 0;
			String TTi_Nombre = "";
			boolean TTi_Tit1 = false;
			boolean TTi_Tit2 = false;
			List<TtituloModel> ttitulosAlumno = alumno.getTtitulos();
			int largoTitulos = ttitulosAlumno.size();
			if(largoTitulos > 0){
				TTitulo_TTi_Id = ttitulosAlumno.get(largoTitulos -1).getTTi_Id();
				TTi_Nombre = ttitulosAlumno.get(largoTitulos - 1).getTTi_Nombre();
				TTi_Tit1 =  ttitulosAlumno.get(largoTitulos - 1).getTTi_Tit1();
				TTi_Tit2 =  ttitulosAlumno.get(largoTitulos - 1).getTTi_Tit2();
			}
			//CARRERA
			int Car_Id = 0;
			String Car_Nombre = "";
			List<CarreraModel> carrerasAlumno = alumno.getCarreras();
			int largoCarreras = carrerasAlumno.size();
			if(largoCarreras > 0){
				Car_Id = carrerasAlumno.get(largoCarreras -1).getCar_Id();
				Car_Nombre = carrerasAlumno.get(largoCarreras -1).getCar_Nombre();
			}
				
				
			listaResultado.add(new ResultReporteAlumnoTT(per_Id, per_Run, per_Nombre, Per_Apellido_Paterno, TTitulo_TTi_Id, TTi_Nombre, Car_Id, Car_Nombre, TTi_Tit1, TTi_Tit2));

		}
		System.out.println("[WS-" + "WSReporteAlumnoTT.listarReporteAlumnoTT" + "]: " + new Timestamp(System.currentTimeMillis()) + " Ha finalizado exitosamente" );
		return listaResultado;
	}
}
