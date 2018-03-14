import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow {

	private JFrame frame;
	private static String s;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
		

		
		
		s = "select P.NumeProfesie, A.Prenume, A.Nume " +
				"FROM Profesie P join Angajat A on P.ProfesieID = A.ProfesieID " +
				"group by A.ProfesieID, P.NumeProfesie,A.Prenume,A.Nume, A.Salariu "+
					"having A.Salariu = (select max(Salariu) from Angajat "+
											"where ProfesieID = A.ProfesieID "+
												"group by ProfesieID)";
				
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {	
		
		frame = new JFrame();
		frame.setBounds(0, 0, 1380, 750);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setVisible(true);
		
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblTitle = new JLabel("AGENTIE FOTOMODELE");
		springLayout.putConstraint(SpringLayout.SOUTH, lblTitle, 120, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblTitle, 1352, SpringLayout.WEST, frame.getContentPane());
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("MV Boli", Font.BOLD, 69));
		springLayout.putConstraint(SpringLayout.NORTH, lblTitle, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblTitle, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblTitle);
		
		JButton btnAngajati = new JButton("Angajati");
		springLayout.putConstraint(SpringLayout.WEST, btnAngajati, 57, SpringLayout.WEST, frame.getContentPane());
		btnAngajati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AngajatiTabel();
				frame.dispose();
			}
		});
		btnAngajati.setFont(new Font("Times New Roman", Font.BOLD, 50));
		frame.getContentPane().add(btnAngajati);
		
		JButton btnCompanii = new JButton("Companii");
		springLayout.putConstraint(SpringLayout.EAST, btnAngajati, -171, SpringLayout.WEST, btnCompanii);
		springLayout.putConstraint(SpringLayout.NORTH, btnCompanii, 21, SpringLayout.SOUTH, lblTitle);
		springLayout.putConstraint(SpringLayout.NORTH, btnAngajati, 0, SpringLayout.NORTH, btnCompanii);
		springLayout.putConstraint(SpringLayout.SOUTH, btnAngajati, 0, SpringLayout.SOUTH, btnCompanii);
		springLayout.putConstraint(SpringLayout.WEST, btnCompanii, 778, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCompanii, -49, SpringLayout.EAST, frame.getContentPane());
		btnCompanii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CompaniiTabel();
				frame.dispose();
			}
		});
		btnCompanii.setFont(new Font("Times New Roman", Font.BOLD, 50));
		frame.getContentPane().add(btnCompanii);
		
		JButton btnModel = new JButton("Modele");
		springLayout.putConstraint(SpringLayout.SOUTH, btnCompanii, -11, SpringLayout.NORTH, btnModel);
		springLayout.putConstraint(SpringLayout.NORTH, btnModel, 220, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnModel, -437, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnModel, 419, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnModel, -417, SpringLayout.EAST, frame.getContentPane());
		btnModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ModeleTabel();
				frame.dispose();
			}
		});
		btnModel.setFont(new Font("Times New Roman", Font.BOLD, 55));
		frame.getContentPane().add(btnModel);
		
		JButton btnPremii = new JButton("Premii");
		springLayout.putConstraint(SpringLayout.NORTH, btnPremii, 6, SpringLayout.SOUTH, btnModel);
		springLayout.putConstraint(SpringLayout.WEST, btnPremii, 48, SpringLayout.WEST, frame.getContentPane());
		btnPremii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PremiiTabel();
				frame.dispose();
			}
		});
		btnPremii.setFont(new Font("Times New Roman", Font.BOLD, 50));
		frame.getContentPane().add(btnPremii);
		
		JButton btnEvenimente = new JButton("Evenimente");
		springLayout.putConstraint(SpringLayout.NORTH, btnEvenimente, 6, SpringLayout.SOUTH, btnModel);
		springLayout.putConstraint(SpringLayout.EAST, btnPremii, -330, SpringLayout.WEST, btnEvenimente);
		springLayout.putConstraint(SpringLayout.WEST, btnEvenimente, 850, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnEvenimente, 0, SpringLayout.EAST, btnCompanii);
		btnEvenimente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EvenimenteTabel();
				frame.dispose();
			}
		});
		btnEvenimente.setFont(new Font("Times New Roman", Font.BOLD, 50));
		frame.getContentPane().add(btnEvenimente);
		
		JButton btnFiltre = new JButton("FILTRE");
		springLayout.putConstraint(SpringLayout.WEST, btnFiltre, 0, SpringLayout.WEST, btnPremii);
		springLayout.putConstraint(SpringLayout.EAST, btnFiltre, 0, SpringLayout.EAST, btnAngajati);
		btnFiltre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FiltreWindow();
				frame.dispose();
			}
		});
		btnFiltre.setFont(new Font("Times New Roman", Font.BOLD, 55));
		frame.getContentPane().add(btnFiltre);
		
		JButton btnActualizari = new JButton("ACTUALIZARI");
		springLayout.putConstraint(SpringLayout.NORTH, btnActualizari, 0, SpringLayout.NORTH, btnFiltre);
		springLayout.putConstraint(SpringLayout.SOUTH, btnActualizari, 0, SpringLayout.SOUTH, btnFiltre);
		springLayout.putConstraint(SpringLayout.EAST, btnActualizari, 0, SpringLayout.EAST, btnCompanii);
		springLayout.putConstraint(SpringLayout.WEST, btnActualizari, 0, SpringLayout.WEST, btnCompanii);
		btnActualizari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ActualizariWindow();
				frame.dispose();
			}
		});
		btnActualizari.setFont(new Font("Times New Roman", Font.BOLD, 55));
		frame.getContentPane().add(btnActualizari);
		
		JLabel lblExit = new JLabel("EXIT");
		springLayout.putConstraint(SpringLayout.SOUTH, btnFiltre, -51, SpringLayout.NORTH, lblExit);
		springLayout.putConstraint(SpringLayout.NORTH, lblExit, -57, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblExit, 509, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblExit, -25, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblExit, -490, SpringLayout.EAST, frame.getContentPane());
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
			}
		});
		lblExit.setFont(new Font("Showcard Gothic", Font.ITALIC, 40));
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblExit);
		
		JButton button = new JButton("STATISTICI");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new StatisticiWindow();
				frame.dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnFiltre, 26, SpringLayout.SOUTH, button);
		springLayout.putConstraint(SpringLayout.SOUTH, button, -207, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnPremii, -52, SpringLayout.NORTH, button);
		springLayout.putConstraint(SpringLayout.SOUTH, btnEvenimente, -52, SpringLayout.NORTH, button);
		springLayout.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, btnPremii);
		springLayout.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, btnCompanii);
		button.setFont(new Font("Times New Roman", Font.BOLD, 55));
		frame.getContentPane().add(button);
		frame.setVisible(true);	
	
	}
}
