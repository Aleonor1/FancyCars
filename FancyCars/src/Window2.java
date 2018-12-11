import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Window2 extends MainnUI {

	private JFrame frmWindow;

	/**
	 * Launch the application.
	 */
	public static void Window2(DBAV db) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window2 window = new Window2(db);
					window.frmWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window2(DBAV db) {
		initialize(db);
	}
	
	public Window2() {
		// implicit constructor
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(DBAV db) {
		frmWindow = new JFrame();
		frmWindow.getContentPane().setBackground(Color.WHITE);
		frmWindow.getContentPane().setLayout(null);
		
		JButton btnAdaugareAutovehicul = new JButton("Adaugare autovehicul");
		btnAdaugareAutovehicul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdaugareAutovehicul avAdd = new AdaugareAutovehicul(db);
				avAdd.AdaugareAutovehicul(db);
				frmWindow.setVisible(false);
			}
		});
		btnAdaugareAutovehicul.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdaugareAutovehicul.setBounds(10, 44, 342, 50);
		frmWindow.getContentPane().add(btnAdaugareAutovehicul);
		
		JButton btnActualizareAutovehicul = new JButton("Actualizare autovehicul");
		btnActualizareAutovehicul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ActualizareAutovehicul avACT = new ActualizareAutovehicul(db);
				avACT.ActualizareAutovehicul(db);
				frmWindow.setVisible(false);
			}
		});
		btnActualizareAutovehicul.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnActualizareAutovehicul.setBounds(432, 44, 342, 50);
		frmWindow.getContentPane().add(btnActualizareAutovehicul);
		
		JButton btnNewButton = new JButton("Actualizare caracteristici extra ale unui AV");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(432, 124, 342, 50);
		frmWindow.getContentPane().add(btnNewButton);
		
		JButton btnRadiereAutovehicul = new JButton("Radiere Autovehicul");
		btnRadiereAutovehicul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RadiereAutovehicul avDel = new RadiereAutovehicul(db);
				avDel.RadiereAutovehicul(db);
				frmWindow.setVisible(false);
			}
		});
		btnRadiereAutovehicul.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRadiereAutovehicul.setBounds(10, 124, 342, 50);
		frmWindow.getContentPane().add(btnRadiereAutovehicul);
		
		JButton btnCautareAutoturismDupa = new JButton("Cautare AV dupa numarul de inmatriculare");
		btnCautareAutoturismDupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CautareAvDupaNr avSearch = new CautareAvDupaNr(db);
				avSearch.CautareAvDupaNr(db);
				frmWindow.setVisible(false);
			}
		});
		btnCautareAutoturismDupa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCautareAutoturismDupa.setBounds(10, 202, 342, 50);
		frmWindow.getContentPane().add(btnCautareAutoturismDupa);
		
		JButton btnCautareAutoturismDupaNume = new JButton("Cautare AV dupa numele proprietarului");
		btnCautareAutoturismDupaNume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CautareDupaProprietar avSearchByName = new CautareDupaProprietar(db);
				avSearchByName.CautareDupaProprietar(db);
				frmWindow.setVisible(false);
			}
		});
		btnCautareAutoturismDupaNume.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCautareAutoturismDupaNume.setBounds(432, 202, 342, 50);
		frmWindow.getContentPane().add(btnCautareAutoturismDupaNume);
		
		JButton btnRevizieAutoturism = new JButton("Revizie autovehicul");
		btnRevizieAutoturism.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RevizieAutovehicul avRevizie = new RevizieAutovehicul(db);
				avRevizie.RevizieAutovehicul(db);
				frmWindow.setVisible(false);
			}
		});
		btnRevizieAutoturism.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRevizieAutoturism.setBounds(10, 280, 342, 50);
		frmWindow.getContentPane().add(btnRevizieAutoturism);
		
		
		JButton btnAfisareaAutoturismelorInmatriculate = new JButton("AV inmatriculate dupa o anumita data");
		btnAfisareaAutoturismelorInmatriculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AutovehiculeDupaData avSearchByDate = new AutovehiculeDupaData(db);
				avSearchByDate.AutovehiculeDupaData(db);
				frmWindow.setVisible(false);
			}
		});
		btnAfisareaAutoturismelorInmatriculate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAfisareaAutoturismelorInmatriculate.setBounds(432, 280, 342, 50);
		frmWindow.getContentPane().add(btnAfisareaAutoturismelorInmatriculate);
		
		JButton btnAfisareaAutoturismelorInainte = new JButton("AV inmatriculate inainte de o anumita data");
		btnAfisareaAutoturismelorInainte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AutovehiculeInainteData avSearchByDate = new AutovehiculeInainteData(db);
				avSearchByDate.AutovehiculeInainteData(db);
				frmWindow.setVisible(false);
			}
		});
		btnAfisareaAutoturismelorInainte.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAfisareaAutoturismelorInainte.setBounds(10, 362, 342, 50);
		frmWindow.getContentPane().add(btnAfisareaAutoturismelorInainte);
		
		JButton btnSortareaAutovehiculelorDupa = new JButton("Sortarea autovehiculelor dupa tip");
		btnSortareaAutovehiculelorDupa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AutovehiculeDupaTip avByTip = new AutovehiculeDupaTip(db);
				avByTip.AutovehiculeDupaTip(db);
				frmWindow.setVisible(false);
			}
			
		});
		btnSortareaAutovehiculelorDupa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSortareaAutovehiculelorDupa.setBounds(432, 365, 342, 50);
		frmWindow.getContentPane().add(btnSortareaAutovehiculelorDupa);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "stopNetworkServer.bat");
				File dir = new File("F:\\Repository for git\\FancyCars\\db-derby-10.14.2.0-bin\\bin");
				pb.directory(dir);
				try {
					Process p = pb.start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(308, 546, 181, 78);
		frmWindow.getContentPane().add(btnExit);
		
		JButton btnStatisticaAutovehiculelorInmatriculate = new JButton("Statistica autovehiculelor inmatriculate in fiecare an");
		btnStatisticaAutovehiculelorInmatriculate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnStatisticaAutovehiculelorInmatriculate.setBounds(195, 445, 400, 50);
		frmWindow.getContentPane().add(btnStatisticaAutovehiculelorInmatriculate);
		frmWindow.setTitle("Main menu");
		frmWindow.setBounds(100, 100, 800, 800);
		frmWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
