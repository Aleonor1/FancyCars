import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clasa generala pentru categoria B, este mostenita din clasa cat_B
 * @author Adrian-Aleonor Nyikita
 * @author Robert Simofi
 */
public class cat_B extends Autovehicul {
	
	int nr_valve;
	int cai_putere;
	/**
	 * Constructorul implicit al clasei
	 */
	cat_B() {
		super();
		nr_valve=0;
		cai_putere=0;
	}
	
	/**
	 * Constructorul cu parametrii al clasei
	 * 
	 * @param t acest parametru reprezinta tipul masinii
	 * @param nr_i parametrul pentru numarul de inmatriculare
	 * @param m parametrul pentru marca
	 * @param d_i parametru pentru data inmatricularii
	 * @param pr parametrul care reprezinta proprietarul autovehiculului
	 * @param d_u_r parametru pentru data ultimeii revizii
	 * @param mo parametru care reprezinta motorizarea autovehiculului
	 * @param tip_c parametrul pentru tip de combustibil
	 * @param cul parametrul pentru culoare
	 * @param nr_v parametrul pentru nr_valve
	 * @param cai_p parametrul care reprezinta puterea motorului
	 */
	cat_B(String t, String nr_i, String m, String d_i, String pr, String d_u_r, String tip_c, String cul, int mo, int nr_v, int cai_p) {
		super(t, nr_i, m, d_i, pr, d_u_r, tip_c, cul, mo);
		nr_valve=nr_v;
		cai_putere=cai_p;
	}
	
	public void write_in_file(BufferedWriter write_aux, FileWriter file_aux) throws IOException {
		super.write_in_file(write_aux, file_aux);
		write_aux.write(String.valueOf(nr_valve));
		write_aux.newLine();
		write_aux.write(String.valueOf(cai_putere));
		write_aux.newLine();
	}
	
	public void print()
	{
		super.print();
		System.out.println("Numar valve: " + nr_valve);
		System.out.println("Cai putere: " +cai_putere);
	}
}
