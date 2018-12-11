import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clasa generala pentru categoria A2, este mostenita din clasa cat_A
 * @author Adrian
 * @author Robert Simofi
 */
public class cat_A2 extends cat_A {
	
	int nr_accidente;
	/**
	 * Constructorul implicit al clasei
	 */
	cat_A2() {
		super();
		nr_accidente=0;
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
	 * @param nr_a parametrul pentru numarul de accidente care l-a avut autovehiculul
	 */
	cat_A2(String t, String nr_i, String m, String d_i, String pr, String d_u_r, String tip_c, String cul, int mo, String car_r, int nr_a) {
		super(t, nr_i, m, d_i, pr, d_u_r, tip_c, cul, mo, car_r);
		nr_accidente=nr_a;
	}
	
	public void print()
	{
		super.print();
		System.out.println("Numarul de accidente al autovehiculului: "+nr_accidente);
	}
	
	public void write_in_file(BufferedWriter write_aux, FileWriter file_aux) throws IOException {
		super.write_in_file(write_aux, file_aux);
		write_aux.write(String.valueOf(nr_accidente));
		write_aux.newLine();
	}
	
	public void setRoti(String roti_aux) {
		caracteristici_roti = roti_aux;
	}
	
	public void setAccidente(int accidente_aux) {
		nr_accidente = accidente_aux;
	}
}
