package dbProject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class DoctorByExperienceTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int FIRST_NAME_COL = 0;
	private static final int LAST_NAME_COL = 1;
	private static final int EXPERIENCE_YEARS_COL = 2;
	
	private String[] columnNames = {"First Name", "Last Name", "Years of experience"};
	private List<DoctorByExperience> doctors;
	
	public DoctorByExperienceTableModel(List<DoctorByExperience> theDoctors){
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
		
		DoctorByExperience tempDoctor = doctors.get(row);
		switch(col){
		case LAST_NAME_COL:
			return tempDoctor.getLastName();
		case FIRST_NAME_COL:
			return tempDoctor.getFirstName();
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
