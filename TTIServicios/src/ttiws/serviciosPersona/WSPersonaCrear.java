package ttiws.serviciosPersona;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.tomcat.jni.Status;

import ttiws.entidades.StatusResult;
import ttiws.model.DepartamentoModel;
import ttiws.model.PersonaHasPersonaModelPK;
import ttiws.model.PersonaHasRolModel;
import ttiws.model.PersonaHasRolModelPK;
import ttiws.model.PersonaModel;
import ttiws.model.RolModel;
import ttiws.serviciosAlumno.WSAlumnoCarreraAgregar;

public class WSPersonaCrear implements Serializable{
	private static final String PERSISTENCE_UNIT_NAME = "TTIServicios";
	private static EntityManagerFactory factory;
	
	/**
	 * Crea una persona a partir de sus parámetros de entrada
	 * @return      Retorna un objeto statusResult con el id de la persona
	 * 				en la propiedad message, si hay una excepcion retorna el 
	 * 				contenido de esta
	 */
	public StatusResult crearPersona(	String codTipoPersona, 
								String username,
								String password,
								String email,
								String run,
								String nombre, 
								String apellidoPaterno,
								String apellidoMaterno,
								String direccion,
								String telefono,
								int codCarrera,
								int idDepartamento){
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    em.getTransaction().begin();
	    //INSTANCIAR VARIABLE Y AUXILIARES
	    PersonaModel persona = new PersonaModel();
	    PersonaHasRolModel hr = new PersonaHasRolModel();
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
			//SET DEPARTAMENTO
		    DepartamentoModel departamento = em.find(DepartamentoModel.class, idDepartamento);
			persona.setDepartamento(departamento);
			em.persist(persona);
			em.getTransaction().commit();
			em.getTransaction().begin();
			//OBTENEMOS EL ROL Y CREAMOS EL VINCULO ENTRE PERSONA Y ROL
			RolModel rol = em.find(RolModel.class, Integer.parseInt(codTipoPersona));
			PersonaHasRolModelPK idPersonaHasRol = new PersonaHasRolModelPK();
			idPersonaHasRol.setPersona_Per_Id(persona.getPer_Id());
			idPersonaHasRol.setRol_Rol_Id(rol.getRol_Id());
			hr.setId(idPersonaHasRol);
			hr.setPer_Rol_Es_Vigente(true);
			hr.setPer_Rol_Fecha_Mod(new Date());
			em.persist(hr);
			em.getTransaction().commit();
			em.close();
			StatusResult statusAgregarCarrera = WSAlumnoCarreraAgregar.agregarCarrera(persona.getPer_Id(), codCarrera);
			if(statusAgregarCarrera.getCode() != 0){
				status = statusAgregarCarrera;
			}else{
				status.setMessage("Finalizado exitosamente. IDPersona = " + Integer.toString(persona.getPer_Id()));
			}
		} catch (Exception e) {
			status.setMessage(e.getMessage());
			status.setCode(1);
			em.getTransaction().rollback();
		}
	    System.out.println("[WS-" + this.getClass().getName() + "]: " + new Timestamp(System.currentTimeMillis()) + " " +  status.getMessage());
	   return status;
	}
	
	/**
	 * Este metodo crea una persona a partir de un objeto PersonaModel
	 * @param bean es un objeto de tipo PersonaModel
	 * @return Retorna un statusResult con el contenido de la excepcion si es que hay,
	 * 		   ademas actualiza por referencia el id con el que se crea la persona
	 */
	public StatusResult crearPersonaFromBean(PersonaModel bean){
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		StatusResult status = new StatusResult(0, "Persona creada exitosamente");
		try {
			em.persist(bean);
			em.flush();
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			status.setMessage(e.getMessage());
			status.setCode(1);
			em.getTransaction().rollback();
		}
		System.out.println("[WS-" + this.getClass().getName() + "]: " + new Timestamp(System.currentTimeMillis()) + " " + status.getMessage());
		return status;
}
	
}
