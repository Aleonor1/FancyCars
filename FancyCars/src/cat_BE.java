import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clasa generala pentru categoria BE, este mostenita din clasa cat_B
 * @author Adrian-Aleonor Nyikita
 * @author Robert Simofi
 */
public class cat_BE extends cat_B  {
	
	int nr_roti_remorca;
	
	cat_BE() {
		super();
		nr_roti_remorca=0;
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
	 * @param nr_ro parametrul care reprezinta numarul de roti al remorcii
	 */
	cat_BE(String t, String nr_i, String m, String d_i, String pr, String d_u_r, String tip_c, String cul, int mo, int nr_v, int cai_p, int nr_ro) {
		super(t, nr_i, m, d_i, pr, d_u_r, tip_c, cul, mo, nr_v, cai_p);
		nr_roti_remorca=nr_ro;
	}
	
	public void print()
	{
		super.print();
		System.out.println("Numarul rotilor la remorca: "+nr_roti_remorca);
	}
	
	public void setValve(int valve_aux) {
		nr_valve = valve_aux;
	}
	
	public void write_in_file(BufferedWriter write_aux, FileWriter file_aux) throws IOException {
		super.write_in_file(write_aux, file_aux);
		write_aux.write(String.valueOf(nr_roti_remorca));
		write_aux.newLine();
	}
	
	public void setCai(int cai_aux) {
		cai_putere = cai_aux;
	}
	
	public void setRotiRemorca(int roti_remorca_aux) {
		nr_roti_remorca = roti_remorca_aux;
	}
}
