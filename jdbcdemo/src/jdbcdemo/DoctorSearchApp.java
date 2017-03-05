package jdbcdemo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class DoctorSearchApp extends JFrame {

	private JPanel contentPane;
	private JTextField lastNameTextField;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable table;

	private Driver driver;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JButton btnUpdateDoctor;
	private JButton btnDeleteDoctor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorSearchApp frame = new DoctorSearchApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DoctorSearchApp() {
		setFont(new Font("Ubuntu", Font.PLAIN, 12));
		
		try{
			driver = new Driver();
		}
		catch (Exception exc){
			JOptionPane.showMessageDialog(this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		setTitle("Doctor Search App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Enter last name");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		panel.add(lblNewLabel);
		
		lastNameTextField = new JTextField();
		panel.add(lastNameTextField);
		lastNameTextField.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String lastName = lastNameTextField.getText();
					List<Doctor> doctors = null;
					
					if (lastName != null && lastName.trim().length() > 0){
						doctors = driver.searchDoctors(lastName);
					}
					else{
						doctors = driver.getAllDoctors();
					}
					
					/*for (Doctor temp : doctors){
						System.out.println(temp);
					}*/
					
					DoctorTableModel model = new DoctorTableModel(doctors);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(DoctorSearchApp.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnSearch);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("Add Doctor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DoctorDialog dialog = new DoctorDialog(DoctorSearchApp.this, driver, null, false);
				
				dialog.setVisible(true);
			}
		});
		panel_1.add(btnNewButton);
		
		btnUpdateDoctor = new JButton("Update Doctor");
		btnUpdateDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				if (row<0){
					JOptionPane.showMessageDialog(DoctorSearchApp.this, "You must select a doctor", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				/*Doctor tempDoctor = new Doctor(table.getValueAt(row, 0).toString(),
										   table.getValueAt(row, 1).toString(),
										   table.getValueAt(row, 2).toString(),
										   Integer.parseInt(table.getValueAt(row, 3).toString()));*/
				Doctor tempDoctor = (Doctor) table.getValueAt(row, DoctorTableModel.OBJECT_COL);
				
				DoctorDialog dialog = new DoctorDialog(DoctorSearchApp.this, driver, tempDoctor, true);
				
				dialog.setVisible(true);
			}
		});
		panel_1.add(btnUpdateDoctor);
		
		btnDeleteDoctor = new JButton("Delete Doctor");
		btnDeleteDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				int row = table.getSelectedRow();
				
				
				if (row<0){
					JOptionPane.showMessageDialog(DoctorSearchApp.this, "You must select a doctor", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				int response = JOptionPane.showConfirmDialog(DoctorSearchApp.this, "Delete this doctor?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if (response != JOptionPane.YES_OPTION){
					return;
				}
				
				Doctor tempDoctor = (Doctor) table.getValueAt(row, DoctorTableModel.OBJECT_COL);
				
				driver.deleteDoctor(tempDoctor.getDoctorId());
				
				refreshDoctorView();
				
				JOptionPane.showMessageDialog(DoctorSearchApp.this, "Doctor deleted succesfully.", "Employee Deleted", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception exc){
					JOptionPane.showMessageDialog(DoctorSearchApp.this, "Error deleting doctor: "+exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel_1.add(btnDeleteDoctor);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFont(new Font("SansSerif", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
	}

	public void refreshDoctorView() {
		try{
			List<Doctor> doctors = driver.getAllDoctors();
			
			DoctorTableModel model = new DoctorTableModel(doctors);
			
			table.setModel(model);
		}
		catch(Exception exc){
			JOptionPane.showMessageDialog(this, "Error: "+exc, "Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
