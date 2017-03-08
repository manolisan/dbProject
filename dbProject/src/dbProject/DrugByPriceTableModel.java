package dbProject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class DrugByPriceTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int NAME_COL = 0;
	private static final int PRICE_COL = 1;
	private static final int PHARMACY_NAME_COL = 2;
	
	private String[] columnNames = {"Drug Name", "Price", "Pharmacy Name"};
	private List<DrugByPrice> drugs;
	
	public DrugByPriceTableModel(List<DrugByPrice> theDrugs){
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
		
		DrugByPrice tempDrug = drugs.get(row);
		switch(col){
		case NAME_COL:
			return tempDrug.getName();
		case PRICE_COL:
			return tempDrug.getPrice();
		case PHARMACY_NAME_COL:
			return tempDrug.getPharmacyName();
		default:
			return tempDrug;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
