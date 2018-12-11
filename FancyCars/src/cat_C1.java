import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clasa generala pentru categoria C1, este mostenita din clasa cat_C
 * @author Adrian-Aleonor Nyikita
 * @author Robert Simofi
 */
public class cat_C1 extends cat_C  {
	
	float dimensiune_container;
	/**
	 * Constructorul implicit al clasei 
	 */
	cat_C1() {
		super();
		dimensiune_container=0;
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
	 * @param dim_c parametrul pentru dimensiunea containerului
	 */
	cat_C1(String t, String nr_i, String m, String d_i, String pr, String d_u_r, String tip_c, String cul, int mo, int ton_a, float dim_c) {
		super(t, nr_i, m, d_i, pr, d_u_r,  tip_c, cul, mo, ton_a);
		dimensiune_container=dim_c;
	}
	
	public void print()
	{
		super.print();
		System.out.println("Dimensiune container: "+ dimensiune_container);
	}
	
	public void write_in_file(BufferedWriter write_aux, FileWriter file_aux) throws IOException {
		super.write_in_file(write_aux, file_aux);
		write_aux.write(String.valueOf(dimensiune_container));
		write_aux.newLine();
	}
	
	public void setTonaj(int tonaj_aux) {
		tonaj_maxim_autorizat = tonaj_aux;
	}
	
	public void setContainer(float container_aux) {
		dimensiune_container = container_aux;
	}
}
