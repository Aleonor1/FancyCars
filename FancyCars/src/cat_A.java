import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clasa generala pentru categoria A, este mostenita din clasa Autovehicul
 * @author Adrian-Aleonor Nyikita
 * @author Robert Simofi
 */
public class cat_A extends Autovehicul {
	
	String caracteristici_roti;
/**
 * Constructorul implicit al clasei
 */
	cat_A() {
		super();
		caracteristici_roti="";
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
	 */
	cat_A(String t, String nr_i, String m, String d_i, String pr, String d_u_r,String tip_c, String cul, int mo, String car_r) {
		super(t, nr_i, m, d_i, pr, d_u_r, tip_c, cul, mo);
		caracteristici_roti=car_r;
	}
	
	public void write_in_file(BufferedWriter write_aux, FileWriter file_aux) throws IOException {
		super.write_in_file(write_aux, file_aux);
		write_aux.write(caracteristici_roti);
		write_aux.newLine();
	}
	
	public void print()
	{
		super.print();
		System.out.println("Caracteristici roti: " + caracteristici_roti);
	}
}
