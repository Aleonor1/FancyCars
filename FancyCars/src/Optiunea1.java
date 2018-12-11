/**
 * Clasa generala pentru Optiunea 1, optiunea in care se poate modifica una din optiunile: Prorpietarul, Motorizarea, Tipul combustibilului si Culoarea
 * @author Adrian-Aleonor Nyikita
 * @author Robert Simofi
 */
import java.util.Scanner;

public class Optiunea1 extends Mainn {
	/**
	 * Cu ajutorul acestei functii se face modificarea atributele Autovehiculului. Se citeste de la tastatura un numar si in functie de numarul citit 
	 * se face operatia. 
	 * @param aux este parametrul care il primim ca si autovehicul, asupra acestuia se efectueaza modificarea
	 */
	public static void doIt(Autovehicul aux) {
		System.out.println("Ce doriti sa modificati la autovehicul?");
		System.out.println("1. Proprietar.");
		System.out.println("2. Motorizare.");
		System.out.println("3. Tip combustibil.");
		System.out.println("4. Culoare.");
		System.out.println("5. Inapoi.");
		Scanner keyboard_for_1 = new Scanner(System.in);
		Scanner keyboard_for_1_1 = new Scanner(System.in);
		String parametru_aux;
		int option_for_1 = keyboard_for_1.nextInt();
		
		switch(option_for_1) {
		
		case 1:
			System.out.println("Introduceti numele noului proprietar:");
			parametru_aux = keyboard_for_1_1.nextLine();
			aux.setNume(parametru_aux);
			System.out.println("Actualizare cu succes.");
			break;
			
		case 2:
			System.out.println("Introduceti noua motorizare:");
			int motor_aux = keyboard_for_1_1.nextInt();
			aux.setMotorizare(motor_aux);
			System.out.println("Actualizare cu succes.");
			break;
			
		case 3:
			System.out.println("Introduceti noul tip de combustibil:");
			parametru_aux = keyboard_for_1_1.nextLine();
			aux.setCombustibil(parametru_aux);
			System.out.println("Actualizare cu succes.");
			break;
			
		case 4:
			System.out.println("Introduceti noua culoare:");
			parametru_aux = keyboard_for_1_1.nextLine();
			aux.setCuloare(parametru_aux);
			System.out.println("Actualizare cu succes.");
			break;
			
		case 5:
			break;
		}
	}
}
