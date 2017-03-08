package dbProject;

public class CompanyByDrug{
		
	private String Name;
	private int NumDrugs;
		
	public CompanyByDrug(String Name, int NumDrugs){
		
		super();
		this.Name = Name;
		this.NumDrugs = NumDrugs;
		
	}
	
	public String getName(){
		return this.Name;
	}
	
	public int getNumDrugs(){
		return this.NumDrugs;
	}
}
