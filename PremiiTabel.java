import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;

import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PremiiTabel extends SQLDatabaseConnection{

	private JFrame frame;
	private JTable table;
	private JLabel lblImageModel;
	private String s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PremiiTabel window = new PremiiTabel();
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
	public PremiiTabel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		s = "SELECT P.PremiuID, P.NumePremiu, P.TaraPremiu, P.UltimaEditie, M.Nume, M.Prenume, M.ModelID"
				+ " FROM Premiu P join Model M on M.ModelID = P.ModelID" ;
		
		ResultSet rs = Query(s);
		
		
		frame = new JFrame();
		frame.setBounds(0, 0, 1380, 750);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblTitluModel = new JLabel("PREMII");
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
		   
		   table.getColumnModel().getColumn(6).setMinWidth(0);
		   table.getColumnModel().getColumn(6).setMaxWidth(0);
		   table.getColumnModel().getColumn(6).setWidth(0);
		   
		   TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
		   JLabel headerLabel = (JLabel) rendererFromHeader;
		   headerLabel.setHorizontalAlignment(JLabel.CENTER);
		   
		   
		String path = "C:\\Users\\user\\Desktop\\POLI\\ANUL --- 3\\SEMESTRUL --- I\\JAVA si Aplicatii WEB\\AgentieFotomodele\\Resources\\premiu1.jpg";
		String pPath = "C:\\Users\\user\\Desktop\\POLI\\ANUL --- 3\\SEMESTRUL --- I\\JAVA si Aplicatii WEB\\AgentieFotomodele\\Resources\\premiu";
		String pPath2 = "C:\\Users\\user\\Desktop\\POLI\\ANUL --- 3\\SEMESTRUL --- I\\JAVA si Aplicatii WEB\\AgentieFotomodele\\Resources\\";
		ImageIcon imageIcon = new ImageIcon(path);
		
		lblImageModel = new JLabel(imageIcon);
		lblImageModel.setBounds(24, 365, 342, 335);
		frame.getContentPane().add(lblImageModel);
		
		JLabel lblPrize = new JLabel(imageIcon);
		lblPrize.setBounds(545, 365, 569, 335);
		frame.getContentPane().add(lblPrize);
		
		JButton backMenu = new JButton("Inapoi la Meniu");
		backMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainWindow();
				frame.dispose();
			}
		});
		backMenu.setFont(new Font("Sylfaen", Font.BOLD, 20));
		backMenu.setBounds(1145, 365, 207, 38);
		frame.getContentPane().add(backMenu);
		
		
		
		ListSelectionModel model = table.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(! model.isSelectionEmpty()){

					Integer i = (Integer) table.getValueAt(table.getSelectedRow(),0);

					ImageIcon imageIcon = new ImageIcon(pPath+""+i+".jpg");
					lblPrize.setIcon(imageIcon);
					imageIcon = null;
					
					
					Integer i2 = (Integer) table.getValueAt(table.getSelectedRow(),6);

					ImageIcon imageIcon2 = new ImageIcon(pPath2+""+i2+".jpg");
					lblImageModel.setIcon(imageIcon2);
					imageIcon2 = null;
					
				}
			}
			
		});
	}
}
