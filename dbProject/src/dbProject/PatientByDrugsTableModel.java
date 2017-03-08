package dbProject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class PatientByDrugsTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int FIRST_NAME_COL = 0;
	private static final int LAST_NAME_COL = 1;
	private static final int QUANTITY_COL = 2;
	
	private String[] columnNames = {"First Name", "Last Name", "Drug Quantity"};
	private List<PatientByDrugs> patients;
	
	public PatientByDrugsTableModel(List<PatientByDrugs> thePatients){
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
		
		PatientByDrugs tempPatient = patients.get(row);
		switch(col){
		case FIRST_NAME_COL:
			return tempPatient.getPatientByDrugsFirstName();
		case LAST_NAME_COL:
			return tempPatient.getPatientByDrugsLastName();
		case QUANTITY_COL:
			return tempPatient.getPatientByDrugsQuantity();
		default:
			return tempPatient;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
