package ttiws.serviciosAlumno;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ttiws.entidades.StatusResult;
import ttiws.model.CalificacionModel;
import ttiws.model.PersonaHasCarreraModel;
import ttiws.model.PersonaHasCarreraModelPK;
import ttiws.model.PersonaModel;
import ttiws.serviciosPersona.WSPersonaConsultar;

public class WSAlumnoCalificacionCrear {
	private static final String PERSISTENCE_UNIT_NAME = "TTIServicios";
	private static EntityManagerFactory factory;
	
	public static StatusResult crearCalificacion(int idAlumno, String Cal_Porcentaje, Date Cal_Fecha, String Cal_Calificacion, String Cal_Descripcion, boolean Cal_Es_Informe){
		PersonaModel alumno;
		CalificacionModel calificacion;
		if(idAlumno != 0){
			alumno = WSPersonaConsultar.consultarPorId(idAlumno);
			if(alumno == null) return new StatusResult(1, "Alumno no existe");
		}else{
			return new StatusResult(1, "Debe ingresar idAlumno");
		}
		
		//COMIENZA TRANSACCION
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
		try{
			calificacion = new CalificacionModel();
			calificacion.setCal_Calificacion(Cal_Calificacion);
			calificacion.setCal_Descripcion(Cal_Descripcion);
			calificacion.setCal_Es_Informe(Cal_Es_Informe);
			calificacion.setCal_Fecha(Cal_Fecha);
			calificacion.setCal_Porcentaje(Cal_Porcentaje);
			calificacion.setPersona(alumno);
		    em.getTransaction().begin();
		    em.persist(calificacion);
		    em.getTransaction().commit();
		    em.close();
	    } catch (Exception e) {
	    	System.out.println("[WS-" + "WSAlumnoCalificacionCrear.crearCalificacion" + "]: " + new Timestamp(System.currentTimeMillis()) + e.getMessage());
	    	em.getTransaction().rollback();
	    	return new StatusResult(1, e.getMessage());
		}
		System.out.println("[WS-" + "WSAlumnoCalificacionCrear.crearCalificacion" + "]: " + new Timestamp(System.currentTimeMillis()) + " Ha finalizado exitosamente");
		   return new StatusResult(0, "Servicio finalizado exitosamente");
		
	}
}
