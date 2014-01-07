package ttiws.serviciosPersona;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.tomcat.jni.Status;

import ttiws.entidades.StatusResult;
import ttiws.model.DepartamentoModel;
import ttiws.model.PersonaHasPersonaModelPK;
import ttiws.model.PersonaHasRolModel;
import ttiws.model.PersonaModel;

public class WSPersonaCrear implements Serializable{
	private static final String PERSISTENCE_UNIT_NAME = "TTIServicios";
	private static EntityManagerFactory factory;
	
	public StatusResult crearPersona(	String tipoPersona, 
								String username,
								String password,
								String email,
								String run,
								String nombre, 
								String apellidoPaterno,
								String apellidoMaterno,
								String direccion,
								String telefono,
								String codCarrera,
								int idDepartamento){
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    em.getTransaction().begin();
	    //INSTANCIAR VARIABLE Y AUXILIARES
	    PersonaModel persona = new PersonaModel();
	    DepartamentoModel departamento = new DepartamentoModel();
	    PersonaHasRolModel rol = new PersonaHasRolModel();
	    PersonaHasPersonaModelPK idRol = new PersonaHasPersonaModelPK();
	    StatusResult status = new StatusResult(0, "Persona creada exitosamente");
	    try {
			persona.setPer_Usuario(username);
			persona.setPer_Password(password);
			persona.setPer_Email(email);
			persona.setPer_Run(run);
			persona.setPer_Nombre(nombre);
			persona.setPer_Apellido_Paterno(apellidoPaterno);
			persona.setPer_Apellido_Materno(apellidoMaterno);
			persona.setPer_Dirección(direccion);
			persona.setPer_Telefono_Celular(telefono);
			//Set Departamento
			departamento.setDep_Id(idDepartamento);
			persona.setDepartamento(departamento);
			em.persist(persona);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			status.setMessage(e.getMessage());
			status.setCode(1);
		}
	    System.out.println("[WS-" + this.getClass().getName() + "]: " + new Timestamp(System.currentTimeMillis()) + status.getMessage());
	   return status;
	}
}
