package dbProject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class CompanyByDrugTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int NAME_COL = 0;
	private static final int NUM_DRUGS_COL = 1;
	
	private String[] columnNames = {"Company Name", "Number of drugs"};
	private List<CompanyByDrug> companies;
	
	public CompanyByDrugTableModel(List<CompanyByDrug> theCompanies){
		companies = theCompanies;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return companies.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		CompanyByDrug tempCompany = companies.get(row);
		switch(col){
		case NAME_COL:
			return tempCompany.getName();
		case NUM_DRUGS_COL:
			return tempCompany.getNumDrugs();
		default:
			return tempCompany;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
