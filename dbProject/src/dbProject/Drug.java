package dbProject;

public class Drug{
		
	private int DrugId;
	private String Name;
	private String Formula;
	private String PharmaceuticalCompanyName;
		
	public Drug(int DrugId, String Name, String Formula, String PharmaceuticalCompanyName){
		
		super();
		this.DrugId = DrugId;
		this.Name = Name;
		this.Formula = Formula;
		this.PharmaceuticalCompanyName = PharmaceuticalCompanyName;
		
	}
	
	public Drug(String Name, String Formula, String PharmaceuticalCompanyName){
		
		super();
		this.Name = Name;
		this.Formula = Formula;
		this.PharmaceuticalCompanyName = PharmaceuticalCompanyName;
		
	}

	public int getDrugId(){
		return this.DrugId;
	}
	
	public void setDrugId(int drugId){
		this.DrugId = drugId;
	}
	
	public String getName(){
		return this.Name;
	}
	
	public void setName(String Name){
		this.Name = Name;
	}
	
	public String getFormula(){
		return this.Formula;
	}
	
	public void setFormula(String Formula){
		this.Formula = Formula;
	}
	
	public String getPharmaceuticalCompanyName(){
		return this.PharmaceuticalCompanyName;
	}
	
	public void setPharmaceuticalCompanyName(String PharmaceuticalCompanyName){
		this.PharmaceuticalCompanyName = PharmaceuticalCompanyName;
	}
	
}
