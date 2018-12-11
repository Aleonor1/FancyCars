import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clasa generala pentru categoria AM, este mostenita din clasa cat_A
 * @author Adrian
 * @author Robert Simofi
 */
public class cat_AM extends cat_A {
	
	String tip_ghidon;
	/**
	 * Constructorul implicit al clasei
	 */
	cat_AM() {
		super();
		tip_ghidon="";
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
	 * @param car_r parametrul pentru caracteristicile rotilor
	 * @param tip_g parametrul care reprezinta tipul ghidonului
	 */
	
	cat_AM(String t, String nr_i, String m, String d_i, String pr, String d_u_r, String tip_c, String cul, int mo, String car_r, String tip_g) {
		super(t, nr_i, m, d_i, pr, d_u_r, tip_c, cul, mo, car_r);
		tip_ghidon=tip_g;
	}
	
	public void print()
	{
		super.print();
		System.out.println("Tipul ghidonului: "+tip_ghidon);
	}
	
	public void write_in_file(BufferedWriter write_aux, FileWriter file_aux) throws IOException {
		super.write_in_file(write_aux, file_aux);
		write_aux.write(tip_ghidon);
		write_aux.newLine();
	}
	
	public void setRoti(String roti_aux) {
		caracteristici_roti = roti_aux;
	}
	
	public void setGhidon(String ghidon_aux) {
		tip_ghidon = ghidon_aux;
	}
}
