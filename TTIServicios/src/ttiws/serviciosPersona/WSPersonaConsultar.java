package ttiws.serviciosPersona;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ttiws.model.PersonaModel;

public class WSPersonaConsultar {
	private static final String PERSISTENCE_UNIT_NAME = "TTIServicios";
	private static EntityManagerFactory factory;
	
	public static PersonaModel consultarPorRun(String run){
		if(run != null & run != ""){
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    EntityManager em = factory.createEntityManager();
		    // ARMAR QUERY SEGUN PARAMETROS INGRESADOS
		    String queryString = "SELECT p FROM PersonaModel p WHERE p.per_Usuario = :run";
		    // FIN ARMAR QUERY
		    Query q = em.createQuery(queryString, PersonaModel.class);
		    q.setParameter("run", run);

		    PersonaModel persona = (PersonaModel) q.getSingleResult();
		    em.close();
		    System.out.println("[WS-" + "WSPersonaConsultar" + "]: " + new Timestamp(System.currentTimeMillis()) + " Ha finalizado exitosamente" );
			return persona;
		}else{
			return null;
		}
	}
	
	public static PersonaModel consultarPorId(String id){
		if(id != null & id != ""){
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    EntityManager em = factory.createEntityManager();
		    // ARMAR QUERY SEGUN PARAMETROS INGRESADOS
		    String queryString = "SELECT p FROM PersonaModel p WHERE p.per_Id = :id";
		    // FIN ARMAR QUERY
		    Query q = em.createQuery(queryString, PersonaModel.class);
		    q.setParameter("id", id);

		    PersonaModel persona = (PersonaModel) q.getSingleResult();
		    em.close();
		    System.out.println("[WS-" + "WSPersonaConsultar" + "]: " + new Timestamp(System.currentTimeMillis()) + " Ha finalizado exitosamente" );
			return persona;
		}else{
			return null;
		}
	}
}
