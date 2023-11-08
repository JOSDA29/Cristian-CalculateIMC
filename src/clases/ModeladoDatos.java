package clases;

import java.util.ArrayList;

import objetos.PersonaVO;

public class ModeladoDatos {
	ArrayList<PersonaVO> listaPersonas;
	Logica logica = new Logica();
	
	public ModeladoDatos() {
		listaPersonas = new ArrayList<PersonaVO>();
	}
	
	public String consultarListadoPersonas() {
		String msg = "";
		PersonaVO p = null;
		for (int i = 0; i < listaPersonas.size(); i++) {
			p= listaPersonas.get(i);
			msg += "———————————————————————————————————————————————\n";
			msg += "<<REGISTROS>>\n";
			msg += "Documento: "+p.getDocumento()+"\n";
			msg += "Nombre: "+p.getNombre()+" \n";
			msg += "Edad: "+p.getEdad()+"\n";
			msg += "Peso: "+p.getPeso()+" \n";
			msg += "Talla: "+p.getTalla()+" \n";
			msg += "IMC: "+p.getImc()+"\n";
			msg += "Conclusion: "+p.getConclusion()+"\n";
			msg += "———————————————————————————————————————————————\n\n";
		}
		return msg;
	}

	public String registrarPersonas(PersonaVO persona) {
		String msg = "";
		msg += "———————————————————————————————————————————————\n";
		msg += "<<DATOS REGISTRADOS>>\n";
		msg += "Documento: "+persona.getDocumento()+"\n";
		msg += "Nombre: "+persona.getNombre()+" \n";
		msg += "Edad: "+persona.getEdad()+"\n";
		msg += "Peso: "+persona.getPeso()+" \n";
		msg += "Talla: "+persona.getTalla()+" \n";
		msg += "IMC: "+persona.getImc()+"\n";
		msg += "Conclusion: "+persona.getConclusion()+"\n";
		msg += "———————————————————————————————————————————————\n\n";
		
		listaPersonas.add(persona);
		return msg;
	}

	public String consultarPromedioPersonas() {
		String msg = "";
		double suma = 0;
		double promedio = 0;
		for (int i = 0; i < listaPersonas.size(); i++) {
			suma += listaPersonas.get(i).getImc();
		}
		promedio = suma/listaPersonas.size();
		
		PersonaVO p = null;
		for (int i = 0; i < listaPersonas.size(); i++) {
			p= listaPersonas.get(i);
			msg += "———————————————————————————————————————————————\n";
			msg += "<<CALCULOS IMC>>\n";
			msg += "Documento: "+p.getDocumento()+"\n";
			msg += "Nombre: "+p.getNombre()+" \n";
			msg += "IMC: "+p.getImc()+"\n";
			msg += "Conclusion: "+p.getConclusion()+"\n";
			msg += "———————————————————————————————————————————————\n\n";
		}
		
		msg += "———————————————————————————————————————————————\n";
		msg += "<<PROMEDIO IMC GENERAL>>\n"; 
		msg += "IMC: "+promedio+"\n";
		msg += "Conclusion: "+logica.conclusionIMC(promedio)+"\n";
		msg += "———————————————————————————————————————————————\n\n";
		
		return msg;
	}
	
	
}
