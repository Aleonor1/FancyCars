import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Clasa care gestioneaza datele generale despre un auto-vehicul. Clasa contine cateva atribute ale unui autovehicul.  
 * @author Adrian-Aleonor Nyikita
 * @author Robert Simofi
 *
 */
public class Autovehicul extends Mainn {
	
	String tip;
	String nr_inmatriculare;
	String marca;
	String data_inmatriculare;
	String proprietar;
	String data_ultimei_revizii;
	int motorizare;
	String tip_combustibil;
	String culoare;
/**
 * Constructorul implicit al clasei
 */
	Autovehicul() {
		tip="";
		nr_inmatriculare="asd";
		marca="";
		data_inmatriculare="01/01/2001";
		proprietar="";
		data_ultimei_revizii="01/01/2001";
		motorizare=0;
		tip_combustibil="";
		culoare="";
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
 */
	
	Autovehicul(String t, String nr_i, String m, String d_i, String pr, String d_u_r, String tip_c, String cul, int mo) {
		tip=t;
		nr_inmatriculare=nr_i;
		marca=m;
		data_inmatriculare=d_i;
		proprietar=pr;
		data_ultimei_revizii=d_u_r;
		motorizare=mo;
		tip_combustibil=tip_c;
		culoare=cul;

	}
	public void print()
	{

		System.out.println("Tipul autovehiculului: "+ tip);
		System.out.println("Numarul de inmatriculare: " + nr_inmatriculare);
		System.out.println("Marca autovehiculului: " + marca );
		System.out.println("Data inmatricularii autovehiculului: " + data_inmatriculare);
		System.out.println("Nume proprietar: " + proprietar );
		System.out.println("Data ultimei revizii: "+ data_ultimei_revizii);
		System.out.println("Tipul combustibilului: "+tip_combustibil);
		System.out.println("Culoarea autovehiculului: "+ culoare);
		System.out.println("Capacitatea motorului: "+motorizare);
		
		
	}
	
	public void write_in_file(BufferedWriter write_aux, FileWriter file_aux) throws IOException {
		write_aux.write(tip);
		write_aux.newLine();
		write_aux.write(nr_inmatriculare);
		write_aux.newLine();
		write_aux.write(marca);
		write_aux.newLine();
		write_aux.write(data_inmatriculare);
		write_aux.newLine();
		write_aux.write(proprietar);
		write_aux.newLine();
		write_aux.write(data_ultimei_revizii);
		write_aux.newLine();
		write_aux.write(tip_combustibil);
		write_aux.newLine();
		write_aux.write(culoare);
		write_aux.newLine();
		write_aux.write(String.valueOf(motorizare));
		write_aux.newLine();
	}
	
	public String get_nr_matriculare() {
		return nr_inmatriculare;
	}
	
	public String get_nume() {
		return proprietar;
	}
	
	public String get_tip() {
		return tip;
	}
	
	public String get_data_inmatriculare() {
		return data_inmatriculare;
	}
	
	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	
	/**
	 * @return the data_ultimei_revizii
	 */
	public String getData_ultimei_revizii() {
		return data_ultimei_revizii;
	}
	
	/**
	 * @return the motorizare
	 */
	public int getMotorizare() {
		return motorizare;
	}
	
	/**
	 * @return the tip_combustibil
	 */
	public String getTip_combustibil() {
		return tip_combustibil;
	}
	
	/**
	 * @return the culoare
	 */
	public String getCuloare() {
		return culoare;
	}
	
	public void setRevizie(String revizie_aux) {
		data_ultimei_revizii = revizie_aux;
	}
	
	public void setNume(String n) {
		proprietar=n;
	}
	
	public void setMotorizare(int m) {
		motorizare=m;
	}
	
	public void setCombustibil(String c) {
		tip_combustibil=c;
	}
	
	public void setCuloare(String cul) {
		culoare=cul;
	}
}

