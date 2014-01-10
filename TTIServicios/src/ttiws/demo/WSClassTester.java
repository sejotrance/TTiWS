package ttiws.demo;

import java.util.List;

import ttiws.model.PersonaModel;
import ttiws.serviciosPersona.WSPersonaConsultar;
import ttiws.serviciosPersona.WSPersonaCrear;
import ttiws.serviciosPersona.WSPersonaListar;

public class WSClassTester {

	public static void main(String[] args) {
//		WSPersonaListar ws = new WSPersonaListar();
//		List<PersonaModel> listaPersonas = ws.listarPersonas("3");
//		for (PersonaModel persona : listaPersonas) {
//			System.out.println(persona.getPer_Id()+":"+persona.getPer_Nombre()+":"+persona.getPersonaHasRols().size());
//		}
		
		
		WSPersonaConsultar ws = new WSPersonaConsultar();
		PersonaModel persona = ws.consultarPorRun("166638275");
			System.out.println(persona.getPer_Id()+":"+persona.getPer_Nombre()+":" + persona.getRols().size() +":"+persona.getPersonaHasRols().size());
	}
}
