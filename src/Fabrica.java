import java.util.Scanner;
import java.util.Vector;
public class Fabrica {
	static Scanner teclado = new Scanner (System.in);
	public static void main(String[] args) {
		Vector lista_coches = new Vector (4);
		int opcion1;
		
		do {
			opcion1=0;
			System.out.println("Opci�n 1, Fabricar coche conociendo matr�cula");
			System.out.println("Opci�n 2, Fabricar coche a partir del n� puertas y el n� de plazas");
			System.out.println("Opci�n 3, Fabricar coche a partir de la marca, el modelo y el color");
			System.out.println("Opci�n 4, Fabricar coche  sin datos");
			System.out.println("Opci�n 5, Tunear coche pint�ndolo");
			System.out.println("Opci�n 6, Tunear coche sin pintar");
			System.out.println("Opci�n 7, Avanzar kilometros");
			System.out.println("Opci�n 8, Mostrar las caracter�sticas de un coche");
			System.out.println("Opci�n 9, Ordenar Coches por km");
			System.out.println("Opci�n 10, Sumar los kilometros recursivo");
			System.out.println("Opci�n 11, Buscar coche recursivo");
			System.out.println("Opci�n 12, Fin del programa");


			try {
				System.out.println("\nIntroduce una opci�n: ");
				 opcion1 = Integer.parseInt(teclado.next());}
				 catch(Exception e) {
				System.out.println("Has introducido una opci�n incorrecta");
			}
			switch (opcion1) {
			case 1:
				if(Coche.numCoches<Coche.maxCoches) {
					Coche car2 = new Coche("5678-AG");
					car2.setMarca("Fiat");
					car2.setModelo("Uno");
					car2.tunear("Rojo");
					car2.avanzar(300);
					car2.setNumPuertas(3);
					car2.setNumPlazas(2);
					lista_coches.add(car2);
					System.out.println(Caracteristicas(car2));
				}else {System.out.println("El almacen esta lleno, no se pueden fabricar m�s coches");}
				break;
			
			case 2:
				if(Coche.numCoches<Coche.maxCoches) {
				Coche car3 = new Coche(5,5);
				car3.setMarca("BMW");
				car3.setModelo("850");
				car3.setColor("Gris");
				car3.avanzar(400);
				car3.setMatricula(matAleatoria());
				lista_coches.add(car3);
				System.out.println(Caracteristicas(car3));
				}else {System.out.println("El almacen esta lleno, no se pueden fabricar m�s coches");}
				break;
			case 3:
				if(Coche.numCoches<Coche.maxCoches) {
				Coche car4 = new Coche("VW", "Caddy", "");
				car4.avanzar(500);
				car4.setNumPuertas(5);
				car4.setNumPlazas(7);
				car4.tunear();
				car4.setMatricula(matAleatoria());
				lista_coches.add(car4);
				Caracteristicas(car4);
				}else {System.out.println("El almacen esta lleno, no se pueden fabricar m�s coches");}
				break;
			case 4:
				if(Coche.numCoches<Coche.maxCoches) {
				Coche car1 = new Coche();
				car1.setMarca("SEAT");
				car1.setModelo("Toledo");
				car1.setColor("Azul");
				car1.avanzar(200);
				car1.setNumPuertas(3);
				car1.setNumPlazas(5);
				car1.setMatricula(matAleatoria());
				lista_coches.add(car1);
				}else {System.out.println("El almacen esta lleno, no se pueden fabricar m�s coches");}
				break;
			case 5:
				System.out.println("Dime la matr�cula del coche que quieres tunear pint�ndolo");
				String matr = teclado.next();
				
				Coche co = buscaCoche(lista_coches, matr);
				if(co==null) {
		    		System.out.println("El coche no existe");
		    	}else {
		    		System.out.println("Dime de que color quieres pintar el coche");
		    		String color=teclado.next();
		    		co.tunear(color);
		    		System.out.print(Caracteristicas(co));
		    	}
				break;
			case 6:
				System.out.println("Dime la matr�cula del coche que quieres tunear sin pintar");
				 matr = teclado.next();
				
				co = buscaCoche(lista_coches, matr);
				if(co==null) {
		    		System.out.println("El coche no existe");
		    	}else {
		    		
		    		co.tunear();
		    		System.out.print(Caracteristicas(co));}
		    		
				break;
			case 7:
				System.out.println("Dime la matr�cula del coche que quieres avanzar");
				 matr = teclado.next();
				 co= buscaCoche(lista_coches, matr);
				if(co==null) {
		    		System.out.println("El coche no existe");
		    	}else {
		    		int km=0;
		    		System.out.println("Dime los kilometros que quieres avanzar");
		    		try {
		    		 km=Integer.parseInt(teclado.next());
		    		}catch(Exception e) {
		    			System.out.print("Introduce un n�mero v�lido");
		    		}
		    		co.avanzar(km);
		    		System.out.print(Caracteristicas(co));}
				break;
			case 8: 
				System.out.println("Dime la matr�cula del coche que quieres mostrar");
				matr = teclado.next();
				
				co = buscaCoche(lista_coches, matr);
				if(co==null) {
		    		System.out.println("El coche no existe");
		    	}else {
		    		
		    		System.out.println(Caracteristicas(co));}
				break;
			case 9:
				System.out.println("1) Ordenar de manera iterativa");
				System.out.println("2) Ordenar de manera recursiva ");
				System.out.println("Dame tu elecci�n");
				int resp=0;
				try {
					resp=Integer.parseInt(teclado.next());
				}catch(Exception e) {
					System.out.println("Parametros incorrecto");
				}
				
				Object aux=null;
				if(resp==1) {
					ordenarPorKM(lista_coches);
					
				} else if(resp==2) {
								ordenarPorKmRecursivo(lista_coches, 0, 0);
						 for(int i=0; i<lista_coches.size();i++) {
									System.out.println( (i+1)+ ")"+ Caracteristicas(((Coche)lista_coches.get(i))));
								    }

						}
				else {System.out.println("S�lo se acepta el 1 y el 2");}

				break;
			case 10:
				int resultado=0;
				int contador=0;
				sumarKmRecursivo(lista_coches, resultado, contador);
				break;
				
			case 11:
				System.out.println("Dame la matricula del coche que buscas");
				String mat=teclado.next();
				Coche c= buscarCocheRecursivo(lista_coches,mat,0) ;
				break;	
			
			
			case 12:
				System.out.println("Fin del programa");
				break;
		
			
			}
		}while(opcion1!=12);
		
	}
	private static Coche buscarCocheRecursivo(Vector lista_coches,String mat, int i ) {
		if(i == lista_coches.size()) {
			return null;
		}else {	if(mat.equals(((Coche)lista_coches.get(i)).getMatricula())) {
				return ((Coche)lista_coches.get(i));
				}else {
					return buscarCocheRecursivo(lista_coches,mat ,i+1);
				}
		}
	
			
	}
	private static int sumarKmRecursivo(Vector lista_coches, int resultado, int contador) {
		if(contador==lista_coches.size()) {
			return ((Coche)lista_coches.get(contador)).getKilometros();
		}else {return ((Coche)lista_coches.get(contador)).getKilometros() + sumarKmRecursivo(lista_coches, resultado, contador+1);}
	}
	private static void ordenarPorKmRecursivo(Vector lista_coches, int i, int j) {
		Object aux;

		if(i < lista_coches.size()-1) {
			
		
			if(((Coche)lista_coches.get(i)).getKilometros()<((Coche)lista_coches.get(j+1)).getKilometros()) {

			aux=lista_coches.get(i);
			lista_coches.set(i, lista_coches.get(j+1));
			lista_coches.set(j+1, aux);
			}
			if(j==lista_coches.size()-2) {
				ordenarPorKmRecursivo(lista_coches, i+1, i+1);
				}else {ordenarPorKmRecursivo(lista_coches, i, j+1);
				
				}
			}

		}
			
	
	private static void ordenarPorKM(Vector lista_coches) {
		Object aux;
		for(int i=0; i<lista_coches.size(); i++) {
			for(int j=i; j<lista_coches.size()-1; j++) {
				
					if(((Coche)lista_coches.get(i)).getKilometros()<((Coche)lista_coches.get(j+1)).getKilometros()) {
						aux=lista_coches.get(i);
						lista_coches.set(i, lista_coches.get(j+1));
						lista_coches.set(j+1, aux);
					}
						
				}		
		}
		for(int i=0; i<lista_coches.size();i++) {
			System.out.println( (i+1)+ ")"+ Caracteristicas(((Coche)lista_coches.get(i))));
		}
		
		
	}
	private static String matAleatoria() {
		int m=(int)Math.floor(Math.random()*(9999-1+1)+1);
		String mat=Integer.toString(m);
		String letras="BCDFGHJKLMNPQRSTVWXZ";
		char letra1=letras.charAt((int)Math.floor(Math.random()*(19-1+1)+1));
		char letra2=letras.charAt((int)Math.floor(Math.random()*(19-1+1)+1));
		char letra3=letras.charAt((int)Math.floor(Math.random()*(19-1+1)+1));
		
		if((m<999)&&(m>=100)) {
			mat="0"+mat;
		}else if((m<100)&&(m>=10)) {
			mat="00"+mat;
		}else if (m<=10) {mat="000"+mat;}
		
		return mat+"-"+letra1+letra2+letra3;
	
	
	
	
	
	
	}

	private static Coche buscaCoche(Vector lista_coches, String matr) {
		int i = 0;
		Coche co = null;
		while(i < lista_coches.size()) {
			if (matr.equals(((Coche)lista_coches.get(i)).getMatricula())){
				
			 co=((Coche)lista_coches.get(i));
			}
			i++;
		}
		
		return co;
	
	}
	

	private static String Caracteristicas(Coche c) {
		String tech;
		if(c.isTechoSolar()==true) {
			tech="S�";
		}else {tech="No";}
		 return "Matricula "+ c.getMatricula()+ 
		 		"\n Marca "+ c.getMarca()+
		 		"\n Modelo "+ c.getModelo()+
		 		"\n Color "+ c.getColor()+
		 		"\n Techo solar "+ tech+
		 		"\n Km "+ c.getKilometros()+
		 		"\n Puertas "+ c.getNumPuertas()+
		 		"\n Plazas "+ c.getNumPlazas()+
		 		"\n";
	}


}