package objetos;

public class PersonaVO {
	private String nombre;
	private int documento;
	private int edad;
	private double peso;
	private double talla;
	private double imc;
	private String conclusion;
	
	public PersonaVO() {
			
		}
	
	public PersonaVO(String nombre, int documento, int edad, double peso, double altura, double imc,
			String conclusion) {
		super();
		this.nombre = nombre;
		this.documento = documento;
		this.edad = edad;
		this.peso = peso;
		this.talla = altura;
		this.imc = imc;
		this.conclusion = conclusion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double getTalla() {
		return talla;
	}
	public void setTalla(double talla) {
		this.talla = talla;
	}
	
	public double getImc() {
		return imc;
	}
	public void setImc(double imc) {
		this.imc = imc;
	}
	
	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
}
