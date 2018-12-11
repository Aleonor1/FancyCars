import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JRadioButton;

public class AdaugareAutovehicul extends Window2 {

	private JFrame frmAdaugareAutovehicul;
	private JTextField numarInmatriculare;
	private JLabel lblCategorie;
	private JLabel lblMarca;
	private JTextField marca;
	private JLabel lblProprietar;
	private JTextField proprietar;
	private JLabel lblMotorizare;
	private JTextField motorizare;
	private JLabel lblCombustibil;
	private JComboBox combustibil;
	private JLabel lblCuloare;
	private JTextField culoare;
	private JLabel caracteristica1;
	private JLabel caracteristica2;
	private JLabel caracteristica3;
	private JTextField caracteristica1_text;
	private JTextField caracteristica2_text;
	private JTextField caracteristica3_text;
	private JButton btnAdaugare;
	private JButton btnRefresh;
	private JButton btnInapoi;
	public static boolean exista;

	/**
	 * Launch the application.
	 */
	public static void AdaugareAutovehicul(DBAV db) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdaugareAutovehicul window = new AdaugareAutovehicul(db);
					window.frmAdaugareAutovehicul.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdaugareAutovehicul(DBAV db) {
		initialize(db);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(DBAV db) {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		
		frmAdaugareAutovehicul = new JFrame();
		frmAdaugareAutovehicul.getContentPane().setBackground(Color.WHITE);
		frmAdaugareAutovehicul.setTitle("Adaugare autovehicul");
		frmAdaugareAutovehicul.setBounds(100, 100, 800, 800);
		frmAdaugareAutovehicul.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdaugareAutovehicul.getContentPane().setLayout(null);
		
		caracteristica1 = new JLabel("New label");
		caracteristica1.setFont(new Font("Tahoma", Font.BOLD, 17));
		caracteristica1.setBounds(127, 426, 285, 29);
		frmAdaugareAutovehicul.getContentPane().add(caracteristica1);
		
		caracteristica2 = new JLabel("New label");
		caracteristica2.setFont(new Font("Tahoma", Font.BOLD, 17));
		caracteristica2.setBounds(127, 467, 285, 29);
		frmAdaugareAutovehicul.getContentPane().add(caracteristica2);
		
		caracteristica3 = new JLabel("New label");
		caracteristica3.setFont(new Font("Tahoma", Font.BOLD, 17));
		caracteristica3.setBounds(127, 506, 285, 29);
		frmAdaugareAutovehicul.getContentPane().add(caracteristica3);
		
		caracteristica1_text = new JTextField();
		caracteristica1_text.setFont(new Font("Tahoma", Font.BOLD, 14));
		caracteristica1_text.setColumns(10);
		caracteristica1_text.setBackground(SystemColor.menu);
		caracteristica1_text.setBounds(417, 427, 206, 29);
		frmAdaugareAutovehicul.getContentPane().add(caracteristica1_text);
		
		caracteristica2_text = new JTextField();
		caracteristica2_text.setFont(new Font("Tahoma", Font.BOLD, 14));
		caracteristica2_text.setColumns(10);
		caracteristica2_text.setBackground(SystemColor.menu);
		caracteristica2_text.setBounds(417, 467, 206, 29);
		frmAdaugareAutovehicul.getContentPane().add(caracteristica2_text);
		
		caracteristica3_text = new JTextField();
		caracteristica3_text.setFont(new Font("Tahoma", Font.BOLD, 14));
		caracteristica3_text.setColumns(10);
		caracteristica3_text.setBackground(SystemColor.menu);
		caracteristica3_text.setBounds(417, 507, 206, 29);
		frmAdaugareAutovehicul.getContentPane().add(caracteristica3_text);
		
		JLabel lblAdaugareAutovehicul = new JLabel("Adaugare autovehicul");
		lblAdaugareAutovehicul.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAdaugareAutovehicul.setBounds(267, 28, 277, 37);
		frmAdaugareAutovehicul.getContentPane().add(lblAdaugareAutovehicul);
		
		JLabel lblNumarInmatriculare = new JLabel("Numar inmatriculare:");
		lblNumarInmatriculare.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNumarInmatriculare.setBounds(127, 116, 225, 37);
		frmAdaugareAutovehicul.getContentPane().add(lblNumarInmatriculare);
		
		numarInmatriculare = new JTextField();
		numarInmatriculare.setBackground(UIManager.getColor("Button.background"));
		numarInmatriculare.setFont(new Font("Tahoma", Font.BOLD, 14));
		numarInmatriculare.setBounds(417, 121, 206, 29);
		frmAdaugareAutovehicul.getContentPane().add(numarInmatriculare);
		numarInmatriculare.setColumns(10);
		
		lblCategorie = new JLabel("Categorie:");
		lblCategorie.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCategorie.setBounds(127, 164, 225, 29);
		frmAdaugareAutovehicul.getContentPane().add(lblCategorie);
		
		caracteristica1.setVisible(false);
		caracteristica2.setVisible(false);
		caracteristica3.setVisible(false);
		caracteristica1_text.setVisible(false);
		caracteristica2_text.setVisible(false);
		caracteristica3_text.setVisible(false);
		
		JComboBox caracteristica2_combo = new JComboBox();
		caracteristica2_combo.setMaximumRowCount(3);
		caracteristica2_combo.setModel(new DefaultComboBoxModel(new String[] {"", "DA", "NU"}));
		caracteristica2_combo.setBounds(417, 467, 206, 27);
		frmAdaugareAutovehicul.getContentPane().add(caracteristica2_combo);
		caracteristica2_combo.setVisible(false);
		
		JComboBox categorie = new JComboBox();
		categorie.setModel(new DefaultComboBoxModel(new String[] {"", "A1", "A2", "AM", "A", "B1", "BE", "B", "C1", "C1E", "CE", "C", "D1", "D1E", "DE", "D"}));
		categorie.setFont(new Font("Tahoma", Font.BOLD, 14));
		categorie.setMaximumRowCount(16);
		categorie.setBackground(UIManager.getColor("Button.background"));
		categorie.setBounds(417, 163, 206, 32);
		frmAdaugareAutovehicul.getContentPane().add(categorie);
		categorie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String categorie_aux = (String)categorie.getSelectedItem();
				switch (categorie_aux) {
				
					case "A1":
						
						caracteristica1.setText("Caracteristici roti:");
						caracteristica2.setText("Capacitate rezervor (litri):");
						caracteristica1.setVisible(true);
						caracteristica2.setVisible(true);
						caracteristica1_text.setVisible(true);
						caracteristica2_text.setVisible(true);
						caracteristica3.setVisible(false);
						caracteristica3_text.setVisible(false);
						caracteristica1_text.setText("");
						caracteristica2_text.setText("");
						caracteristica3_text.setText("");
						caracteristica2_combo.setVisible(false);
						break;
						
					case "A2":
						
						caracteristica1.setText("Caracteristici roti:");
						caracteristica2.setText("Numar accidente:");
						caracteristica1.setVisible(true);
						caracteristica2.setVisible(true);
						caracteristica1_text.setVisible(true);
						caracteristica2_text.setVisible(true);
						caracteristica3.setVisible(false);
						caracteristica3_text.setVisible(false);
						caracteristica1_text.setText("");
						caracteristica2_text.setText("");
						caracteristica3_text.setText("");
						caracteristica2_combo.setVisible(false);
						break;
						
					case "AM":
						
						caracteristica1.setText("Caracteristici roti:");
						caracteristica2.setText("Tip ghidon:");
						caracteristica1.setVisible(true);
						caracteristica2.setVisible(true);
						caracteristica1_text.setVisible(true);
						caracteristica2_text.setVisible(true);
						caracteristica3.setVisible(false);
						caracteristica3_text.setVisible(false);
						caracteristica1_text.setText("");
						caracteristica2_text.setText("");
						caracteristica3_text.setText("");
						caracteristica2_combo.setVisible(false);
						break;
						
						case "A":
						
						caracteristica1.setText("Caracteristici roti:");
						caracteristica2.setText("");
						caracteristica1.setVisible(true);
						caracteristica2.setVisible(false);
						caracteristica1_text.setVisible(true);
						caracteristica2_text.setVisible(false);
						caracteristica3.setVisible(false);
						caracteristica3_text.setVisible(false);
						caracteristica1_text.setText("");
						caracteristica2_text.setText("");
						caracteristica3_text.setText("");
						caracteristica2_combo.setVisible(false);
						break;
						
					case "B1":
						
						caracteristica1.setText("Numar valve:");
						caracteristica2.setText("Cai putere:");
						caracteristica3.setText("An fabricatie:");
						caracteristica1.setVisible(true);
						caracteristica2.setVisible(true);
						caracteristica3.setVisible(true);
						caracteristica1_text.setVisible(true);
						caracteristica2_text.setVisible(true);
						caracteristica3_text.setVisible(true);
						caracteristica1_text.setText("");
						caracteristica2_text.setText("");
						caracteristica3_text.setText("");
						caracteristica2_combo.setVisible(false);
						break;
						
					case "BE":
						
						caracteristica1.setText("Numar valve:");
						caracteristica2.setText("Cai putere:");
						caracteristica3.setText("Numar roti remorca:");
						caracteristica1.setVisible(true);
						caracteristica2.setVisible(true);
						caracteristica3.setVisible(true);
						caracteristica1_text.setVisible(true);
						caracteristica2_text.setVisible(true);
						caracteristica3_text.setVisible(true);
						caracteristica1_text.setText("");
						caracteristica2_text.setText("");
						caracteristica3_text.setText("");
						caracteristica2_combo.setVisible(false);
						break;
					
						case "B":
						
						caracteristica1.setText("Numar valve:");
						caracteristica2.setText("Cai putere:");
						caracteristica3.setText("");
						caracteristica1.setVisible(true);
						caracteristica2.setVisible(true);
						caracteristica3.setVisible(false);
						caracteristica1_text.setVisible(true);
						caracteristica2_text.setVisible(true);
						caracteristica3_text.setVisible(false);
						caracteristica1_text.setText("");
						caracteristica2_text.setText("");
						caracteristica3_text.setText("");
						caracteristica2_combo.setVisible(false);
						break;
						
					case "C1":
						
						caracteristica1.setText("Tonaj maxim autorizat:");
						caracteristica2.setText("Dimensiune container (cm cubi):");
						caracteristica1.setVisible(true);
						caracteristica2.setVisible(true);
						caracteristica1_text.setVisible(true);
						caracteristica2_text.setVisible(true);
						caracteristica3.setVisible(false);
						caracteristica3_text.setVisible(false);
						caracteristica1_text.setText("");
						caracteristica2_text.setText("");
						caracteristica3_text.setText("");
						caracteristica2_combo.setVisible(false);
						break;
						
					case "C1E":
						
						caracteristica1.setText("Tonaj maxim autorizat:");
						caracteristica2.setText("Dimensiune remorca:");
						caracteristica1.setVisible(true);
						caracteristica2.setVisible(true);
						caracteristica1_text.setVisible(true);
						caracteristica2_text.setVisible(true);
						caracteristica3.setVisible(false);
						caracteristica3_text.setVisible(false);
						caracteristica1_text.setText("");
						caracteristica2_text.setText("");
						caracteristica3_text.setText("");
						caracteristica2_combo.setVisible(false);
						break;
						
					case "CE":
						
						caracteristica1.setText("Tonaj maxim autorizat:");
						caracteristica2.setText("Tip remorca:");
						caracteristica1.setVisible(true);
						caracteristica2.setVisible(true);
						caracteristica1_text.setVisible(true);
						caracteristica2_text.setVisible(true);
						caracteristica3.setVisible(false);
						caracteristica3_text.setVisible(false);
						caracteristica1_text.setText("");
						caracteristica2_text.setText("");
						caracteristica3_text.setText("");
						caracteristica2_combo.setVisible(false);
						break;
						
						case "C":
						
						caracteristica1.setText("Tonaj maxim autorizat:");
						caracteristica2.setText("");
						caracteristica1.setVisible(true);
						caracteristica2.setVisible(false);
						caracteristica1_text.setVisible(true);
						caracteristica2_text.setVisible(false);
						caracteristica3.setVisible(false);
						caracteristica3_text.setVisible(false);
						caracteristica1_text.setText("");
						caracteristica2_text.setText("");
						caracteristica3_text.setText("");
						caracteristica2_combo.setVisible(false);
						break;
						
					case "D1":
						
						caracteristica1.setText("Locuri maxim autorizate:");
						caracteristica2.setText("Clima:");
						caracteristica1.setVisible(true);
						caracteristica2.setVisible(true);
						caracteristica1_text.setVisible(true);
						caracteristica2_text.setVisible(false);
						caracteristica3.setVisible(false);
						caracteristica3_text.setVisible(false);
						caracteristica1_text.setText("");
						caracteristica2_text.setText("");
						caracteristica3_text.setText("");
						caracteristica2_combo.setVisible(true);
						break;
						
					case "D1E":
						
						caracteristica1.setText("Locuri maxim autorizate:");
						caracteristica2.setText("Etaj:");
						caracteristica1.setVisible(true);
						caracteristica2.setVisible(true);
						caracteristica1_text.setVisible(true);
						caracteristica2_text.setVisible(false);
						caracteristica3.setVisible(false);
						caracteristica3_text.setVisible(false);
						caracteristica1_text.setText("");
						caracteristica2_text.setText("");
						caracteristica3_text.setText("");
						caracteristica2_combo.setVisible(true);
						break;
						
					case "DE":
						
						caracteristica1.setText("Locuri maxim autorizate:");
						caracteristica2.setText("Numar kilometri:");
						caracteristica1.setVisible(true);
						caracteristica2.setVisible(true);
						caracteristica1_text.setVisible(true);
						caracteristica2_text.setVisible(true);
						caracteristica3.setVisible(false);
						caracteristica3_text.setVisible(false);
						caracteristica1_text.setText("");
						caracteristica2_text.setText("");
						caracteristica3_text.setText("");
						caracteristica2_combo.setVisible(false);
						break;
						
						case "D":
						
						caracteristica1.setText("Locuri maxim autorizate:");
						caracteristica2.setText("");
						caracteristica1.setVisible(true);
						caracteristica2.setVisible(false);
						caracteristica1_text.setVisible(true);
						caracteristica2_text.setVisible(false);
						caracteristica3.setVisible(false);
						caracteristica3_text.setVisible(false);
						caracteristica1_text.setText("");
						caracteristica2_text.setText("");
						caracteristica3_text.setText("");
						caracteristica2_combo.setVisible(false);
						break;
				
					case "":
						caracteristica1.setVisible(false);
						caracteristica2.setVisible(false);
						caracteristica3.setVisible(false);
						caracteristica1_text.setVisible(false);
						caracteristica2_text.setVisible(false);
						caracteristica3_text.setVisible(false);
						caracteristica1_text.setText("");
						caracteristica2_text.setText("");
						caracteristica3_text.setText("");
						caracteristica2_combo.setVisible(false);
						break;
						
				}
			}
		});
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMarca.setBounds(127, 205, 206, 29);
		frmAdaugareAutovehicul.getContentPane().add(lblMarca);
		
		marca = new JTextField();
		marca.setBackground(UIManager.getColor("Button.background"));
		marca.setFont(new Font("Tahoma", Font.BOLD, 14));
		marca.setBounds(417, 206, 206, 29);
		frmAdaugareAutovehicul.getContentPane().add(marca);
		marca.setColumns(10);
		
		lblProprietar = new JLabel("Proprietar:");
		lblProprietar.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblProprietar.setBounds(127, 250, 225, 37);
		frmAdaugareAutovehicul.getContentPane().add(lblProprietar);
		
		proprietar = new JTextField();
		proprietar.setFont(new Font("Tahoma", Font.BOLD, 14));
		proprietar.setBackground(UIManager.getColor("Button.background"));
		proprietar.setBounds(417, 255, 206, 29);
		frmAdaugareAutovehicul.getContentPane().add(proprietar);
		proprietar.setColumns(10);
		
		lblMotorizare = new JLabel("Motorizare (cm cubi):");
		lblMotorizare.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMotorizare.setBounds(127, 298, 225, 29);
		frmAdaugareAutovehicul.getContentPane().add(lblMotorizare);
		
		motorizare = new JTextField();
		motorizare.setFont(new Font("Tahoma", Font.BOLD, 14));
		motorizare.setBackground(UIManager.getColor("Button.background"));
		motorizare.setBounds(417, 299, 206, 29);
		frmAdaugareAutovehicul.getContentPane().add(motorizare);
		motorizare.setColumns(10);
		
		lblCombustibil = new JLabel("Combustibil:");
		lblCombustibil.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCombustibil.setBounds(127, 342, 225, 29);
		frmAdaugareAutovehicul.getContentPane().add(lblCombustibil);
		
		combustibil = new JComboBox();
		combustibil.setMaximumRowCount(6);
		combustibil.setFont(new Font("Tahoma", Font.BOLD, 14));
		combustibil.setModel(new DefaultComboBoxModel(new String[] {"", "diesel", "benzina", "GPL", "electric", "hybrid"}));
		combustibil.setBounds(417, 343, 206, 29);
		frmAdaugareAutovehicul.getContentPane().add(combustibil);
		
		lblCuloare = new JLabel("Culoare:");
		lblCuloare.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuloare.setBounds(127, 386, 200, 29);
		frmAdaugareAutovehicul.getContentPane().add(lblCuloare);
		
		culoare = new JTextField();
		culoare.setFont(new Font("Tahoma", Font.BOLD, 14));
		culoare.setBackground(UIManager.getColor("Button.background"));
		culoare.setBounds(417, 387, 206, 29);
		frmAdaugareAutovehicul.getContentPane().add(culoare);
		culoare.setColumns(10);
		
		btnAdaugare = new JButton("ADAUGARE");
		btnAdaugare.setBackground(new Color(100, 149, 237));
		btnAdaugare.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				boolean success=false;
				if ((culoare.getText().isEmpty()) || (numarInmatriculare.getText().isEmpty()) || (marca.getText().isEmpty()) || (proprietar.getText().isEmpty()) || (motorizare.getText().isEmpty()) || ((String)categorie.getSelectedItem()=="") || ((String)combustibil.getSelectedItem()=="") || (caracteristica1_text.getText().isEmpty())){
					JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Completati toate datele!", "Date invalide", JOptionPane.ERROR_MESSAGE);
				} else {
					
					String numarInmatriculareAux = numarInmatriculare.getText();
					String proprietarAux = proprietar.getText();
					String marcaAux = marca.getText();
					String culoareAux = culoare.getText();
					int motorizareAux = Integer.parseInt(motorizare.getText());
					String dataInmatriculareAux = dateFormat.format(date);
					String dataUltimeiReviziiAux = dateFormat.format(date);
					String combustibilAux = (String)combustibil.getSelectedItem();
					String categorieAux = (String)categorie.getSelectedItem();
					
					if ((String)categorie.getSelectedItem()=="C") {
						
						int caracteristica1Int = Integer.parseInt(caracteristica1_text.getText());
						cat_C autovehicul_c = new cat_C(categorieAux, numarInmatriculareAux, marcaAux, dataInmatriculareAux, proprietarAux, dataUltimeiReviziiAux, combustibilAux, culoareAux, motorizareAux, caracteristica1Int);
						try {
							db.cautare(numarInmatriculare.getText());
							if (exista) {
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Autovehiculul cu acest numar de inmatriculare este deja inregistrat in baza de date!", "Date invalide", JOptionPane.ERROR_MESSAGE);
							} else {
								db.adaugareAutovehicul(autovehicul_c);
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Ati inregistrat autovehiculul cu succes!");
								success=true;
							}
						} catch (SQLException ex) {
							ex.printStackTrace();
						} catch (Exception se) {
							se.printStackTrace();
						}
						
					} else {

					if ((String)categorie.getSelectedItem()=="A") {
								
						String caracteristica1String = caracteristica1_text.getText();
						cat_A autovehicul_a = new cat_A(categorieAux, numarInmatriculareAux, marcaAux, dataInmatriculareAux, proprietarAux, dataUltimeiReviziiAux, combustibilAux, culoareAux, motorizareAux, caracteristica1String);
						
						try {
							db.cautare(numarInmatriculare.getText());
							if (exista) {
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Autovehiculul cu acest numar de inmatriculare este deja inregistrat in baza de date!", "Date invalide", JOptionPane.ERROR_MESSAGE);
							} else {
								db.adaugareAutovehicul(autovehicul_a);
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Ati inregistrat autovehiculul cu succes!");
								success=true;
							}
						} catch (SQLException ex) {
							ex.printStackTrace();
						} catch (Exception se) {
							se.printStackTrace();
						}
								
					} else {
								
					if ((String)categorie.getSelectedItem()=="D") {
									
						int caracteristica1Int = Integer.parseInt(caracteristica1_text.getText());
						cat_D autovehicul_d = new cat_D(categorieAux, numarInmatriculareAux, marcaAux, dataInmatriculareAux, proprietarAux, dataUltimeiReviziiAux, combustibilAux, culoareAux, motorizareAux, caracteristica1Int);
						
						try {
							db.cautare(numarInmatriculare.getText());
							if (exista) {
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Autovehiculul cu acest numar de inmatriculare este deja inregistrat in baza de date!", "Date invalide", JOptionPane.ERROR_MESSAGE);
							} else {
								db.adaugareAutovehicul(autovehicul_d);
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Ati inregistrat autovehiculul cu succes!");
								success=true;
							}
						} catch (SQLException ex) {
							ex.printStackTrace();
						} catch (Exception se) {
							se.printStackTrace();
						}
									
					} else {
					
					if (((String)categorie.getSelectedItem()=="D1") || ((String)categorie.getSelectedItem()=="D1E")) {
						caracteristica2_text.setText(" ");
					}
						
					if ((caracteristica2_text.getText().isEmpty()) || (((String)caracteristica2_combo.getSelectedItem()=="") && (((String)categorie.getSelectedItem()=="D1") || ((String)categorie.getSelectedItem()=="D1E")))) {
						JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Completati toate datele!", "Date invalide", JOptionPane.ERROR_MESSAGE);
						
					} else {
						
					if ((String)categorie.getSelectedItem()=="B") {
							
						int caracteristica1Int = Integer.parseInt(caracteristica1_text.getText());
						int caracteristica2Int = Integer.parseInt(caracteristica2_text.getText());
						cat_B autovehicul_b = new cat_B(categorieAux, numarInmatriculareAux, marcaAux, dataInmatriculareAux, proprietarAux, dataUltimeiReviziiAux, combustibilAux, culoareAux, motorizareAux, caracteristica1Int, caracteristica2Int);
							
						try {
							db.cautare(numarInmatriculare.getText());
							if (exista) {
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Autovehiculul cu acest numar de inmatriculare este deja inregistrat in baza de date!", "Date invalide", JOptionPane.ERROR_MESSAGE);
							} else {
								db.adaugareAutovehicul(autovehicul_b);
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Ati inregistrat autovehiculul cu succes!");
								success=true;
							}
						} catch (SQLException ex) {
								ex.printStackTrace();
						} catch (Exception se) {
								se.printStackTrace();
						}
						
					} else {
						
					if ((String)categorie.getSelectedItem()=="D1") {
						
						int caracteristica1Int = Integer.parseInt(caracteristica1_text.getText());
						boolean caracteristica2Boolean = ((String)caracteristica2_combo.getSelectedItem()=="DA")?true:false;
						cat_D1 autovehicul_d1 = new cat_D1(categorieAux, numarInmatriculareAux, marcaAux, dataInmatriculareAux, proprietarAux, dataUltimeiReviziiAux, combustibilAux, culoareAux, motorizareAux, caracteristica1Int, caracteristica2Boolean);
						try {
							db.cautare(numarInmatriculare.getText());
							if (exista) {
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Autovehiculul cu acest numar de inmatriculare este deja inregistrat in baza de date!", "Date invalide", JOptionPane.ERROR_MESSAGE);
							} else {
								db.adaugareAutovehicul(autovehicul_d1);
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Ati inregistrat autovehiculul cu succes!");
								success=true;
							}
						} catch (SQLException ex) {
							ex.printStackTrace();
						} catch (Exception se) {
							se.printStackTrace();
						}
						
					} else {
						
					if ((String)categorie.getSelectedItem()=="D1E") {
						
						int caracteristica1Int = Integer.parseInt(caracteristica1_text.getText());
						boolean caracteristica2Boolean = ((String)caracteristica2_combo.getSelectedItem()=="DA")?true:false;
						cat_D1E autovehicul_d1e = new cat_D1E(categorieAux, numarInmatriculareAux, marcaAux, dataInmatriculareAux, proprietarAux, dataUltimeiReviziiAux, combustibilAux, culoareAux, motorizareAux, caracteristica1Int, caracteristica2Boolean);
						try {
							db.cautare(numarInmatriculare.getText());
							if (exista) {
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Autovehiculul cu acest numar de inmatriculare este deja inregistrat in baza de date!", "Date invalide", JOptionPane.ERROR_MESSAGE);
							} else {
								db.adaugareAutovehicul(autovehicul_d1e);
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Ati inregistrat autovehiculul cu succes!");
								success=true;
							}
						} catch (SQLException ex) {
							ex.printStackTrace();
						} catch (Exception se) {
							se.printStackTrace();
						}
						
					} else {

					if ((String)categorie.getSelectedItem()=="A1") {
						
						String caracteristica1String = caracteristica1_text.getText();
						int caracteristica2Int = Integer.parseInt(caracteristica2_text.getText());
						cat_A1 autovehicul_a1 = new cat_A1(categorieAux, numarInmatriculareAux, marcaAux, dataInmatriculareAux, proprietarAux, dataUltimeiReviziiAux, combustibilAux, culoareAux, motorizareAux, caracteristica1String, caracteristica2Int);
						
						try {
							db.cautare(numarInmatriculare.getText());
							if (exista) {
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Autovehiculul cu acest numar de inmatriculare este deja inregistrat in baza de date!", "Date invalide", JOptionPane.ERROR_MESSAGE);
							} else {
								db.adaugareAutovehicul(autovehicul_a1);
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Ati inregistrat autovehiculul cu succes!");
								success=true;
							}
						} catch (SQLException ex) {
							ex.printStackTrace();
						} catch (Exception se) {
							se.printStackTrace();
						}
						
					} else {

					if ((String)categorie.getSelectedItem()=="A2") {
						
						String caracteristica1String = caracteristica1_text.getText();
						int caracteristica2Int = Integer.parseInt(caracteristica2_text.getText());
						cat_A2 autovehicul_a2 = new cat_A2(categorieAux, numarInmatriculareAux, marcaAux, dataInmatriculareAux, proprietarAux, dataUltimeiReviziiAux, combustibilAux, culoareAux, motorizareAux, caracteristica1String, caracteristica2Int);
						
						try {
							db.cautare(numarInmatriculare.getText());
							if (exista) {
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Autovehiculul cu acest numar de inmatriculare este deja inregistrat in baza de date!", "Date invalide", JOptionPane.ERROR_MESSAGE);
							} else {
								db.adaugareAutovehicul(autovehicul_a2);
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Ati inregistrat autovehiculul cu succes!");
								success=true;
							}
						} catch (SQLException ex) {
							ex.printStackTrace();
						} catch (Exception se) {
							se.printStackTrace();
						}
					
					} else {
						
					if ((String)categorie.getSelectedItem()=="AM") {
						
						String caracteristica1String = caracteristica1_text.getText();
						String caracteristica2String = caracteristica2_text.getText();
						cat_AM autovehicul_am = new cat_AM(categorieAux, numarInmatriculareAux, marcaAux, dataInmatriculareAux, proprietarAux, dataUltimeiReviziiAux, combustibilAux, culoareAux, motorizareAux, caracteristica1String, caracteristica2String);

						try {
							db.cautare(numarInmatriculare.getText());
							if (exista) {
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Autovehiculul cu acest numar de inmatriculare este deja inregistrat in baza de date!", "Date invalide", JOptionPane.ERROR_MESSAGE);
							} else {
								db.adaugareAutovehicul(autovehicul_am);
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Ati inregistrat autovehiculul cu succes!");
								success=true;
							}
						} catch (SQLException ex) {
							ex.printStackTrace();
						} catch (Exception se) {
							se.printStackTrace();
						}
						
					} else {

					if ((String)categorie.getSelectedItem()=="C1") {
						
						int caracteristica1Int = Integer.parseInt(caracteristica1_text.getText());
						float caracteristica2Float = Float.parseFloat(caracteristica2_text.getText());
						cat_C1 autovehicul_c1 = new cat_C1(categorieAux, numarInmatriculareAux, marcaAux, dataInmatriculareAux, proprietarAux, dataUltimeiReviziiAux, combustibilAux, culoareAux, motorizareAux, caracteristica1Int, caracteristica2Float);
						
						try {
							db.cautare(numarInmatriculare.getText());
							if (exista) {
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Autovehiculul cu acest numar de inmatriculare este deja inregistrat in baza de date!", "Date invalide", JOptionPane.ERROR_MESSAGE);
							} else {
								db.adaugareAutovehicul(autovehicul_c1);
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Ati inregistrat autovehiculul cu succes!");
								success=true;
							}
						} catch (SQLException ex) {
							ex.printStackTrace();
						} catch (Exception se) {
							se.printStackTrace();
						}
								
					} else {
					
					if ((String)categorie.getSelectedItem()=="C1E") {
						
						int caracteristica1Int = Integer.parseInt(caracteristica1_text.getText());
						String caracteristica2String = caracteristica2_text.getText();
						cat_C1E autovehicul_c1e = new cat_C1E(categorieAux, numarInmatriculareAux, marcaAux, dataInmatriculareAux, proprietarAux, dataUltimeiReviziiAux, combustibilAux, culoareAux, motorizareAux, caracteristica1Int, caracteristica2String);
						
						try {
							db.cautare(numarInmatriculare.getText());
							if (exista) {
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Autovehiculul cu acest numar de inmatriculare este deja inregistrat in baza de date!", "Date invalide", JOptionPane.ERROR_MESSAGE);
							} else {
								db.adaugareAutovehicul(autovehicul_c1e);
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Ati inregistrat autovehiculul cu succes!");
								success=true;
							}
						} catch (SQLException ex) {
							ex.printStackTrace();
						} catch (Exception se) {
							se.printStackTrace();
						}
						
					} else {
									
					if ((String)categorie.getSelectedItem()=="CE") {
						
						int caracteristica1Int = Integer.parseInt(caracteristica1_text.getText());
						String caracteristica2String = caracteristica2_text.getText();
						cat_CE autovehicul_ce = new cat_CE(categorieAux, numarInmatriculareAux, marcaAux, dataInmatriculareAux, proprietarAux, dataUltimeiReviziiAux, combustibilAux, culoareAux, motorizareAux, caracteristica1Int, caracteristica2String);
						
						try {
							db.cautare(numarInmatriculare.getText());
							if (exista) {
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Autovehiculul cu acest numar de inmatriculare este deja inregistrat in baza de date!", "Date invalide", JOptionPane.ERROR_MESSAGE);
							} else {
								db.adaugareAutovehicul(autovehicul_ce);
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Ati inregistrat autovehiculul cu succes!");
								success=true;
							}
						} catch (SQLException ex) {
							ex.printStackTrace();
						} catch (Exception se) {
							se.printStackTrace();
						}
						
					} else {
										
					if ((String)categorie.getSelectedItem()=="DE") {
						
						int caracteristica1Int = Integer.parseInt(caracteristica1_text.getText());
						float caracteristica2Float = Float.parseFloat(caracteristica2_text.getText());
						cat_DE autovehicul_de = new cat_DE(categorieAux, numarInmatriculareAux, marcaAux, dataInmatriculareAux, proprietarAux, dataUltimeiReviziiAux, combustibilAux, culoareAux, motorizareAux, caracteristica1Int, caracteristica2Float);

						try {
							db.cautare(numarInmatriculare.getText());
							if (exista) {
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Autovehiculul cu acest numar de inmatriculare este deja inregistrat in baza de date!", "Date invalide", JOptionPane.ERROR_MESSAGE);
							} else {
								db.adaugareAutovehicul(autovehicul_de);
								JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Ati inregistrat autovehiculul cu succes!");
								success=true;
							}
						} catch (SQLException ex) {
							ex.printStackTrace();
						} catch (Exception se) {
							se.printStackTrace();
						}
						
					} else {
											
					if (caracteristica3_text.getText().isEmpty()) {
							JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Completati toate datele!", "Date invalide", JOptionPane.ERROR_MESSAGE);
					} else {
						
						int caracteristica1Int = Integer.parseInt(caracteristica1_text.getText());
						int caracteristica2Int = Integer.parseInt(caracteristica2_text.getText());
						int caracteristica3Int = Integer.parseInt(caracteristica3_text.getText());
						
						if ((String)categorie.getSelectedItem()=="B1") {
							
							cat_B1 autovehicul_b1 = new cat_B1(categorieAux, numarInmatriculareAux, marcaAux, dataInmatriculareAux, proprietarAux, dataUltimeiReviziiAux, combustibilAux, culoareAux, motorizareAux, caracteristica1Int, caracteristica2Int, caracteristica3Int);
							
							try {
								db.cautare(numarInmatriculare.getText());
								if (exista) {
									JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Autovehiculul cu acest numar de inmatriculare este deja inregistrat in baza de date!", "Date invalide", JOptionPane.ERROR_MESSAGE);
								} else {
									db.adaugareAutovehicul(autovehicul_b1);
									JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Ati inregistrat autovehiculul cu succes!");
									success=true;
								}
							} catch (SQLException ex) {
								ex.printStackTrace();
							} catch (Exception se) {
								se.printStackTrace();
							}
							
						} else {
							
							cat_BE autovehicul_be = new cat_BE(categorieAux, numarInmatriculareAux, marcaAux, dataInmatriculareAux, proprietarAux, dataUltimeiReviziiAux, combustibilAux, culoareAux, motorizareAux, caracteristica1Int, caracteristica2Int, caracteristica3Int);
							
							try {
								db.cautare(numarInmatriculare.getText());
								if (exista) {
									JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Autovehiculul cu acest numar de inmatriculare este deja inregistrat in baza de date!", "Date invalide", JOptionPane.ERROR_MESSAGE);
								} else {
									db.adaugareAutovehicul(autovehicul_be);
									JOptionPane.showMessageDialog(frmAdaugareAutovehicul, "Ati inregistrat autovehiculul cu succes!");
									success=true;
								}
							} catch (SQLException ex) {
								ex.printStackTrace();
							} catch (Exception se) {
								se.printStackTrace();
							}
						}
		}}}}}}}}}}}}}}}}
		
			if (success) {
				numarInmatriculare.setText("");
				culoare.setText("");
				marca.setText("");
				motorizare.setText("");
				proprietar.setText("");
				caracteristica1.setVisible(false);
				caracteristica2.setVisible(false);
				caracteristica3.setVisible(false);
				caracteristica1_text.setVisible(false);
				caracteristica2_text.setVisible(false);
				caracteristica3_text.setVisible(false);
				caracteristica1_text.setText("");
				caracteristica2_text.setText("");
				caracteristica3_text.setText("");
				combustibil.setSelectedItem("");
				categorie.setSelectedItem("");
				caracteristica2_combo.setSelectedItem("");
				caracteristica2_combo.setVisible(false);
			}
		}});
		
		btnAdaugare.setEnabled(true);
		btnAdaugare.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAdaugare.setBounds(98, 583, 159, 63);
		frmAdaugareAutovehicul.getContentPane().add(btnAdaugare);
		
		btnRefresh = new JButton("REFRESH");
		btnRefresh.setBackground(new Color(144, 238, 144));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numarInmatriculare.setText("");
				culoare.setText("");
				marca.setText("");
				motorizare.setText("");
				proprietar.setText("");
				caracteristica1.setVisible(false);
				caracteristica2.setVisible(false);
				caracteristica3.setVisible(false);
				caracteristica1_text.setVisible(false);
				caracteristica2_text.setVisible(false);
				caracteristica3_text.setVisible(false);
				caracteristica1_text.setText("");
				caracteristica2_text.setText("");
				caracteristica3_text.setText("");
				combustibil.setSelectedItem("");
				categorie.setSelectedItem("");
				caracteristica2_combo.setSelectedItem("");
				caracteristica2_combo.setVisible(false);
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnRefresh.setBounds(295, 583, 159, 63);
		frmAdaugareAutovehicul.getContentPane().add(btnRefresh);
		
		btnInapoi = new JButton("INAPOI");
		btnInapoi.setBackground(new Color(255, 69, 0));
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window2 w2 = new Window2(db);
				w2.Window2(db);
				frmAdaugareAutovehicul.setVisible(false);
			}
		});
		btnInapoi.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnInapoi.setBounds(491, 583, 159, 63);
		frmAdaugareAutovehicul.getContentPane().add(btnInapoi);
		
	}
}
