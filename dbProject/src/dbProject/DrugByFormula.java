package dbProject;

public class DrugByFormula{
		
	private String Name;
	private String Formula;
		
	public DrugByFormula(String Name, String Formula){
		
		super();
		this.Name = Name;
		this.Formula = Formula;
		
	}

	public String getName(){
		return this.Name;
	}
	
	public String getFormula(){
		return this.Formula;
	}
	
}
