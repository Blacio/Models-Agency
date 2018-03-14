
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
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

public class ModeleTabel extends SQLDatabaseConnection{

	JFrame frame;
	private static String s,s1,s2,s3,s4;
	private JTable table;
	private int nrNewID;
	private int nrNewID2;
	private JLabel lblImageModel;
	private JTextField textFieldNume,textFieldNume2;
	private JTextField textFieldPrenume,textFieldPrenume2;
	private JTextField textFieldBust,textFieldBust2;
	private JTextField textFieldTalie,textFieldTalie2;
	private JTextField textFieldSolduri,textFieldSolduri2;
	private JTextField textFieldDataNasterii,textFieldDataNasterii2;
	private JTextField textFieldInaltime,textFieldInaltime2;
	private JTextField textFieldGreutate,textFieldGreutate2;
	private JTextField textFieldOchi,textFieldOchi2;
	private JTextField textFieldPar,textFieldPar2;
	private JTextField textFieldOrigine,textFieldOrigine2;
	private JTextField textFieldResedinta,textFieldResedinta2;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModeleTabel window = new ModeleTabel();
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
	public ModeleTabel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		s = "SELECT M.ModelID,M.Nume,M.Prenume, M.DataNasterii, M.Inaltime, M.Greutate, M.Bust, M.Talie, M.Solduri,M.CuloareOchi,M.CuloarePar, M.LocNastere, M.Cetatenie, M.CompanieID,C.NumeCompanie "
				+ " FROM Model M join Companie C on M.CompanieID = C.CompanieID" ;
		s1 = "SELECT NumeCompanie FROM Companie";
		s2 = "SELECT NumeEveniment FROM Evenimente";
		s3 = "SELECT AgendaID FROM Participa";
		

		
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
		
		JLabel lblTitluModel = new JLabel("MODELE");
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
		   
		   table.getColumnModel().getColumn(13).setMinWidth(0);
		   table.getColumnModel().getColumn(13).setMaxWidth(0);
		   table.getColumnModel().getColumn(13).setWidth(0);
		   
		   nrNewID = (Integer) table.getValueAt(table.getRowCount()-1,0) + 5;
		   
