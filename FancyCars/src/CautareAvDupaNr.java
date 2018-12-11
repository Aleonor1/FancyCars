import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Adrian
 *
 */
public class CautareAvDupaNr extends Window2 {

	private JFrame frmCautareDupaNr;
	private JTextField numarInmatriculare;
	private JButton btnInapoi;
	public static boolean exista;

	/**
	 * Launch the application.
	 */
	public static void CautareAvDupaNr(DBAV db) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CautareAvDupaNr window = new CautareAvDupaNr(db);
					window.frmCautareDupaNr.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CautareAvDupaNr(DBAV db) {
		initialize(db);
	}

	private void initialize(DBAV db) {
		frmCautareDupaNr = new JFrame();
		frmCautareDupaNr.setBounds(100, 100, 800, 800);
		frmCautareDupaNr.getContentPane().setBackground(Color.WHITE);
		frmCautareDupaNr.setTitle("Cautarea autovehicul dupa numarul de inmatriculare");
		frmCautareDupaNr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCautareDupaNr.getContentPane().setLayout(null);

		JLabel lblCautareDupaNr = new JLabel("Cautare autovehicul dupa numarul de inmatriculare");
		lblCautareDupaNr.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblCautareDupaNr.setBounds(32, 36, 720, 54);
		frmCautareDupaNr.getContentPane().add(lblCautareDupaNr);

		JLabel lblIntroducetiNumarulDe = new JLabel(
				"Introduceti numarul de inmatriculare al autovehiculului pe care doriti sa il cautati:");
		lblIntroducetiNumarulDe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIntroducetiNumarulDe.setBounds(32, 125, 720, 25);
		frmCautareDupaNr.getContentPane().add(lblIntroducetiNumarulDe);

		numarInmatriculare = new JTextField();
		numarInmatriculare.setFont(new Font("Tahoma", Font.BOLD, 17));
		numarInmatriculare.setBounds(286, 188, 212, 40);
		frmCautareDupaNr.getContentPane().add(numarInmatriculare);

		JButton btnCautareDupaNr = new JButton("CAUTARE");
		btnCautareDupaNr.setBackground(new Color(144, 238, 144));
		btnCautareDupaNr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numarInmatriculare.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frmCautareDupaNr, "Introduceti numarul de inmatriculare!",
							"Numarul de inmatriculare inexistent", JOptionPane.ERROR_MESSAGE);
				} else
					try {
						if (db.cautare2(numarInmatriculare.getText()) == false) {
							JOptionPane.showMessageDialog(frmCautareDupaNr, "Autovehiculul nu exista!");
						} else {
							ResultSet resultSet = db.cautare3(numarInmatriculare.getText());
							ResultSetMetaData rsmd = resultSet.getMetaData();
							int columnsNumber = rsmd.getColumnCount();
							String autovehicul = "";
							while (resultSet.next()) {
								for (int i = 1; i <= columnsNumber; i++) {
									// if (i > 1) m.out.print(", ");
									if (i > 1)
										autovehicul += "			";
									String columnValue = resultSet.getString(i);
									if (rsmd.getColumnName(i).equals("NRINMATRICULARE")) {
										autovehicul += "NUMAR INMATRICULARE: "+ columnValue + '\n';
									} else if (rsmd.getColumnName(i).equals("DATAINMATRICULARE")) {
										autovehicul += "DATA INMATRICULARII: "+ columnValue + '\n'+ columnValue + '\n';
									} else if (rsmd.getColumnName(i).equals("DATAULTIMEIREVIZII")) {
										autovehicul += "DATA ULTIMEI REVIZII: "+ columnValue + '\n';
									} else if (rsmd.getColumnName(i).equals("TIPCOMBUSTIBIL")) {
										autovehicul += "TIP COMBUSTIBIL: "+ columnValue + '\n';
									} else {
										autovehicul += rsmd.getColumnName(i) + " " + columnValue + '\n';
									}
								}
								JOptionPane.showMessageDialog(frmCautareDupaNr, autovehicul);
							}
						}

					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnCautareDupaNr.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCautareDupaNr.setBounds(312, 265, 159, 63);
		frmCautareDupaNr.getContentPane().add(btnCautareDupaNr);
		// btnInapoi.setBounds(307, 318, 159, 63);

		JButton btnInapoi = new JButton("Inapoi");
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window2 w2 = new Window2(db);
				w2.Window2(db);
				frmCautareDupaNr.setVisible(false);
			}
		});
		btnInapoi.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnInapoi.setBounds(312, 337, 159, 63);
		// btnInapoi.setBounds(307, 318, 148, 40);
		btnInapoi.setBackground(new Color(255, 69, 0));
		frmCautareDupaNr.getContentPane().add(btnInapoi);
	}

}
