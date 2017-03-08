package dbProject;

public class DoctorByPatients{
		
	private String FirstName;
	private String LastName;
	private int numPatients;
		
	public DoctorByPatients(String FirstName, String LastName, int numPatients){
		
		super();
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.numPatients = numPatients;
	}
	
	
	public String getFirstName(){
		return this.FirstName;
	}
	
	public String getLastName(){
		return this.LastName;
	}
	
	public int getNumPatients(){
		return this.numPatients;
	}
}
