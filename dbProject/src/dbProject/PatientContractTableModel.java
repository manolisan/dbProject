package dbProject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class PatientContractTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int FIRST_NAME_COL = 0;
	private static final int LAST_NAME_COL = 1;
	private static final int DATE_COL = 2;
	private static final int DRUG_COL = 3;
	
	private String[] columnNames = {"First Name", "Last Name", "Prescription Date", "Drug"};
	private List<PatientContract> patients;
	
	public PatientContractTableModel(List<PatientContract> thePatients){
		patients = thePatients;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return patients.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		PatientContract tempPatient = patients.get(row);
		switch(col){
		case FIRST_NAME_COL:
			return tempPatient.getFirstName();
		case LAST_NAME_COL:
			return tempPatient.getLastName();
		case DATE_COL:
			return tempPatient.getDate();
		case DRUG_COL:
			return tempPatient.getDrug();
		default:
			return tempPatient;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
