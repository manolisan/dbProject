package dbProject;

public class PharmacyAvg{

	private String Name;
	private int Avg;
		
	public PharmacyAvg(String Name, int Avg){
		
		super();
		this.Name = Name;
		this.Avg = Avg;
		
	}

	public String getName(){
		return this.Name;
	}
	
	public int getAvg(){
		return this.Avg;
	}
	
}
