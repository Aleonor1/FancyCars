import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 */

/**
 * @author Adrian
 *
 */
public class ActualizareAutovehicul extends Window2 {
	
	private JFrame frame;
	private JTextField numarInmatriculare;

	/**
	 * Launch the application.
	 */
	public static void ActualizareAutovehicul(DBAV db) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActualizareAutovehicul window = new ActualizareAutovehicul(db);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ActualizareAutovehicul(DBAV db) {
		initialize(db);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(DBAV db) {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 800);
		frame.setTitle("Actualizare autovehicul");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblActualizareAutovehicul = new JLabel("Actualizare autovehicul");
		lblActualizareAutovehicul.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblActualizareAutovehicul.setBounds(235, 36, 337, 54);
		frame.getContentPane().add(lblActualizareAutovehicul);
		
		JLabel lblIntroducetiNumarulDe = new JLabel("Introduceti numarul de inmatriculare al autovehiculului pe care doriti sa il modificati:");
		lblIntroducetiNumarulDe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIntroducetiNumarulDe.setBounds(37, 125, 720, 25);
		frame.getContentPane().add(lblIntroducetiNumarulDe);
		
		numarInmatriculare = new JTextField();
		numarInmatriculare.setFont(new Font("Tahoma", Font.BOLD, 17));
		numarInmatriculare.setBounds(281, 188, 212, 40);
		frame.getContentPane().add(numarInmatriculare);
		numarInmatriculare.setColumns(10);
		
		JButton btnCauta = new JButton("CAUTA");
		btnCauta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numarInmatriculare.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Introduceti numarul de inmatriculare!", "Numarul de inmatriculare inexistent", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCauta.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCauta.setBounds(307, 257, 148, 40);
		frame.getContentPane().add(btnCauta);
		
		JButton btnInapoi = new JButton("Inapoi");
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window2 w2 = new Window2(db);
				w2.Window2(db);
				frame.setVisible(false);
			}
		});
		btnInapoi.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnInapoi.setBounds(307, 318, 148, 40);
		frame.getContentPane().add(btnInapoi);
	}
}