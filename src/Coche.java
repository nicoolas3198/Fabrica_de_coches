
public class Coche {
	
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private boolean techoSolar=false;
	private int kilometros;
	private int numPuertas;
	private int numPlazas;
	public static int numCoches;
	public final static int maxCoches=5;
	
	
	public Coche () {
		
		this.marca="SEAT";
		this.modelo="Altea";
		this.color="Blanco";
		this.numPuertas=3;
		this.numPlazas=5;
	    numCoches++;
		
	}
	
	public Coche (String matr) {
		this.matricula=matr;
		this.marca="SEAT";
		this.modelo="Altea";
		this.color="Blanco";
		this.numPuertas=3;
		this.numPlazas=5;
		numCoches++;
		
	}
	public Coche (int numPue, int numPla) {
		this.marca="SEAT";
		this.modelo="Altea";
		this.color="Blanco";
		setNumPuertas(numPue);
		setNumPlazas(numPla);
		numCoches++;
		
	}
	public Coche (String mar, String mod, String col) {
		this.marca=mar;
		this.modelo=mod;
		this.color=col;
		this.numPuertas=3;
		this.numPlazas=5;
		numCoches++;
		
	}
	
	public void avanzar (int km) {
		this.kilometros=this.kilometros+km;
		
	}
	public void tunear () {
		this.kilometros=0;
		if(!techoSolar) {
		this.techoSolar=true;
		}else {System.out.println("El techo solar ya esta instalado.");}
	}
	public void tunear(String _color) {
		tunear();
		this.color=_color;
	}
	public void matricular(String m) {
	this.matricula=m;
	}
	
	
	
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matr) {
		this.matricula = matr;
	}
	
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public boolean isTechoSolar() {
		
		return techoSolar;
	}
	public void setTechoSolar(boolean techoSolar) {
		this.techoSolar = techoSolar;
	}
	public int getKilometros() {
		return kilometros;
	}
	public void setKilometros(int kilometros) {
		
		if (kilometros > 0) {
		this.kilometros = kilometros;
		}else {System.out.print("Introduce un numero válido");}
		
		
	}
	public int getNumPuertas() {
		return numPuertas;
	}
	public void setNumPuertas(int numPue) {
		if((numPue<3)||(numPue>5)) {
			System.out.print("Número de puertas incorrecto");
		}else {this.numPuertas=numPue;}
	}
	public int getNumPlazas() {
		return numPlazas;
	}
	public void setNumPlazas(int numPla) {
		if((numPla<2)||(numPla>7)) {
			System.out.print("Número de plazas incorrecto");
		}else {this.numPlazas=numPla;}
	}
	



	
}
