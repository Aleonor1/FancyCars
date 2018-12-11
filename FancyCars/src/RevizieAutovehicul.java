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
public class RevizieAutovehicul extends Window2 {

	private JFrame frmRevizieAutovehicul;
	private JTextField numarInmatriculare;
	private JButton btnAdaugare;
	private JButton btnInapoi;
	public static boolean exista;
	boolean success = false;

	/**
	 * Launch the application.
	 */
	public static void RevizieAutovehicul(DBAV db) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RevizieAutovehicul window = new RevizieAutovehicul(db);
					window.frmRevizieAutovehicul.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RevizieAutovehicul(DBAV db) {
		initialize(db);
	}

	private void initialize(DBAV db) {
		frmRevizieAutovehicul = new JFrame();
		frmRevizieAutovehicul.getContentPane().setBackground(Color.WHITE);
		frmRevizieAutovehicul.setBounds(100, 100, 800, 800);
		frmRevizieAutovehicul.setTitle("Actualizare autovehicul");
		frmRevizieAutovehicul.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRevizieAutovehicul.getContentPane().setLayout(null);

		JLabel lblRevizieAutovehicul = new JLabel("Actualizare autovehicul");
		lblRevizieAutovehicul.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblRevizieAutovehicul.setBounds(235, 36, 337, 54);
		frmRevizieAutovehicul.getContentPane().add(lblRevizieAutovehicul);

		JLabel lblIntroducetiNumarulDe = new JLabel(
				"Introduceti numarul de inmatriculare al autovehiculului pe care doriti sa il actualizati:");
		lblIntroducetiNumarulDe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIntroducetiNumarulDe.setBounds(37, 125, 720, 25);
		frmRevizieAutovehicul.getContentPane().add(lblIntroducetiNumarulDe);

		numarInmatriculare = new JTextField();
		numarInmatriculare.setFont(new Font("Tahoma", Font.BOLD, 17));
		numarInmatriculare.setBounds(281, 188, 212, 40);
		frmRevizieAutovehicul.getContentPane().add(numarInmatriculare);
		JButton btnRadiere = new JButton("REVIZIE");
		btnRadiere.setBackground(new Color(144, 238, 144));
		btnRadiere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numarInmatriculare.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frmRevizieAutovehicul, "Introduceti numarul de inmatriculare!",
							"Numarul de inmatriculare inexistent", JOptionPane.ERROR_MESSAGE);
				}
				try {
					if (db.cautare2(numarInmatriculare.getText())==false)
					{
						JOptionPane.showMessageDialog(frmRevizieAutovehicul, "Autovehiculul nu exista", "Eroare", JOptionPane.ERROR_MESSAGE);
					}
					 else {
						String nrInmatriculareAux = numarInmatriculare.getText();
						try {
							db.UpdateDate(nrInmatriculareAux);
							db.afisare();
							success=true;
							JOptionPane.showMessageDialog(frmRevizieAutovehicul, "Ati radiat cu succes autovehiculul!");
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
		frmRevizieAutovehicul.getContentPane().add(btnRadiere);
		// btnInapoi.setBounds(307, 318, 159, 63);

		JButton btnInapoi = new JButton("Inapoi");
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window2 w2 = new Window2(db);
				w2.Window2(db);
				frmRevizieAutovehicul.setVisible(false);
			}
		});
		btnInapoi.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnInapoi.setBounds(307, 337, 159, 63);
		// btnInapoi.setBounds(307, 318, 148, 40);
		btnInapoi.setBackground(new Color(255, 69, 0));
		frmRevizieAutovehicul.getContentPane().add(btnInapoi);
	}

}
