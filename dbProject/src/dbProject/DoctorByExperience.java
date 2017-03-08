package dbProject;

public class DoctorByExperience{
		
	private String FirstName;
	private String LastName;
	private int ExperienceYears;
		
	public DoctorByExperience(String FirstName, String LastName, int ExperienceYears){
		
		super();
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.ExperienceYears = ExperienceYears;
		
	}
	
	public String getFirstName(){
		return this.FirstName;
	}
	
	public String getLastName(){
		return this.LastName;
	}
	
	public int getExperienceYears(){
		return ExperienceYears;
	}
}
