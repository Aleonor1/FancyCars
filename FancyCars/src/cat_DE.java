import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clasa generala pentru categoria DE, este mostenita din clasa cat_D
 * @author Adrian-Aleonor Nyikita
 * @author Robert Simofi
 */
public class cat_DE extends cat_D {
	
	float nr_km;
	/**
	 * Constructorul implicit al clasei 
	 */
	cat_DE() {
		super();
		nr_km=0;
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
	 * @param loc_a parametru pentru numarul maxim de locuri autorizate
	 * @param nr_k parametrul pentru numarul de kilometrii
	 */
	cat_DE(String t, String nr_i, String m, String d_i, String pr, String d_u_r, String tip_c, String cul, int mo, int loc_a, float nr_k) {
		super(t, nr_i, m, d_i, pr, d_u_r, tip_c, cul, mo, loc_a);
		nr_km=nr_k;
	}
	
	public void print()
	{
		super.print();
		System.out.println("Nr kilometri: "+nr_km);
	}
	
	public void write_in_file(BufferedWriter write_aux, FileWriter file_aux) throws IOException {
		super.write_in_file(write_aux, file_aux);
		write_aux.write(String.valueOf(nr_km));
		write_aux.newLine();
	}
	
	public void setLocuri(int locuri_aux) {
		locuri_maxim_autorizate = locuri_aux;
	}
	
	public void setKM(float km_aux) {
		nr_km = km_aux;
	}
}
