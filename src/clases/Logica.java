package clases;

import objetos.PersonaVO;

public class Logica {

	public String conclusionIMC(double imc) {
		String conclusion = "";
		if (imc < 18) {
			conclusion = "Anorexia";
		}else if (imc >= 18 && imc < 20) {
			conclusion = "Delgadez";
		}else if (imc >= 20 && imc < 27) {
			conclusion = "Normalidad";
		}else if (imc >= 27 && imc < 30) {
			conclusion = "Obecidad (grado 1)";
		}else if (imc >= 30 && imc < 35) {
			conclusion = "Obecidad (grado 2)";
		}else if (imc >= 35 && imc < 40) {
			conclusion = "Obecidad (grado 3)";
		}else if (imc >= 40) {
			conclusion = "obesidad Mórbida";
		}
		return conclusion;
		
	}

	public double calcularIMC(double peso, double talla) {
		double imc =  peso/(talla*talla);
		return imc;
	}


}
