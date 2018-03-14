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

public class CompaniiTabel extends SQLDatabaseConnection{

	private JFrame frame;
	private JTable table;
	private JLabel lblImageModel;
	private String s;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompaniiTabel window = new CompaniiTabel();
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
	public CompaniiTabel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		s = "select * , (select count(*) from Lucreaza "+
							"where CompanieID = C.CompanieID "+
								"group by CompanieID) as 'Numar Angajati' "+
				"from Companie C";
		
		ResultSet rs = Query(s);
		
		
		frame = new JFrame();
		frame.setBounds(0, 0, 1380, 750);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblTitluModel = new JLabel("Companii");
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
		   
		   TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
		   JLabel headerLabel = (JLabel) rendererFromHeader;
		   headerLabel.setHorizontalAlignment(JLabel.CENTER);
		   
		   
		String path = "C:\\Users\\user\\Desktop\\POLI\\ANUL --- 3\\SEMESTRUL --- I\\JAVA si Aplicatii WEB\\AgentieFotomodele\\Resources\\comp1.jpg";
		String pPath = "C:\\Users\\user\\Desktop\\POLI\\ANUL --- 3\\SEMESTRUL --- I\\JAVA si Aplicatii WEB\\AgentieFotomodele\\Resources\\comp";
		ImageIcon imageIcon = new ImageIcon(path);
		
		lblImageModel = new JLabel(imageIcon);
		lblImageModel.setBounds(10, 374, 1057, 335);
		frame.getContentPane().add(lblImageModel);
		
		btnNewButton = new JButton("Inapoi la Meniu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainWindow();
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Sylfaen", Font.BOLD, 20));
		btnNewButton.setBounds(1073, 359, 279, 56);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
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
					
					
					
				}
			}
			
		});
	}
}
