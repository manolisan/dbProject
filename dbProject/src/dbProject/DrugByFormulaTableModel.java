package dbProject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class DrugByFormulaTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int NAME_COL = 0;
	private static final int FORMULA_COL = 1;
	
	private String[] columnNames = {"Name", "Formula"};
	private List<DrugByFormula> drugs;
	
	public DrugByFormulaTableModel(List<DrugByFormula> theDrugs){
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
		
		DrugByFormula tempDrug = drugs.get(row);
		switch(col){
		case NAME_COL:
			return tempDrug.getName();
		case FORMULA_COL:
			return tempDrug.getFormula();
		default:
			return tempDrug;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
