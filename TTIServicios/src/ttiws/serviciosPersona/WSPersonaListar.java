package ttiws.serviciosPersona;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ttiws.entidades.Persona;
import ttiws.model.PersonaModel;

public class WSPersonaListar {
	private static final String PERSISTENCE_UNIT_NAME = "TTIServicios";
	private static EntityManagerFactory factory;
	
	public List<PersonaModel> listarPersonas(String codTipoPersona){
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    // ARMAR QUERY SEGUN PARAMETROS INGRESADOS
	    String queryString = "SELECT p FROM PersonaModel p ";
	    if(codTipoPersona != null && codTipoPersona != ""){
	    	queryString += ("JOIN p.personaHasRols hr join hr.rol r  WHERE r.rol_Id="+codTipoPersona);
	    }
	    // FIN ARMAR QUERY
	    TypedQuery<PersonaModel> q = em.createQuery(queryString, PersonaModel.class);
//	    if(codTipoPersona != null && codTipoPersona != ""){
//	    	q.setParameter("codTipoPersona", codTipoPersona);
//	    }
	    //q.setParameter("username", username);
	    List<PersonaModel> personaList = q.getResultList();
	    em.close();
	    System.out.println("[WS-" + this.getClass().getName() + "]: " + new Timestamp(System.currentTimeMillis()) + " Ha finalizado exitosamente" );
		return personaList;
	}
}
