package ttiws.serviciosAlumno;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import ttiws.model.CalificacionModel;

public class WSAlumnoCalificacionListar {
	private static final String PERSISTENCE_UNIT_NAME = "TTIServicios";
	private static EntityManagerFactory factory;
	
	public static List<CalificacionModel> listarCalificaciones(int idAlumno){
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    // ARMAR QUERY SEGUN PARAMETROS INGRESADOS
	    String queryString = "SELECT c FROM CalificacionModel c ";
	    if(idAlumno != 0){
	    	queryString += ("JOIN c.persona pc WHERE pc.per_Id="+idAlumno);
	    }
	    // FIN ARMAR QUERY
	    TypedQuery<CalificacionModel> q = em.createQuery(queryString, CalificacionModel.class);
	    List<CalificacionModel> listaCalificaciones = q.getResultList();
	    em.close();
	    System.out.println("[WS-" + "WSAlumnoCalificacionListar.listarCalificaciones" + "]: " + new Timestamp(System.currentTimeMillis()) + " Ha finalizado exitosamente" );
	    return listaCalificaciones;
		
	}
}
