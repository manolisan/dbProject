package dbProject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class PharmacyTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int NAME_COL = 0;
	private static final int TOWN_COL = 1;
	private static final int STREET_NAME_COL = 2;
	private static final int NUMBER_COL = 3;
	private static final int POSTAL_CODE_COL = 4;
	private static final int PHONE_NUMBER_COL = 5;
	
	private String[] columnNames = {"Name", "Town", "Street Name", "Number", "Postal Code", "Phone Number"};
	private List<Pharmacy> pharmacies;
	
	public PharmacyTableModel(List<Pharmacy> thePharmacies){
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
		
		Pharmacy tempPharmacy = pharmacies.get(row);
		switch(col){
		case NAME_COL:
			return tempPharmacy.getName();
		case TOWN_COL:
			return tempPharmacy.getTown();
		case STREET_NAME_COL:
			return tempPharmacy.getStreetName();
		case NUMBER_COL:
			return tempPharmacy.getNumber();
		case POSTAL_CODE_COL:
			return tempPharmacy.getPostalCode();
		case PHONE_NUMBER_COL:
			return tempPharmacy.getPhoneNumber();
		default:
			return tempPharmacy;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
