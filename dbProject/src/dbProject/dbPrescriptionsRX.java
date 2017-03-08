package dbProject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class dbPrescriptionsRX extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;

	private Driver driver;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JButton btnUpdateDoctor;
	private JButton btnDeleteDoctor;
	private JPanel panel_2;
	private JButton doctorTableButton;
	private JButton pharmacyTableButton;
	private JButton drugTableButton;

	private int tableChosen;
	private JLabel lblTools;
	private JPanel panel;
	private JButton btnPatientsByDrugs;
	private JLabel lblQueries;
	private Component verticalStrut;
	private JButton btnDoctorsByPatients;
	private Component verticalStrut_1;
	private JButton btnSpecialitiesByExperience;
	private JButton patientPrescriptionViewButton;
	private Component verticalStrut_2;
	private JButton pharmacyAvgPriceViewButton;
	private JLabel lblTables;
	private Component verticalStrut_3;
	private JLabel lblViews;
	private Component verticalStrut_4;
	private Component verticalStrut_5;
	private JButton btnExpDrugs;
	private Component verticalStrut_6;
	private JButton btnCompanyByDrugs;
	private Component verticalStrut_7;
	private JButton btnDrugsByPrescription;
	private Component verticalStrut_8;
	private JButton btnDrugsByPrice;
	private Component verticalStrut_9;
	private JButton btnDrugsOfFormula;
	private JTextField formulaGivenTextField;
	private Component verticalStrut_10;
	private JButton btnDrugsOfSpeciality;
	private JTextField specialityGivenTextField;
	private Component verticalStrut_11;
	private JButton btnDoctorByExperience;
	private JTextField givenExperienceTextField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dbPrescriptionsRX frame = new dbPrescriptionsRX();
					frame.setSize(1100, 700);;
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
	public dbPrescriptionsRX() {
		setFont(new Font("Ubuntu", Font.PLAIN, 12));
		try{
			driver = new Driver();
		}
		catch (Exception exc){
			JOptionPane.showMessageDialog(this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		setTitle("Prescriptions RX Database");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFont(new Font("Noto Sans CJK TC Regular", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		
		panel_2 = new JPanel();
		scrollPane.setRowHeaderView(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Box tablesBox = Box.createVerticalBox();
	
		doctorTableButton = new JButton();
		doctorTableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableChosen = 1;
				try{
					List<Doctor> doctors = null;
					
					doctors = driver.getAllDoctors();
					
					DoctorTableModel model = new DoctorTableModel(doctors);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		lblTables = new JLabel("Tables");
		tablesBox.add(lblTables);
		
		verticalStrut_3 = Box.createVerticalStrut(10);
		tablesBox.add(verticalStrut_3);
		doctorTableButton.setIcon(new ImageIcon("/home/stratis/Downloads/doctor-1295581_1280-micro.png"));
		doctorTableButton.setVerticalAlignment(SwingConstants.TOP);
		doctorTableButton.setSize(new Dimension(40,40));
		doctorTableButton.setBorderPainted(false);
		doctorTableButton.setContentAreaFilled(false);
		doctorTableButton.setFocusPainted(false);
		doctorTableButton.setOpaque(false);
		
		tablesBox.add(doctorTableButton);
		tablesBox.add(Box.createVerticalStrut(10));
		
		pharmacyTableButton = new JButton();
		pharmacyTableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableChosen = 2;
				try{
					List<Pharmacy> pharmacies = null;
					
					pharmacies = driver.getAllPharmacies();
					
					PharmacyTableModel model = new PharmacyTableModel(pharmacies);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		pharmacyTableButton.setIcon(new ImageIcon("/home/stratis/Downloads/7e88cce2beec5f097aa60245d9d70fc0-micro.png"));
		pharmacyTableButton.setSize(new Dimension(40,40));
		pharmacyTableButton.setBorderPainted(false);
		pharmacyTableButton.setContentAreaFilled(false);
		pharmacyTableButton.setFocusPainted(false);
		pharmacyTableButton.setOpaque(false);
		tablesBox.add(pharmacyTableButton);
		tablesBox.add(Box.createVerticalStrut(10));
		
		drugTableButton = new JButton();
		drugTableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableChosen = 3;
				try{
					List<Drug> drugs = null;
					
					drugs = driver.getAllDrugs();
					
					DrugTableModel model = new DrugTableModel(drugs);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		drugTableButton.setIcon(new ImageIcon("/home/stratis/Downloads/Capsule.png"));
		drugTableButton.setSize(new Dimension(40,40));
		drugTableButton.setBorderPainted(false);
		drugTableButton.setContentAreaFilled(false);
		drugTableButton.setFocusPainted(false);
		drugTableButton.setOpaque(false);
		tablesBox.add(drugTableButton);
		tablesBox.add(Box.createVerticalStrut(20));
		
		panel_2.add(tablesBox);
		
		patientPrescriptionViewButton = new JButton();
		patientPrescriptionViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableChosen = 0;
				try{
					List<PatientContract> patients = null;
					
					patients = driver.getAllPatientContract();
					
					PatientContractTableModel model = new PatientContractTableModel(patients);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		lblViews = new JLabel("Views");
		tablesBox.add(lblViews);
		
		verticalStrut_4 = Box.createVerticalStrut(10);
		tablesBox.add(verticalStrut_4);
		patientPrescriptionViewButton.setIcon(new ImageIcon("/home/stratis/Downloads/patient-icon-9244-micro.png"));
		patientPrescriptionViewButton.setSize(new Dimension(40,40));
		patientPrescriptionViewButton.setBorderPainted(false);
		patientPrescriptionViewButton.setContentAreaFilled(false);
		patientPrescriptionViewButton.setFocusPainted(false);
		patientPrescriptionViewButton.setOpaque(false);
		tablesBox.add(patientPrescriptionViewButton);
		
		verticalStrut_2 = Box.createVerticalStrut(10);
		tablesBox.add(verticalStrut_2);
		
		pharmacyAvgPriceViewButton = new JButton();
		pharmacyAvgPriceViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableChosen = 0;
				try{
					List<PharmacyAvg> pharmacies = null;
					
					pharmacies = driver.getAllPharmacyAvg();
					
					PharmacyAvgTableModel model = new PharmacyAvgTableModel(pharmacies);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		pharmacyAvgPriceViewButton.setIcon(new ImageIcon("/home/stratis/Downloads/US-dollar-icon-micro.png"));
		pharmacyAvgPriceViewButton.setSize(new Dimension(40,40));
		pharmacyAvgPriceViewButton.setBorderPainted(false);
		pharmacyAvgPriceViewButton.setContentAreaFilled(false);
		pharmacyAvgPriceViewButton.setFocusPainted(false);
		pharmacyAvgPriceViewButton.setOpaque(false);
		tablesBox.add(pharmacyAvgPriceViewButton);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		btnNewButton = new JButton();
		btnNewButton.setIcon(new ImageIcon("/home/stratis/Downloads/add-icon-micro.png"));
		btnNewButton.setPreferredSize(new Dimension(35, 35));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setOpaque(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tableChosen == 1){
					DoctorDialog dialog = new DoctorDialog(dbPrescriptionsRX.this, driver, null, false);
					dialog.setVisible(true);
				}
				else if (tableChosen == 2){
					PharmacyDialog dialog = new PharmacyDialog(dbPrescriptionsRX.this, driver, null, false);
					dialog.setVisible(true);
				}
				else if (tableChosen == 3){
					DrugDialog dialog = new DrugDialog(dbPrescriptionsRX.this, driver, null, false);
					dialog.setVisible(true);
				}
			}
		});
		
		lblTools = new JLabel("Tools");
		panel_1.add(lblTools);
		panel_1.add(btnNewButton);
		
		btnUpdateDoctor = new JButton();
		btnUpdateDoctor.setIcon(new ImageIcon("/home/stratis/Downloads/edit-xxl-micro.png"));
		btnUpdateDoctor.setPreferredSize(new Dimension(35, 35));
		btnUpdateDoctor.setBorderPainted(false);
		btnUpdateDoctor.setContentAreaFilled(false);
		btnUpdateDoctor.setFocusPainted(false);
		btnUpdateDoctor.setOpaque(false);
		btnUpdateDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				if (tableChosen == 1){
					if (row<0){
						JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "You must select a doctor", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				else if (tableChosen == 2){
					if (row<0){
						JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "You must select a pharmacy", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				else if (tableChosen == 3){
					if (row<0){
						JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "You must select a drug", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				if (tableChosen == 1){
					Doctor tempDoctor = (Doctor) table.getValueAt(row, DoctorTableModel.OBJECT_COL);
					DoctorDialog dialog = new DoctorDialog(dbPrescriptionsRX.this, driver, tempDoctor, true);
					dialog.setVisible(true);
				}
				else if (tableChosen == 2){
					Pharmacy tempPharmacy = (Pharmacy) table.getValueAt(row, PharmacyTableModel.OBJECT_COL);
					PharmacyDialog dialog = new PharmacyDialog(dbPrescriptionsRX.this, driver, tempPharmacy, true);
					dialog.setVisible(true);
				}
				else if (tableChosen == 3){
					Drug tempDrug = (Drug) table.getValueAt(row, DrugTableModel.OBJECT_COL);
					DrugDialog dialog = new DrugDialog(dbPrescriptionsRX.this, driver, tempDrug, true);
					dialog.setVisible(true);
				}
			}
		});
		panel_1.add(btnUpdateDoctor);
		
		btnDeleteDoctor = new JButton();
		btnDeleteDoctor.setIcon(new ImageIcon("/home/stratis/Downloads/delete-2-xxl-micro.png"));
		btnDeleteDoctor.setBorderPainted(false);
		btnDeleteDoctor.setContentAreaFilled(false);
		btnDeleteDoctor.setFocusPainted(false);
		btnDeleteDoctor.setOpaque(false);
		btnDeleteDoctor.setPreferredSize(new Dimension(35,35));
		btnDeleteDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				int row = table.getSelectedRow();
				
				
				if (tableChosen == 1){
					if (row<0){
						JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "You must select a doctor", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				else if (tableChosen == 2){
					if (row<0){
						JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "You must select a pharmacy", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				else if (tableChosen == 3){
					if (row<0){
						JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "You must select a drug", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				if (tableChosen == 1){
					int response = JOptionPane.showConfirmDialog(dbPrescriptionsRX.this, "Delete this doctor?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (response != JOptionPane.YES_OPTION) return;
				}
				else if (tableChosen == 2){
					int response = JOptionPane.showConfirmDialog(dbPrescriptionsRX.this, "Delete this pharmacy?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (response != JOptionPane.YES_OPTION) return;
				}
				else if (tableChosen == 3){
					int response = JOptionPane.showConfirmDialog(dbPrescriptionsRX.this, "Delete this drug?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (response != JOptionPane.YES_OPTION) return;
				}
				
				if (tableChosen == 1){
					Doctor tempDoctor = (Doctor) table.getValueAt(row, DoctorTableModel.OBJECT_COL);
					driver.deleteDoctor(tempDoctor.getDoctorId());
					refreshDoctorView();
					JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "Doctor deleted succesfully.", "Doctor Deleted", JOptionPane.INFORMATION_MESSAGE);
				}
				else if (tableChosen == 2){
					Pharmacy tempPharmacy = (Pharmacy) table.getValueAt(row, PharmacyTableModel.OBJECT_COL);
					driver.deletePharmacy(tempPharmacy.getPharmacyId());
					refreshPharmacyView();
					JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "Pharmacy deleted succesfully.", "Pharmacy Deleted", JOptionPane.INFORMATION_MESSAGE);
				}
				else if (tableChosen == 3){
					Drug tempDrug = (Drug) table.getValueAt(row, DrugTableModel.OBJECT_COL);
					driver.deleteDrug(tempDrug.getDrugId());
					refreshDrugView();
					JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "Drug deleted succesfully.", "Drug Deleted", JOptionPane.INFORMATION_MESSAGE);
				}
				}
				catch(Exception exc){
					JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "Error deleting doctor: "+exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel_1.add(btnDeleteDoctor);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		
		Box queriesBox = Box.createVerticalBox();
		panel.add(queriesBox);
		
		lblQueries = new JLabel("Queries");
		lblQueries.setHorizontalAlignment(SwingConstants.LEFT);
		queriesBox.add(lblQueries);
		
		verticalStrut = Box.createVerticalStrut(10);
		queriesBox.add(verticalStrut);
		
		btnPatientsByDrugs = new JButton("Patients with more than 5 drugs");
		btnPatientsByDrugs.setIcon(new ImageIcon("/home/stratis/Downloads/playstation-circle-icon-micro.png"));
		btnPatientsByDrugs.setPreferredSize(new Dimension(250, 25));
		btnPatientsByDrugs.setBorderPainted(false);
		btnPatientsByDrugs.setContentAreaFilled(false);
		btnPatientsByDrugs.setFocusPainted(false);
		btnPatientsByDrugs.setOpaque(false);
		btnPatientsByDrugs.setHorizontalAlignment(SwingConstants.LEFT);
		btnPatientsByDrugs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					tableChosen = 0;
					List<PatientByDrugs> patients = null;
					
					patients = driver.getPatientByDrugs();
					
					PatientByDrugsTableModel model = new PatientByDrugsTableModel(patients);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		queriesBox.add(btnPatientsByDrugs);
		queriesBox.add(Box.createVerticalStrut(10));
		
		btnDoctorsByPatients = new JButton("Doctors by patients");
		btnDoctorsByPatients.setIcon(new ImageIcon("/home/stratis/Downloads/playstation-circle-icon-micro.png"));
		btnDoctorsByPatients.setPreferredSize(new Dimension(250, 25));
		btnDoctorsByPatients.setBorderPainted(false);
		btnDoctorsByPatients.setContentAreaFilled(false);
		btnDoctorsByPatients.setFocusPainted(false);
		btnDoctorsByPatients.setOpaque(false);
		btnDoctorsByPatients.setHorizontalAlignment(SwingConstants.LEFT);
		btnDoctorsByPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					tableChosen = 0;
					List<DoctorByPatients> doctors = null;
					
					doctors = driver.getDoctorByPatients();
					
					DoctorByPatientsTableModel model = new DoctorByPatientsTableModel(doctors);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		queriesBox.add(btnDoctorsByPatients);
		
		verticalStrut_1 = Box.createVerticalStrut(10);
		queriesBox.add(verticalStrut_1);
		
		btnSpecialitiesByExperience = new JButton("Specialities by experience");
		btnSpecialitiesByExperience.setIcon(new ImageIcon("/home/stratis/Downloads/playstation-circle-icon-micro.png"));
		btnSpecialitiesByExperience.setPreferredSize(new Dimension(250, 25));
		btnSpecialitiesByExperience.setBorderPainted(false);
		btnSpecialitiesByExperience.setContentAreaFilled(false);
		btnSpecialitiesByExperience.setFocusPainted(false);
		btnSpecialitiesByExperience.setOpaque(false);
		btnSpecialitiesByExperience.setHorizontalAlignment(SwingConstants.LEFT);
		btnSpecialitiesByExperience.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					tableChosen = 0;
					List<SpecialityByExperience> specialities = null;
					
					specialities = driver.getSpecialityByExperience();
					
					SpecialityByExperienceTableModel model = new SpecialityByExperienceTableModel(specialities);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		queriesBox.add(btnSpecialitiesByExperience);
		
		verticalStrut_5 = Box.createVerticalStrut(10);
		queriesBox.add(verticalStrut_5);
		
		btnExpDrugs = new JButton("Expensive Drugs");
		btnExpDrugs.setIcon(new ImageIcon("/home/stratis/Downloads/playstation-circle-icon-micro.png"));
		btnExpDrugs.setPreferredSize(new Dimension(250, 25));
		btnExpDrugs.setBorderPainted(false);
		btnExpDrugs.setContentAreaFilled(false);
		btnExpDrugs.setFocusPainted(false);
		btnExpDrugs.setOpaque(false);
		btnExpDrugs.setHorizontalAlignment(SwingConstants.LEFT);
		btnExpDrugs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					tableChosen = 0;
					List<PharmacyAvg> drugs = null;
					
					drugs = driver.getExpDrugs();
					
					ExpDrugsTableModel model = new ExpDrugsTableModel(drugs);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		queriesBox.add(btnExpDrugs);
		
		verticalStrut_6 = Box.createVerticalStrut(10);
		queriesBox.add(verticalStrut_6);
		
		btnCompanyByDrugs = new JButton("Companies by drugs");
		btnCompanyByDrugs.setIcon(new ImageIcon("/home/stratis/Downloads/playstation-circle-icon-micro.png"));
		btnCompanyByDrugs.setPreferredSize(new Dimension(250, 25));
		btnCompanyByDrugs.setBorderPainted(false);
		btnCompanyByDrugs.setContentAreaFilled(false);
		btnCompanyByDrugs.setFocusPainted(false);
		btnCompanyByDrugs.setOpaque(false);
		btnCompanyByDrugs.setHorizontalAlignment(SwingConstants.LEFT);
		btnCompanyByDrugs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					tableChosen = 0;
					List<CompanyByDrug> companies = null;
					
					companies = driver.getCompanyByDrug();
					
					CompanyByDrugTableModel model = new CompanyByDrugTableModel(companies);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		queriesBox.add(btnCompanyByDrugs);
		
		verticalStrut_7 = Box.createVerticalStrut(10);
		queriesBox.add(verticalStrut_7);
		
		btnDrugsByPrescription = new JButton("Drugs by prescriptions");
		btnDrugsByPrescription.setIcon(new ImageIcon("/home/stratis/Downloads/playstation-circle-icon-micro.png"));
		btnDrugsByPrescription.setPreferredSize(new Dimension(250, 25));
		btnDrugsByPrescription.setBorderPainted(false);
		btnDrugsByPrescription.setContentAreaFilled(false);
		btnDrugsByPrescription.setFocusPainted(false);
		btnDrugsByPrescription.setOpaque(false);
		btnDrugsByPrescription.setHorizontalAlignment(SwingConstants.LEFT);
		btnDrugsByPrescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					tableChosen = 0;
					List<DrugByPrescription> drugs = null;
					
					drugs = driver.getDrugByPrescription();
					
					DrugByPrescriptionTableModel model = new DrugByPrescriptionTableModel(drugs);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		queriesBox.add(btnDrugsByPrescription);
		
		verticalStrut_8 = Box.createVerticalStrut(10);
		queriesBox.add(verticalStrut_8);
		
		btnDrugsByPrice = new JButton("Drugs by price");
		btnDrugsByPrice.setIcon(new ImageIcon("/home/stratis/Downloads/playstation-circle-icon-micro.png"));
		btnDrugsByPrice.setPreferredSize(new Dimension(250, 25));
		btnDrugsByPrice.setBorderPainted(false);
		btnDrugsByPrice.setContentAreaFilled(false);
		btnDrugsByPrice.setFocusPainted(false);
		btnDrugsByPrice.setOpaque(false);
		btnDrugsByPrice.setHorizontalAlignment(SwingConstants.LEFT);
		btnDrugsByPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					tableChosen = 0;
					List<DrugByPrice> drugs = null;
					
					drugs = driver.getDrugByPrice();
					
					DrugByPriceTableModel model = new DrugByPriceTableModel(drugs);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		queriesBox.add(btnDrugsByPrice);
		
		verticalStrut_9 = Box.createVerticalStrut(10);
		queriesBox.add(verticalStrut_9);
		
		btnDrugsOfFormula = new JButton("Drugs of formula:");
		btnDrugsOfFormula.setIcon(new ImageIcon("/home/stratis/Downloads/playstation-circle-icon-micro.png"));
		btnDrugsOfFormula.setPreferredSize(new Dimension(250, 25));
		btnDrugsOfFormula.setBorderPainted(false);
		btnDrugsOfFormula.setContentAreaFilled(false);
		btnDrugsOfFormula.setFocusPainted(false);
		btnDrugsOfFormula.setOpaque(false);
		btnDrugsOfFormula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					tableChosen = 0;
					String formulaGiven = formulaGivenTextField.getText();
					List<DrugByFormula> drugs = null;
					
					if(formulaGiven != null && formulaGiven.trim().length()>0){
						drugs = driver.searchFormula(formulaGiven);
					}
					else{
						drugs = driver.getDrugsByFormula();
					}
					
					DrugByFormulaTableModel model = new DrugByFormulaTableModel(drugs);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDrugsOfFormula.setHorizontalAlignment(SwingConstants.LEFT);
		queriesBox.add(btnDrugsOfFormula);
		
		formulaGivenTextField = new JTextField();
		formulaGivenTextField.setColumns(10);
		queriesBox.add(formulaGivenTextField);
		
		verticalStrut_10 = Box.createVerticalStrut(10);
		queriesBox.add(verticalStrut_10);
		
		btnDrugsOfSpeciality = new JButton("Drugs of speciality:");
		btnDrugsOfSpeciality.setIcon(new ImageIcon("/home/stratis/Downloads/playstation-circle-icon-micro.png"));
		btnDrugsOfSpeciality.setPreferredSize(new Dimension(250, 25));
		btnDrugsOfSpeciality.setBorderPainted(false);
		btnDrugsOfSpeciality.setContentAreaFilled(false);
		btnDrugsOfSpeciality.setFocusPainted(false);
		btnDrugsOfSpeciality.setOpaque(false);
		btnDrugsOfSpeciality.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					tableChosen = 0;
					String specialityGiven = specialityGivenTextField.getText();
					List<String> drugs = null;
					
					if(specialityGiven != null && specialityGiven.trim().length()>0){
						drugs = driver.searchDrugsBySpeciality(specialityGiven);
					}
					else{
						drugs = driver.getAllDrugsBySpeciality();
					}
					
					DrugsBySpecialityTableModel model = new DrugsBySpecialityTableModel(drugs);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDrugsOfSpeciality.setHorizontalAlignment(SwingConstants.LEFT);
		queriesBox.add(btnDrugsOfSpeciality);
		
		specialityGivenTextField = new JTextField();
		specialityGivenTextField.setColumns(10);
		queriesBox.add(specialityGivenTextField);
		
		verticalStrut_11 = Box.createVerticalStrut(10);
		queriesBox.add(verticalStrut_11);
		
		btnDoctorByExperience = new JButton("Doctors with years of experience more than:");
		btnDoctorByExperience.setIcon(new ImageIcon("/home/stratis/Downloads/playstation-circle-icon-micro.png"));
		btnDoctorByExperience.setPreferredSize(new Dimension(350, 25));
		btnDoctorByExperience.setBorderPainted(false);
		btnDoctorByExperience.setContentAreaFilled(false);
		btnDoctorByExperience.setFocusPainted(false);
		btnDoctorByExperience.setOpaque(false);
		btnDoctorByExperience.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					tableChosen = 0;
					String givenExperienceStr = givenExperienceTextField.getText();
					
					List<DoctorByExperience> doctors = null;
					
					if(givenExperienceStr != null && givenExperienceStr.trim().length()>0){
						int givenExperience = Integer.parseInt(givenExperienceStr);
						doctors = driver.searchDoctorsByExperience(givenExperience);
					}
					else{
						
						doctors = driver.getAllDoctorsByExperience();
					}
					
					DoctorByExperienceTableModel model = new DoctorByExperienceTableModel(doctors);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(dbPrescriptionsRX.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDoctorByExperience.setHorizontalAlignment(SwingConstants.LEFT);
		queriesBox.add(btnDoctorByExperience);
		
		givenExperienceTextField = new JTextField();
		givenExperienceTextField.setColumns(10);
		queriesBox.add(givenExperienceTextField);
		
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
	
	public void refreshPharmacyView() {
		try{
			List<Pharmacy> pharmacies = driver.getAllPharmacies();
			
			PharmacyTableModel model = new PharmacyTableModel(pharmacies);
			
			table.setModel(model);
		}
		catch(Exception exc){
			JOptionPane.showMessageDialog(this, "Error: "+exc, "Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void refreshDrugView() {
		try{
			List<Drug> drugs = driver.getAllDrugs();
			
			DrugTableModel model = new DrugTableModel(drugs);
			
			table.setModel(model);
		}
		catch(Exception exc){
			JOptionPane.showMessageDialog(this, "Error: "+exc, "Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
