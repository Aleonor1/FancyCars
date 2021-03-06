import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clasa generala pentru categoria D1, este mostenita din clasa cat_D
 * @author Adrian-Aleonor Nyikita
 * @author Robert Simofi
 */
public class cat_D1 extends cat_D {
	
	boolean are_clima;
	/**
	 * Constructorul implicit al clasei 
	 */
	cat_D1() {
		super();
		are_clima=false;
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
	 * @param are_c boolean pentru a vedea daca masina are clima sau nu
	 */
	cat_D1(String t, String nr_i, String m, String d_i, String pr, String d_u_r,  String tip_c, String cul, int mo, int loc_a, boolean are_c) {
		super(t, nr_i, m, d_i, pr, d_u_r, tip_c, cul,  mo, loc_a);
		are_clima=are_c;
	}
	
	public void print()
	{
		super.print();
		if (are_clima == true)
			System.out.println("Are clima");
		else
			System.out.println("Nu are clima");
	}
	
	public void write_in_file(BufferedWriter write_aux, FileWriter file_aux) throws IOException {
		super.write_in_file(write_aux, file_aux);
		write_aux.write(String.valueOf(are_clima));
		write_aux.newLine();
	}
	
	public void setLocuri(int locuri_aux) {
		locuri_maxim_autorizate = locuri_aux;
	}
	
	public void setClima(boolean clima_aux) {
		are_clima = clima_aux;
	}
	
	public boolean getClima() {
		return are_clima;
	}
}
