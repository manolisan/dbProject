package dbProject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class DoctorByPatientsTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int LAST_NAME_COL = 1;
	private static final int FIRST_NAME_COL = 0;
	private static final int NUM_PATIENTS_COL = 2;
	
	private String[] columnNames = {"First Name", "Last Name", "Number of patients"};
	private List<DoctorByPatients> doctors;
	
	public DoctorByPatientsTableModel(List<DoctorByPatients> theDoctors){
		doctors = theDoctors;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return doctors.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		DoctorByPatients tempDoctor = doctors.get(row);
		switch(col){
		case LAST_NAME_COL:
			return tempDoctor.getLastName();
		case FIRST_NAME_COL:
			return tempDoctor.getFirstName();
		case NUM_PATIENTS_COL:
			return tempDoctor.getNumPatients();
		default:
			return tempDoctor;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
