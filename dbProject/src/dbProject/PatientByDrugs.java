package dbProject;

public class PatientByDrugs{
		
	private String FirstName;
	private String LastName;
	private int Quantity;
		
	public PatientByDrugs(String FirstName, String LastName, int Quantity){
		
		super();
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Quantity = Quantity;
		
	}

	public String getPatientByDrugsFirstName(){
		return this.FirstName;
	}
	
	public String getPatientByDrugsLastName(){
		return this.LastName;
	}
	
	public int getPatientByDrugsQuantity(){
		return this.Quantity;
	}
}
