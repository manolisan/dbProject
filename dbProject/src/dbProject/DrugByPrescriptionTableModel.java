package dbProject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class DrugByPrescriptionTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int NAME_COL = 0;
	private static final int NUM_PRESCRIPTIONS_COL = 1;
	
	private String[] columnNames = {"Drug Name", "Number of prescriptions"};
	private List<DrugByPrescription> drugs;
	
	public DrugByPrescriptionTableModel(List<DrugByPrescription> theDrugs){
		drugs = theDrugs;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return drugs.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		DrugByPrescription tempDrug = drugs.get(row);
		switch(col){
		case NAME_COL:
			return tempDrug.getName();
		case NUM_PRESCRIPTIONS_COL:
			return tempDrug.getNumPrescriptions();
		default:
			return tempDrug;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
