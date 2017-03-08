package dbProject;

public class PatientContract{
		
	private String FirstName;
	private String LastName;
	private String Date;
	private String Drug;
		
	public PatientContract(String FirstName, String LastName, String Date, String Drug){
		
		super();
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Date = Date;
		this.Drug = Drug;
		
	}

	
	public String getFirstName(){
		return this.FirstName;
	}
	
	public String getLastName(){
		return this.LastName;
	}
	
	public String getDate(){
		return this.Date;
	}
	
	public String getDrug(){
		return this.Drug;
	}
}
