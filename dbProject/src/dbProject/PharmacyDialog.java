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
public class PharmacyDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField pharmacyNameTextField;
	private JTextField townTextField;
	private JTextField streetNameTextField;
	private JTextField streetNumberTextField;

	private Driver driver;
	
	private dbPrescriptionsRX dbPrescriptionsRXApp;
	
	private Pharmacy previousPharmacy = null;
	private boolean updateMode = false;
	private JTextField postalCodeTextField;
	private JTextField phoneNumberTextField;
	
	public PharmacyDialog(dbPrescriptionsRX theDbPrescriptionsRXApp, Driver theDriver, Pharmacy thePreviousPharmacy, boolean theUpdateMode){
		this();
		driver = theDriver;
		dbPrescriptionsRXApp = theDbPrescriptionsRXApp;
		previousPharmacy = thePreviousPharmacy;
		updateMode = theUpdateMode;
		
		if(updateMode){
			setTitle("Update Pharmacy");
			populateGui(previousPharmacy);
		}
	}
	
	private void populateGui(Pharmacy thePharmacy) {
		
		pharmacyNameTextField.setText(thePharmacy.getName());
		townTextField.setText(thePharmacy.getTown());
		streetNameTextField.setText(thePharmacy.getStreetName());
		streetNumberTextField.setText((new Integer(thePharmacy.getNumber())).toString());		
		postalCodeTextField.setText((new Integer(thePharmacy.getPostalCode())).toString());
		phoneNumberTextField.setText((new Integer(thePharmacy.getPhoneNumber())).toString());
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PharmacyDialog dialog = new PharmacyDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PharmacyDialog() {
		setTitle("Add Pharmacy");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Pharmacy Name");
			lblNewLabel.setBounds(33, 18, 114, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			pharmacyNameTextField = new JTextField();
			pharmacyNameTextField.setBounds(156, 16, 114, 19);
			contentPanel.add(pharmacyNameTextField);
			pharmacyNameTextField.setColumns(10);
		}
		{
			JLabel lblLastName = new JLabel("Town");
			lblLastName.setBounds(33, 42, 75, 15);
			contentPanel.add(lblLastName);
		}
		{
			townTextField = new JTextField();
			townTextField.setBounds(156, 42, 114, 19);
			contentPanel.add(townTextField);
			townTextField.setColumns(10);
		}
		{
			JLabel lblSpeciality = new JLabel("Street Name");
			lblSpeciality.setBounds(33, 66, 105, 15);
			contentPanel.add(lblSpeciality);
		}
		{
			streetNameTextField = new JTextField();
			streetNameTextField.setBounds(156, 66, 114, 19);
			contentPanel.add(streetNameTextField);
			streetNameTextField.setColumns(10);
		}
		{
			JLabel lblYearsOfExperience = new JLabel("Street Number");
			lblYearsOfExperience.setBounds(33, 90, 140, 15);
			contentPanel.add(lblYearsOfExperience);
		}
		{
			streetNumberTextField = new JTextField();
			streetNumberTextField.setBounds(216, 90, 54, 19);
			contentPanel.add(streetNumberTextField);
			streetNumberTextField.setColumns(10);
		}
		
		JLabel lblNewLabel_1 = new JLabel("Postal Code");
		lblNewLabel_1.setBounds(33, 114, 114, 15);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(33, 138, 114, 15);
		contentPanel.add(lblPhoneNumber);
		
		postalCodeTextField = new JTextField();
		postalCodeTextField.setBounds(156, 114, 114, 19);
		contentPanel.add(postalCodeTextField);
		postalCodeTextField.setColumns(10);
		
		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setBounds(156, 138, 114, 19);
		contentPanel.add(phoneNumberTextField);
		phoneNumberTextField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						savePharmacy();
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
	
	protected void savePharmacy(){
		
		
		String pharmacyName = pharmacyNameTextField.getText();
		String town = townTextField.getText();
		String streetName = streetNameTextField.getText();
		String streetNumberStr = streetNumberTextField.getText();
		String postalCodeStr = postalCodeTextField.getText();
		String phoneNumberStr = phoneNumberTextField.getText();
		
		int streetNumber = Integer.parseInt(streetNumberStr);
		int postalCode = Integer.parseInt(postalCodeStr);
		int phoneNumber = Integer.parseInt(phoneNumberStr);
		
		Pharmacy tempPharmacy = null;
		
		if(updateMode){
			tempPharmacy = previousPharmacy;
			tempPharmacy.setName(pharmacyName);
			tempPharmacy.setTown(town);
			tempPharmacy.setStreetName(streetName);
			tempPharmacy.setNumber(streetNumber);
			tempPharmacy.setPostalCode(postalCode);
			tempPharmacy.setPhoneNumber(phoneNumber);
		}
		else{
			tempPharmacy = new Pharmacy(pharmacyName, town, streetName, streetNumber, postalCode, phoneNumber);
		}
		
		try{
			if(updateMode){
				driver.updatePharmacy(tempPharmacy);
			}
			else{
				driver.addPharmacy(tempPharmacy);
			}
			
			setVisible(false);
			dispose();
			
			dbPrescriptionsRXApp.refreshPharmacyView();
			
			JOptionPane.showMessageDialog(dbPrescriptionsRXApp, "Pharmacy added succesfully.", "Pharmacy Added", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception exc){
			JOptionPane.showMessageDialog(dbPrescriptionsRXApp, "Error saving pharmacy: "+exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
