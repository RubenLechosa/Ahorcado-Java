import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Ahorcado {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int elegir = 0;

		System.out.println("Bienvenido/a al Ahorcado \n");

		System.out.println("Elige entre los siguientes:\n" + "1. Jugar\r\n" + "2. Mostrar Ranking\r\n" + "3. Salir \n");
		elegir = sc.nextInt();

		if (elegir == 1) {
			juego();
		}

	}

	public static void juego() {
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		String NomFit = "./text.txt";
		String s[] = new String[65194];

		int contadorpalabras = 0;
		boolean repetir = true;
		boolean repetirtodo = true;
		char letra;
		int contador = 0;
		int contadorfallos = 0;
		int temp = 0;
		int fin = 0;
		String volver = "none";

		try {
			// Abrir el fichero indicado en la variable nombreFichero
			FileReader fr = new FileReader(NomFit);
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
		
		int aleatorio = rand.nextInt(65194);

		tiempoespera();

			//System.out.println(s[aleatorio]);//Printa la letra

			char[] palabra = s[aleatorio].toCharArray();
			char[] guionesbueno = new char [palabra.length];

			for(int i = 0;i<palabra.length;i++){
				guionesbueno[i] = '_';
			}

			mostrar(guionesbueno);
	
		while(repetir) {
				
	System.out.println("\n\nInserta una letra");
	letra = sc.next().charAt(0);
	temp = contador;
	for (int i = 0; i < palabra.length; i++) {
		if(letra == palabra[i]) {
			guionesbueno[i] = letra;
			contador++;
			mostrar(guionesbueno);
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
				System.out.println("\nQuieres volver a jugar? (si/no)");
				volver = sc.nextLine();
				
			
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
		
		System.out.println("\n\nFin palabra, has ganado");
		
			sc.nextLine();
			System.out.println("\nQuieres volver a jugar? (si/no)");
			volver = sc.nextLine();
		
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
	System.out.println("Hasta pronto");
		
	
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
