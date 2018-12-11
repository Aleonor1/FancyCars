import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import javax.swing.ScrollPaneConstants;

/**
 * 
 */

/**
 * @author Adrian
 *
 */
public class CautareDupaProprietar extends Window2 {

	private JFrame frmCautareDupaProprietar;
	private JTextField numeProprietar;
	private JButton btnInapoi;
	public static boolean exista = true;

	/**
	 * Launch the application.
	 */
	public static void CautareDupaProprietar(DBAV db) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CautareDupaProprietar window = new CautareDupaProprietar(db);
					window.frmCautareDupaProprietar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CautareDupaProprietar(DBAV db) {
		initialize(db);
	}

	private void initialize(DBAV db) {
		frmCautareDupaProprietar = new JFrame();
		frmCautareDupaProprietar.getContentPane().setBackground(Color.WHITE);
		frmCautareDupaProprietar.setBounds(100, 100, 800, 800);
		frmCautareDupaProprietar.setTitle("Cautarea autovehiculelor unui proprietar");
		frmCautareDupaProprietar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCautareDupaProprietar.getContentPane().setLayout(null);
		
		JLabel lblCautareDupaProprietar = new JLabel("Cautarea autovehiculelor unui proprietar");
		lblCautareDupaProprietar.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblCautareDupaProprietar.setBounds(111, 35, 561, 54);
		frmCautareDupaProprietar.getContentPane().add(lblCautareDupaProprietar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(169, 466, 445, 214);
		frmCautareDupaProprietar.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		

		JLabel lblIntroducetiNumarulDe = new JLabel(
				"Introduceti numele persoanei ale carei masini vreti sa le vizualizati:");
		lblIntroducetiNumarulDe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIntroducetiNumarulDe.setBounds(111, 125, 561, 25);
		frmCautareDupaProprietar.getContentPane().add(lblIntroducetiNumarulDe);

		numeProprietar = new JTextField();
		numeProprietar.setFont(new Font("Tahoma", Font.BOLD, 17));
		numeProprietar.setBounds(286, 188, 212, 40);
		frmCautareDupaProprietar.getContentPane().add(numeProprietar);

		JButton btnCautareDupaProprietar = new JButton("CAUTARE");
		btnCautareDupaProprietar.setBackground(new Color(144, 238, 144));
		btnCautareDupaProprietar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numeProprietar.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frmCautareDupaProprietar, "Introduceti numele persoanei!",
							"Persoana nu detine nici un autovehicul!", JOptionPane.ERROR_MESSAGE);
				} else if (exista == true) {
					try {
						ResultSet resultSet = db.DupaNume(numeProprietar.getText());
						ResultSetMetaData rsmd = resultSet.getMetaData();
						int columnsNumber = rsmd.getColumnCount();
						String autovehicul = "", autovehicul2 = "";
						while (resultSet.next()) {
							for (int i = 1; i <= columnsNumber; i++) {
								if (i > 1)
									autovehicul += "";
								String columnValue = resultSet.getString(i);
								if (rsmd.getColumnName(i).equals("NRINMATRICULARE")) {
									autovehicul += "NUMAR INMATRICULARE" + columnValue + '\n';
									autovehicul2 += "NUMAR INMATRICULARE" + columnValue;
								} else if (rsmd.getColumnName(i).equals("DATAINMATRICULARE")) {
									autovehicul += "DATA INMATRICULARII" + columnValue + '\n';
									autovehicul2 += "DATA INMATRICULARII" + columnValue;
								} else if (rsmd.getColumnName(i).equals("DATAULTIMEIREVIZII")) {
									autovehicul += "DATA ULTIMEI REVIZII" + columnValue + '\n';
									autovehicul2 += "DATA ULTIMEI REVIZII" + columnValue;
								} else if (rsmd.getColumnName(i).equals("TIPCOMBUSTIBIL")) {
									autovehicul += "TIP COMBUSTIBIL" + columnValue + '\n';
									autovehicul2 += "TIP COMBUSTIBIL" + columnValue;
								} else if (rsmd.getColumnName(i).equals("CARACTERISTICA3")) {
									autovehicul += '\n';
								} else {
									autovehicul += rsmd.getColumnName(i) + ":" + columnValue + '\n';
									autovehicul2 += rsmd.getColumnName(i) + " " + columnValue;
								}
							}
						}
						if (autovehicul2 == "")
							JOptionPane.showMessageDialog(frmCautareDupaProprietar,
									"Persoana nu detine nici un autovehicul!");
						else {
							System.out.println(autovehicul);
							textArea.setText("Autovehiculele proprietarului sunt urmatoarele: " + "\n" + autovehicul);
						}
						numeProprietar.setText("");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnCautareDupaProprietar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCautareDupaProprietar.setBounds(312, 265, 159, 63);
		frmCautareDupaProprietar.getContentPane().add(btnCautareDupaProprietar);
		// btnInapoi.setBounds(307, 318, 159, 63);

		JButton btnInapoi_1 = new JButton("Inapoi");
		btnInapoi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window2 w2 = new Window2(db);
				w2.Window2(db);
				frmCautareDupaProprietar.setVisible(false);
			}
		});
		btnInapoi_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnInapoi_1.setBounds(312, 337, 159, 63);
		// btnInapoi.setBounds(307, 318, 148, 40);
		btnInapoi_1.setBackground(new Color(255, 69, 0));
		frmCautareDupaProprietar.getContentPane().add(btnInapoi_1);
		
	


	}
}
