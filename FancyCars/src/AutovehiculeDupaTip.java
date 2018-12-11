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
public class AutovehiculeDupaTip extends Window2 {

	private JFrame AutovehiculeDupaTip;
	private JTextField data;
	private JButton btnInapoi;
	public static boolean exista = true;

	/**
	 * Launch the application.
	 */
	public static void AutovehiculeDupaTip(DBAV db) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutovehiculeDupaTip window = new AutovehiculeDupaTip(db);
					window.AutovehiculeDupaTip.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AutovehiculeDupaTip(DBAV db) {
		initialize(db);
	}

	private void initialize(DBAV db) {
		AutovehiculeDupaTip = new JFrame();
		AutovehiculeDupaTip.getContentPane().setBackground(Color.WHITE);
		AutovehiculeDupaTip.setBounds(100, 100, 800, 800);
		AutovehiculeDupaTip.setTitle("Afisarea autovehiculelor dupa tip");
		AutovehiculeDupaTip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AutovehiculeDupaTip.getContentPane().setLayout(null);

		JLabel lblAutovehiculeDupaTip = new JLabel("Afisarea autovehiculelor dupa tip");
		lblAutovehiculeDupaTip.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblAutovehiculeDupaTip.setBounds(165, 35, 454, 54);
		AutovehiculeDupaTip.getContentPane().add(lblAutovehiculeDupaTip);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(169, 466, 445, 214);
		AutovehiculeDupaTip.getContentPane().add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JButton btnAutovehiculeDupaTip = new JButton("AFISARE");
		btnAutovehiculeDupaTip.setBackground(new Color(144, 238, 144));
		btnAutovehiculeDupaTip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
					try {
						ResultSet resultSet = db.AutovehiculeDupaTip();
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
								} else {
									autovehicul += rsmd.getColumnName(i) + ":" + columnValue + '\n';
									autovehicul2 += rsmd.getColumnName(i) + " " + columnValue;
								}
							}
						}
						if (autovehicul2 == "")
							JOptionPane.showMessageDialog(AutovehiculeDupaTip,
									"Nu exista autovehicule inmatriculate inainte de data");
						else {
						//	System.out.println(autovehicul);
							textArea.setText("Autovehiculele ordonate dupa tip sunt:" + "\n" + autovehicul);
						}
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
		btnAutovehiculeDupaTip.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAutovehiculeDupaTip.setBounds(312, 265, 159, 63);
		AutovehiculeDupaTip.getContentPane().add(btnAutovehiculeDupaTip);
		// btnInapoi.setBounds(307, 318, 159, 63);

		btnInapoi = new JButton("INAPOI");
		btnInapoi.setBackground(new Color(255, 69, 0));
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window2 w2 = new Window2(db);
				w2.Window2(db);
				AutovehiculeDupaTip.setVisible(false);
			}
		});
		btnInapoi.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnInapoi.setBounds(312, 362, 159, 63);
		AutovehiculeDupaTip.getContentPane().add(btnInapoi);

	}
}
