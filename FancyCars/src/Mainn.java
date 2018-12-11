/**
 * Aceasta este clasa principala, aici putem actualiza datele unei masini, inmatricularea unui nou autovehicul, modificarea caracteristici aditionale
 * ale unui autovehicul inmatriculat, cautarea autoturismului dupa numarul de inmatriculare, cautarea autoturismelor ale unui proprietar,
 * revizia autoturismului, radierea autoturismului, afisarea tuturoul autoturismelui inmatriculate dupa o anumita data, afisarea autoturismelui dupa reviziei
 * sortarea autovehiculelor dupa tip
 * @author Adrian-Aleonor Nyikita
 * @author Robert Simofi
 */
import java.io.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;
import java.text.*;
import java.util.*;

public class Mainn extends MainnUI {
	public static int contor_revizie=0;
	public static int contor_data=0;
	public static int parametru_aux_4=0;
	public static ArrayList <Autovehicul> autovehicule_sortate_dupa_tip = new ArrayList <Autovehicul>();
	public static ArrayList <String> date_inmatriculare = new ArrayList<String>();
	public static <E> void mainn() throws IOException,ClassNotFoundException, SQLException {
		DBAV t1 = new DBAV();	
		t1.creareBD();
		t1.afisare();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		int option=0;
		
		Scanner keyboard = new Scanner(System.in);
		Scanner keyboard_aux = new Scanner(System.in);

		while (option != 11) {
			System.out.println("Optiunea 1: Actualizare autovehicul.");
			System.out.println("Optiunea 2: Inmatricularea unui nou autoturism.");
			System.out.println("Optiunea 3: Modificare caracteristici aditionale a unui av inmatriculat.");
			System.out.println("Optiunea 4: Cautare autoturism dupa nr de inmatriculare.");
			System.out.println("Optiunea 5: Cautare autoturism dupa nume proprietar.");
			System.out.println("Optiunea 6: Revizie autoturism.");
			System.out.println("Optiunea 7: Radiere autoturism.");
			System.out.println("Optiunea 8: Afisarea autoturismelor inmatriculate dupa o anumita data.");
			System.out.println("Optiunea 9: Afisarea autoturismelor inainte de o data a reviziei.");
			System.out.println("Optiunea 10: Sortarea av dupa tip.");
			System.out.println("Optiunea 11: Stop");
			System.out.println("Alegeti o optiune: ");
			
			String nr_matr_aux;
			E av_aux;
			option = keyboard.nextInt();
			keyboard.nextLine();
			
			switch (option) {
			
				case 1:
					
					//later
					System.out.println("Introduceti numarul de inmatriculare al autovehiculului pe care doriti sa il actualizati: ");
					nr_matr_aux = keyboard_aux.nextLine();
					
					break;
					
				case 2:
					
					System.out.println("Introduceti numarul de inmatriculare al autovehiculului pe care doriti sa il inmatriculati: ");
					nr_matr_aux = keyboard_aux.nextLine();
					
					break;
					
				case 3:
					
					System.out.println("Introduceti numarul de inmatriculare al autovehiculului pe care doriti sa il actualizati: ");
					nr_matr_aux = keyboard_aux.nextLine();
					
					break;
					
				case 4:
					
					System.out.println("Introduceti numarul de inmatriculare al autovehiculului pe care doriti sa il cautati: ");
					nr_matr_aux = keyboard_aux.nextLine();
					
					break;
					
				case 5:
					
					Scanner keyboard_for_4 = new Scanner(System.in);
					System.out.println("Introduceti numele persoanei a carui autovehicule vreti sa le vizionati:");
					String nume_aux_for_4 = keyboard_for_4.nextLine();
					if (parametru_aux_4==0) {
						System.out.println("Nu s-au gasit autovehicule inmatriculate pe numele acestui proprietar.");
					}
					break;
					
				case 6:
					
					System.out.println("Introduceti numarul de inmatriculare al autovehiculului caruia doriti sa ii faceti revizia: ");
					nr_matr_aux = keyboard_aux.nextLine();
					
					break;
					
				case 7:
					
					System.out.println("Introduceti numarul de inmatriculare al autovehiculului pe care doriti sa il radiati: ");
					nr_matr_aux = keyboard_aux.nextLine();
					
					break;
					
				case 8:
					
					System.out.println("Introduceti data pentru afisare autoturismelor inmatriculate dupa aceasta data: ");
					String data_aux = keyboard_aux.nextLine();
					if (contor_data== 0)
						System.out.println("Nu exista autovehicule inmatriculate dupa aceasta data");
					
					break;
					
				case 9:
					
					System.out.println("Introduceti data pentru afisarea autoturismelor cu revizia facuta inainte de data: ");
					String data_aux2 = keyboard_aux.nextLine();
					if (contor_revizie == 0)
						System.out.println("Nu exista autovehicule cu revizia facuta inainte de aceasta data");
					
					break;
					
				case 10:
					
					
					break;
					
				case 11:
					break;
					
				default:
					System.out.println("Optiune invalida");
					break;
			}
		}
	}
}