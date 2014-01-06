package ttiws.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ttiws.entidades.StatusResult;
import ttiws.model.PersonaModel;
import ttiws.serviciosPersona.WSPersonaCrear;

public class Main {
  private static final String PERSISTENCE_UNIT_NAME = "TTIServicios";
  private static EntityManagerFactory factory;

  public static void main(String[] args) {
    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager em = factory.createEntityManager();
    String username = "usuario";
    // read the existing entries and write to console
    Query q = em.createQuery("select p FROM PersonaModel p where p.per_Usuario = :username");
    q.setParameter("username", username);
    List<PersonaModel> personaList = q.getResultList();
    for (PersonaModel persona : personaList) {
      System.out.println(persona.getPer_Nombre() + " " + persona.getPer_Apellido_Paterno());
    }
    System.out.println("Size: " + personaList.size());
    em.close();
//    WSPersonaCrear crearPersonaWS = new WSPersonaCrear();
//    StatusResult status = crearPersonaWS.crearPersona("", "usuario", "Passw0rd","mail@mail.com", "1-9", "Nombre", "apellidoPaterno", "apellidoMaterno", "Direccion", "213124233", "", 1);
    // create new profe
    /*em.getTransaction().begin();
    Profesor profesor = new Profesor();
    int id = profesorList.size() +1;
	profesor.setPro_Id(id);
	profesor.setPro_Run("32132");
	profesor.setPro_Nombres("nombre");
	profesor.setPro_Apellido_Paterno("Apellido");
	profesor.setPro_Apellido_Materno("Segundo apellido");
	profesor.setPro_Direccion("Direccion asdsadsadas");
	profesor.setPro_Email("mail@mail.com");
	profesor.setPro_Telefono_Celular("8372138");
	profesor.setPro_Usuario("user" + id);
	profesor.setPro_Password("passw0rd");
	System.out.print(profesor);
	em.persist(profesor);
	em.getTransaction().commit();*/
  }
} 