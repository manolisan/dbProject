package dbProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DoctorDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField specialityTextField;
	private JTextField experienceYearsTextField;

	private Driver driver;
	
	private dbPrescriptionsRX doctorSearchApp;
	
	private Doctor previousDoctor = null;
	private boolean updateMode = false;
	
	public DoctorDialog(dbPrescriptionsRX theDoctorSearchApp, Driver theDriver, Doctor thePreviousDoctor, boolean theUpdateMode){
		this();
		driver = theDriver;
		doctorSearchApp = theDoctorSearchApp;
		previousDoctor = thePreviousDoctor;
		updateMode = theUpdateMode;
		
		if(updateMode){
			setTitle("Update Doctor");
			populateGui(previousDoctor);
		}
	}
	
	private void populateGui(Doctor theDoctor) {
		
		firstNameTextField.setText(theDoctor.getFirstName());
		lastNameTextField.setText(theDoctor.getLastName());
		specialityTextField.setText(theDoctor.getSpeciality());
		experienceYearsTextField.setText((new Integer(theDoctor.getExperienceYears())).toString());		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DoctorDialog dialog = new DoctorDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DoctorDialog() {
		setTitle("Add Doctor");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("First Name");
			lblNewLabel.setBounds(33, 18, 76, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			firstNameTextField = new JTextField();
			firstNameTextField.setBounds(130, 18, 114, 19);
			contentPanel.add(firstNameTextField);
			firstNameTextField.setColumns(10);
		}
		{
			JLabel lblLastName = new JLabel("Last Name");
			lblLastName.setBounds(33, 42, 75, 15);
			contentPanel.add(lblLastName);
		}
		{
			lastNameTextField = new JTextField();
			lastNameTextField.setBounds(130, 42, 114, 19);
			contentPanel.add(lastNameTextField);
			lastNameTextField.setColumns(10);
		}
		{
			JLabel lblSpeciality = new JLabel("Speciality");
			lblSpeciality.setBounds(33, 66, 69, 15);
			contentPanel.add(lblSpeciality);
		}
		{
			specialityTextField = new JTextField();
			specialityTextField.setBounds(130, 66, 114, 19);
			contentPanel.add(specialityTextField);
			specialityTextField.setColumns(10);
		}
		{
			JLabel lblYearsOfExperience = new JLabel("Years of experience");
			lblYearsOfExperience.setBounds(33, 90, 140, 15);
			contentPanel.add(lblYearsOfExperience);
		}
		{
			experienceYearsTextField = new JTextField();
			experienceYearsTextField.setBounds(190, 90, 54, 19);
			contentPanel.add(experienceYearsTextField);
			experienceYearsTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						saveDoctor();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	protected void saveDoctor(){
		
		
		String firstName = firstNameTextField.getText();
		String lastName = lastNameTextField.getText();
		String speciality = specialityTextField.getText();
		String experienceYearsStr = experienceYearsTextField.getText();
		
		int experienceYears = Integer.parseInt(experienceYearsStr);
		
		Doctor tempDoctor = null;
		
		if(updateMode){
			tempDoctor = previousDoctor;
			tempDoctor.setLastName(lastName);
			tempDoctor.setFirstName(firstName);
			tempDoctor.setSpeciality(speciality);
			tempDoctor.setExperienceYears(experienceYears);
		}
		else{
			tempDoctor = new Doctor(firstName, lastName, speciality, experienceYears);
		}
		
		try{
			if(updateMode){
				driver.updateDoctor(tempDoctor);
			}
			else{
				driver.addDoctor(tempDoctor);
			}
			
			setVisible(false);
			dispose();
			
			doctorSearchApp.refreshDoctorView();
			
			JOptionPane.showMessageDialog(doctorSearchApp, "Doctor added succesfully.", "Doctor Added", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception exc){
			JOptionPane.showMessageDialog(doctorSearchApp, "Error saving employee: "+exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
