import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class MainnUI {

	private JFrame frmMainclass;

	/**
	 * Launch the application.
	 */
	public static <E> void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainnUI window1 = new MainnUI();
					window1.frmMainclass.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainnUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainclass = new JFrame();
		frmMainclass.setTitle("FancyCars");
		frmMainclass.setBounds(100, 100, 800, 800);
		frmMainclass.getContentPane().setBackground(Color.WHITE);
		frmMainclass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnNewButton = new JButton("Start session");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(294, 408, 208, 82);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final DBAV t1 = new DBAV();
				try {
					ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "startNetworkServer.bat");
					File dir = new File("F:\\Repository for git\\FancyCars\\db-derby-10.14.2.0-bin\\bin");
					pb.directory(dir);
					Process p = pb.start();
					TimeUnit.SECONDS.sleep(1);
					t1.creareBD();
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Date date = new Date();
					Window2 w2 = new Window2(t1);
					w2.Window2(t1);
					frmMainclass.setVisible(false);
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(frmMainclass, "Connection failed!", "Connection Failed!",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				} catch (Exception se) {
					se.printStackTrace();
				}
			}
		});
		frmMainclass.getContentPane().setLayout(null);
		frmMainclass.getContentPane().add(btnNewButton);

		JLabel lblFancycars = new JLabel("FancyCars");
		lblFancycars.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblFancycars.setBounds(323, 37, 145, 63);
		frmMainclass.getContentPane().add(lblFancycars);

		JLabel lblBy = new JLabel("by");
		lblBy.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBy.setBounds(372, 114, 41, 45);
		frmMainclass.getContentPane().add(lblBy);

		JLabel lblSimofiRobert = new JLabel("Simofi Robert & Nyikita Adrian Aleonor");
		lblSimofiRobert.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSimofiRobert.setBounds(186, 169, 444, 42);
		frmMainclass.getContentPane().add(lblSimofiRobert);
	}
}
