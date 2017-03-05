package jdbcdemo;

public class Doctor{
		
	private int DoctorId;
	private String FirstName;
	private String LastName;
	private String Speciality;
	private int ExperienceYears;
		
	public Doctor(int DoctorId, String FirstName, String LastName, String Speciality, int ExperienceYears){
		
		super();
		this.DoctorId = DoctorId;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Speciality = Speciality;
		this.ExperienceYears = ExperienceYears;
		
	}
	
public Doctor(String FirstName, String LastName, String Speciality, int ExperienceYears){
		
		super();
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Speciality = Speciality;
		this.ExperienceYears = ExperienceYears;
		
	}

	public int getDoctorId(){
		return this.DoctorId;
	}
	
	public String getFirstName(){
		return this.FirstName;
	}
	
	public void setFirstName(String firstName){
		this.FirstName = firstName;
	}
	
	public String getLastName(){
		return this.LastName;
	}
	
	public void setLastName(String lastName){
		this.LastName = lastName;
	}
	
	public String getSpeciality(){
		return this.Speciality;
	}
	
	public void setSpeciality(String speciality){
		this.Speciality = speciality;
	}
	
	public int getExperienceYears(){
		return ExperienceYears;
	}
	
	public void setExperienceYears(int exp){
		this.ExperienceYears = exp;
	}
}
