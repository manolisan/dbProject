package dbProject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class DrugsBySpecialityTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int NAME_COL = 0;
	
	private String[] columnNames = {"Drug Name"};
	private List<String> drugs;
	
	public DrugsBySpecialityTableModel(List<String> theDrugs){
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
		
		String tempDrug = drugs.get(row);
		switch(col){
		case NAME_COL:
			return tempDrug;
		default:
			return tempDrug;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
