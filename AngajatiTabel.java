
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JList;

public class AngajatiTabel extends SQLDatabaseConnection{

	JFrame frame;
	private static String s,s1,s2,s3,s4;
	private JTable table;
	private int nrNewID,nrNewID2;
	private JLabel lblImageModel;
	private JTextField textFieldNume,textFieldNume2;
	private JTextField textFieldPrenume,textFieldPrenume2;
	private JTextField textFieldDataNasterii,textFieldDataNasterii2;
	private JTextField textFieldDataAngajarii,textFieldDataAngajarii2;
	private JTextField textFieldOrigine,textFieldOrigine2;
	private JTextField textFieldSalariu;
	private JTextField textFieldSalariu2;
	private JTable table_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AngajatiTabel window = new AngajatiTabel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	}

	/**
	 * Create the application
	 */
	public AngajatiTabel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		s = "SELECT A.AngajatID, A.Nume, A.Prenume, A.DataNasterii, A.LocNastere, A.ProfesieID, P.NumeProfesie, A.DataAngajarii,  A.Salariu"
				+ " FROM Angajat A join Profesie P on A.ProfesieID = P.ProfesieID" ;
		s1 = "SELECT NumeProfesie FROM Profesie";
		s2 = "SELECT NumeCompanie FROM Companie";
		s3 = "SELECT ContractID FROM Lucreaza";
		
		ResultSet rs = Query(s);
		ResultSet rs1 = Query(s1);
		ResultSet rs2 = Query(s1);
		ResultSet rs3 = Query(s2);
		ResultSet rs4 = Query(s3);
		
		frame = new JFrame();
		frame.setBounds(0, 0, 1380, 750);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitluModel = new JLabel("ANGAJATI");
		lblTitluModel.setBounds(10, 10, 1342, 63);
		lblTitluModel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 50));
		lblTitluModel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblTitluModel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 1342, 257);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(){
			public boolean isCellEditable(int row,int column){
			    return false;
			}
		};
		scrollPane.setViewportView(table);
		

		table.setModel(DbUtils.resultSetToTableModel(rs));

		   table.getColumnModel().getColumn(0).setMinWidth(0);
		   table.getColumnModel().getColumn(0).setMaxWidth(0);
		   table.getColumnModel().getColumn(0).setWidth(0);
		   
		   table.getColumnModel().getColumn(5).setMinWidth(0);
		   table.getColumnModel().getColumn(5).setMaxWidth(0);
		   table.getColumnModel().getColumn(5).setWidth(0);
		   
		   nrNewID = (Integer) table.getValueAt(table.getRowCount()-1,0) + 5;
		   
			try {
				while (rs4.next()) {
					nrNewID2  = rs4.getInt("ContractID");
	}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			nrNewID2 += 1;
		   
		   TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
		   JLabel headerLabel = (JLabel) rendererFromHeader;
		   headerLabel.setHorizontalAlignment(JLabel.CENTER);
		   
		   
		String path = "C:\\Users\\user\\Desktop\\POLI\\ANUL --- 3\\SEMESTRUL --- I\\JAVA si Aplicatii WEB\\AgentieFotomodele\\Resources\\angajat.jpg";
		ImageIcon imageIcon = new ImageIcon(path);
		
		lblImageModel = new JLabel(imageIcon);
		lblImageModel.setBounds(24, 365, 342, 335);
		frame.getContentPane().add(lblImageModel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(372, 408, 947, 283);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("ADAUGA", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNume = new JLabel("Nume");
		lblNume.setBounds(22, 24, 86, 14);
		panel.add(lblNume);
		
		JLabel lblPrenume = new JLabel("Prenume");
		lblPrenume.setBounds(229, 24, 86, 14);
		panel.add(lblPrenume);
		
		textFieldNume = new JTextField();
		textFieldNume.setBounds(22, 44, 184, 20);
		panel.add(textFieldNume);
		textFieldNume.setColumns(10);
		
		textFieldPrenume = new JTextField();
		textFieldPrenume.setColumns(10);
		textFieldPrenume.setBounds(229, 44, 199, 20);
		panel.add(textFieldPrenume);
		
		
		JLabel lblDataNasterii = new JLabel("Data Nasterii");
		lblDataNasterii.setBounds(22, 92, 108, 14);
		panel.add(lblDataNasterii);
		
		textFieldDataNasterii = new JTextField();
		textFieldDataNasterii.setColumns(10);
		textFieldDataNasterii.setBounds(22, 117, 264, 20);
		panel.add(textFieldDataNasterii);
		
		
		JLabel lblLoculNasterii = new JLabel("Tara de origine");
		lblLoculNasterii.setBounds(352, 92, 108, 14);
		panel.add(lblLoculNasterii);
		
		textFieldOrigine = new JTextField();
		textFieldOrigine.setColumns(10);
		textFieldOrigine.setBounds(352, 117, 264, 20);
		panel.add(textFieldOrigine);
		
		
		
		JLabel lblSalariu = new JLabel("Salariu");
		lblSalariu.setBounds(352, 168, 108, 14);
		panel.add(lblSalariu);
		
		textFieldSalariu = new JTextField();
		textFieldSalariu.setColumns(10);
		textFieldSalariu.setBounds(352, 193, 264, 20);
		panel.add(textFieldSalariu);
		
		JLabel lblDataAngajarii = new JLabel("Data Angajarii");
		lblDataAngajarii.setBounds(22, 168, 108, 14);
		panel.add(lblDataAngajarii);
		
		textFieldDataAngajarii = new JTextField();
		textFieldDataAngajarii.setColumns(10);
		textFieldDataAngajarii.setBounds(22, 193, 264, 20);
		panel.add(textFieldDataAngajarii);
		
		JComboBox comboBoxProfesie = new JComboBox();
		comboBoxProfesie.setBounds(751, 117, 118, 20);
		panel.add(comboBoxProfesie);
		
		try {
			while (rs1.next()) {
				String em = rs1.getString("NumeProfesie");
				comboBoxProfesie.addItem(em);
}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JLabel lblProfesie = new JLabel("Profesie");
		lblProfesie.setBounds(751, 92, 94, 14);
		panel.add(lblProfesie);
		
		
		DefaultListModel modelL = new DefaultListModel();
		int counter = 0;
		
		try {
			while (rs3.next()) {
				String em = rs3.getString("NumeCompanie");
				modelL.add(counter,em);
				counter++;
}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(675, 165, 257, 79);
		JList list = new JList(modelL);
		scrollPane_1.setViewportView(list);
		panel.add(scrollPane_1);
		
		
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nume = textFieldNume.getText();
				String prenume = textFieldPrenume.getText();
				String dataNasterii = textFieldDataNasterii.getText();
				if(dataNasterii == "") dataNasterii = "1900-01-01";
				String locNastere = textFieldOrigine.getText();
				String dataAngajare = textFieldDataAngajarii.getText();
				if(dataAngajare == "") dataAngajare = "1900-01-01";
				String salariu = textFieldSalariu.getText();
				if(salariu == "") salariu = "1.00";
				Integer compId = comboBoxProfesie.getSelectedIndex() + 1;
				
				int[] compIndex = list.getSelectedIndices();
				
								
				String sNew = "INSERT INTO Angajat "
						+ "VALUES ( " + nrNewID + ", '" + nume + "', '" + prenume + "', '" + dataNasterii + "', '" + locNastere + "', '" 
						+ compId + "', '" + dataAngajare + "', '" + salariu + "');" ;
				boolean b = Update(sNew);
				
				for(int i: compIndex){
					int compNr = i+1; 
				String s2New = "INSERT INTO Lucreaza "+
						 "VALUES ( " + nrNewID2 + ", " + nrNewID + ", " + compNr + ")";
					Update(s2New);
					nrNewID2++;
				}
				
				
				if(b) {
					JOptionPane.showMessageDialog(frame, "Angajatul a fost adaugat in baza de date"); 
					new AngajatiTabel();
					frame.dispose();
				}
				else JOptionPane.showMessageDialog(frame, "Va rugam respectati restrictiile privind tipul si lungimea datelor");
				
				
			}
		});
		btnInsert.setBounds(496, 43, 349, 23);
		panel.add(btnInsert);
		

		
		JLabel lblCompanii = new JLabel("Companii");
		lblCompanii.setBounds(675, 148, 94, 14);
		panel.add(lblCompanii);
				
		
		
		JPanel panel1 = new JPanel();
		tabbedPane.addTab("UPDATE", null, panel1, null);
		panel1.setLayout(null);
		
		JLabel lblNume2 = new JLabel("Nume");
		lblNume2.setBounds(22, 24, 86, 14);
		panel1.add(lblNume2);
		
		JLabel lblPrenume2 = new JLabel("Prenume");
		lblPrenume2.setBounds(229, 24, 86, 14);
		panel1.add(lblPrenume2);
		
		textFieldNume2 = new JTextField();
		textFieldNume2.setBounds(22, 44, 184, 20);
		panel1.add(textFieldNume2);
		textFieldNume2.setColumns(10);
		
		textFieldPrenume2 = new JTextField();
		textFieldPrenume2.setColumns(10);
		textFieldPrenume2.setBounds(229, 44, 199, 20);
		panel1.add(textFieldPrenume2);
		
		
		JLabel lblDataNasterii2 = new JLabel("Data Nasterii");
		lblDataNasterii2.setBounds(22, 92, 108, 14);
		panel1.add(lblDataNasterii2);
		
		textFieldDataNasterii2 = new JTextField();
		textFieldDataNasterii2.setColumns(10);
		textFieldDataNasterii2.setBounds(22, 117, 264, 20);
		panel1.add(textFieldDataNasterii2);
		
		
		JLabel lblLoculNasterii2 = new JLabel("Tara de origine");
		lblLoculNasterii2.setBounds(352, 92, 108, 14);
		panel1.add(lblLoculNasterii2);
		
		textFieldOrigine2 = new JTextField();
		textFieldOrigine2.setColumns(10);
		textFieldOrigine2.setBounds(352, 117, 264, 20);
		panel1.add(textFieldOrigine2);
		
		JLabel lblDataAngajarii2 = new JLabel("Data Angajarii");
		lblDataAngajarii2.setBounds(22, 168, 108, 14);
		panel1.add(lblDataAngajarii2);
		
		textFieldDataAngajarii2 = new JTextField();
		textFieldDataAngajarii2.setColumns(10);
		textFieldDataAngajarii2.setBounds(22, 193, 264, 20);
		panel1.add(textFieldDataAngajarii2);
		
		JComboBox comboBoxProfesie2 = new JComboBox();
		comboBoxProfesie2.setBounds(751, 117, 118, 20);
		panel1.add(comboBoxProfesie2);
		
		try {
			while (rs2.next()) {
				String em = rs2.getString("NumeProfesie");
				comboBoxProfesie2.addItem(em);
}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JLabel lblProfesie2 = new JLabel("Profesie");
		lblProfesie2.setBounds(751, 92, 94, 14);
		panel1.add(lblProfesie2);
		
		
			JButton btnUpdate = new JButton("UPDATE");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					String nume = textFieldNume2.getText();
					String prenume = textFieldPrenume2.getText();
					String dataNasterii = textFieldDataNasterii2.getText();
					String locNastere = textFieldOrigine2.getText();
					String dataAngajare = textFieldDataAngajarii2.getText();
					String salariu = textFieldSalariu2.getText().toString();
					Integer compId = comboBoxProfesie2.getSelectedIndex() + 1;
					Integer idMod = (Integer) table.getValueAt(table.getSelectedRow(),0);
									
					String s3 = "UPDATE Angajat "
							+ "SET Nume = '" + nume + "', Prenume = '" + prenume + "', DataNasterii = '" + dataNasterii + "', LocNastere = '" + locNastere 
							+ "', ProfesieID = '" + compId + "', Salariu = '" + salariu + "', DataAngajarii = '" + dataAngajare
							+ "' WHERE AngajatID = '" + idMod + "';"; 
					boolean b = Update(s3);
					
					if(b) {
						JOptionPane.showMessageDialog(frame, "Datele au fost actualizate in baza de date"); 
						new AngajatiTabel();
						frame.dispose();
					}
					else JOptionPane.showMessageDialog(frame, "Va rugam respectati restrictiile privind tipul si lungimea datelor");
					
				}
			});
			btnUpdate.setBounds(496, 43, 373, 23);
			panel1.add(btnUpdate);
			
			textFieldSalariu2 = new JTextField();
			textFieldSalariu2.setColumns(10);
			textFieldSalariu2.setBounds(352, 193, 264, 20);
			panel1.add(textFieldSalariu2);
			
			JLabel lblSalariu2 = new JLabel("Salariu");
			lblSalariu2.setBounds(352, 168, 108, 14);
			panel1.add(lblSalariu2);
			
			
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("DELETE", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNume23 = new JLabel("Nume");
		lblNume23.setBounds(22, 24, 86, 14);
		panel_2.add(lblNume23);
		
		JLabel lblPrenume23 = new JLabel("Prenume");
		lblPrenume23.setBounds(252, 24, 86, 14);
		panel_2.add(lblPrenume23);
		
		JLabel lblDataNasterii23 = new JLabel("Data Nasterii");
		lblDataNasterii23.setBounds(22, 104, 108, 14);
		panel_2.add(lblDataNasterii23);
				
		JLabel lblLoculNasterii23 = new JLabel("Tara de origine");
		lblLoculNasterii23.setBounds(252, 104, 108, 14);
		panel_2.add(lblLoculNasterii23);
		
		JLabel lblCompanie23 = new JLabel("Profesie");
		lblCompanie23.setBounds(432, 51, 94, 14);
		panel_2.add(lblCompanie23);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer idMod = (Integer) table.getValueAt(table.getSelectedRow(),0);
				
				String sDel = "DELETE FROM Angajat "
						+ "WHERE AngajatID = '"+ idMod + "';";
				
				String s2Del = "DELETE FROM Lucreaza "+
						"WHERE AngajatID = " + idMod ;
				
				boolean b = Update(sDel);
				Update(s2Del);
				
				if(b) {
					JOptionPane.showMessageDialog(frame, "Angajatul a fost sters din baza de date !"); 
						new AngajatiTabel();
						frame.dispose();
				}
			}
		});
		btnDelete.setBounds(665, 104, 221, 44);
		panel_2.add(btnDelete);
		
		JLabel lblNume3 = new JLabel("NUME");
		lblNume3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNume3.setBounds(22, 49, 158, 14);
		panel_2.add(lblNume3);
		
		JLabel lblPrenume3 = new JLabel("PRENUME");
		lblPrenume3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrenume3.setBounds(252, 49, 170, 14);
		panel_2.add(lblPrenume3);
		
		JLabel lblDataNasterii3 = new JLabel("DATA NASTERII");
		lblDataNasterii3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDataNasterii3.setBounds(22, 129, 140, 14);
		panel_2.add(lblDataNasterii3);
		
		JLabel lblOrigine3 = new JLabel("ORIGINE");
		lblOrigine3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOrigine3.setBounds(252, 129, 140, 14);
		panel_2.add(lblOrigine3);
		
		JLabel lblCompanie3 = new JLabel("PROFESIE");
		lblCompanie3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCompanie3.setBounds(432, 76, 108, 14);
		panel_2.add(lblCompanie3);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Companii", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 922, 233);
		panel_1.add(scrollPane_2);
		
		table_1 = new JTable(){
			public boolean isCellEditable(int row,int column){
			    return false;
			}
		};
		scrollPane_2.setViewportView(table_1);
		
		
		
		JLabel lblOperatie = new JLabel("Operati baza de date:");
		lblOperatie.setFont(new Font("Tempus Sans ITC", Font.BOLD, 28));
		lblOperatie.setBounds(376, 360, 396, 37);
		frame.getContentPane().add(lblOperatie);
		
		JButton btnBackMenu = new JButton("Inapoi la MENIU");
		btnBackMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new MainWindow();
				frame.dispose();;
			}
		});
		btnBackMenu.setFont(new Font("Sylfaen", Font.BOLD, 20));
		btnBackMenu.setBounds(896, 365, 423, 32);
		frame.getContentPane().add(btnBackMenu);
		
		JLabel lblPentruCa = new JLabel("***   Dimensiuni maxime admise: Nume, Prenume (30), Tara de origine (20)");
		lblPentruCa.setBounds(382, 702, 937, 14);
		frame.getContentPane().add(lblPentruCa);
		
		JLabel lblPentruCampurile = new JLabel("***   Pentru campurile Data Angajarii si Data Nasterii respectati formatul 'AAAA-LL-ZZ' iar pentru campul Salariu formatul Y--Y.XX");
		lblPentruCampurile.setBounds(382, 725, 937, 14);
		frame.getContentPane().add(lblPentruCampurile);
		
		frame.setResizable(false);     
		frame.setVisible(true);
				
				
		ListSelectionModel model = table.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(! model.isSelectionEmpty()){

					Integer i = (Integer) table.getValueAt(table.getSelectedRow(),0);

					
					String s = null;
					
					s = (String) table.getValueAt(table.getSelectedRow(),1);
					textFieldNume2.setText(s);
					lblNume3.setText(s);
					
					s = (String) table.getValueAt(table.getSelectedRow(),2);
					textFieldPrenume2.setText(s);
					lblPrenume3.setText(s);
					
					Date d = null;
					d = (Date) table.getValueAt(table.getSelectedRow(),3);
					textFieldDataNasterii2.setText(d.toString());
					lblDataNasterii3.setText(s);
					
					s = (String) table.getValueAt(table.getSelectedRow(),4);
					textFieldOrigine2.setText(s);
					lblOrigine3.setText(s);
					
					Date d1 = null;
					d1 = (Date) table.getValueAt(table.getSelectedRow(),7);
					textFieldDataAngajarii2.setText(d.toString());
					lblDataAngajarii2.setText(s);
					
					s = (String) table.getValueAt(table.getSelectedRow(),8).toString();
					textFieldSalariu2.setText(s);
					
					i = (Integer) table.getValueAt(table.getSelectedRow(),5);
					comboBoxProfesie2.setSelectedIndex(i-1);
					
					s = (String) table.getValueAt(table.getSelectedRow(),6);
					lblCompanie3.setText(s);
					

					s4 = "select NumeCompanie, Tara,AnulFondarii, CifraAfaceri "+
							"from Companie C join Lucreaza L on C.CompanieID = L.CompanieID "+
								"where L.AngajatID = "+ table.getValueAt(table.getSelectedRow(),0).toString()   ;
					ResultSet rs5 = Query(s4);
					
					
					table_1.setModel(DbUtils.resultSetToTableModel(rs5));	
					
				}
			}
			
		});
	}
}
