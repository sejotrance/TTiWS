package ttiws.serviciosCarrera;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import ttiws.model.CarreraModel;

public class WSCarreraConsultar {
	private static final String PERSISTENCE_UNIT_NAME = "TTIServicios";
	private static EntityManagerFactory factory;
	
	public static CarreraModel consultarPorId(int codCarrera){
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    // ARMAR QUERY SEGUN PARAMETROS INGRESADOS
	    String queryString = "SELECT c FROM CarreraModel c ";
	    if(codCarrera != 0){
	    	queryString += ("WHERE c.car_Id="+codCarrera);
	    }
	    // FIN ARMAR QUERY
	    TypedQuery<CarreraModel> q = em.createQuery(queryString, CarreraModel.class);
	    
	    CarreraModel carrera = q.getSingleResult();
	    em.close();
	    System.out.println("[WS-" + "WSCarreraConsultar.consultarPorId" + "]: " + new Timestamp(System.currentTimeMillis()) + " Ha finalizado exitosamente" );
		return carrera;
	}
}
