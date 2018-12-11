import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clasa generala pentru categoria A1, este mostenita din clasa cat_A
 * @author Adrian
 * @author Robert Simofi
 */
public class cat_A1 extends cat_A {
	
	int capacitate_rezervor;
	/**
	 * Constructorul implicit al clasei
	 */
	cat_A1() {
		super();
		capacitate_rezervor=0;
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
	 * @param cap_r parametrul care reprezinta capacitatea rezervorului de combustibil
	 */
	cat_A1(String t, String nr_i, String m, String d_i, String pr, String d_u_r, String tip_c, String cul, int mo, String car_r, int cap_r) {
		super(t, nr_i, m, d_i, pr, d_u_r, tip_c, cul, mo, car_r);
		capacitate_rezervor=cap_r;
	}
	
	public void print()
	{
		super.print();
		System.out.println("Capacittea rezervorului: "+capacitate_rezervor);
	}
	
	public void write_in_file(BufferedWriter write_aux, FileWriter file_aux) throws IOException {
		super.write_in_file(write_aux, file_aux);
		write_aux.write(String.valueOf(capacitate_rezervor));
		write_aux.newLine();
	}
	
	public void setRoti(String roti_aux) {
		caracteristici_roti = roti_aux;
	}
	
	public void setRezervor(int rezervor_aux) {
		capacitate_rezervor = rezervor_aux;
	}
}
