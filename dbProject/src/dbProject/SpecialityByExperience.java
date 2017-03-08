package dbProject;

public class SpecialityByExperience{
		
	private String speciality;
	private int numDoctors;
	private int avgExperience;
		
	public SpecialityByExperience(String speciality, int numDoctors, int avgExperience){
		
		super();
		this.speciality = speciality;
		this.numDoctors = numDoctors;
		this.avgExperience = avgExperience;
	}
	
	
	public String getSpeciality(){
		return this.speciality;
	}
	
	public int getNumDoctors(){
		return this.numDoctors;
	}
	
	public int getAvgExperience(){
		return this.avgExperience;
	}
}
