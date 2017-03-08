package dbProject;

public class DrugByPrescription{
		
	private String Name;
	private int NumPrescriptions;
		
	public DrugByPrescription(String Name, int NumPrescriptions){
		
		super();
		this.Name = Name;
		this.NumPrescriptions = NumPrescriptions;
		
	}
	
	public String getName(){
		return this.Name;
	}
	
	public int getNumPrescriptions(){
		return this.NumPrescriptions;
	}
}
