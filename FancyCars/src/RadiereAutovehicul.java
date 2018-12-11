import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class RadiereAutovehicul extends Window2 {

	private JFrame frmRadiereAutovehicul;
	private JTextField numarInmatriculare;
	private JButton btnAdaugare;
	private JButton btnInapoi;
	public static boolean exista;
	boolean success = false;

	/**
	 * Launch the application.
	 */
	public static void RadiereAutovehicul(DBAV db) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadiereAutovehicul window = new RadiereAutovehicul(db);
					window.frmRadiereAutovehicul.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RadiereAutovehicul(DBAV db) {
		initialize(db);
	}

	private void initialize(DBAV db) {
		frmRadiereAutovehicul = new JFrame();
		frmRadiereAutovehicul.getContentPane().setBackground(Color.WHITE);
		frmRadiereAutovehicul.setBounds(100, 100, 800, 800);
		frmRadiereAutovehicul.setTitle("Actualizare autovehicul");
		frmRadiereAutovehicul.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRadiereAutovehicul.getContentPane().setLayout(null);

		JLabel lblRadiereAutovehicul = new JLabel("Actualizare autovehicul");
		lblRadiereAutovehicul.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblRadiereAutovehicul.setBounds(235, 36, 337, 54);
		frmRadiereAutovehicul.getContentPane().add(lblRadiereAutovehicul);

		JLabel lblIntroducetiNumarulDe = new JLabel(
				"Introduceti numarul de inmatriculare al autovehiculului pe care doriti sa il radiati:");
		lblIntroducetiNumarulDe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIntroducetiNumarulDe.setBounds(37, 125, 720, 25);
		frmRadiereAutovehicul.getContentPane().add(lblIntroducetiNumarulDe);

		numarInmatriculare = new JTextField();
		numarInmatriculare.setFont(new Font("Tahoma", Font.BOLD, 17));
		numarInmatriculare.setBounds(281, 188, 212, 40);
		frmRadiereAutovehicul.getContentPane().add(numarInmatriculare);

		JButton btnRadiere = new JButton("RADIERE");
		btnRadiere.setBackground(new Color(144, 238, 144));
		btnRadiere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numarInmatriculare.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frmRadiereAutovehicul, "Introduceti numarul de inmatriculare!",
							"Numarul de inmatriculare inexistent", JOptionPane.ERROR_MESSAGE);
				}
				try {
					if (db.cautare2(numarInmatriculare.getText())==false)
					{
						JOptionPane.showMessageDialog(frmRadiereAutovehicul, "Autovehiculul nu exista", "Eroare", JOptionPane.ERROR_MESSAGE);
					}
					 else {
						String nrInmatriculareAux = numarInmatriculare.getText();
						try {
							db.deleteRow(nrInmatriculareAux);
							success=true;
							JOptionPane.showMessageDialog(frmRadiereAutovehicul, "Ati radiat cu succes autovehiculul!");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				numarInmatriculare.setText("");}
		});
		btnRadiere.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRadiere.setBounds(307, 265, 159, 63);
		frmRadiereAutovehicul.getContentPane().add(btnRadiere);
		// btnInapoi.setBounds(307, 318, 159, 63);

		JButton btnInapoi = new JButton("Inapoi");
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window2 w2 = new Window2(db);
				w2.Window2(db);
				frmRadiereAutovehicul.setVisible(false);
			}
		});
		btnInapoi.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnInapoi.setBounds(307, 337, 159, 63);
		// btnInapoi.setBounds(307, 318, 148, 40);
		btnInapoi.setBackground(new Color(255, 69, 0));
		frmRadiereAutovehicul.getContentPane().add(btnInapoi);
	}

}
