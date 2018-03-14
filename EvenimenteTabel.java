import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;

import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class EvenimenteTabel extends SQLDatabaseConnection{

	private JFrame frame;
	private JTable table;
	private JLabel lblImageModel;
	private String s;
	private int nrNewID;
	private JTextField eventI;
	private JTextField locationI;
	private JTextField dateI;
	private JTextField eventU;
	private JTextField locationU;
	private JTextField dateU;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EvenimenteTabel window = new EvenimenteTabel();
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
	public EvenimenteTabel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		s = "select * , (select count(*) from Participa "+
							"where EvenimentID = E.EvenimentID "+ 
								"group by EvenimentID) as 'Numar Participanti'"+
				"from Evenimente E";
		
		ResultSet rs = Query(s);
		
		
		frame = new JFrame();
		frame.setBounds(0, 0, 1380, 750);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblTitluModel = new JLabel("EVENIMENTE");
		lblTitluModel.setBounds(10, 10, 1342, 63);
		lblTitluModel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 50));
		lblTitluModel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblTitluModel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 1342, 201);
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
		   
		   
		   nrNewID = (Integer) table.getValueAt(table.getRowCount()-1,0) + 5;
		   
		   TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
		   JLabel headerLabel = (JLabel) rendererFromHeader;
		   headerLabel.setHorizontalAlignment(JLabel.CENTER);
		   
		   
		String path = "C:\\Users\\user\\Desktop\\POLI\\ANUL --- 3\\SEMESTRUL --- I\\JAVA si Aplicatii WEB\\AgentieFotomodele\\Resources\\event1.jpg";
		String pPath = "C:\\Users\\user\\Desktop\\POLI\\ANUL --- 3\\SEMESTRUL --- I\\JAVA si Aplicatii WEB\\AgentieFotomodele\\Resources\\event";
		ImageIcon imageIcon = new ImageIcon(path);
		
		lblImageModel = new JLabel(imageIcon);
		lblImageModel.setBounds(24, 365, 342, 335);
		frame.getContentPane().add(lblImageModel);
		
		eventI = new JTextField();
		eventI.setBounds(514, 437, 221, 20);
		frame.getContentPane().add(eventI);
		eventI.setColumns(10);
		
		JLabel lblNumeEveniment = new JLabel("Nume Eveniment");
		lblNumeEveniment.setBounds(514, 406, 221, 20);
		frame.getContentPane().add(lblNumeEveniment);
		
		JLabel lblLocatie = new JLabel("Locatie");
		lblLocatie.setBounds(514, 492, 221, 20);
		frame.getContentPane().add(lblLocatie);
		
		locationI = new JTextField();
		locationI.setColumns(10);
		locationI.setBounds(514, 523, 221, 20);
		frame.getContentPane().add(locationI);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(514, 564, 221, 20);
		frame.getContentPane().add(lblData);
		
		dateI = new JTextField();
		dateI.setColumns(10);
		dateI.setBounds(514, 595, 221, 20);
		frame.getContentPane().add(dateI);
		
		JLabel label_2 = new JLabel("Nume Eveniment");
		label_2.setBounds(788, 406, 229, 20);
		frame.getContentPane().add(label_2);
		
		eventU = new JTextField();
		eventU.setColumns(10);
		eventU.setBounds(788, 437, 229, 20);
		frame.getContentPane().add(eventU);
		
		locationU = new JTextField();
		locationU.setColumns(10);
		locationU.setBounds(788, 523, 229, 20);
		frame.getContentPane().add(locationU);
		
		dateU = new JTextField();
		dateU.setColumns(10);
		dateU.setBounds(788, 595, 229, 20);
		frame.getContentPane().add(dateU);
		
		JLabel lblData_1 = new JLabel("Data");
		lblData_1.setBounds(788, 564, 229, 20);
		frame.getContentPane().add(lblData_1);
		
		JLabel lblLocatie_1 = new JLabel("Locatie");
		lblLocatie_1.setBounds(788, 492, 229, 20);
		frame.getContentPane().add(lblLocatie_1);
		
		JLabel label_5 = new JLabel("Nume Eveniment");
		label_5.setBounds(1114, 406, 175, 20);
		frame.getContentPane().add(label_5);
		
		JLabel lblLocatie_2 = new JLabel("Locatie");
		lblLocatie_2.setBounds(1114, 492, 175, 20);
		frame.getContentPane().add(lblLocatie_2);
		
		JLabel lblData_2 = new JLabel("Data");
		lblData_2.setBounds(1114, 564, 175, 20);
		frame.getContentPane().add(lblData_2);
		
		JLabel eventD = new JLabel("Nume Eveniment");
		eventD.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		eventD.setBounds(1114, 437, 238, 20);
		frame.getContentPane().add(eventD);
		
		JLabel locationD = new JLabel("Locatie Eveniment");
		locationD.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		locationD.setBounds(1114, 521, 238, 20);
		frame.getContentPane().add(locationD);
		
		JLabel dateD = new JLabel("Data Eveniment");
		dateD.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		dateD.setBounds(1114, 595, 238, 20);
		frame.getContentPane().add(dateD);
		
		JLabel lblInsert = new JLabel("INSERT");
		lblInsert.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		lblInsert.setBounds(514, 350, 175, 20);
		frame.getContentPane().add(lblInsert);
		
		JLabel lblUpdate = new JLabel("UPDATE");
		lblUpdate.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		lblUpdate.setBounds(788, 350, 175, 20);
		frame.getContentPane().add(lblUpdate);
		
		JLabel lblDelete = new JLabel("DELETE");
		lblDelete.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		lblDelete.setBounds(1114, 350, 175, 20);
		frame.getContentPane().add(lblDelete);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String nume = eventI.getText();
				String locatie = locationI.getText();
				String data = dateI.getText().toString();
				
				
				String s3 = "INSERT INTO Evenimente "
						+ "VALUES ( " + nrNewID + ", '" + nume + "', '" + locatie + "', '" + data + "' );" ;
				boolean b = Update(s3);
				
				if(b) {
					JOptionPane.showMessageDialog(frame, "Evenimentul a fost adaugat in baza de date"); 
					new EvenimenteTabel();
					frame.dispose();
				}
				else JOptionPane.showMessageDialog(frame, "Va rugam respectati restrictiile privind tipul si lungimea datelor");
				
			}
		});
		btnInsert.setBounds(514, 648, 175, 23);
		frame.getContentPane().add(btnInsert);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nume = eventU.getText();
				String locatie = locationU.getText();
				String data = dateU.getText().toString();
				Integer idMod = (Integer) table.getValueAt(table.getSelectedRow(),0);
				
				
				String s3 = "UPDATE Evenimente "
						+ "SET NumeEveniment = '" + nume + "', Locatie = '" + locatie + "', DataEveniment = '" + data
						+ "' WHERE EvenimentID = '" + idMod + "';"; 
				boolean b = Update(s3);
				
				if(b) {
					JOptionPane.showMessageDialog(frame, "Datele au fost actualizate in baza de date"); 
					new EvenimenteTabel();
					frame.dispose();
				}
				else JOptionPane.showMessageDialog(frame, "Va rugam respectati restrictiile privind tipul si lungimea datelor");
			}
		});
		btnUpdate.setBounds(788, 648, 175, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Integer idMod = (Integer) table.getValueAt(table.getSelectedRow(),0);
				
				String s3 = "DELETE FROM Evenimente "
						+ "WHERE EvenimentID = '"+ idMod + "';";
				boolean b = Update(s3);
				
				if(b) {
					JOptionPane.showMessageDialog(frame, "Modelul a fost sters din baza de date !"); 
					new EvenimenteTabel();
					frame.dispose();
				}
			}
		});
		btnDelete.setBounds(1114, 648, 175, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnMenu = new JButton("Inapoi la Meniu");
		btnMenu.setFont(new Font("Sylfaen", Font.BOLD, 20));
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainWindow();
				frame.dispose();
			}
		});
		btnMenu.setBounds(1060, 291, 292, 35);
		frame.getContentPane().add(btnMenu);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(759, 406, 19, 285);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(1060, 406, 26, 285);
		frame.getContentPane().add(separator_1);
		
		JLabel label = new JLabel("***   Pentru campul Data, respectati formatul AAAA-LL-ZZ");
		label.setBounds(514, 725, 536, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("***   Lungimea maxima admisa pentru campurile Nume Eveniment si Locatie sunt 30 respectiv 50");
		label_1.setBounds(514, 711, 838, 14);
		frame.getContentPane().add(label_1);
		
		
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
					eventU.setText(s);
					eventD.setText(s);
					
					s = (String) table.getValueAt(table.getSelectedRow(),2);
					locationU.setText(s);
					locationD.setText(s);
					
					Date d = null;
					d = (Date) table.getValueAt(table.getSelectedRow(),3);
					dateU.setText(d.toString());
					dateD.setText(s);
					
				}
			}
			
		});
		
	}
}
