package dbProject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class SpecialityByExperienceTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int SPECIALITY_COL = 0;
	private static final int NUM_DOCTORS_COL = 1;
	private static final int AVG_EXPERIENCE_COL = 2;
	
	private String[] columnNames = {"Speciality", "Number of doctors", "Average doctor experience"};
	private List<SpecialityByExperience> specialities;
	
	public SpecialityByExperienceTableModel(List<SpecialityByExperience> theSpecialities){
		specialities = theSpecialities;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return specialities.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		SpecialityByExperience tempSpeciality = specialities.get(row);
		switch(col){
		case SPECIALITY_COL:
			return tempSpeciality.getSpeciality();
		case NUM_DOCTORS_COL:
			return tempSpeciality.getNumDoctors();
		case AVG_EXPERIENCE_COL:
			return tempSpeciality.getAvgExperience();
		default:
			return tempSpeciality;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
