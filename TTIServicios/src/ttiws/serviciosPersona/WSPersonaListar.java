package ttiws.serviciosPersona;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ttiws.entidades.Persona;
import ttiws.model.PersonaModel;

public class WSPersonaListar {
	private static final String PERSISTENCE_UNIT_NAME = "TTIServicios";
	private static EntityManagerFactory factory;
	
	public List<Persona> listarPersonas(boolean esVigente, String codTipoPersona){
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    // read the existing entries and write to console
	    String queryString = "SELECT p FROM PersonaModel p";
	    Query q = em.createQuery(queryString);
	    //q.setParameter("username", username);
	    List<PersonaModel> personaList = q.getResultList();
	    ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
	    for (PersonaModel persona : personaList) {
	    	Persona e = new Persona();
	      listaPersonas.add(e);
	    }
	    em.close();
	    System.out.println("[WS-" + this.getClass().getName() + "]: " + new Timestamp(System.currentTimeMillis()) + " Ha finalizado exitosamente" );
		return listaPersonas;
		
	}
}
