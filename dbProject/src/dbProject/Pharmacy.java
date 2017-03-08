package dbProject;

public class Pharmacy{
		
	private int PharmacyId;
	private String Name;
	private String Town;
	private String StreetName;
	private int Number;
	private int PostalCode;
	private int PhoneNumber;
		
	public Pharmacy(int PharmacyId, String Name, String Town, String StreetName, int Number, int PostalCode, int PhoneNumber){
		
		super();
		this.PharmacyId = PharmacyId;
		this.Name = Name;
		this.Town = Town;
		this.StreetName = StreetName;
		this.Number = Number;
		this.PostalCode = PostalCode;
		this.PhoneNumber = PhoneNumber;
		
	}
	
	public Pharmacy(String Name, String Town, String StreetName, int Number, int PostalCode, int PhoneNumber){
		
		super();
		this.Name = Name;
		this.Town = Town;
		this.StreetName = StreetName;
		this.Number = Number;
		this.PostalCode = PostalCode;
		this.PhoneNumber = PhoneNumber;
		
	}

	public int getPharmacyId(){
		return this.PharmacyId;
	}
	
	public String getName(){
		return this.Name;
	}
	
	public void setName(String Name){
		this.Name = Name;
	}
	
	public String getTown(){
		return this.Town;
	}
	
	public void setTown(String Town){
		this.Town = Town;
	}
	
	public String getStreetName(){
		return this.StreetName;
	}
	
	public void setStreetName(String StreetName){
		this.StreetName = StreetName;
	}
	
	public int getNumber(){
		return Number;
	}
	
	public void setNumber(int Number){
		this.Number = Number;
	}
	
	public int getPostalCode(){
		return this.PostalCode;
	}
	
	public void setPostalCode(int PostalCode){
		this.PostalCode = PostalCode;
	}
	
	public int getPhoneNumber(){
		return this.PhoneNumber;
	}
	
	public void setPhoneNumber(int PhoneNumber){
		this.PhoneNumber = PhoneNumber;
	}
	
}
