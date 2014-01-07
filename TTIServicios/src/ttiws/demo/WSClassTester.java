package ttiws.demo;

import ttiws.serviciosPersona.WSPersonaListar;

public class WSClassTester {

	public static void main(String[] args) {
		WSPersonaListar ws = new WSPersonaListar();
		ws.listarPersonas(false, "");
	}
}
