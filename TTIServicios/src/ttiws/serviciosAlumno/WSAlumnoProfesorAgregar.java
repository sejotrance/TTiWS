package ttiws.serviciosAlumno;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ttiws.entidades.StatusResult;
import ttiws.model.PersonaHasPersonaModel;
import ttiws.model.PersonaHasPersonaModelPK;
import ttiws.model.PersonaHasRolModel;
import ttiws.model.PersonaModel;
import ttiws.serviciosPersona.WSPersonaConsultar;

public class WSAlumnoProfesorAgregar{
	private static final String PERSISTENCE_UNIT_NAME = "TTIServicios";
	private static EntityManagerFactory factory;
	private PersonaModel alumno;
	private PersonaModel profesor;
	public StatusResult agregarProfesor(int idAlumno, int idProfesor){
		
		if(idAlumno != 0){
			alumno = WSPersonaConsultar.consultarPorId(idAlumno);
			if(alumno == null) return new StatusResult(1, "Alumno no existe");
		}else{
			return new StatusResult(1, "Debe ingresar idAlumno");
		}
		if(idProfesor != 0){
			profesor = WSPersonaConsultar.consultarPorId(idProfesor);
			if(profesor == null) return new StatusResult(1, "Profesor no existe");
		}else{
			return new StatusResult(1, "Debe ingresar idProfesor");
		}
		//COMIENZA TRANSACCION
		try{
			PersonaHasPersonaModel personaHP= new PersonaHasPersonaModel();
			PersonaHasPersonaModelPK pk = new PersonaHasPersonaModelPK();
			pk.setPersona_Per_Id(alumno.getPer_Id());
			pk.setPersona_Per_Id1(profesor.getPer_Id());
			personaHP.setId(pk);
			personaHP.setPer_Per_Fecha_Mod(new Date());
			personaHP.setPersona1(alumno);
			personaHP.setPersona2(profesor);
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    EntityManager em = factory.createEntityManager();
		    em.getTransaction().begin();
		    em.persist(personaHP);
		    em.getTransaction().commit();
		    em.close();
	    } catch (Exception e) {
	    	System.out.println("[WS-" + this.getClass().getName() + "]: " + new Timestamp(System.currentTimeMillis()) + e.getMessage());
			return new StatusResult(1, e.getMessage());
		}
		System.out.println("[WS-" + this.getClass().getName() + "]: " + new Timestamp(System.currentTimeMillis()) + " Ha finalizado exitosamente");
		   return new StatusResult(0, "Servicio finalizado exitosamente");
	}
	

}
