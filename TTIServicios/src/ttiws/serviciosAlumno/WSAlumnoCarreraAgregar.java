package ttiws.serviciosAlumno;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ttiws.entidades.StatusResult;
import ttiws.model.CarreraModel;
import ttiws.model.PersonaHasCarreraModel;
import ttiws.model.PersonaHasCarreraModelPK;
import ttiws.model.PersonaModel;
import ttiws.serviciosCarrera.WSCarreraConsultar;
import ttiws.serviciosPersona.WSPersonaConsultar;

public class WSAlumnoCarreraAgregar {
	private static final String PERSISTENCE_UNIT_NAME = "TTIServicios";
	private static EntityManagerFactory factory;
	
	public static StatusResult agregarCarrera(int idAlumno, int idCarrera){
		PersonaModel alumno;
		CarreraModel carrera;
		if(idAlumno != 0){
			alumno = WSPersonaConsultar.consultarPorId(idAlumno);
			if(alumno == null) return new StatusResult(1, "Alumno no existe");
		}else{
			return new StatusResult(1, "Debe ingresar idAlumno");
		}
		if(idCarrera != 0){
			carrera = WSCarreraConsultar.consultarPorId(idCarrera);
			if(carrera == null) return new StatusResult(1, "Carrera no existe");
		}else{
			return new StatusResult(1, "Debe ingresar idCarrera");
		}
		//COMIENZA TRANSACCION
		try{
			PersonaHasCarreraModel personaHC= new PersonaHasCarreraModel();
			PersonaHasCarreraModelPK pk = new PersonaHasCarreraModelPK();
			pk.setPersona_Per_Id(alumno.getPer_Id());
			pk.setCarrera_Car_Id(carrera.getCar_Id());
			personaHC.setId(pk);
			personaHC.setPer_Car_Fecha_Mod(new Date());
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    EntityManager em = factory.createEntityManager();
		    em.getTransaction().begin();
		    em.persist(personaHC);
		    em.getTransaction().commit();
		    em.close();
	    } catch (Exception e) {
	    	System.out.println("[WS-" + "WSAlumnoCarreraAgregar.agregarCarrera" + "]: " + new Timestamp(System.currentTimeMillis()) + e.getMessage());
			return new StatusResult(1, e.getMessage());
		}
		System.out.println("[WS-" + "WSAlumnoCarreraAgregar.agregarCarrera" + "]: " + new Timestamp(System.currentTimeMillis()) + " Ha finalizado exitosamente");
		   return new StatusResult(0, "Servicio finalizado exitosamente");
	}
}
