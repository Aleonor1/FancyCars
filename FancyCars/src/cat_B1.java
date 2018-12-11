import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clasa generala pentru categoria B1, este mostenita din clasa cat_B
 * @author Adrian-Aleonor Nyikita
 * @author Robert Simofi
 */
public class cat_B1 extends cat_B {
	
	int an_fabricatie;
	/**
	 * Constructorul implicit al clasei
	 */
	cat_B1() {
		super();
		an_fabricatie=0;
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
	 * @param parametrul pentru anul in care a fost fabricat autovehiculul
	 */
	cat_B1(String t, String nr_i, String m, String d_i, String pr, String d_u_r, String tip_c, String cul, int mo, int nr_v, int cai_p, int an_fab) {
		super(t, nr_i, m, d_i, pr, d_u_r, tip_c, cul, mo, nr_v, cai_p);
		an_fabricatie=an_fab;
	}
	
	public void print()
	{
		super.print();
		System.out.println("Anul fabricatiei: " + an_fabricatie);
	}
	
	public void write_in_file(BufferedWriter write_aux, FileWriter file_aux) throws IOException {
		super.write_in_file(write_aux, file_aux);
		write_aux.write(String.valueOf(an_fabricatie));
		write_aux.newLine();
	}
	
	public void setValve(int valve_aux) {
		nr_valve = valve_aux;
	}
	
	public void setCai(int cai_aux) {
		cai_putere = cai_aux;
	}
	
}
