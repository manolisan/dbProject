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
public class DrugDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField drugNameTextField;
	private JTextField drugFormulaTextField;
	private JTextField pharmaceuticalCompanyNameTextField;

	private Driver driver;
	
	private dbPrescriptionsRX dbPrescriptionsRXApp;
	
	private Drug previousDrug = null;
	private boolean updateMode = false;
	
	public DrugDialog(dbPrescriptionsRX theDbPrescriptionsRXApp, Driver theDriver, Drug thePreviousDrug, boolean theUpdateMode){
		this();
		driver = theDriver;
		dbPrescriptionsRXApp = theDbPrescriptionsRXApp;
		previousDrug = thePreviousDrug;
		updateMode = theUpdateMode;
		
		if(updateMode){
			setTitle("Update Drug");
			populateGui(previousDrug);
		}
	}
	
	private void populateGui(Drug theDrug) {
		
		drugNameTextField.setText(theDrug.getName());
		drugFormulaTextField.setText(theDrug.getFormula());
		pharmaceuticalCompanyNameTextField.setText(theDrug.getPharmaceuticalCompanyName());
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DrugDialog dialog = new DrugDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DrugDialog() {
		setTitle("Add Drug");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Drug Name");
			lblNewLabel.setBounds(33, 18, 114, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			drugNameTextField = new JTextField();
			drugNameTextField.setBounds(156, 16, 114, 19);
			contentPanel.add(drugNameTextField);
			drugNameTextField.setColumns(10);
		}
		{
			JLabel lblLastName = new JLabel("Drug Formula");
			lblLastName.setBounds(33, 42, 105, 15);
			contentPanel.add(lblLastName);
		}
		{
			drugFormulaTextField = new JTextField();
			drugFormulaTextField.setBounds(156, 42, 114, 19);
			contentPanel.add(drugFormulaTextField);
			drugFormulaTextField.setColumns(10);
		}
		{
			JLabel lblSpeciality = new JLabel("Company Name");
			lblSpeciality.setBounds(33, 66, 114, 15);
			contentPanel.add(lblSpeciality);
		}
		{
			pharmaceuticalCompanyNameTextField = new JTextField();
			pharmaceuticalCompanyNameTextField.setBounds(156, 66, 114, 19);
			contentPanel.add(pharmaceuticalCompanyNameTextField);
			pharmaceuticalCompanyNameTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						saveDrug();
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
	
	protected void saveDrug(){
		
		
		String drugName = drugNameTextField.getText();
		String drugFormula = drugFormulaTextField.getText();
		String pharmaceuticalCompanyName = pharmaceuticalCompanyNameTextField.getText();
		
		
		Drug tempDrug = null;
		
		if(updateMode){
			tempDrug = previousDrug;
			tempDrug.setName(drugName);
			tempDrug.setFormula(drugFormula);
			tempDrug.setPharmaceuticalCompanyName(pharmaceuticalCompanyName);
		}
		else{
			tempDrug = new Drug(drugName, drugFormula, pharmaceuticalCompanyName);
		}
		
		try{
			if(updateMode){
				driver.updateDrug(tempDrug);
			}
			else{
				driver.addDrug(tempDrug);
			}
			
			setVisible(false);
			dispose();
			
			dbPrescriptionsRXApp.refreshDrugView();
			
			JOptionPane.showMessageDialog(dbPrescriptionsRXApp, "Drug added succesfully.", "Drug Added", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception exc){
			JOptionPane.showMessageDialog(dbPrescriptionsRXApp, "Error saving drug: "+exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
