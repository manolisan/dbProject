package dbProject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class DrugTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int NAME_COL = 0;
	private static final int FORMULA_COL = 1;
	private static final int PHARMACEUTICAL_COMPANY_NAME_COL = 2;
	
	private String[] columnNames = {"Name", "Formula", "Company Name"};
	private List<Drug> drugs;
	
	public DrugTableModel(List<Drug> theDrugs){
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
		
		Drug tempDrug = drugs.get(row);
		switch(col){
		case NAME_COL:
			return tempDrug.getName();
		case FORMULA_COL:
			return tempDrug.getFormula();
		case PHARMACEUTICAL_COMPANY_NAME_COL:
			return tempDrug.getPharmaceuticalCompanyName();
		default:
			return tempDrug;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
