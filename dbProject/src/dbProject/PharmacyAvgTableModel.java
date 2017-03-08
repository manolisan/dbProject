package dbProject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class PharmacyAvgTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int NAME_COL = 0;
	private static final int AVG_COL = 1;
	
	private String[] columnNames = {"Pharmacy Name", "Average Drug Price"};
	private List<PharmacyAvg> pharmacies;
	
	public PharmacyAvgTableModel(List<PharmacyAvg> thePharmacies){
		pharmacies = thePharmacies;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return pharmacies.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		PharmacyAvg tempPharmacy = pharmacies.get(row);
		switch(col){
		case NAME_COL:
			return tempPharmacy.getName();
		case AVG_COL:
			return tempPharmacy.getAvg();
		default:
			return tempPharmacy;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
