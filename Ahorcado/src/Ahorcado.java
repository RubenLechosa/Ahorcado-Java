import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Ahorcado {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int elegir = 0;
		boolean repetir = true;
		String nombre = "";
		
		
		while(repetir) {
		System.out.println("Bienvenido/a al Menu del ahorcado \n");
		
		do {
			try {
				System.out.println("Elige entre los siguientes:\n" + "1. Jugar\r\n" + "2. Mostrar Ranking\r\n" + "3. Salir \n");
				elegir = Integer.parseInt(sc.next());
			} catch (Exception e) {
				System.out.println("Caracter inválido, vuelve a elegir \n");
			}
		} while (elegir != 1 && elegir != 2 && elegir != 3);

		
		sc.nextLine();
		if (elegir == 1) {
			System.out.println("Inserta tu nombre:");
			nombre = sc.nextLine();
			
			nombre(nombre);
			
			
			juego();
		}else if(elegir  == 2){
			System.out.println("RANKING DE JUGADORES");
		}else if(elegir == 3) {
			repetir = false;
		}
		
		
		
		}
		
		System.out.println("Hasta pronto!!!");

	}

	public static void juego() {
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		String fpalabras = "./text.txt";
		String s[] = new String[65194];

		boolean repetir = true;
		boolean repetirtodo = true;
		char letra;
		int contador = 0;
		int contadorfallos = 0;
		int temp = 0;
		int fin = 0;
		String volver = "none";
		int cvictorias = 0;
		

		try {
			// Abrir el fichero indicado en la variable nombreFichero
			FileReader fr = new FileReader(fpalabras);
			BufferedReader br = new BufferedReader(fr);

			for (int i = 0; i < s.length; i++) {
				s[i] = br.readLine();
			}

			// Cerrar el fichero
			fr.close();
			br.close();
		} catch (IOException e) {
			System.out.println("Error E/S: " + e);
		}
	
		while(repetirtodo) {
			repetir = true;
			char comprobar[] = new char [27];
			int cn = 0;
		
		int aleatorio = rand.nextInt(65119);

		tiempoespera();

			System.out.println(s[aleatorio]);//Printa la letra

			char[] palabra = s[aleatorio].toCharArray();
			char[] guionesbueno = new char [palabra.length];

			for(int i = 0;i<palabra.length;i++){
				guionesbueno[i] = '_';
			}

			
	
		while(repetir) {
			
				
	System.out.println("\nInserta una letra");
	mostrar(guionesbueno);
	letra = sc.next().charAt(0);
	
	for (int i = 0; i < guionesbueno.length; i++) {
		while(guionesbueno[i] == letra) {
		System.out.println("Error, Ya has introducido esta letra");
		letra = sc.next().charAt(0);
	}
	}
	
	temp = contador;
	for (int i = 0; i < palabra.length; i++) {
		if(letra == palabra[i]) {
			guionesbueno[i] = letra;
			contador++;
			
		}
		
	}
	
	if(temp == contador) {
		System.out.println("Has fallado\n");
		dibujo(fin);
		fin++;
		
		if(fin == 7) {
			System.out.println("Has perdido");
			mostrar(guionesbueno);
			System.out.println();
			System.out.println("La palabra era: "+s[aleatorio]);
			
				sc.nextLine();
			
				do {
					try {
						System.out.println("\nQuieres volver a jugar? (si/no)");
						volver = sc.nextLine().toLowerCase();
					} catch (Exception e) {
						System.out.println("Caracter inválido, vuelve a elegir \n");
					}
				} while (!volver.equals("si") && !volver.equals("no"));
				
			
				if(volver.equals("si")) {
					repetir = false;
					repetirtodo = true;
					contador = 0;
					fin = 0;
				}else if (volver.equals("no")) {
					repetirtodo = false;
					repetir = false;
					
				}
		}
	}
		
	
	
	if(palabra.length == contador) {
		
		System.out.println("\n\nFeliciades!!!, has ganado");
			cvictorias++;
			sc.nextLine();
			
			do {
				try {
					System.out.println("\nQuieres volver a jugar? (si/no)");
					volver = sc.nextLine().toLowerCase();
				} catch (Exception e) {
					System.out.println("Caracter inválido, vuelve a elegir \n");
				}
			} while (!volver.equals("si") && !volver.equals("no"));
		
		if(volver.equals("si")) {
			repetir = false;
			repetirtodo = true;
			contador = 0;
			fin = 0;
		}else if (volver.equals("no")) {
			repetirtodo = false;
			repetir = false;
			
		}
		
	}
	
		
		}
	}
		
	
	}
	public static void nombre(String nombre) {
		
		String fnombre = "./nombre.txt";
		int lineas = 0;
		int contador = 0;
		
		try {
			// Abrir el fichero indicado en la variable nombreFichero
			FileReader fr = new FileReader(fnombre);
			BufferedReader br = new BufferedReader(fr);
			
			while (br.readLine() != null) lineas++;
		

			// Cerrar el fichero
			fr.close();
			br.close();
		} catch (IOException e) {
			System.out.println("Error E/S: " + e);
		}
		
		
		try {
			// Abrir el fichero indicado en la variable nombreFichero
			FileReader fr = new FileReader(fnombre);
			BufferedReader br = new BufferedReader(fr);
			
			String nombres[] = new String [lineas];

			for (int i = 0; i < lineas; i++) {
				nombres[i] = br.readLine();
				
			}
			
			for (int i = 0; i < nombres.length; i++) {
				if(nombres[i].equals(nombre)) {
					contador++;
				}
			}

			// Cerrar el fichero
			fr.close();
			br.close();
		} catch (IOException e) {
			System.out.println("Error E/S: " + e);
		}
			
			
			if(contador == 1) {
				System.out.println("Bienvenido/a de nuevo");
			}else if(contador == 0) {
				System.out.println("Veo que es tu primera vez aqui, Bienvenido/a");
				
				try {
				      
					   // true -> guarda los datos al final del fichero conservando los datos que ya hab�a	
					   // false o res -> Si el archivo existe lo elimina y escribe el nuevo contenido
					   FileWriter fw = new FileWriter(fnombre, true);
					   //Crear un objeto BufferedWriter
					   BufferedWriter bw = new BufferedWriter(fw);
					   
					       //Leer, por ejemplo, un texto desde el tec
					       //Escrbir en el fichero el texto
					      	bw.write(nombre);
					       
					       //Escribir en el fichero un salto de l�nea
					       bw.newLine();
					       //Tambi�n se puede: bw.write("\n");
					   
					   //Cerrar el buffer
					   bw.close();
					   fw.close();
					  
						
				    }catch(IOException e){
				         System.out.println("Error E/S: "+e);
				    	}
				
			}
				
					
				
	}

	public static void mostrar(char[] palabra) {
		for (int i = 0; i < palabra.length; i++) {
			System.out.print(palabra[i]+" ");
		}
		System.out.println();
	}

	public static void tiempoespera(){
		System.out.print("Estamos buscando una palabra");
		try {
			Thread.sleep(1*500);
		} catch (Exception e) {
			System.out.print(e);
		}
		System.out.print(".");
		try {
			Thread.sleep(1*500);
		} catch (Exception e) {
			System.out.print(e);
		}
		System.out.print(".");
		try {
			Thread.sleep(1*500);
		} catch (Exception e) {
			System.out.print(e);
		}
		System.out.print(".");
		try {
			Thread.sleep(1*500);
		} catch (Exception e) {
			System.out.print(e);
		}
		System.out.println();
	}
	public static void dibujo(int contador) {
		String dibujo[] = {"   +---+\r\n"
				+ "   |   |\r\n"
				+ "       |\r\n"
				+ "       |\r\n"
				+ "       |\r\n"
				+ "       |\r\n"
				+ "\r\n"
				+ "=========", "  +---+\r\n"
						+ "  |   |\r\n"
						+ "  O   |\r\n"
						+ "      |\r\n"
						+ "      |\r\n"
						+ "      |\r\n"
						+ "=========", "  +---+\r\n"
								+ "  |   |\r\n"
								+ "  O   |\r\n"
								+ "  |   |\r\n"
								+ "      |\r\n"
								+ "      |\r\n"
								+ "=========", "  +---+\r\n"
										+ "  |   |\r\n"
										+ "  O   |\r\n"
										+ " /|   |\r\n"
										+ "      |\r\n"
										+ "      |\r\n"
										+ "=========", "  +---+\r\n"
												+ "  |   |\r\n"
												+ "  O   |\r\n"
												+ " /|\\  |\r\n"
												+ "      |\r\n"
												+ "      |\r\n"
												+ "=========", "  +---+\r\n"
														+ "  |   |\r\n"
														+ "  O   |\r\n"
														+ " /|\\  |\r\n"
														+ " /    |\r\n"
														+ "      |\r\n"
														+ "=========", "  +---+\r\n"
																+ "  |   |\r\n"
																+ "  O   |\r\n"
																+ " /|\\  |\r\n"
																+ " / \\  |\r\n"
																+ "      |\r\n"
																+ "========="};
		
		System.out.println(dibujo[contador]);
	}

}