			try {
				while (rs4.next()) {
					nrNewID2  = rs4.getInt("AgendaID");
	}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			nrNewID2 += 1;
		   
		   TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
		   JLabel headerLabel = (JLabel) rendererFromHeader;
		   headerLabel.setHorizontalAlignment(JLabel.CENTER);
		   
		   
		String path = "C:\\Users\\user\\Desktop\\POLI\\ANUL --- 3\\SEMESTRUL --- I\\JAVA si Aplicatii WEB\\AgentieFotomodele\\Resources\\1.jpg";
		String pPath = "C:\\Users\\user\\Desktop\\POLI\\ANUL --- 3\\SEMESTRUL --- I\\JAVA si Aplicatii WEB\\AgentieFotomodele\\Resources\\";
		ImageIcon imageIcon = new ImageIcon(path);
		
		lblImageModel = new JLabel(imageIcon);
		lblImageModel.setBounds(24, 365, 342, 335);
		frame.getContentPane().add(lblImageModel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(372, 408, 947, 283);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("ADD MODEL", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNume = new JLabel("Nume");
		lblNume.setBounds(22, 24, 86, 14);
		panel.add(lblNume);
		
		JLabel lblPrenume = new JLabel("Prenume");
		lblPrenume.setBounds(143, 24, 86, 14);
		panel.add(lblPrenume);
		
		textFieldNume = new JTextField();
		textFieldNume.setBounds(22, 44, 86, 20);
		panel.add(textFieldNume);
		textFieldNume.setColumns(10);
		
		textFieldPrenume = new JTextField();
		textFieldPrenume.setColumns(10);
		textFieldPrenume.setBounds(143, 44, 86, 20);
		panel.add(textFieldPrenume);
		
		JLabel lblMarimeBust = new JLabel("Marime Bust");
		lblMarimeBust.setBounds(37, 92, 192, 14);
		panel.add(lblMarimeBust);
		
		JLabel lblMarimeTalie = new JLabel("Marime Talie");
		lblMarimeTalie.setBounds(37, 145, 192, 14);
		panel.add(lblMarimeTalie);
		
		JLabel lblMarimeSolduri = new JLabel("Marime Solduri");
		lblMarimeSolduri.setBounds(37, 190, 192, 14);
		panel.add(lblMarimeSolduri);
		
		textFieldBust = new JTextField();
		textFieldBust.setColumns(10);
		textFieldBust.setBounds(37, 109, 192, 20);
		panel.add(textFieldBust);
		
		textFieldTalie = new JTextField();
		textFieldTalie.setColumns(10);
		textFieldTalie.setBounds(37, 159, 192, 20);
		panel.add(textFieldTalie);
		
		textFieldSolduri = new JTextField();
		textFieldSolduri.setColumns(10);
		textFieldSolduri.setBounds(37, 206, 192, 20);
		panel.add(textFieldSolduri);
		
		JLabel lblDataNasterii = new JLabel("Data Nasterii");
		lblDataNasterii.setBounds(268, 24, 108, 14);
		panel.add(lblDataNasterii);
		
		textFieldDataNasterii = new JTextField();
		textFieldDataNasterii.setColumns(10);
		textFieldDataNasterii.setBounds(268, 44, 144, 20);
		panel.add(textFieldDataNasterii);
		
		JLabel lblInaltime = new JLabel("Inaltime");
		lblInaltime.setBounds(268, 112, 108, 14);
		panel.add(lblInaltime);
		
		JLabel lblGreutate = new JLabel("Greutate");
		lblGreutate.setBounds(268, 162, 108, 14);
		panel.add(lblGreutate);
		
		textFieldInaltime = new JTextField();
		textFieldInaltime.setColumns(10);
		textFieldInaltime.setBounds(268, 130, 108, 20);
		panel.add(textFieldInaltime);
		
		textFieldGreutate = new JTextField();
		textFieldGreutate.setColumns(10);
		textFieldGreutate.setBounds(268, 184, 108, 20);
		panel.add(textFieldGreutate);
		
		JLabel lblCm = new JLabel("cm");
		lblCm.setBounds(386, 130, 46, 14);
		panel.add(lblCm);
		
		JLabel lblKg = new JLabel("kg");
		lblKg.setBounds(386, 190, 46, 14);
		panel.add(lblKg);
		
		JLabel lblCuloareOchi = new JLabel("Culoare ochi");
		lblCuloareOchi.setBounds(442, 112, 94, 14);
		panel.add(lblCuloareOchi);
		
		textFieldOchi = new JTextField();
		textFieldOchi.setColumns(10);
		textFieldOchi.setBounds(442, 130, 162, 20);
		panel.add(textFieldOchi);
		
		textFieldPar = new JTextField();
		textFieldPar.setColumns(10);
		textFieldPar.setBounds(442, 184, 162, 20);
		panel.add(textFieldPar);
		
		JLabel lblCuloarePar = new JLabel("Culoare par");
		lblCuloarePar.setBounds(442, 162, 94, 14);
		panel.add(lblCuloarePar);
		
		JLabel lblLoculNasterii = new JLabel("Tara de origine");
		lblLoculNasterii.setBounds(431, 24, 108, 14);
		panel.add(lblLoculNasterii);
		
		textFieldOrigine = new JTextField();
		textFieldOrigine.setColumns(10);
		textFieldOrigine.setBounds(540, 21, 264, 20);
		panel.add(textFieldOrigine);
		
		JLabel lblTaraDeResedinta = new JLabel("Tara cetatenie");
		lblTaraDeResedinta.setBounds(431, 65, 108, 14);
		panel.add(lblTaraDeResedinta);
		
		textFieldResedinta = new JTextField();
		textFieldResedinta.setColumns(10);
		textFieldResedinta.setBounds(540, 62, 264, 20);
		panel.add(textFieldResedinta);
		
		
		JComboBox comboBoxCompanie = new JComboBox();
		comboBoxCompanie.setBounds(652, 109, 183, 20);
		panel.add(comboBoxCompanie);
		
		try {
			while (rs1.next()) {
				String em = rs1.getString("NumeCompanie");
				comboBoxCompanie.addItem(em);
}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JLabel lblCompanie = new JLabel("Companie");
		lblCompanie.setBounds(652, 92, 94, 14);
		panel.add(lblCompanie);
		
		DefaultListModel modelL = new DefaultListModel();
		int counter = 0;
		
		try {
			while (rs3.next()) {
				String em = rs3.getString("NumeEveniment");
				modelL.add(counter,em);
				counter++;
}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(652, 161, 264, 83);
		panel.add(scrollPane_1);
		JList list = new JList(modelL);
		scrollPane_1.setViewportView(list);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nume = textFieldNume.getText();
				String prenume = textFieldPrenume.getText();
				String dataNasterii = textFieldDataNasterii.getText();
				if(dataNasterii == "") dataNasterii = "1990-01-01";
				String inaltime = textFieldInaltime.getText();
				if(inaltime == "") inaltime = "180";
				String greutate = textFieldGreutate.getText();
				if(greutate == "") greutate = "50";
				String bust = textFieldBust.getText();
				if(bust == null) bust = "90";
				String talie = textFieldTalie.getText();
				if(talie == null) talie = "60";
				String solduri = textFieldSolduri.getText();
				if(solduri == null) solduri = "90";
				String culoareOchi = textFieldOchi.getText();
				if(culoareOchi == "") culoareOchi = "caprui";
				String culoarePar = textFieldPar.getText();
				if(culoarePar == "") culoarePar = "saten";
				String locNastere = textFieldOrigine.getText();
				if(locNastere == "") locNastere = "USA";
				String cetatenie = textFieldResedinta.getText();
				if(cetatenie == "") cetatenie = "USA";
				Integer compId = comboBoxCompanie.getSelectedIndex() + 1;
				
				int[] eventsIndex = list.getSelectedIndices();
								
				String sNew = "INSERT INTO Model " 
						+ "VALUES ( " + nrNewID + ", '" + nume + "', '" + prenume + "', '" + dataNasterii + "', '" + inaltime + "', '" + greutate + "', '" + bust + "', '" + talie + "', '" + solduri + "', '"
						+ culoareOchi + "', '" + culoarePar + "', '" + locNastere + "', '" + cetatenie + "', " + compId + " )" ;
				boolean b = Update(sNew);
				
				for(int i: eventsIndex){
					int eventNr = i+1; 
				String s2New = "INSERT INTO Participa "+
						 "VALUES ( " + nrNewID2 + ", " + nrNewID + ", " + eventNr + ")";
					Update(s2New);
					nrNewID2++;
				}
				
				if(b) {
					JOptionPane.showMessageDialog(frame, "Modelul a fost adaugat in baza de date"); 
					new ModeleTabel();
					frame.dispose();
				}
				else JOptionPane.showMessageDialog(frame, "Va rugam respectati restrictiile privind tipul si lungimea datelor");
				
				
			}
		});
		btnInsert.setBounds(827, 43, 89, 23);
		panel.add(btnInsert);
		
		JLabel lblEvenimente = new JLabel("Evenimente");
		lblEvenimente.setBounds(652, 145, 94, 14);
		panel.add(lblEvenimente);
	
		
		
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("UPDATE MODEL", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNume2 = new JLabel("Nume");
		lblNume2.setBounds(22, 24, 86, 14);
		panel_1.add(lblNume2);
		
		JLabel lblPrenume2 = new JLabel("Prenume");
		lblPrenume2.setBounds(143, 24, 86, 14);
		panel_1.add(lblPrenume2);
		
		textFieldNume2 = new JTextField();
		textFieldNume2.setBounds(22, 44, 86, 20);
		panel_1.add(textFieldNume2);
		textFieldNume2.setColumns(10);
		
		textFieldPrenume2 = new JTextField();
		textFieldPrenume2.setColumns(10);
		textFieldPrenume2.setBounds(143, 44, 86, 20);
		panel_1.add(textFieldPrenume2);
		
		JLabel lblMarimeBust2 = new JLabel("Marime Bust");
		lblMarimeBust2.setBounds(37, 92, 192, 14);
		panel_1.add(lblMarimeBust2);
		
		JLabel lblMarimeTalie2 = new JLabel("Marime Talie");
		lblMarimeTalie2.setBounds(37, 145, 192, 14);
		panel_1.add(lblMarimeTalie2);
		
		JLabel lblMarimeSolduri2 = new JLabel("Marime Solduri");
		lblMarimeSolduri2.setBounds(37, 190, 192, 14);
		panel_1.add(lblMarimeSolduri2);
		
		textFieldBust2 = new JTextField();
		textFieldBust2.setColumns(10);
		textFieldBust2.setBounds(37, 109, 192, 20);
		panel_1.add(textFieldBust2);
		
		textFieldTalie2 = new JTextField();
		textFieldTalie2.setColumns(10);
		textFieldTalie2.setBounds(37, 159, 192, 20);
		panel_1.add(textFieldTalie2);
		
		textFieldSolduri2 = new JTextField();
		textFieldSolduri2.setColumns(10);
		textFieldSolduri2.setBounds(37, 206, 192, 20);
		panel_1.add(textFieldSolduri2);
		
		JLabel lblDataNasterii2 = new JLabel("Data Nasterii");
		lblDataNasterii2.setBounds(268, 24, 108, 14);
		panel_1.add(lblDataNasterii2);
		
		textFieldDataNasterii2 = new JTextField();
		textFieldDataNasterii2.setColumns(10);
		textFieldDataNasterii2.setBounds(268, 44, 144, 20);
		panel_1.add(textFieldDataNasterii2);
		
		JLabel lblInaltime2 = new JLabel("Inaltime");
		lblInaltime2.setBounds(268, 112, 108, 14);
		panel_1.add(lblInaltime2);
		
		JLabel lblGreutate2 = new JLabel("Greutate");
		lblGreutate2.setBounds(268, 162, 108, 14);
		panel_1.add(lblGreutate2);
		
		textFieldInaltime2 = new JTextField();
		textFieldInaltime2.setColumns(10);
		textFieldInaltime2.setBounds(268, 130, 108, 20);
		panel_1.add(textFieldInaltime2);
		
		textFieldGreutate2 = new JTextField();
		textFieldGreutate2.setColumns(10);
		textFieldGreutate2.setBounds(268, 184, 108, 20);
		panel_1.add(textFieldGreutate2);
		
		JLabel lblCm2 = new JLabel("cm");
		lblCm2.setBounds(386, 130, 46, 14);
		panel_1.add(lblCm2);
		
		JLabel lblKg2 = new JLabel("kg");
		lblKg2.setBounds(386, 190, 46, 14);
		panel_1.add(lblKg2);
		
		JLabel lblCuloareOchi2 = new JLabel("Culoare ochi");
		lblCuloareOchi2.setBounds(442, 112, 94, 14);
		panel_1.add(lblCuloareOchi2);
		
		textFieldOchi2 = new JTextField();
		textFieldOchi2.setColumns(10);
		textFieldOchi2.setBounds(442, 130, 162, 20);
		panel_1.add(textFieldOchi2);
		
		textFieldPar2 = new JTextField();
		textFieldPar2.setColumns(10);
		textFieldPar2.setBounds(442, 184, 162, 20);
		panel_1.add(textFieldPar2);
		
		JLabel lblCuloarePar2 = new JLabel("Culoare par");
		lblCuloarePar2.setBounds(442, 162, 94, 14);
		panel_1.add(lblCuloarePar2);
		
		JLabel lblLoculNasterii2 = new JLabel("Tara de origine");
		lblLoculNasterii2.setBounds(431, 24, 108, 14);
		panel_1.add(lblLoculNasterii2);
		
		textFieldOrigine2 = new JTextField();
		textFieldOrigine2.setColumns(10);
		textFieldOrigine2.setBounds(540, 21, 264, 20);
		panel_1.add(textFieldOrigine2);
		
		JLabel lblTaraDeResedinta2 = new JLabel("Tara cetatenie");
		lblTaraDeResedinta2.setBounds(431, 65, 108, 14);
		panel_1.add(lblTaraDeResedinta2);
		
		textFieldResedinta2 = new JTextField();
		textFieldResedinta2.setColumns(10);
		textFieldResedinta2.setBounds(540, 62, 264, 20);
		panel_1.add(textFieldResedinta2);
		
		
		JComboBox comboBoxCompanie2 = new JComboBox();
		comboBoxCompanie2.setBounds(707, 130, 183, 20);
		panel_1.add(comboBoxCompanie2);
		
		try {
			while (rs2.next()) {
				String em = rs2.getString("NumeCompanie");
				comboBoxCompanie2.addItem(em);
}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JLabel lblCompanie2 = new JLabel("Companie");
		lblCompanie2.setBounds(707, 112, 97, 14);
		panel_1.add(lblCompanie2);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nume = textFieldNume2.getText();
				String prenume = textFieldPrenume2.getText();
				String dataNasterii = textFieldDataNasterii2.getText();
				if(dataNasterii == "") dataNasterii = "1990-01-01";
				String inaltime = textFieldInaltime2.getText();
				if(inaltime == "") inaltime = "180";
				String greutate = textFieldGreutate2.getText();
				if(greutate == "") greutate = "50";
				String bust = textFieldBust2.getText();
				if(bust == null) bust = "90";
				String talie = textFieldTalie2.getText();
				if(talie == null) talie = "60";
				String solduri = textFieldSolduri2.getText();
				if(solduri == null) solduri = "90";
				String culoareOchi = textFieldOchi2.getText();
				if(culoareOchi == "") culoareOchi = "caprui";
				String culoarePar = textFieldPar2.getText();
				if(culoarePar == "") culoarePar = "saten";
				String locNastere = textFieldOrigine2.getText();
				if(locNastere == "") locNastere = "USA";
				String cetatenie = textFieldResedinta2.getText();
				if(cetatenie == "") cetatenie = "USA";
				Integer compId = comboBoxCompanie2.getSelectedIndex() + 1;
				Integer idMod = (Integer) table.getValueAt(table.getSelectedRow(),0);
								
				String sUp = "UPDATE Model "
						+ "SET Nume = '" + nume + "', Prenume = '" + prenume + "', DataNasterii = '" + dataNasterii + "', Inaltime = '" + inaltime + "', Greutate = '"
						+ greutate + "', Bust = '" + bust + "', Talie = '" + talie + "', Solduri = '" + solduri + "', CuloareOchi = '" + culoareOchi + "', CuloarePar = '" + culoarePar
						+ "', LocNastere = '" + locNastere + "', Cetatenie = '" + cetatenie + "', CompanieID = '" + compId
						+ "' WHERE ModelID = '" + idMod + "';"; 
				
				boolean b = Update(sUp);
				
				if(b) {
					JOptionPane.showMessageDialog(frame, "Datele au fost actualizate in baza de date"); 
					new ModeleTabel();
					frame.dispose();
				}
				else JOptionPane.showMessageDialog(frame, "Va rugam respectati restrictiile privind tipul si lungimea datelor");
				
			}
		});
		btnUpdate.setBounds(827, 43, 89, 23);
		panel_1.add(btnUpdate);
		
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("DELETE MODEL", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNume23 = new JLabel("Nume");
		lblNume23.setBounds(22, 24, 86, 14);
		panel_2.add(lblNume23);
		
		JLabel lblPrenume23 = new JLabel("Prenume");
		lblPrenume23.setBounds(143, 24, 86, 14);
		panel_2.add(lblPrenume23);
		
		JLabel lblMarimeBust23 = new JLabel("Marime Bust");
		lblMarimeBust23.setBounds(37, 92, 192, 14);
		panel_2.add(lblMarimeBust23);
		
		JLabel lblMarimeTalie23 = new JLabel("Marime Talie");
		lblMarimeTalie23.setBounds(37, 145, 192, 14);
		panel_2.add(lblMarimeTalie23);
		
		JLabel lblMarimeSolduri23 = new JLabel("Marime Solduri");
		lblMarimeSolduri23.setBounds(37, 190, 192, 14);
		panel_2.add(lblMarimeSolduri23);
		
		JLabel lblDataNasterii23 = new JLabel("Data Nasterii");
		lblDataNasterii23.setBounds(268, 24, 108, 14);
		panel_2.add(lblDataNasterii23);
		
		JLabel lblInaltime23 = new JLabel("Inaltime");
		lblInaltime23.setBounds(279, 112, 108, 14);
		panel_2.add(lblInaltime23);
		
		JLabel lblGreutate23 = new JLabel("Greutate");
		lblGreutate23.setBounds(279, 170, 108, 14);
		panel_2.add(lblGreutate23);
		
		JLabel lblCm23 = new JLabel("cm");
		lblCm23.setBounds(397, 139, 46, 14);
		panel_2.add(lblCm23);
		
		JLabel lblKg23 = new JLabel("kg");
		lblKg23.setBounds(397, 190, 46, 14);
		panel_2.add(lblKg23);
		
		JLabel lblCuloareOchi23 = new JLabel("Culoare ochi");
		lblCuloareOchi23.setBounds(553, 112, 94, 14);
		panel_2.add(lblCuloareOchi23);
		
		JLabel lblCuloarePar23 = new JLabel("Culoare par");
		lblCuloarePar23.setBounds(555, 170, 94, 14);
		panel_2.add(lblCuloarePar23);
		
		JLabel lblLoculNasterii23 = new JLabel("Tara de origine");
		lblLoculNasterii23.setBounds(431, 24, 108, 14);
		panel_2.add(lblLoculNasterii23);
		
		JLabel lblTaraDeResedinta23 = new JLabel("Tara de resedinta");
		lblTaraDeResedinta23.setBounds(431, 65, 108, 14);
		panel_2.add(lblTaraDeResedinta23);	
		
		JLabel lblCompanie23 = new JLabel("Companie");
		lblCompanie23.setBounds(780, 24, 94, 14);
		panel_2.add(lblCompanie23);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer idMod = (Integer) table.getValueAt(table.getSelectedRow(),0);
				
				String sDel = "DELETE FROM Model "
						+ "WHERE ModelID = '"+ idMod + "'";
				
				String s2Del = "DELETE FROM Participa "+
							"WHERE ModelID = " + idMod ;
				 		
				boolean b = Update(sDel);
				Update(s2Del);
				
				
				String strPath = "C:\\Users\\user\\Desktop\\POLI\\ANUL --- 3\\SEMESTRUL --- I\\JAVA si Aplicatii WEB\\AgentieFotomodele\\Resources\\" + idMod + ".jpg";
				Path pathDel = Paths.get(strPath);
				File f = new File(strPath);
				
				if(b) {
					JOptionPane.showMessageDialog(frame, "Modelul a fost sters din baza de date !"); 
					try {
						Files.deleteIfExists(pathDel);
						new ModeleTabel();
						frame.dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnDelete.setBounds(693, 140, 221, 44);
		panel_2.add(btnDelete);
		
		JLabel lblNume3 = new JLabel("NUME");
		lblNume3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNume3.setBounds(22, 49, 108, 14);
		panel_2.add(lblNume3);
		
		JLabel lblPrenume3 = new JLabel("PRENUME");
		lblPrenume3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrenume3.setBounds(143, 49, 108, 14);
		panel_2.add(lblPrenume3);
		
		JLabel lblBust = new JLabel("BUST");
		lblBust.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBust.setBounds(37, 112, 108, 14);
		panel_2.add(lblBust);
		
		JLabel lblTalie = new JLabel("TALIE");
		lblTalie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTalie.setBounds(37, 165, 108, 14);
		panel_2.add(lblTalie);
		
		JLabel lblSolduri = new JLabel("SOLDURI");
		lblSolduri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSolduri.setBounds(37, 211, 108, 14);
		panel_2.add(lblSolduri);
		
		JLabel lblDataNasterii3 = new JLabel("DATA NASTERII");
		lblDataNasterii3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDataNasterii3.setBounds(268, 49, 140, 14);
		panel_2.add(lblDataNasterii3);
		
		JLabel lblInaltime3 = new JLabel("INALTIME");
		lblInaltime3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInaltime3.setBounds(279, 137, 108, 14);
		panel_2.add(lblInaltime3);
		
		JLabel lblGreutate3 = new JLabel("GREUTATE");
		lblGreutate3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGreutate3.setBounds(279, 190, 108, 14);
		panel_2.add(lblGreutate3);
		
		JLabel lblOrigine3 = new JLabel("ORIGINE");
		lblOrigine3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOrigine3.setBounds(539, 24, 140, 14);
		panel_2.add(lblOrigine3);
		
		JLabel lblResedinta3 = new JLabel("RESEDINTA");
		lblResedinta3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResedinta3.setBounds(539, 65, 140, 14);
		panel_2.add(lblResedinta3);
		
		JLabel lblOchi3 = new JLabel("OCHI");
		lblOchi3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOchi3.setBounds(553, 130, 108, 14);
		panel_2.add(lblOchi3);
		
		JLabel lblPar3 = new JLabel("PAR");
		lblPar3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPar3.setBounds(553, 190, 108, 14);
		panel_2.add(lblPar3);
		
		JLabel lblCompanie3 = new JLabel("COMPANIE");
		lblCompanie3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCompanie3.setBounds(806, 49, 108, 14);
		panel_2.add(lblCompanie3);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Evenimente", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 922, 233);
		panel_3.add(scrollPane_2);
		
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
		
		JLabel lblPentruCa = new JLabel("***   Dimensiuni maxime admise: Nume, Prenume (30), Culoare Ochi, Culoare Par (10), Tara de origine, Tara cetatenie (20)");
		lblPentruCa.setBounds(382, 691, 937, 14);
		frame.getContentPane().add(lblPentruCa);
		
		JLabel lblPentruCampurile = new JLabel("***   Pentru campurile Marime Bust, Marime Talie, Marime Solduri, Inaltime, Greutate nu introduceti decat valori numerice in intervalul 0 - 255");
		lblPentruCampurile.setBounds(382, 710, 937, 14);
		frame.getContentPane().add(lblPentruCampurile);
		
		JLabel lblPentruCampul = new JLabel("***   Pentru campul Data Nasterii respectati formatul 'AAAA-LL-ZZ'");
		lblPentruCampul.setBounds(382, 725, 937, 14);
		frame.getContentPane().add(lblPentruCampul);
		
		frame.setResizable(false);     
		frame.setVisible(true);
				
				
		ListSelectionModel model = table.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(! model.isSelectionEmpty()){

					Integer i = (Integer) table.getValueAt(table.getSelectedRow(),0);

					ImageIcon imageIcon = new ImageIcon(pPath+""+i+".jpg");
					lblImageModel.setIcon(imageIcon);
					imageIcon = null;
					
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
					
					s = (String) table.getValueAt(table.getSelectedRow(),4).toString();
					textFieldInaltime2.setText(s);
					lblInaltime3.setText(s);
					
					s = (String) table.getValueAt(table.getSelectedRow(),5).toString();
					textFieldGreutate2.setText(s);
					lblGreutate3.setText(s);
					
					s = (String) table.getValueAt(table.getSelectedRow(),6).toString();
					textFieldBust2.setText(s);
					lblBust.setText(s);
					
					s = (String) table.getValueAt(table.getSelectedRow(),7).toString();
					textFieldTalie2.setText(s);
					lblTalie.setText(s);
					
					s = (String) table.getValueAt(table.getSelectedRow(),8).toString();
					textFieldSolduri2.setText(s);
					lblSolduri.setText(s);
					
					s = (String) table.getValueAt(table.getSelectedRow(),9);
					textFieldOchi2.setText(s);
					lblOchi3.setText(s);
					
					s = (String) table.getValueAt(table.getSelectedRow(),10);
					textFieldPar2.setText(s);
					lblPar3.setText(s);
					
					s = (String) table.getValueAt(table.getSelectedRow(),11);
					textFieldOrigine2.setText(s);
					lblOrigine3.setText(s);
					
					s = (String) table.getValueAt(table.getSelectedRow(),12);
					textFieldResedinta2.setText(s);
					lblResedinta3.setText(s);
		
					
					i = (Integer) table.getValueAt(table.getSelectedRow(),13);
					comboBoxCompanie2.setSelectedIndex(i-1);
					
					s = (String) table.getValueAt(table.getSelectedRow(),14);
					lblCompanie3.setText(s);
					
					
					s4 = "select NumeEveniment, Locatie, DataEveniment "+
							"from Evenimente E join Participa P on E.EvenimentID = P.EvenimentID "+
								"where P.ModelID = "+ table.getValueAt(table.getSelectedRow(),0).toString()   ;
					ResultSet rs5 = Query(s4);
					
					
					table_1.setModel(DbUtils.resultSetToTableModel(rs5));		
					
				}
			}
			
		});
	}
}
