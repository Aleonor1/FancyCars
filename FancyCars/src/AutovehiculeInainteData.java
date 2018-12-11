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
public class AutovehiculeInainteData extends Window2 {

	private JFrame AutovehiculeInainteData;
	private JTextField data;
	private JButton btnInapoi;
	public static boolean exista = true;

	/**
	 * Launch the application.
	 */
	public static void AutovehiculeInainteData(DBAV db) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutovehiculeInainteData window = new AutovehiculeInainteData(db);
					window.AutovehiculeInainteData.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AutovehiculeInainteData(DBAV db) {
		initialize(db);
	}

	private void initialize(DBAV db) {
		AutovehiculeInainteData = new JFrame();
		AutovehiculeInainteData.getContentPane().setBackground(Color.WHITE);
		AutovehiculeInainteData.setBounds(100, 100, 800, 800);
		AutovehiculeInainteData.setTitle("Cautarea autovehiculelor inmatriculate inainte de o anumita data");
		AutovehiculeInainteData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AutovehiculeInainteData.getContentPane().setLayout(null);
		
		JLabel lblCautareDupaProprietar = new JLabel("Cautarea autovehiculelor inmatriculate inainte de  o anumita data");
		lblCautareDupaProprietar.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblCautareDupaProprietar.setBounds(111, 35, 561, 54);
		AutovehiculeInainteData.getContentPane().add(lblCautareDupaProprietar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(169, 466, 445, 214);
		AutovehiculeInainteData.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		

		JLabel lblIntroducetiNumarulDe = new JLabel("Introduceti data dupa formatul MM/DD/YYYY:");
		lblIntroducetiNumarulDe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIntroducetiNumarulDe.setBounds(203, 125, 378, 25);
		AutovehiculeInainteData.getContentPane().add(lblIntroducetiNumarulDe);

		data = new JTextField();
		data.setFont(new Font("Tahoma", Font.BOLD, 17));
		data.setBounds(286, 188, 212, 40);
		AutovehiculeInainteData.getContentPane().add(data);

		JButton btnCautareDupaProprietar = new JButton("CAUTARE");
		btnCautareDupaProprietar.setBackground(new Color(144, 238, 144));
		btnCautareDupaProprietar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (data.getText().isEmpty()) {
					JOptionPane.showMessageDialog(AutovehiculeInainteData, "Introduceti data!!","Nu exista autovehicul inmatriculat inainte de aceasta data!", JOptionPane.ERROR_MESSAGE);
				} else if (exista == true) {
					try {
						ResultSet resultSet = db.AutovehiculeInainteData(data.getText());
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
							JOptionPane.showMessageDialog(AutovehiculeInainteData,
									"Nu exista autovehicule inmatriculate inainte de data");
						else {
						
							textArea.setText("Autovehiculele inmatriculate inainte sunt:" + "\n" + autovehicul);
						}
						data.setText("");
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
		AutovehiculeInainteData.getContentPane().add(btnCautareDupaProprietar);
		// btnInapoi.setBounds(307, 318, 159, 63);

		btnInapoi = new JButton("INAPOI");
		btnInapoi.setBackground(new Color(255, 69, 0));
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window2 w2 = new Window2(db);
				w2.Window2(db);
				AutovehiculeInainteData.setVisible(false);
			}
		});
		btnInapoi.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnInapoi.setBounds(312, 362, 159, 63);
		AutovehiculeInainteData.getContentPane().add(btnInapoi);
		
	


	}
}
