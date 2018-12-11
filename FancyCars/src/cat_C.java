import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clasa generala pentru categoria C, este mostenita din clasa Autovehicul
 * @author Adrian-Aleonor Nyikita
 * @author Robert Simofi
 */
public class cat_C extends Autovehicul {
	
	int tonaj_maxim_autorizat;
	/**
	 * Constructorul implicit al clasei 
	 */
	cat_C() {
		super();
		tonaj_maxim_autorizat=0;
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
	 * @param ton_a parametrul pentru tonajul maxim autorizat
	 */
	cat_C(String t, String nr_i, String m, String d_i, String pr, String d_u_r,  String tip_c, String cul, int mo, int ton_a) {
		super(t, nr_i, m, d_i, pr, d_u_r, tip_c, cul, mo);
		tonaj_maxim_autorizat=ton_a;
	}
	
	public void write_in_file(BufferedWriter write_aux, FileWriter file_aux) throws IOException {
		super.write_in_file(write_aux, file_aux);
		write_aux.write(String.valueOf(tonaj_maxim_autorizat));
		write_aux.newLine();
	}
	
	public void print()
	{
		super.print();
		System.out.println("Tonaj maxim autorizat: "+tonaj_maxim_autorizat);
	}
}
