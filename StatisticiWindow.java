import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class StatisticiWindow extends SQLDatabaseConnection{

	private JFrame frame;
	private JTable table,table2,table3,table4,table5,table6,table7,table8,table9,table10;
	private JTextField textField,textField3,textField4,textField5,textField8,textField88,textField11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatisticiWindow window = new StatisticiWindow();
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
	public StatisticiWindow() {
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
		CardLayout cd = new CardLayout(0,0);
		frame.getContentPane().setLayout(cd);
		
		
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_450062785093719");
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 472, 1250, 195);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("<html>Companiile ordonate alfabetic la care lucreaza cel putin un model care a castigat un premiu si care este fondata dupa un anumit an !</html>");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 21));
		lblNewLabel.setBounds(74, 145, 1236, 79);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(74, 282, 309, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton nextBut = new JButton("NEXT");
		nextBut.setFont(new Font("Tahoma", Font.BOLD, 12));
		nextBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.next(frame.getContentPane());
			}
		});
		nextBut.setBounds(1147, 46, 163, 23);
		panel.add(nextBut);
		
		JButton menuBut = new JButton("Inapoi la MENIU");
		menuBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainWindow();
				frame.dispose();
			}
		});
		menuBut.setFont(new Font("Sylfaen", Font.BOLD, 15));
		menuBut.setBounds(974, 80, 336, 23);
		panel.add(menuBut);
		
		JButton prevBut = new JButton("BACK");
		prevBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.previous(frame.getContentPane());
			}
		});
		prevBut.setFont(new Font("Tahoma", Font.BOLD, 12));
		prevBut.setBounds(974, 46, 163, 23);
		panel.add(prevBut);
		
		JLabel lblTastatiAnulMinim = new JLabel("Tastati anul minim de fondare al companiei:");
		lblTastatiAnulMinim.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblTastatiAnulMinim.setBounds(74, 258, 1236, 23);
		panel.add(lblTastatiAnulMinim);
		
		JLabel lblNewLabel_1 = new JLabel("Nu exista informatii de afisat !!!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(974, 447, 336, 14);
		lblNewLabel_1.setVisible(false);
		panel.add(lblNewLabel_1);
		
		
		JButton findBut = new JButton("AFISEAZA REZULTATE");
		findBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String aux1 = textField.getText().toString();
				
				String s1 = "select C.NumeCompanie, C.AnulFondarii, C.CifraAfaceri, C.Tara " +
								"from Companie C join Model M on C.CompanieID = M.ModelID " +
									"where C.AnulFondarii > "+ aux1 + " AND M.ModelID in (select ModelID from Premiu) " +
										"order by C.NumeCompanie";
				
				ResultSet rs1 = Query(s1);
				
				try{
				table.setModel(DbUtils.resultSetToTableModel(rs1));
				}catch(Exception e){
					JOptionPane.showMessageDialog(frame, "Va rugam respectati formatul impus !!!"); 
				}
				
				if(table.getModel().getRowCount() == 0) 		lblNewLabel_1.setVisible(true);
				else lblNewLabel_1.setVisible(false);
				
			}
		});
		findBut.setFont(new Font("Sylfaen", Font.BOLD, 15));
		findBut.setBounds(974, 277, 336, 39);
		panel.add(findBut);
		
		JLabel lblStatistici = new JLabel("STATISTICI");
		lblStatistici.setFont(new Font("Sylfaen", Font.BOLD, 35));
		lblStatistici.setBounds(74, 51, 735, 52);
		panel.add(lblStatistici);
		
		JLabel lblNr = new JLabel("NR. 1");
		lblNr.setFont(new Font("Sylfaen", Font.ITALIC, 30));
		lblNr.setBounds(74, 114, 735, 39);
		panel.add(lblNr);
		
		JLabel lblVaRugam = new JLabel("***   Va rugam introduceti o valoare numerica");
		lblVaRugam.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVaRugam.setBounds(74, 323, 735, 14);
		panel.add(lblVaRugam);
		
		JLabel lblNerespectareaFormatului = new JLabel("***   Nerespectarea formatului va conduce la rezultate nule");
		lblNerespectareaFormatului.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNerespectareaFormatului.setBounds(74, 348, 735, 14);
		panel.add(lblNerespectareaFormatului);
		
		
		
		
		JPanel panel1 = new JPanel();
		frame.getContentPane().add(panel1, "name_450067771735809");
		panel1.setLayout(null);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(60, 472, 1250, 195);
		panel1.add(scrollPane2);
		
		table2 = new JTable();
		scrollPane2.setViewportView(table2);
		
		JLabel lblNewLabel2 = new JLabel("<html>Numele si prenumele modelelor care au cetatenia aferenta tarii in care activeaza firma la care lucreaza impreuna cu numele si prenumele angajatiilor care s-au nascut in tara in care activeaza una din firmele pentru care lucreaza !</html>");
		lblNewLabel2.setFont(new Font("Sitka Text", Font.BOLD, 21));
		lblNewLabel2.setBounds(74, 145, 1236, 79);
		panel1.add(lblNewLabel2);
		
		JButton nextBut2 = new JButton("NEXT");
		nextBut2.setFont(new Font("Tahoma", Font.BOLD, 12));
		nextBut2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.next(frame.getContentPane());
			}
		});
		nextBut2.setBounds(1147, 46, 163, 23);
		panel1.add(nextBut2);
		
		JButton menuBut2 = new JButton("Inapoi la MENIU");
		menuBut2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainWindow();
				frame.dispose();
			}
		});
		menuBut2.setFont(new Font("Sylfaen", Font.BOLD, 15));
		menuBut2.setBounds(974, 80, 336, 23);
		panel1.add(menuBut2);
		
		JButton prevBut2 = new JButton("BACK");
		prevBut2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.previous(frame.getContentPane());
			}
		});
		prevBut2.setFont(new Font("Tahoma", Font.BOLD, 12));
		prevBut2.setBounds(974, 46, 163, 23);
		panel1.add(prevBut2);
		
		JButton findBut2 = new JButton("AFISEAZA REZULTATE");
		findBut2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String s2 = 
						"select M.Nume, M.Prenume from Model M join Companie C on M.CompanieID = C.CompanieID "+
								"where C.Tara = M.Cetatenie "+

						"union "+

						"select distinct A.Nume, A.Prenume from Angajat A join Lucreaza L on A.AngajatID = L.AngajatID "+
																			"join Companie C on L.CompanieID = C.CompanieID "+
							"where A.LocNastere = C.Tara ";
						
		
		ResultSet rs2 = Query(s2);
		table2.setModel(DbUtils.resultSetToTableModel(rs2));
				
			}
		});
		findBut2.setFont(new Font("Sylfaen", Font.BOLD, 15));
		findBut2.setBounds(974, 277, 336, 39);
		panel1.add(findBut2);
		
		JLabel lblStatistici2 = new JLabel("STATISTICI");
		lblStatistici2.setFont(new Font("Sylfaen", Font.BOLD, 35));
		lblStatistici2.setBounds(74, 51, 735, 52);
		panel1.add(lblStatistici2);
		
		JLabel lblNr2 = new JLabel("NR. 2");
		lblNr2.setFont(new Font("Sylfaen", Font.ITALIC, 30));
		lblNr2.setBounds(74, 114, 735, 39);
		panel1.add(lblNr2);
		
		
		
		
		
		
		
		JPanel panel2 = new JPanel();
		frame.getContentPane().add(panel2, "name_450073918706628");
		panel2.setLayout(null);
		frame.setVisible(true);
		
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(60, 472, 1250, 195);
		panel2.add(scrollPane3);
		
		table3 = new JTable();
		scrollPane3.setViewportView(table3);
		
		JLabel lblNewLabel3 = new JLabel("<html>Numele, prenumele si salariul acelor angajati care sunt nascuti in aceasi tara ca si un model ce lucreaza la una din companiile la care lucreaza si ei, ordonati descrescator dupa salariu !</html>");
		lblNewLabel3.setFont(new Font("Sitka Text", Font.BOLD, 21));
		lblNewLabel3.setBounds(74, 145, 1236, 79);
		panel2.add(lblNewLabel3);
		
		textField3 = new JTextField();
		textField3.setBounds(74, 282, 309, 29);
		panel2.add(textField3);
		textField3.setColumns(10);
		
		JButton nextBut3 = new JButton("NEXT");
		nextBut3.setFont(new Font("Tahoma", Font.BOLD, 12));
		nextBut3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.next(frame.getContentPane());
			}
		});
		nextBut3.setBounds(1147, 46, 163, 23);
		panel2.add(nextBut3);
		
		JButton menuBut3 = new JButton("Inapoi la MENIU");
		menuBut3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainWindow();
				frame.dispose();
			}
		});
		menuBut3.setFont(new Font("Sylfaen", Font.BOLD, 15));
		menuBut3.setBounds(974, 80, 336, 23);
		panel2.add(menuBut3);
		
		JButton prevBut3 = new JButton("BACK");
		prevBut3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.previous(frame.getContentPane());
			}
		});
		prevBut3.setFont(new Font("Tahoma", Font.BOLD, 12));
		prevBut3.setBounds(974, 46, 163, 23);
		panel2.add(prevBut3);
		
		JLabel lblTastatiAnulMinim3 = new JLabel("Tastati tara de provenienta:");
		lblTastatiAnulMinim3.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblTastatiAnulMinim3.setBounds(74, 258, 1236, 23);
		panel2.add(lblTastatiAnulMinim3);
		
		
		JLabel label_2 = new JLabel("Nu exista informatii de afisat !!!");
		label_2.setHorizontalAlignment(SwingConstants.TRAILING);
		label_2.setBounds(974, 447, 336, 14);
		label_2.setVisible(false);
		panel2.add(label_2);
		
		
		JButton findBut3 = new JButton("AFISEAZA REZULTATE");
		findBut3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String aux3 = textField3.getText().toString();
				
				String s3 = "select DISTINCT A.Nume, A.Prenume, A.Salariu "+
								"from Angajat A join Lucreaza L on A.AngajatID = L.AngajatID, Model M "+
									"where L.CompanieID = M.CompanieID AND A.LocNastere = M.LocNastere AND A.LocNastere LIKE '" + aux3 +
										"' order by Salariu DESC";
				
				ResultSet rs3 = Query(s3);
				table3.setModel(DbUtils.resultSetToTableModel(rs3));
				
				if(table3.getModel().getRowCount() == 0) 		label_2.setVisible(true);
				else label_2.setVisible(false);
				
			}
		});
		findBut3.setFont(new Font("Sylfaen", Font.BOLD, 15));
		findBut3.setBounds(974, 277, 336, 39);
		panel2.add(findBut3);
		
		JLabel lblStatistici3 = new JLabel("STATISTICI");
		lblStatistici3.setFont(new Font("Sylfaen", Font.BOLD, 35));
		lblStatistici3.setBounds(74, 51, 735, 52);
		panel2.add(lblStatistici3);
		
		JLabel lblNr3 = new JLabel("NR. 3");
		lblNr3.setFont(new Font("Sylfaen", Font.ITALIC, 30));
		lblNr3.setBounds(74, 114, 735, 39);
		panel2.add(lblNr3);
		
		JLabel label_9 = new JLabel("***   Nerespectarea formatului va conduce la rezultate nule");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_9.setBounds(74, 352, 735, 14);
		panel2.add(label_9);
		
		JLabel lblLungimeMaxima = new JLabel("***   Lungime maxima admisa: 50");
		lblLungimeMaxima.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLungimeMaxima.setBounds(74, 322, 735, 14);
		panel2.add(lblLungimeMaxima);
		

		
		
		
		
		
		
		JPanel panel4 = new JPanel();
		frame.getContentPane().add(panel4, "name_456846894771065");
		panel4.setLayout(null);
		
		JScrollPane scrollPane4 = new JScrollPane();
		scrollPane4.setBounds(60, 472, 1250, 195);
		panel4.add(scrollPane4);
		
		table4 = new JTable();
		scrollPane4.setViewportView(table4);
		
		JLabel lblNewLabel4 = new JLabel("<html>Numele, prenumele, locul nasterii, cetatenia si compania modelelor, in ordine alfabetica, nascute inainte de o anumita data, ce lucreaza pentru companii cu o cifra de afaceri mai mare decat media !</html>");
		lblNewLabel4.setFont(new Font("Sitka Text", Font.BOLD, 21));
		lblNewLabel4.setBounds(74, 145, 1236, 79);
		panel4.add(lblNewLabel4);
		
		textField4 = new JTextField();
		textField4.setBounds(74, 282, 309, 29);
		panel4.add(textField4);
		textField4.setColumns(10);
		
		JButton nextBut4 = new JButton("NEXT");
		nextBut4.setFont(new Font("Tahoma", Font.BOLD, 12));
		nextBut4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.next(frame.getContentPane());
			}
		});
		nextBut4.setBounds(1147, 46, 163, 23);
		panel4.add(nextBut4);
		
		JButton menuBut4 = new JButton("Inapoi la MENIU");
		menuBut4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainWindow();
				frame.dispose();
			}
		});
		menuBut4.setFont(new Font("Sylfaen", Font.BOLD, 15));
		menuBut4.setBounds(974, 80, 336, 23);
		panel4.add(menuBut4);
		
		JButton prevBut4 = new JButton("BACK");
		prevBut4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.previous(frame.getContentPane());
			}
		});
		prevBut4.setFont(new Font("Tahoma", Font.BOLD, 12));
		prevBut4.setBounds(974, 46, 163, 23);
		panel4.add(prevBut4);
		
		JLabel lblTastatiAnulMinim4 = new JLabel("Tastati data nasterii maxima admisa al modelului:");
		lblTastatiAnulMinim4.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblTastatiAnulMinim4.setBounds(74, 258, 1236, 23);
		panel4.add(lblTastatiAnulMinim4);
		
		JLabel label_3 = new JLabel("Nu exista informatii de afisat !!!");
		label_3.setHorizontalAlignment(SwingConstants.TRAILING);
		label_3.setBounds(974, 447, 336, 14);
		label_3.setVisible(false);
		panel4.add(label_3);
		
		JButton findBut4 = new JButton("AFISEAZA REZULTATE");
		findBut4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String aux4 = textField4.getText().toString();
				
				String s4 = "select M.Nume, M.Prenume, M.LocNastere, M.Cetatenie, C.NumeCompanie "+
								"from Model M join Companie C on M.CompanieID = C.CompanieID "+
									"where M.DataNasterii < '" + aux4  + "' AND C.CifraAfaceri > "+
											"(select avg(CifraAfaceri) from Companie) "+
												"order by M.Nume";
				
				ResultSet rs4 = Query(s4);
				try{
				table4.setModel(DbUtils.resultSetToTableModel(rs4));
				}catch(Exception e){
					JOptionPane.showMessageDialog(frame, "Va rugam respectati formatul impus !!!"); 
				}
				
				if(table4.getModel().getRowCount() == 0) 		label_3.setVisible(true);
				else label_3.setVisible(false);
			}
		});
		findBut4.setFont(new Font("Sylfaen", Font.BOLD, 15));
		findBut4.setBounds(974, 277, 336, 39);
		panel4.add(findBut4);
		
		JLabel lblStatistici4 = new JLabel("STATISTICI");
		lblStatistici4.setFont(new Font("Sylfaen", Font.BOLD, 35));
		lblStatistici4.setBounds(74, 51, 735, 52);
		panel4.add(lblStatistici4);
		
		JLabel lblNr4 = new JLabel("NR. 4");
		lblNr4.setFont(new Font("Sylfaen", Font.ITALIC, 30));
		lblNr4.setBounds(74, 114, 735, 39);
		panel4.add(lblNr4);
		
		JLabel lblVaRugam4 = new JLabel("***   Va rugam introduceti o data in formatul AAAA-LL-ZZ");
		lblVaRugam4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVaRugam4.setBounds(74, 323, 735, 14);
		panel4.add(lblVaRugam4);
		
		JLabel label_1 = new JLabel("***   Nerespectarea formatului va conduce la rezultate nule");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(74, 348, 735, 14);
		panel4.add(label_1);
		
		
		
		
		
		
		
		
		JPanel panel5 = new JPanel();
		frame.getContentPane().add(panel5, "name_456863092029206");
		panel5.setLayout(null);
		
		JScrollPane scrollPane5 = new JScrollPane();
		scrollPane5.setBounds(60, 472, 1250, 195);
		panel5.add(scrollPane5);
		
		table5 = new JTable();
		scrollPane5.setViewportView(table5);
		
		JLabel lblNewLabel5 = new JLabel("<html>Modelele si compania la care lucreaza acestea, care au castigat un numar minim de premii, ordonate crescator dupa raportul dintre inaltime si greutate !</html>");
		lblNewLabel5.setFont(new Font("Sitka Text", Font.BOLD, 21));
		lblNewLabel5.setBounds(74, 145, 1236, 79);
		panel5.add(lblNewLabel5);
		
		textField5 = new JTextField();
		textField5.setBounds(74, 282, 309, 29);
		panel5.add(textField5);
		textField5.setColumns(10);
		
		JButton nextBut5 = new JButton("NEXT");
		nextBut5.setFont(new Font("Tahoma", Font.BOLD, 12));
		nextBut5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.next(frame.getContentPane());
			}
		});
		nextBut5.setBounds(1147, 46, 163, 23);
		panel5.add(nextBut5);
		
		JButton menuBut5 = new JButton("Inapoi la MENIU");
		menuBut5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainWindow();
				frame.dispose();
			}
		});
		menuBut5.setFont(new Font("Sylfaen", Font.BOLD, 15));
		menuBut5.setBounds(974, 80, 336, 23);
		panel5.add(menuBut5);
		
		JButton prevBut5 = new JButton("BACK");
		prevBut5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.previous(frame.getContentPane());
			}
		});
		prevBut5.setFont(new Font("Tahoma", Font.BOLD, 12));
		prevBut5.setBounds(974, 46, 163, 23);
		panel5.add(prevBut5);
		
		JLabel lblTastatiAnulMinim5 = new JLabel("Tastati numarul minim de premii:");
		lblTastatiAnulMinim5.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblTastatiAnulMinim5.setBounds(74, 258, 1236, 23);
		panel5.add(lblTastatiAnulMinim5);
		
		JLabel label_4 = new JLabel("Nu exista informatii de afisat !!!");
		label_4.setHorizontalAlignment(SwingConstants.TRAILING);
		label_4.setBounds(974, 447, 336, 14);
		label_4.setVisible(false);
		panel5.add(label_4);
		
		JButton findBut5 = new JButton("AFISEAZA REZULTATE");
		findBut5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String aux5 = textField5.getText().toString();
				
				String s5 = "select M.Nume,M.Prenume,M.LocNastere,M.Cetatenie, M.CuloareOchi,M.CuloarePar,C.NumeCompanie "+
								"from Model M join Companie C on M.CompanieID = C.CompanieID "+
												 "join Premiu P on M.ModelID = P.ModelID "+
									"group by P.ModelID, M.Nume,M.Prenume,M.LocNastere,M.Cetatenie, M.CuloareOchi,M.CuloarePar, M.Inaltime,M.Greutate,C.NumeCompanie "+
										"having count(P.PremiuID) >= " + aux5 +
											" order by M.Inaltime/(M.Greutate+1)";
				
				ResultSet rs5 = Query(s5);
				try{
				table5.setModel(DbUtils.resultSetToTableModel(rs5));
				}catch(Exception e){
					JOptionPane.showMessageDialog(frame, "Va rugam respectati formatul impus !!!"); 
				}
				
				if(table5.getModel().getRowCount() == 0) 		label_4.setVisible(true);
				else label_4.setVisible(false);
			}
		});
		findBut5.setFont(new Font("Sylfaen", Font.BOLD, 15));
		findBut5.setBounds(974, 277, 336, 39);
		panel5.add(findBut5);
		
		JLabel lblStatistici5 = new JLabel("STATISTICI");
		lblStatistici5.setFont(new Font("Sylfaen", Font.BOLD, 35));
		lblStatistici5.setBounds(74, 51, 735, 52);
		panel5.add(lblStatistici5);
		
		JLabel lblNr5 = new JLabel("NR. 5");
		lblNr5.setFont(new Font("Sylfaen", Font.ITALIC, 30));
		lblNr5.setBounds(74, 114, 735, 39);
		panel5.add(lblNr5);
		
		JLabel lblVaRugam5 = new JLabel("***   Va rugam introduceti o valoare numerica");
		lblVaRugam5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVaRugam5.setBounds(74, 323, 735, 14);
		panel5.add(lblVaRugam5);
		
		JLabel label_5 = new JLabel("***   Nerespectarea formatului va conduce la rezultate nule");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(74, 348, 735, 14);
		panel5.add(label_5);
		
		
		
		
		
		
		JPanel panel6 = new JPanel();
		frame.getContentPane().add(panel6, "name_460327254994499");
		panel6.setLayout(null);
		
		JScrollPane scrollPane6 = new JScrollPane();
		scrollPane6.setBounds(60, 472, 1250, 195);
		panel6.add(scrollPane6);
		
		table6 = new JTable();
		scrollPane6.setViewportView(table6);
		
		JLabel lblNewLabel6 = new JLabel("<html>Numele, prenumele,compania si marimea bustului, a taliei si a soldurilor modelelor ce lucreaza<br> la companii in care se afla castigatoare ale unor premii !</html>");
		lblNewLabel6.setFont(new Font("Sitka Text", Font.BOLD, 21));
		lblNewLabel6.setBounds(74, 145, 1236, 79);
		panel6.add(lblNewLabel6);
		
		JButton nextBut6 = new JButton("NEXT");
		nextBut6.setFont(new Font("Tahoma", Font.BOLD, 12));
		nextBut6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.next(frame.getContentPane());
			}
		});
		nextBut6.setBounds(1147, 46, 163, 23);
		panel6.add(nextBut6);
		
		JButton menuBut6 = new JButton("Inapoi la MENIU");
		menuBut6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainWindow();
				frame.dispose();
			}
		});
		menuBut6.setFont(new Font("Sylfaen", Font.BOLD, 15));
		menuBut6.setBounds(974, 80, 336, 23);
		panel6.add(menuBut6);
		
		JButton prevBut6 = new JButton("BACK");
		prevBut6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.previous(frame.getContentPane());
			}
		});
		prevBut6.setFont(new Font("Tahoma", Font.BOLD, 12));
		prevBut6.setBounds(974, 46, 163, 23);
		panel6.add(prevBut6);
		
		
		JButton findBut6 = new JButton("AFISEAZA REZULTATE");
		findBut6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String s6 = "select M.Nume, M.Prenume, M.Bust, M.Talie, M.Solduri, C.NumeCompanie "+
								"from Model M join Companie C on M.CompanieID = C.CompanieID "+
									"where M.CompanieID in (select C.CompanieID from Companie C "+
																	"join Model M on C.CompanieID = M.CompanieID "+
																		"join Premiu P on P.ModelID = M.ModelID)";
				
				ResultSet rs6 = Query(s6);
				table6.setModel(DbUtils.resultSetToTableModel(rs6));
			}
		});
		findBut6.setFont(new Font("Sylfaen", Font.BOLD, 15));
		findBut6.setBounds(974, 277, 336, 39);
		panel6.add(findBut6);
		
		JLabel lblStatistici6 = new JLabel("STATISTICI");
		lblStatistici6.setFont(new Font("Sylfaen", Font.BOLD, 35));
		lblStatistici6.setBounds(74, 51, 735, 52);
		panel6.add(lblStatistici6);
		
		JLabel lblNr6 = new JLabel("NR. 6");
		lblNr6.setFont(new Font("Sylfaen", Font.ITALIC, 30));
		lblNr6.setBounds(74, 114, 735, 39);
		panel6.add(lblNr6);
		
		
		
		
		
		
		
		JPanel panel7 = new JPanel();
		frame.getContentPane().add(panel7, "name_494061937821872");
		panel7.setLayout(null);
		
		JScrollPane scrollPane7 = new JScrollPane();
		scrollPane7.setBounds(60, 472, 1250, 195);
		panel7.add(scrollPane7);
		
		table7 = new JTable();
		scrollPane7.setViewportView(table7);
		
		JLabel lblNewLabel7 = new JLabel("<html>Numele, prenumele si salariu angajatului cel mai bine platit, in functie de profesie!</html>");
		lblNewLabel7.setFont(new Font("Sitka Text", Font.BOLD, 21));
		lblNewLabel7.setBounds(74, 145, 1236, 79);
		panel7.add(lblNewLabel7);
		
		JButton nextBut7 = new JButton("NEXT");
		nextBut7.setFont(new Font("Tahoma", Font.BOLD, 12));
		nextBut7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.next(frame.getContentPane());
			}
		});
		nextBut7.setBounds(1147, 46, 163, 23);
		panel7.add(nextBut7);
		
		JButton menuBut7 = new JButton("Inapoi la MENIU");
		menuBut7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainWindow();
				frame.dispose();
			}
		});
		menuBut7.setFont(new Font("Sylfaen", Font.BOLD, 15));
		menuBut7.setBounds(974, 80, 336, 23);
		panel7.add(menuBut7);
		
		JButton prevBut7 = new JButton("BACK");
		prevBut7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.previous(frame.getContentPane());
			}
		});
		prevBut7.setFont(new Font("Tahoma", Font.BOLD, 12));
		prevBut7.setBounds(974, 46, 163, 23);
		panel7.add(prevBut7);
		
		JButton findBut7 = new JButton("AFISEAZA REZULTATE");
		findBut7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String s7 = "select P.NumeProfesie, A.Prenume, A.Nume, A.Salariu "+
								"from Profesie P join Angajat A on P.ProfesieID = A.ProfesieID "+
									"group by A.ProfesieID, P.NumeProfesie,A.Prenume,A.Nume, A.Salariu "+
										"having A.Salariu = (select max(Salariu) from Angajat "+
																"where ProfesieID = A.ProfesieID "+
																	"group by ProfesieID)";
				
				ResultSet rs7 = Query(s7);
				table7.setModel(DbUtils.resultSetToTableModel(rs7));
			}
		});
		findBut7.setFont(new Font("Sylfaen", Font.BOLD, 15));
		findBut7.setBounds(974, 277, 336, 39);
		panel7.add(findBut7);
		
		JLabel lblStatistici7 = new JLabel("STATISTICI");
		lblStatistici7.setFont(new Font("Sylfaen", Font.BOLD, 35));
		lblStatistici7.setBounds(74, 51, 735, 52);
		panel7.add(lblStatistici7);
		
		JLabel lblNr7 = new JLabel("NR. 7");
		lblNr7.setFont(new Font("Sylfaen", Font.ITALIC, 30));
		lblNr7.setBounds(74, 114, 735, 39);
		panel7.add(lblNr7);
		
		
		
		
		
		
		
		
		
		JPanel panel8 = new JPanel();
		frame.getContentPane().add(panel8, "name_494066507773850");
		panel8.setLayout(null);
		
		JScrollPane scrollPane8 = new JScrollPane();
		scrollPane8.setBounds(60, 472, 1250, 195);
		panel8.add(scrollPane8);
		
		table8 = new JTable();
		scrollPane8.setViewportView(table8);
		
		JLabel lblNewLabel8 = new JLabel("<html>Numele, prenumele, data nasterii, cetatenia, compania si tara in care activeaza aceasta a tuturor modelelor care participa la un numar minim de evenimente ce se desfasoara dupa o anumita data !</html>");
		lblNewLabel8.setFont(new Font("Sitka Text", Font.BOLD, 21));
		lblNewLabel8.setBounds(74, 145, 1236, 79);
		panel8.add(lblNewLabel8);
		
		textField8 = new JTextField();
		textField8.setBounds(74, 282, 309, 29);
		panel8.add(textField8);
		textField8.setColumns(10);
		
		JButton nextBut8 = new JButton("NEXT");
		nextBut8.setFont(new Font("Tahoma", Font.BOLD, 12));
		nextBut8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.next(frame.getContentPane());
			}
		});
		nextBut8.setBounds(1147, 46, 163, 23);
		panel8.add(nextBut8);
		
		JButton menuBut8 = new JButton("Inapoi la MENIU");
		menuBut8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainWindow();
				frame.dispose();
			}
		});
		menuBut8.setFont(new Font("Sylfaen", Font.BOLD, 15));
		menuBut8.setBounds(974, 80, 336, 23);
		panel8.add(menuBut8);
		
		JButton prevBut8 = new JButton("BACK");
		prevBut8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.previous(frame.getContentPane());
			}
		});
		prevBut8.setFont(new Font("Tahoma", Font.BOLD, 12));
		prevBut8.setBounds(974, 46, 163, 23);
		panel8.add(prevBut8);
		
		JLabel lblTastatiAnulMinim8 = new JLabel("Tastati numarul minim de evenimente:");
		lblTastatiAnulMinim8.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblTastatiAnulMinim8.setBounds(74, 258, 476, 23);
		panel8.add(lblTastatiAnulMinim8);
		
		JLabel label_7 = new JLabel("Nu exista informatii de afisat !!!");
		label_7.setHorizontalAlignment(SwingConstants.TRAILING);
		label_7.setBounds(974, 447, 336, 14);
		label_7.setVisible(false);
		panel8.add(label_7);
		
		JButton findBut8 = new JButton("AFISEAZA REZULTATE");
		findBut8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String aux8 = textField8.getText().toString();
				String aux88 = textField88.getText().toString();
				
				String s8 = "select M.Nume, M.Prenume, M.DataNasterii, M.Cetatenie,C.NumeCompanie, C.Tara "+
								"from Model M join Companie C on M.CompanieID = C.CompanieID "+
									"where " + aux8 + " <= (select count(*) from Participa P join Evenimente E on P.EvenimentID = E.EvenimentID "+
													"where M.ModelID = P.ModelID AND E.DataEveniment > '"+ aux88 +
														"' group by P.ModelID)";

				
				ResultSet rs8 = Query(s8);
				try{
				table8.setModel(DbUtils.resultSetToTableModel(rs8));
				}catch(Exception e){
					JOptionPane.showMessageDialog(frame, "Va rugam respectati formatul impus !!!"); 
				}
				
				if(table8.getModel().getRowCount() == 0) 		label_7.setVisible(true);
				else label_7.setVisible(false);
			}
		});
		findBut8.setFont(new Font("Sylfaen", Font.BOLD, 15));
		findBut8.setBounds(974, 361, 336, 39);
		panel8.add(findBut8);
		
		JLabel lblStatistici8 = new JLabel("STATISTICI");
		lblStatistici8.setFont(new Font("Sylfaen", Font.BOLD, 35));
		lblStatistici8.setBounds(74, 51, 735, 52);
		panel8.add(lblStatistici8);
		
		JLabel lblNr8 = new JLabel("NR. 8");
		lblNr8.setFont(new Font("Sylfaen", Font.ITALIC, 30));
		lblNr8.setBounds(74, 114, 735, 39);
		panel8.add(lblNr8);
		
		JLabel lblVaRugam8 = new JLabel("***   Va rugam introduceti data in formatul AAAA-LL-ZZ");
		lblVaRugam8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVaRugam8.setBounds(599, 322, 417, 14);
		panel8.add(lblVaRugam8);
		
		textField88 = new JTextField();
		textField88.setColumns(10);
		textField88.setBounds(599, 282, 309, 29);
		panel8.add(textField88);
		
		JLabel label = new JLabel("***   Va rugam introduceti o valoare numerica");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(74, 323, 374, 14);
		panel8.add(label);
		
		JLabel lblTastatiDataDupa = new JLabel("Tastati data dupa care se desfasoara evenimentele:");
		lblTastatiDataDupa.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblTastatiDataDupa.setBounds(599, 258, 476, 23);
		panel8.add(lblTastatiDataDupa);	
		
		JLabel label_6 = new JLabel("***   Nerespectarea formatului va conduce la rezultate nule");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(74, 373, 834, 14);
		panel8.add(label_6);
		
		
		
		
		
		
		
		JPanel panel9 = new JPanel();
		frame.getContentPane().add(panel9, "name_494078518996306");
		panel9.setLayout(null);
		
		
		JScrollPane scrollPane9 = new JScrollPane();
		scrollPane9.setBounds(60, 472, 1250, 195);
		panel9.add(scrollPane9);
		
		table9 = new JTable();
		scrollPane9.setViewportView(table9);
		
		JLabel lblNewLabel9 = new JLabel("<html>Numele, prenumele, premiul castigat, si numarul de angajati ai firmei pentru care lucreaza acele modele care au castigat cel putin un premiu !</html>");
		lblNewLabel9.setFont(new Font("Sitka Text", Font.BOLD, 21));
		lblNewLabel9.setBounds(74, 145, 1236, 79);
		panel9.add(lblNewLabel9);
		
		JButton nextBut9 = new JButton("NEXT");
		nextBut9.setFont(new Font("Tahoma", Font.BOLD, 12));
		nextBut9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.next(frame.getContentPane());
			}
		});
		nextBut9.setBounds(1147, 46, 163, 23);
		panel9.add(nextBut9);
		
		JButton menuBut9 = new JButton("Inapoi la MENIU");
		menuBut9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainWindow();
				frame.dispose();
			}
		});
		menuBut9.setFont(new Font("Sylfaen", Font.BOLD, 15));
		menuBut9.setBounds(974, 80, 336, 23);
		panel9.add(menuBut9);
		
		JButton prevBut9 = new JButton("BACK");
		prevBut9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.previous(frame.getContentPane());
			}
		});
		prevBut9.setFont(new Font("Tahoma", Font.BOLD, 12));
		prevBut9.setBounds(974, 46, 163, 23);
		panel9.add(prevBut9);
		
		JButton findBut9 = new JButton("AFISEAZA REZULTATE");
		findBut9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				
				String s9 = "select M.Nume, M.Prenume, P.NumePremiu, "+
										  "( select count(*) from Lucreaza "+
											 	"where CompanieID = M.CompanieID "+
													"group by CompanieID ) as NumarAngajati "+
								"from Model M join Premiu P on P.ModelID = M.ModelID "+
									"order by NumarAngajati DESC";
				
				ResultSet rs9 = Query(s9);
				table9.setModel(DbUtils.resultSetToTableModel(rs9));
			}
		});
		findBut9.setFont(new Font("Sylfaen", Font.BOLD, 15));
		findBut9.setBounds(974, 277, 336, 39);
		panel9.add(findBut9);
		
		JLabel lblStatistici9 = new JLabel("STATISTICI");
		lblStatistici9.setFont(new Font("Sylfaen", Font.BOLD, 35));
		lblStatistici9.setBounds(74, 51, 735, 52);
		panel9.add(lblStatistici9);
		
		JLabel lblNr9 = new JLabel("NR. 9");
		lblNr9.setFont(new Font("Sylfaen", Font.ITALIC, 30));
		lblNr9.setBounds(74, 114, 735, 39);
		panel9.add(lblNr9);
		
		
		
		
		
		
		JPanel panel11 = new JPanel();
		frame.getContentPane().add(panel11, "name_494085236923738");
		panel11.setLayout(null);
		
		
		JScrollPane scrollPane11 = new JScrollPane();
		scrollPane11.setBounds(60, 472, 1250, 195);
		panel11.add(scrollPane11);
		
		table10 = new JTable();
		scrollPane11.setViewportView(table10);
		
		JLabel lblNewLabel11 = new JLabel("<html> Numele si prenumele modelelor care lucreaza la companiile la cara angajatul cu salariul maxim castiga mai putin decat toti angajatii unei anumite companii !</html>");
		lblNewLabel11.setFont(new Font("Sitka Text", Font.BOLD, 21));
		lblNewLabel11.setBounds(74, 145, 1236, 79);
		panel11.add(lblNewLabel11);
		
		textField11 = new JTextField();
		textField11.setBounds(74, 282, 309, 29);
		panel11.add(textField11);
		textField11.setColumns(10);
		
		JButton nextBut11 = new JButton("NEXT");
		nextBut11.setFont(new Font("Tahoma", Font.BOLD, 12));
		nextBut11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.next(frame.getContentPane());
			}
		});
		nextBut11.setBounds(1147, 46, 163, 23);
		panel11.add(nextBut11);
		
		JButton menuBut11 = new JButton("Inapoi la MENIU");
		menuBut11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainWindow();
				frame.dispose();
			}
		});
		menuBut11.setFont(new Font("Sylfaen", Font.BOLD, 15));
		menuBut11.setBounds(974, 80, 336, 23);
		panel11.add(menuBut11);
		
		JLabel lblTastatiAnulMinim11 = new JLabel("Tastati numele companiei:");
		lblTastatiAnulMinim11.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblTastatiAnulMinim11.setBounds(74, 258, 1236, 23);
		panel11.add(lblTastatiAnulMinim11);
		
		JButton prevBut11 = new JButton("BACK");
		prevBut11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.previous(frame.getContentPane());
			}
		});
		prevBut11.setFont(new Font("Tahoma", Font.BOLD, 12));
		prevBut11.setBounds(974, 46, 163, 23);
		panel11.add(prevBut11);
		
		JLabel label_8 = new JLabel("Nu exista informatii de afisat !!!");
		label_8.setHorizontalAlignment(SwingConstants.TRAILING);
		label_8.setBounds(974, 447, 336, 14);
		label_8.setVisible(false);
		panel11.add(label_8);
	
		
		JButton findBut11 = new JButton("AFISEAZA REZULTATE");
		findBut11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String aux11 = textField11.getText().toString();
				
				String s11 = "select M.Nume, M.Prenume "+
								"from Model M "+
									"group by M.CompanieID, M.Nume, M.Prenume "+
										"having (select MAX(Salariu) from Angajat A join Lucreaza L on A.AngajatID = L.AngajatID "+
											"where L.CompanieID = M.CompanieID) < ANY "+
													"(select A2.Salariu from Angajat A2 join Lucreaza L2 on A2.AngajatID = L2.AngajatID "+
																						 "join Companie C2 on L2.CompanieID = C2.CompanieID "+
															"where C2.NumeCompanie LIKE '" + aux11 +"')";

				
				ResultSet rs11 = Query(s11);
				table10.setModel(DbUtils.resultSetToTableModel(rs11));
				
				if(table10.getModel().getRowCount() == 0) 		label_8.setVisible(true);
				else label_8.setVisible(false);
			}
		});
		findBut11.setFont(new Font("Sylfaen", Font.BOLD, 15));
		findBut11.setBounds(974, 277, 336, 39);
		panel11.add(findBut11);
		
		JLabel lblStatistici11 = new JLabel("STATISTICI");
		lblStatistici11.setFont(new Font("Sylfaen", Font.BOLD, 35));
		lblStatistici11.setBounds(74, 51, 735, 52);
		panel11.add(lblStatistici11);
		
		JLabel lblNr11 = new JLabel("NR. 10");
		lblNr11.setFont(new Font("Sylfaen", Font.ITALIC, 30));
		lblNr11.setBounds(74, 114, 735, 39);
		panel11.add(lblNr11);
		
		
		JLabel lblVaRugam11 = new JLabel("***   Va rugam introduceti numele exact al companiei dorite");
		lblVaRugam11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVaRugam11.setBounds(74, 323, 735, 14);
		panel11.add(lblVaRugam11);
		
		JLabel lblLungimeMaxima_1 = new JLabel("***   Lungime maxima admisa: 50");
		lblLungimeMaxima_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLungimeMaxima_1.setBounds(74, 337, 735, 14);
		panel11.add(lblLungimeMaxima_1);
		
		JLabel label_10 = new JLabel("***   Nerespectarea formatului va conduce la rezultate nule");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_10.setBounds(74, 377, 735, 14);
		panel11.add(label_10);
		
		
	}
}
