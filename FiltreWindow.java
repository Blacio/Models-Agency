import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FiltreWindow extends SQLDatabaseConnection{

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JRadioButton rdbtnNume;
	private JRadioButton rdbtnTaraCetatenie;
	private JRadioButton rdbtnDataNasterii;
	private JRadioButton rdbtnTaraOrigine;
	private JRadioButton rdbtnCuloareOchi;
	private JRadioButton rdbtnPrenume;
	private JTextField tfnume;
	private JTextField tfprenume;
	private JTextField tfdata;
	private JTextField tforigine;
	private JTextField tfresedinta;
	private JTextField tfochi;
	private JTextField tfinaltime;
	private JTextField tfgreutate;
	private JTextField tfpar;
	private JRadioButton rdbtnMarimeBust;
	private JTextField tfbust;
	private JRadioButton rdbtnMarimeTalie;
	private JRadioButton rdbtnMarimeSolduri;
	private JTextField tftalie;
	private JTextField tfsolduri;
	private JButton btnNewButton;
	private JTextField tfgreutate2;
	private JTextField tfinaltime2;
	private JTextField tfbust2;
	private JTextField tftalie2;
	private JTextField tfsolduri2;
	private JTextField tfdata2;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JTable table;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FiltreWindow window = new FiltreWindow();
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
	public FiltreWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		String auxS = "SELECT NumeCompanie FROM Companie";
		ResultSet auxRs = Query(auxS);
		
		
		frame = new JFrame();
		frame.setBounds(0, 0, 1380, 750);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitluModel = new JLabel("FILTRE");
		lblTitluModel.setBounds(304, 10, 733, 63);
		lblTitluModel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 50));
		lblTitluModel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblTitluModel);
		
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(53, 65, 1253, 301);
		frame.getContentPane().add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("CAUTA MODEL", null, panel, null);
		panel.setLayout(null);
		
		rdbtnNume = new JRadioButton("Nume");
		rdbtnNume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfnume.isEditable())
					tfnume.setEditable(false);
				else tfnume.setEditable(true);
			}
		});
		rdbtnNume.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		rdbtnNume.setBounds(36, 28, 109, 23);
		panel.add(rdbtnNume);
		
		rdbtnTaraCetatenie = new JRadioButton("Tara Resedinta");
		rdbtnTaraCetatenie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfresedinta.isEditable())
					tfresedinta.setEditable(false);
				else tfresedinta.setEditable(true);
			}
		});
		rdbtnTaraCetatenie.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		rdbtnTaraCetatenie.setBounds(252, 112, 145, 23);
		panel.add(rdbtnTaraCetatenie);
		
		rdbtnDataNasterii = new JRadioButton("Data Nasterii");
		rdbtnDataNasterii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfdata.isEditable()){
					tfdata.setEditable(false);
					tfdata2.setEditable(false);
				}
				else {
					tfdata.setEditable(true);
					tfdata2.setEditable(true);
				}
			}
		});
		rdbtnDataNasterii.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		rdbtnDataNasterii.setBounds(36, 189, 139, 23);
		panel.add(rdbtnDataNasterii);
		
		rdbtnTaraOrigine = new JRadioButton("Tara Origine");
		rdbtnTaraOrigine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tforigine.isEditable())
					tforigine.setEditable(false);
				else tforigine.setEditable(true);
			}
		});
		rdbtnTaraOrigine.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		rdbtnTaraOrigine.setBounds(252, 28, 145, 23);
		panel.add(rdbtnTaraOrigine);
		
		rdbtnCuloareOchi = new JRadioButton("Culoare Ochi");
		rdbtnCuloareOchi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfochi.isEditable())
					tfochi.setEditable(false);
				else tfochi.setEditable(true);
			}
		});
		rdbtnCuloareOchi.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		rdbtnCuloareOchi.setBounds(1093, 28, 129, 23);
		panel.add(rdbtnCuloareOchi);
		
		rdbtnPrenume = new JRadioButton("Prenume");
		rdbtnPrenume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfprenume.isEditable())
					tfprenume.setEditable(false);
				else tfprenume.setEditable(true);
			}
		});
		rdbtnPrenume.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		rdbtnPrenume.setBounds(36, 112, 109, 23);
		panel.add(rdbtnPrenume);
		
		JRadioButton rdbtnInaltime = new JRadioButton("Inaltime");
		rdbtnInaltime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfinaltime.isEditable()){
					tfinaltime.setEditable(false);
					tfinaltime2.setEditable(false);
				}
				else {
					tfinaltime.setEditable(true);
					tfinaltime2.setEditable(true);
				}
			}
		});
		rdbtnInaltime.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		rdbtnInaltime.setBounds(516, 28, 129, 23);
		panel.add(rdbtnInaltime);
		
		JRadioButton rdbtnGreutate = new JRadioButton("Greutate");
		rdbtnGreutate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfgreutate.isEditable()){
					tfgreutate.setEditable(false);
					tfgreutate2.setEditable(false);
				}
				else {
					tfgreutate.setEditable(true);
					tfgreutate2.setEditable(true);
				}
			}
		});
		rdbtnGreutate.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		rdbtnGreutate.setBounds(516, 112, 129, 23);
		panel.add(rdbtnGreutate);
		
		JRadioButton rdbtnCuloarePar = new JRadioButton("Culoare Par");
		rdbtnCuloarePar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfpar.isEditable())
					tfpar.setEditable(false);
				else tfpar.setEditable(true);
			}
		});
		rdbtnCuloarePar.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		rdbtnCuloarePar.setBounds(1093, 112, 109, 23);
		panel.add(rdbtnCuloarePar);
		
		tfnume = new JTextField();
		tfnume.setEditable(false);
		tfnume.setBounds(36, 58, 119, 20);
		panel.add(tfnume);
		tfnume.setColumns(10);
		
		tfprenume = new JTextField();
		tfprenume.setColumns(10);
		tfprenume.setEditable(false);
		tfprenume.setBounds(36, 142, 119, 20);
		panel.add(tfprenume);
		tfprenume.setEditable(false);
		
		tfdata = new JTextField();
		tfdata.setEditable(false);
		tfdata.setColumns(10);
		tfdata.setBounds(36, 219, 161, 20);
		panel.add(tfdata);
		
		tforigine = new JTextField();
		tforigine.setEditable(false);
		tforigine.setColumns(10);
		tforigine.setBounds(252, 58, 145, 20);
		panel.add(tforigine);
		
		tfresedinta = new JTextField();
		tfresedinta.setEditable(false);
		tfresedinta.setColumns(10);
		tfresedinta.setBounds(252, 142, 145, 20);
		panel.add(tfresedinta);
		
		tfochi = new JTextField();
		tfochi.setEditable(false);
		tfochi.setColumns(10);
		tfochi.setBounds(1093, 58, 129, 20);
		panel.add(tfochi);
		
		tfinaltime = new JTextField();
		tfinaltime.setEditable(false);
		tfinaltime.setColumns(10);
		tfinaltime.setBounds(516, 58, 109, 20);
		panel.add(tfinaltime);
		
		tfgreutate = new JTextField();
		tfgreutate.setEditable(false);
		tfgreutate.setColumns(10);
		tfgreutate.setBounds(516, 142, 109, 20);
		panel.add(tfgreutate);
		
		tfpar = new JTextField();
		tfpar.setEditable(false);
		tfpar.setColumns(10);
		tfpar.setBounds(1093, 142, 129, 20);
		panel.add(tfpar);
		
		rdbtnMarimeBust = new JRadioButton("Marime Bust");
		rdbtnMarimeBust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfbust.isEditable()){
					tfbust.setEditable(false);
					tfbust2.setEditable(false);
				}
				else {
					tfbust.setEditable(true);
					tfbust2.setEditable(true);
				}
			}
		});
		rdbtnMarimeBust.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		rdbtnMarimeBust.setBounds(810, 28, 139, 23);
		panel.add(rdbtnMarimeBust);
		
		tfbust = new JTextField();
		tfbust.setEditable(false);
		tfbust.setColumns(10);
		tfbust.setBounds(810, 58, 109, 20);
		panel.add(tfbust);
		
		rdbtnMarimeTalie = new JRadioButton("Marime Talie");
		rdbtnMarimeTalie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tftalie.isEditable()){
					tftalie.setEditable(false);
					tftalie2.setEditable(false);
				}
				else {
					tftalie.setEditable(true);
					tftalie2.setEditable(true);
				}
			}
		});
		rdbtnMarimeTalie.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		rdbtnMarimeTalie.setBounds(810, 112, 139, 23);
		panel.add(rdbtnMarimeTalie);
		
		rdbtnMarimeSolduri = new JRadioButton("Marime solduri");
		rdbtnMarimeSolduri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfsolduri.isEditable()){
					tfsolduri.setEditable(false);
					tfsolduri2.setEditable(false);
				}
				else {
					tfsolduri.setEditable(true);
					tfsolduri2.setEditable(true);
				}
			}
		});
		rdbtnMarimeSolduri.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		rdbtnMarimeSolduri.setBounds(810, 189, 139, 23);
		panel.add(rdbtnMarimeSolduri);
		
		tftalie = new JTextField();
		tftalie.setEditable(false);
		tftalie.setColumns(10);
		tftalie.setBounds(810, 142, 109, 20);
		panel.add(tftalie);
		
		tfsolduri = new JTextField();
		tfsolduri.setEditable(false);
		tfsolduri.setColumns(10);
		tfsolduri.setBounds(810, 219, 109, 20);
		panel.add(tfsolduri);
		
		JComboBox cbcompanie = new JComboBox();
		cbcompanie.setEnabled(false);
		cbcompanie.setBounds(1093, 219, 129, 20);
		panel.add(cbcompanie);
		
		try {
			while (auxRs.next()) {
				String em = auxRs.getString("NumeCompanie");
				cbcompanie.addItem(em);
}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JRadioButton rdbtnCompanie = new JRadioButton("Companie");
		rdbtnCompanie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cbcompanie.isEnabled())
					cbcompanie.setEnabled(false);
				else cbcompanie.setEnabled(true);
			}
		});
		rdbtnCompanie.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		rdbtnCompanie.setBounds(1093, 189, 109, 23);
		panel.add(rdbtnCompanie);
		
		tfgreutate2 = new JTextField();
		tfgreutate2.setEditable(false);
		tfgreutate2.setColumns(10);
		tfgreutate2.setBounds(640, 142, 109, 20);
		panel.add(tfgreutate2);
		
		tfinaltime2 = new JTextField();
		tfinaltime2.setEditable(false);
		tfinaltime2.setColumns(10);
		tfinaltime2.setBounds(640, 58, 109, 20);
		panel.add(tfinaltime2);
		
		tfbust2 = new JTextField();
		tfbust2.setEditable(false);
		tfbust2.setColumns(10);
		tfbust2.setBounds(939, 58, 109, 20);
		panel.add(tfbust2);
		
		tftalie2 = new JTextField();
		tftalie2.setEditable(false);
		tftalie2.setColumns(10);
		tftalie2.setBounds(939, 142, 109, 20);
		panel.add(tftalie2);
		
		tfsolduri2 = new JTextField();
		tfsolduri2.setEditable(false);
		tfsolduri2.setColumns(10);
		tfsolduri2.setBounds(939, 219, 109, 20);
		panel.add(tfsolduri2);
		
		tfdata2 = new JTextField();
		tfdata2.setEditable(false);
		tfdata2.setColumns(10);
		tfdata2.setBounds(236, 219, 161, 20);
		panel.add(tfdata2);
		
		label = new JLabel("---");
		label.setBounds(211, 222, 15, 14);
		panel.add(label);
		
		label_1 = new JLabel("-");
		label_1.setBounds(630, 61, 5, 14);
		panel.add(label_1);
		
		label_2 = new JLabel("-");
		label_2.setBounds(630, 142, 5, 14);
		panel.add(label_2);
		
		label_3 = new JLabel("-");
		label_3.setBounds(924, 61, 5, 14);
		panel.add(label_3);
		
		label_4 = new JLabel("-");
		label_4.setBounds(924, 145, 5, 14);
		panel.add(label_4);
		
		label_5 = new JLabel("-");
		label_5.setBounds(924, 222, 5, 14);
		panel.add(label_5);
		
		btnNewButton = new JButton("Inapoi la MENIU");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainWindow();
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Sylfaen", Font.BOLD, 20));
		btnNewButton.setBounds(1047, 34, 259, 31);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(53, 393, 1253, 301);
		frame.getContentPane().add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		frame.setVisible(true);
		
		
		JButton btnCauta = new JButton("CAUTA");
		btnCauta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String s = "SELECT M.ModelID,M.Nume,M.Prenume, M.DataNasterii, M.Inaltime, M.Greutate, M.Bust, M.Talie, M.Solduri,M.CuloareOchi,M.CuloarePar, M.LocNastere, M.Cetatenie, M.CompanieID,C.NumeCompanie "+
						"FROM Model M, Companie C "+
							"WHERE M.CompanieID = C.CompanieID";
				
				int i = cbcompanie.getSelectedIndex() + 1;
			
				if(tfnume.isEditable()) s = s+ " AND M.Nume LIKE '" + tfnume.getText() +  "'";
				if(tfprenume.isEditable()) s = s+ " AND M.Prenume LIKE '" + tfprenume.getText() +  "'";
				if(tfdata.isEditable()) s = s+ " AND M.DataNasterii BETWEEN '" + tfdata.getText().toString() +  "' AND '" + tfdata2.getText().toString() +  "'";
				if(tforigine.isEditable()) s = s+ " AND M.LocNastere LIKE '" + tforigine.getText() +  "'";
				if(tfresedinta.isEditable()) s = s+ " AND M.Cetatenie LIKE '" + tfresedinta.getText() +  "'";
				if(tfinaltime.isEditable()) s = s+ " AND M.Inaltime BETWEEN '" + tfinaltime.getText().toString() +  "' AND '" + tfinaltime2.getText().toString() +  "'";
				if(tfgreutate.isEditable()) s = s+ " AND M.Greutate BETWEEN '" + tfgreutate.getText().toString() +  "' AND '" + tfgreutate2.getText().toString() +  "'";
				if(tfbust.isEditable()) s = s+ " AND M.Bust BETWEEN '" + tfbust.getText().toString() +  "' AND '" + tfbust2.getText().toString() +  "'";
				if(tftalie.isEditable()) s = s+ " AND M.Talie BETWEEN '" + tftalie.getText().toString() +  "' AND '" + tftalie2.getText().toString() +  "'";
				if(tfsolduri.isEditable()) s = s+" AND M.Solduri BETWEEN '" + tfsolduri.getText().toString() +  "' AND '" + tfsolduri2.getText().toString() +  "'";
				if(tfpar.isEditable()) s = s+ " AND M.CuloarePar LIKE '" + tfpar.getText() +  "'";
				if(tfochi.isEditable()) s = s+ " AND M.CuloareOchi LIKE '" + tfochi.getText() +  "'";
				if(cbcompanie.isEnabled()) s = s + " AND M.CompanieID = " + i;
				

				ResultSet rs = Query(s);
				table.setModel(DbUtils.resultSetToTableModel(rs));

				   table.getColumnModel().getColumn(0).setMinWidth(0);
				   table.getColumnModel().getColumn(0).setMaxWidth(0);
				   table.getColumnModel().getColumn(0).setWidth(0);
				   
				   table.getColumnModel().getColumn(13).setMinWidth(0);
				   table.getColumnModel().getColumn(13).setMaxWidth(0);
				   table.getColumnModel().getColumn(13).setWidth(0);
				
				
				
				
			}
		});
		btnCauta.setFont(new Font("Sitka Small", Font.PLAIN, 19));
		btnCauta.setBounds(516, 210, 233, 37);
		panel.add(btnCauta);
		
		label_6 = new JLabel("***   Dimensiuni maxime admise: Nume, Prenume (30), Culoare Ochi, Culoare Par (10), Tara de origine, Tara cetatenie (20)");
		label_6.setBounds(53, 705, 937, 14);
		frame.getContentPane().add(label_6);
		
		label_7 = new JLabel("***   Pentru campurile Marime Bust, Marime Talie, Marime Solduri, Inaltime, Greutate nu introduceti decat valori numerice in intervalul 0 - 255");
		label_7.setBounds(53, 716, 937, 14);
		frame.getContentPane().add(label_7);
		
		label_8 = new JLabel("***   Pentru campul Data Nasterii respectati formatul 'AAAA-LL-ZZ'");
		label_8.setBounds(53, 730, 937, 14);
		frame.getContentPane().add(label_8);
		
	}
}
