/**
 * Clasa generala pentru optiunea 3. Optiunea in care se pot actualiza cateva date ale masinii, mai exact atributele speciale fiecarei clase(cat_A1, cat_AM)
 * @author Adrian-Aleonor Nyikita
 * @author Robert Simofi
 */
import java.util.Scanner;

public class Optiunea3 extends Mainn {
	/**
	 * Se citeste de la tastatura o optiune pentru a modifica atributele speciale ale clasei.
	 * @param aux
	 */
	public void doIt(Autovehicul aux) {
		
		Scanner keyboard_for_3 = new Scanner(System.in);
		System.out.println("Ce doriti sa actualizati la autovehicul?");
		int option_for_3, int_aux;
		String string_aux;
		float float_aux;
		
		if (aux instanceof cat_A1) {
			
			cat_A1 aux_final = (cat_A1) aux;
			System.out.println("1. Caracteristici roti.");
			System.out.println("2. Capacitate rezervor.");
			
			option_for_3 = keyboard_for_3.nextInt();
			keyboard_for_3.nextLine();
			
			if (option_for_3 == 1) {
				
				System.out.println("Introduceti caracteristicile rotilor:");
				string_aux = keyboard_for_3.nextLine();
				aux_final.setRoti(string_aux);
				
			} else {
				
				System.out.println("Introduceti capacitatea rezervorului:");
				int_aux = keyboard_for_3.nextInt();
				keyboard_for_3.nextLine();
				aux_final.setRezervor(int_aux);
			}
		
		} else if (aux instanceof cat_A2) {
			
			cat_A2 aux_final = (cat_A2) aux;
			System.out.println("1. Caracteristici roti.");
			System.out.println("2. Numar de accidente.");
			
			option_for_3 = keyboard_for_3.nextInt();
			keyboard_for_3.nextLine();
			
			if (option_for_3 == 1) {
				
				System.out.println("Introduceti caracteristicile rotilor:");
				string_aux = keyboard_for_3.nextLine();
				aux_final.setRoti(string_aux);
				
			} else {
				
				System.out.println("Introduceti numarul de accidente:");
				int_aux = keyboard_for_3.nextInt();
				keyboard_for_3.nextLine();
				aux_final.setAccidente(int_aux);
			}
			
		} else if (aux instanceof cat_AM) {
			
			cat_AM aux_final = (cat_AM) aux;
			System.out.println("1. Caracteristici roti.");
			System.out.println("2. Tip ghidon.");
			
			option_for_3 = keyboard_for_3.nextInt();
			keyboard_for_3.nextLine();
			
			if (option_for_3 == 1) {
				
				System.out.println("Introduceti caracteristicile rotilor:");
				string_aux = keyboard_for_3.nextLine();
				aux_final.setRoti(string_aux);
				
			} else {
				
				System.out.println("Introduceti tipul ghidonului:");
				string_aux = keyboard_for_3.nextLine();
				aux_final.setGhidon(string_aux);
			}
			
		} else if (aux instanceof cat_B1) {
			
			cat_B1 aux_final = (cat_B1) aux;
			System.out.println("1. Numar valve.");
			System.out.println("2. Cai putere.");
			
			option_for_3 = keyboard_for_3.nextInt();
			keyboard_for_3.nextLine();
			
			if (option_for_3 == 1) {
				
				System.out.println("Introduceti numarul de valve:");
				int_aux = keyboard_for_3.nextInt();
				keyboard_for_3.nextLine();
				aux_final.setValve(int_aux);
				
			} else {
				
				System.out.println("Introduceti numarul de cai putere:");
				int_aux = keyboard_for_3.nextInt();
				keyboard_for_3.nextLine();
				aux_final.setCai(int_aux);
			}
			
		} else if (aux instanceof cat_BE) {
			
			cat_BE aux_final = (cat_BE) aux;
			System.out.println("1. Numar valve.");
			System.out.println("2. Cai putere.");
			System.out.println("3. Numar roti remorca.");
			
			option_for_3 = keyboard_for_3.nextInt();
			keyboard_for_3.nextLine();
			
			if (option_for_3 == 1) {
				
				System.out.println("Introduceti numarul de valve:");
				int_aux = keyboard_for_3.nextInt();
				keyboard_for_3.nextLine();
				aux_final.setValve(int_aux);
				
			} else if (option_for_3 == 2) {
				
				System.out.println("Introduceti numarul de cai putere:");
				int_aux = keyboard_for_3.nextInt();
				keyboard_for_3.nextLine();
				aux_final.setCai(int_aux);
				
			} else {
				
				System.out.println("Introduceti numarul de roti al remorcii:");
				int_aux = keyboard_for_3.nextInt();
				keyboard_for_3.nextLine();
				aux_final.setRotiRemorca(int_aux);
			}	
			
		} else if (aux instanceof cat_C1) {
			
			cat_C1 aux_final = (cat_C1) aux;
			System.out.println("1. Tonaj maxim autorizat.");
			System.out.println("2. Dimensiune container.");
			
			option_for_3 = keyboard_for_3.nextInt();
			keyboard_for_3.nextLine();
			
			if (option_for_3 == 1) {
				
				System.out.println("Introduceti tonajul maxim autorizat:");
				int_aux = keyboard_for_3.nextInt();
				keyboard_for_3.nextLine();
				aux_final.setTonaj(int_aux);
				
			} else {
				
				System.out.println("Introduceti dimensiunea containerului:");
				float_aux = keyboard_for_3.nextFloat();
				keyboard_for_3.nextLine();
				aux_final.setContainer(float_aux);
			}
			
		} else if (aux instanceof cat_C1E) {
			
			cat_C1E aux_final = (cat_C1E) aux;
			System.out.println("1. Tonaj maxim autorizat.");
			System.out.println("2. Dimensiune remorca.");
			
			option_for_3 = keyboard_for_3.nextInt();
			keyboard_for_3.nextLine();
			
			if (option_for_3 == 1) {
				
				System.out.println("Introduceti tonajul maxim autorizat:");
				int_aux = keyboard_for_3.nextInt();
				keyboard_for_3.nextLine();
				aux_final.setTonaj(int_aux);
				
			} else {
				
				System.out.println("Introduceti dimensiunea remorcii:");
				string_aux = keyboard_for_3.nextLine();
				aux_final.setRemorca(string_aux);
			}
			
		} else if (aux instanceof cat_CE) {
			
			cat_CE aux_final = (cat_CE) aux;
			System.out.println("1. Tonaj maxim autorizat.");
			System.out.println("2. Tip remorca.");
			
			option_for_3 = keyboard_for_3.nextInt();
			keyboard_for_3.nextLine();
			
			if (option_for_3 == 1) {
				
				System.out.println("Introduceti tonajul maxim autorizat:");
				int_aux = keyboard_for_3.nextInt();
				keyboard_for_3.nextLine();
				aux_final.setTonaj(int_aux);
				
			} else {
				
				System.out.println("Introduceti tipul remorcii:");
				string_aux = keyboard_for_3.nextLine();
				aux_final.setTipRemorca(string_aux);
			}
			
		} else if (aux instanceof cat_D1) {
			
			cat_D1 aux_final = (cat_D1) aux;
			System.out.println("1. Numar maxim de locuri autorizate.");
			System.out.println("2. Climatizare.");
			
			option_for_3 = keyboard_for_3.nextInt();
			keyboard_for_3.nextLine();
			
			if (option_for_3 == 1) {
				
				System.out.println("Introduceti numarul maxim de locuri autorizate:");
				int_aux = keyboard_for_3.nextInt();
				keyboard_for_3.nextLine();
				aux_final.setLocuri(int_aux);
				
			} else {
				boolean parametru_aux = aux_final.getClima();
				if (parametru_aux) {
					aux_final.setClima(false);
				} else {
					aux_final.setClima(true);
				}
			}
			
		} else if (aux instanceof cat_D1E) {
			
			cat_D1E aux_final = (cat_D1E) aux;
			System.out.println("1. Numar maxim de locuri autorizate.");
			System.out.println("2. Etajare.");
			
			option_for_3 = keyboard_for_3.nextInt();
			keyboard_for_3.nextLine();
			
			if (option_for_3 == 1) {
				
				System.out.println("Introduceti numarul maxim de locuri autorizate:");
				int_aux = keyboard_for_3.nextInt();
				keyboard_for_3.nextLine();
				aux_final.setLocuri(int_aux);
				
			} else {
				boolean parametru_aux = aux_final.getEtaj();
				if (parametru_aux) {
					aux_final.setEtaj(false);
				} else {
					aux_final.setEtaj(true);
				}
			}
			
		} else if (aux instanceof cat_DE) {
			
			cat_DE aux_final = (cat_DE) aux;
			System.out.println("1. Numar maxim de locuri autorizate.");
			System.out.println("2. Numar total kilometri.");
			
			option_for_3 = keyboard_for_3.nextInt();
			keyboard_for_3.nextLine();
			
			if (option_for_3 == 1) {
				
				System.out.println("Introduceti numarul maxim de locuri autorizate:");
				int_aux = keyboard_for_3.nextInt();
				keyboard_for_3.nextLine();
				aux_final.setLocuri(int_aux);
				
			} else {
				
				System.out.println("Introduceti numarul total de kilometri:");
				float_aux = keyboard_for_3.nextFloat();
				keyboard_for_3.nextLine();
				aux_final.setKM(float_aux);
			}
		}
	}
}
