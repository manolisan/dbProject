package dbProject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class DoctorTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int LAST_NAME_COL = 1;
	private static final int FIRST_NAME_COL = 0;
	private static final int SPECIALITY_COL = 2;
	private static final int EXPERIENCE_YEARS_COL = 3;
	
	private String[] columnNames = {"First Name", "Last Name", "Speciality", "Years of experience"};
	private List<Doctor> doctors;
	
	public DoctorTableModel(List<Doctor> theDoctors){
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
		
		Doctor tempDoctor = doctors.get(row);
		switch(col){
		case LAST_NAME_COL:
			return tempDoctor.getLastName();
		case FIRST_NAME_COL:
			return tempDoctor.getFirstName();
		case SPECIALITY_COL:
			return tempDoctor.getSpeciality();
		case EXPERIENCE_YEARS_COL:
			return tempDoctor.getExperienceYears();
		default:
			return tempDoctor;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
