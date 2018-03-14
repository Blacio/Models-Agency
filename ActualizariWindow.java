import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ActualizariWindow extends SQLDatabaseConnection{

	private JFrame frame;
	private JTextField textField1;
	private JTable table;
	private JTextField textField2;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JLabel lbl3;
	private JTextField textField3;
	private JLabel lbl4;
	private JTextField textField4;
	private JTextField textField33;
	private JLabel lblNewLabel;
	private JLabel lblProcentulMaririi;
	private JLabel lblInaltime;
	private JLabel lblGreutate;
	private JLabel lblPrimeleCateCompanii;
	private JButton aplica1;
	private JButton aplica2;
	private JButton aplica3;
	private JButton aplica4;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JButton backMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActualizariWindow window = new ActualizariWindow();
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
	public ActualizariWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		String s1 = "SELECT * FROM Model";
		String s2 = "SELECT * FROM Angajat";
		String s3 = "SELECT * FROM Companie";
		
		ResultSet rs1 = Query(s1);
		ResultSet rs2 = Query(s2);
		ResultSet rs3 = Query(s1);
		ResultSet rs4 = Query(s3);

		frame = new JFrame();
		frame.setBounds(0, 0, 1380, 750);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblTitluModel = new JLabel("ACTUALIZARI");
		lblTitluModel.setBounds(312, 10, 762, 63);
		lblTitluModel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 50));
		lblTitluModel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblTitluModel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 235, 1342, 12);
		frame.getContentPane().add(separator);
		
		JLabel lbl1 = new JLabel("<html>Toate modele nascute inainte dupa o anumita data vor primi cetatenia aferenta tarii in care s-au nascut</html>");
		lbl1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 14));
		lbl1.setBounds(24, 118, 429, 63);
		frame.getContentPane().add(lbl1);
		
		textField1 = new JTextField();
		textField1.setBounds(218, 192, 235, 20);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(484, 84, 868, 139);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(){
			public boolean isCellEditable(int row,int column){
			    return false;
			}
		};
		scrollPane.setViewportView(table);
		
		table.setModel(DbUtils.resultSetToTableModel(rs1));

		   table.getColumnModel().getColumn(0).setMinWidth(0);
		   table.getColumnModel().getColumn(0).setMaxWidth(0);
		   table.getColumnModel().getColumn(0).setWidth(0);
		
		JLabel lbl2 = new JLabel("<html>Toti angajati care au un salariu mai mic decat media salariilor angajatilor companiei 'Marilyn' vor avea o marire de salariu</html>");
		lbl2.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 14));
		lbl2.setBounds(24, 258, 429, 63);
		frame.getContentPane().add(lbl2);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(218, 362, 235, 20);
		frame.getContentPane().add(textField2);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(484, 258, 868, 139);
		frame.getContentPane().add(scrollPane_1);
		
		table_1 = new JTable(){
			public boolean isCellEditable(int row,int column){
			    return false;
			}
		};
		scrollPane_1.setViewportView(table_1);
		
		
		table_1.setModel(DbUtils.resultSetToTableModel(rs2));

		   table_1.getColumnModel().getColumn(0).setMinWidth(0);
		   table_1.getColumnModel().getColumn(0).setMaxWidth(0);
		   table_1.getColumnModel().getColumn(0).setWidth(0);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(484, 436, 868, 139);
		frame.getContentPane().add(scrollPane_2);
		
		table_2 = new JTable(){
			public boolean isCellEditable(int row,int column){
			    return false;
			}
		};
		scrollPane_2.setViewportView(table_2);
		
		table_2.setModel(DbUtils.resultSetToTableModel(rs3));

		   table_2.getColumnModel().getColumn(0).setMinWidth(0);
		   table_2.getColumnModel().getColumn(0).setMaxWidth(0);
		   table_2.getColumnModel().getColumn(0).setWidth(0);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(484, 618, 868, 139);
		frame.getContentPane().add(scrollPane_3);
		
		table_3 = new JTable(){
			public boolean isCellEditable(int row,int column){
			    return false;
			}
		};
		scrollPane_3.setViewportView(table_3);
		
		table_3.setModel(DbUtils.resultSetToTableModel(rs4));

		   table_3.getColumnModel().getColumn(0).setMinWidth(0);
		   table_3.getColumnModel().getColumn(0).setMaxWidth(0);
		   table_3.getColumnModel().getColumn(0).setWidth(0);
		

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 413, 1342, 12);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 595, 1342, 12);
		frame.getContentPane().add(separator_2);
		
		lbl3 = new JLabel("<html>Sterge toate modelele care au o inaltime mai mica si o greutate mai mare decat anumite limite admise</html>");
		lbl3.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 14));
		lbl3.setBounds(24, 436, 429, 63);
		frame.getContentPane().add(lbl3);
		
		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(218, 510, 235, 20);
		frame.getContentPane().add(textField3);
		
		lbl4 = new JLabel("<html>Stergeti acele companii care activeaza in tara in care este nascut cel mai prost platit angajat si care are un salariu mai mic de o anumita suma</html>");
		lbl4.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 14));
		lbl4.setBounds(24, 618, 429, 63);
		frame.getContentPane().add(lbl4);
		
		textField4 = new JTextField();
		textField4.setColumns(10);
		textField4.setBounds(218, 717, 211, 20);
		frame.getContentPane().add(textField4);
		
		textField33 = new JTextField();
		textField33.setColumns(10);
		textField33.setBounds(218, 541, 235, 20);
		frame.getContentPane().add(textField33);
		
		lblNewLabel = new JLabel("Anul minim: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(112, 195, 96, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblProcentulMaririi = new JLabel("Procentul maririi: ");
		lblProcentulMaririi.setBounds(129, 337, 324, 14);
		frame.getContentPane().add(lblProcentulMaririi);
		
		lblInaltime = new JLabel("Inaltime < ");
		lblInaltime.setHorizontalAlignment(SwingConstants.TRAILING);
		lblInaltime.setBounds(112, 513, 96, 14);
		frame.getContentPane().add(lblInaltime);
		
		lblGreutate = new JLabel("Greutate > ");
		lblGreutate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGreutate.setBounds(112, 544, 96, 14);
		frame.getContentPane().add(lblGreutate);
		
		lblPrimeleCateCompanii = new JLabel("Salariul minim:");
		lblPrimeleCateCompanii.setBounds(129, 692, 300, 14);
		frame.getContentPane().add(lblPrimeleCateCompanii);
		
		aplica1 = new JButton("APLICA");
		aplica1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String q1 = "update Model set Cetatenie = LocNastere "+
								"where YEAR(DataNasterii) > " + textField1.getText();
				
				boolean b = Update(q1);
				
				if(b) {
					JOptionPane.showMessageDialog(frame, "Actualizare efectuata cu succes !"); 
					new ActualizariWindow();
					frame.dispose();
				}
				else JOptionPane.showMessageDialog(frame, "Va rugam respectati restrictiile privind tipul si lungimea datelor");
				
				
			}
		});
		aplica1.setBounds(13, 191, 89, 23);
		frame.getContentPane().add(aplica1);
		
		aplica2 = new JButton("APLICA");
		aplica2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String q2 = "update Angajat set Salariu = Salariu + "+ textField2.getText()  +   "*Salariu "+
								"where Salariu < (select avg(A.Salariu) "+
								                     " from Angajat A join Lucreaza L on A.AngajatID = L.AngajatID "+
								                     		"where L.CompanieID = 2)";
		
		boolean b = Update(q2);
		
		if(b) {
			JOptionPane.showMessageDialog(frame, "Actualizare efectuata cu succes !"); 
			new ActualizariWindow();
			frame.dispose();
		}
		else JOptionPane.showMessageDialog(frame, "Va rugam respectati restrictiile privind tipul si lungimea datelor");
			}
		});
		aplica2.setBounds(13, 331, 89, 23);
		frame.getContentPane().add(aplica2);
		
		aplica3 = new JButton("APLICA");
		aplica3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String q3 = "delete from Model "+
								"where Inaltime < "+ textField3.getText()  + " AND Greutate > " + textField33.getText();

				boolean b = Update(q3);
				
				if(b) {
					JOptionPane.showMessageDialog(frame, "Actualizare efectuata cu succes !"); 
					new ActualizariWindow();
					frame.dispose();
				}
				else JOptionPane.showMessageDialog(frame, "Va rugam respectati restrictiile privind tipul si lungimea datelor");
	
			}
		});
		aplica3.setBounds(13, 524, 89, 23);
		frame.getContentPane().add(aplica3);
		
		aplica4 = new JButton("APLICA");
		aplica4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String q4 = "delete from Companie "+
								"where Tara = (select A.LocNastere from Angajat A "+
													"where A.Salariu = (select min(Salariu) from Angajat) AND A.Salariu < " + textField4.getText() + ")";

		boolean b = Update(q4);
		
		if(b) {
			JOptionPane.showMessageDialog(frame, "Actualizare efectuata cu succes !"); 
			new ActualizariWindow();
			frame.dispose();
		}
		else JOptionPane.showMessageDialog(frame, "Va rugam respectati restrictiile privind tipul si lungimea datelor");
			}
		});
		aplica4.setBounds(13, 691, 89, 23);
		frame.getContentPane().add(aplica4);
		
		backMenu = new JButton("Inapoi la MENIU");
		backMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainWindow();
				frame.dispose();
			}
		});
		backMenu.setFont(new Font("Sylfaen", Font.BOLD, 20));
		backMenu.setBounds(1084, 32, 268, 43);
		frame.getContentPane().add(backMenu);
	}

}
