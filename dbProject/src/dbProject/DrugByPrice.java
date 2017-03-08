package dbProject;

public class DrugByPrice{
		
	private String Name;
	private int Price;
	private String PharmacyName;
		
	public DrugByPrice(String Name, int Price, String PharmacyName){
		
		super();
		this.Name = Name;
		this.Price = Price;
		this.PharmacyName = PharmacyName;
		
	}
	
	public String getName(){
		return this.Name;
	}
	
	public int getPrice(){
		return this.Price;
	}
	
	public String getPharmacyName(){
		return this.PharmacyName;
	}
}
