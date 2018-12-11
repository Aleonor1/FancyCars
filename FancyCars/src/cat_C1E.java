import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clasa generala pentru categoria C1E, este mostenita din clasa cat_C
 * @author Adrian-Aleonor Nyikita
 * @author Robert Simofi
 */
public class cat_C1E extends cat_C {
	
	String dimensiune_remorca;
	/**
	 * Constructorul implicit al clasei 
	 */
	cat_C1E() {
		super();
		dimensiune_remorca="";
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
	 * @param dim_r parametrul pentru dimensiunea remorcii
	 */
	cat_C1E(String t, String nr_i, String m, String d_i, String pr, String d_u_r, String tip_c, String cul, int mo, int ton_a, String dim_r) {
		super(t, nr_i, m, d_i, pr, d_u_r, tip_c, cul, mo, ton_a);
		dimensiune_remorca=dim_r;
	}
	
	public void print()
	{
		super.print();
		System.out.println("Dimensiune remorca: "+ dimensiune_remorca);
	}
	
	public void write_in_file(BufferedWriter write_aux, FileWriter file_aux) throws IOException {
		super.write_in_file(write_aux, file_aux);
		write_aux.write(dimensiune_remorca);
		write_aux.newLine();
	}
	
	public void setTonaj(int tonaj_aux) {
		tonaj_maxim_autorizat = tonaj_aux;
	}
	
	public void setRemorca(String remorca_aux) {
		dimensiune_remorca = remorca_aux;
	}
}
