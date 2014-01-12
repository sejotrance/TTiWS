package ttiws.serviciosCarrera;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import ttiws.model.CarreraModel;

public class WSCarreraListar {
	private static final String PERSISTENCE_UNIT_NAME = "TTIServicios";
	private static EntityManagerFactory factory;
	
	public static List<CarreraModel> listarCarreras(int codEscuela){
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    // ARMAR QUERY SEGUN PARAMETROS INGRESADOS
	    String queryString = "SELECT c FROM CarreraModel c ";
	    if(codEscuela != 0){
	    	queryString += ("WHERE c.escuela.esc_Id="+codEscuela);
	    }
	    // FIN ARMAR QUERY
	    TypedQuery<CarreraModel> q = em.createQuery(queryString, CarreraModel.class);
	    
	    List<CarreraModel> carreraList = q.getResultList();
	    em.close();
	    System.out.println("[WS-" + "WSCarreraListar.listarCarreras" + "]: " + new Timestamp(System.currentTimeMillis()) + " Ha finalizado exitosamente" );
		return carreraList;
	}
}
