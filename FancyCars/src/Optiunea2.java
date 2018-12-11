/**
 * Clasa pentru Optiunea numarul 2, adica inmatricularea unui nou Autovechiul
 * @author Adrian-Aleonor Nyikita
 * @author Robert Simofi
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Optiunea2 extends Mainn {
	/**
	 * Prima data se citeste o optiune de la tastatura un numar, acesta reprezinta ce tip de autovehicul vrem sa inmatriculam. Dupa care citim de la 
	 * tastaura atributele generale pentru fiecare autovehicul, iar mai apoi citim atributele speciale fiecarei clase.
	 * @param avl_aux
	 * @return
	 */
	public static AVLtree doIt(AVLtree avl_aux, String nr_matr_aux) {
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
		System.out.println("Ce tip de autovehicul doriti sa inmatriculati?");
		System.out.println("1. Categoria A1.");
		System.out.println("2. Categoria A2.");
		System.out.println("3. Categoria AM.");
		System.out.println("4. Categoria B1.");
		System.out.println("5. Categoria BE.");
		System.out.println("6. Categoria C1.");
		System.out.println("7. Categoria C1E.");
		System.out.println("8. Categoria CE.");
		System.out.println("9. Categoria D1.");
		System.out.println("10. Categoria D1E.");
		System.out.println("11. Categoria DE.");
		System.out.println("12. Inapoi.");
		
		Scanner keyboard_for_2 = new Scanner(System.in);
		
		int option_for_2 = keyboard_for_2.nextInt();
		keyboard_for_2.nextLine();
		String marca_aux = new String(""),
			   nume_aux = new String(""),
			   combustibil_aux = new String(""),
			   culoare_aux = new String("");
		int motorizare_aux=0;
		if (option_for_2 != 12) {
			
			System.out.println("Introduceti marca autovehiculului:");
			marca_aux = keyboard_for_2.nextLine();
			
			System.out.println("Introduceti numele proprietarului:");
			nume_aux = keyboard_for_2.nextLine();
			
			System.out.println("Introduceti motorizarea autovehiculului:");
			motorizare_aux = keyboard_for_2.nextInt();
			keyboard_for_2.nextLine();
			
			System.out.println("Introduceti tipul combustibilului al autovehiculului:");
			combustibil_aux = keyboard_for_2.nextLine();
			
			System.out.println("Introduceti culoarea autovehiculului:");
			culoare_aux = keyboard_for_2.nextLine();
		}
		
		switch(option_for_2) {
		
			case 1:
				
				System.out.println("Introduceti caracteristicile rotilor ale autovehiculului:");
				String roti_aux1 = keyboard_for_2.nextLine();
				
				System.out.println("Introduceti capacitatea rezervorului al autovehiculului:");
				int rezervor_aux = keyboard_for_2.nextInt();
				keyboard_for_2.nextLine();
				
				cat_A1 auto_aux1 = new cat_A1("A1", nr_matr_aux, marca_aux, dateFormat.format(date), nume_aux, dateFormat.format(date), combustibil_aux, culoare_aux, motorizare_aux, roti_aux1, rezervor_aux);
				avl_aux.insert(auto_aux1);
				break;
				
			case 2:
				
				System.out.println("Introduceti caracteristicile rotilor ale autovehiculului:");
				String roti_aux2 = keyboard_for_2.nextLine();
				
				System.out.println("Introduceti numarul de accidente al autovehiculului:");
				int accidente_aux = keyboard_for_2.nextInt();
				keyboard_for_2.nextLine();
				
				cat_A2 auto_aux2 = new cat_A2("A2", nr_matr_aux, marca_aux, dateFormat.format(date), nume_aux, dateFormat.format(date), combustibil_aux, culoare_aux, motorizare_aux, roti_aux2, accidente_aux);
				avl_aux.insert(auto_aux2);
				break;
				
			case 3:
				
				System.out.println("Introduceti caracteristicile rotilor ale autovehiculului:");
				String roti_aux3 = keyboard_for_2.nextLine();
				
				System.out.println("Introduceti tipul ghidonului al autovehiculului:");
				String ghidon_aux = keyboard_for_2.nextLine();
				keyboard_for_2.nextLine();
				
				cat_AM auto_aux3 = new cat_AM("AM", nr_matr_aux, marca_aux, dateFormat.format(date), nume_aux, dateFormat.format(date), combustibil_aux, culoare_aux, motorizare_aux, roti_aux3, ghidon_aux);
				avl_aux.insert(auto_aux3);
				break;
				
			case 4:
				
				System.out.println("Introduceti numarul de valve al autovehiculului:");
				int valve_aux1 = keyboard_for_2.nextInt();
				keyboard_for_2.nextLine();
				
				System.out.println("Introduceti numarul de cai putere al autovehiculului:");
				int cai_aux1 = keyboard_for_2.nextInt();
				keyboard_for_2.nextLine();
				
				System.out.println("Introduceti anul fabricatiei autovehiculului:");
				int an_aux = keyboard_for_2.nextInt();
				keyboard_for_2.nextLine();
				
				cat_B1 auto_aux4 = new cat_B1("B1", nr_matr_aux, marca_aux, dateFormat.format(date), nume_aux, dateFormat.format(date), combustibil_aux, culoare_aux, motorizare_aux, valve_aux1, cai_aux1, an_aux);
				avl_aux.insert(auto_aux4);
				break;
				
			case 5:
				
				System.out.println("Introduceti numarul de valve al autovehiculului:");
				int valve_aux2 = keyboard_for_2.nextInt();
				keyboard_for_2.nextLine();
				
				System.out.println("Introduceti numarul de cai putere al autovehiculului:");
				int cai_aux2 = keyboard_for_2.nextInt();
				keyboard_for_2.nextLine();
				
				System.out.println("Introduceti numarul de roti al remorcii autovehiculului:");
				int nr_roti_aux = keyboard_for_2.nextInt();
				keyboard_for_2.nextLine();
				
				cat_BE auto_aux5 = new cat_BE("BE", nr_matr_aux, marca_aux, dateFormat.format(date), nume_aux, dateFormat.format(date), combustibil_aux, culoare_aux, motorizare_aux, valve_aux2, cai_aux2, nr_roti_aux);
				avl_aux.insert(auto_aux5);
				break;
				
			case 6:
				
				System.out.println("Introduceti tonajul maxim autorizat al autovehiculului:");
				int tonaj_aux1 = keyboard_for_2.nextInt();
				keyboard_for_2.nextLine();
				
				System.out.println("Introduceti dimensiunea containerului al autovehiculului:");
				float dimensiune_aux = keyboard_for_2.nextFloat();
				keyboard_for_2.nextLine();
				
				cat_C1 auto_aux6 = new cat_C1("C1", nr_matr_aux, marca_aux, dateFormat.format(date), nume_aux, dateFormat.format(date), combustibil_aux, culoare_aux, motorizare_aux, tonaj_aux1, dimensiune_aux);
				avl_aux.insert(auto_aux6);
				break;
				
			case 7:
				
				System.out.println("Introduceti tonajul maxim autorizat al autovehiculului:");
				int tonaj_aux2 = keyboard_for_2.nextInt();
				keyboard_for_2.nextLine();
				
				System.out.println("Introduceti dimensiunea remorcii al autovehiculului:");
				String dimensiune_aux2 = keyboard_for_2.nextLine();
				
				
				cat_C1E auto_aux7 = new cat_C1E("C1E", nr_matr_aux, marca_aux, dateFormat.format(date), nume_aux, dateFormat.format(date), combustibil_aux, culoare_aux, motorizare_aux, tonaj_aux2, dimensiune_aux2);
				avl_aux.insert(auto_aux7);
				break;
				
			case 8:
				
				System.out.println("Introduceti tonajul maxim autorizat al autovehiculului:");
				int tonaj_aux3 = keyboard_for_2.nextInt();
				keyboard_for_2.nextLine();
				
				System.out.println("Introduceti tipul remorcii al autovehiculului:");
				String tip_remorca_aux = keyboard_for_2.nextLine();
				
				
				cat_CE auto_aux8 = new cat_CE("CE", nr_matr_aux, marca_aux, dateFormat.format(date), nume_aux, dateFormat.format(date), combustibil_aux, culoare_aux, motorizare_aux, tonaj_aux3, tip_remorca_aux);
				avl_aux.insert(auto_aux8);
				break;
				
			case 9:
				
				System.out.println("Introduceti numarul maxim de locuri autorizate:");
				int locuri_aux1 = keyboard_for_2.nextInt();
				keyboard_for_2.nextLine();
				
				System.out.println("Autovehiculul are clima?");
				System.out.println("1: Da.");
				System.out.println("2: Nu.");
				int clima_aux1 = keyboard_for_2.nextInt();
				boolean clima_aux2;
				keyboard_for_2.nextLine();
				if (clima_aux1 == 1) {
					clima_aux2 = true;
				} else {
					clima_aux2 = false;
				}
				
				cat_D1 auto_aux9 = new cat_D1("D1", nr_matr_aux, marca_aux, dateFormat.format(date), nume_aux, dateFormat.format(date), combustibil_aux, culoare_aux, motorizare_aux, locuri_aux1, clima_aux2);
				avl_aux.insert(auto_aux9);
				break;
				
			case 10:
				
				System.out.println("Introduceti numarul maxim de locuri autorizate:");
				int locuri_aux2 = keyboard_for_2.nextInt();
				keyboard_for_2.nextLine();
				
				System.out.println("Autovehiculul are etaj?");
				System.out.println("1: Da.");
				System.out.println("2: Nu.");
				int etaj_aux1 = keyboard_for_2.nextInt();
				boolean etaj_aux2;
				keyboard_for_2.nextLine();
				if (etaj_aux1 == 1) {
					etaj_aux2 = true;
				} else {
					etaj_aux2 = false;
				}
				
				cat_D1E auto_aux10 = new cat_D1E("D1E", nr_matr_aux, marca_aux, dateFormat.format(date), nume_aux, dateFormat.format(date), combustibil_aux, culoare_aux, motorizare_aux, locuri_aux2, etaj_aux2);
				avl_aux.insert(auto_aux10);
				break;
				
			case 11:
				
				System.out.println("Introduceti numarul maxim de locuri autorizate:");
				int locuri_aux3 = keyboard_for_2.nextInt();
				keyboard_for_2.nextLine();
				
				System.out.println("Introduceti numarul de kilometrii al autovehiculului:");
				float km_aux = keyboard_for_2.nextFloat();
				keyboard_for_2.nextLine();
				
				cat_DE auto_aux11 = new cat_DE("DE", nr_matr_aux, marca_aux, dateFormat.format(date), nume_aux, dateFormat.format(date), combustibil_aux, culoare_aux, motorizare_aux, locuri_aux3, km_aux);
				avl_aux.insert(auto_aux11);
				break;
				
			case 12:
				break;
		}
		return avl_aux;
	}
}
