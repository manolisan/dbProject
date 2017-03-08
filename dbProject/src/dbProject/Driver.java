package dbProject;

import java.sql.*;
import java.util.*;
import java.io.*;


public class Driver {

	private static Connection myConn;

	public Driver() throws Exception {

		// get db properties
		Properties props = new Properties();
		props.load(new FileInputStream("connection.properties"));

		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");

		// connect to database
		myConn = DriverManager.getConnection(dburl, user, password);

		System.out.println("DB connection successful to: " + dburl);
	}

	private Doctor convertRowToDoctor(ResultSet myRs) throws SQLException {

		int id = myRs.getInt("DoctorId");
		String lastName = myRs.getString("LastName");
		String firstName = myRs.getString("FirstName");
		String speciality = myRs.getString("Speciality");
		int experienceYears = myRs.getInt("ExperianceYears");

		Doctor tempDoctor = new Doctor(id, firstName, lastName, speciality, experienceYears);

		return tempDoctor;
	}
	
	private Pharmacy convertRowToPharmacy(ResultSet myRs) throws SQLException {

		int id = myRs.getInt("PharmacyId");
		String name = myRs.getString("Name");
		String town = myRs.getString("Town");
		String streetName = myRs.getString("StreetName");
		int number = myRs.getInt("Number");
		int postalCode = myRs.getInt("PostalCode");
		int phoneNumber = myRs.getInt("PhoneNumber");

		Pharmacy tempPharmacy = new Pharmacy(id, name, town, streetName, number, postalCode, phoneNumber);

		return tempPharmacy;
	}
	
	private Drug convertRowToDrug(ResultSet myRs) throws SQLException {

		int id = myRs.getInt("DrugId");
		String name = myRs.getString("Name");
		String formula = myRs.getString("Formula");
		String pharmaceuticalCompanyName = myRs.getString("PHARMACEUTICALCOMPANY.Name");

		Drug tempDrug = new Drug(id, name, formula, pharmaceuticalCompanyName);

		return tempDrug;
	}
	
	private DrugByFormula convertRowToDrugByFormula(ResultSet myRs) throws SQLException {

		String name = myRs.getString("Name");
		String formula = myRs.getString("Formula");

		DrugByFormula tempDrug = new DrugByFormula(name, formula);

		return tempDrug;
	}
	
	private PatientByDrugs convertRowToPatientByDrug(ResultSet myRs) throws SQLException {

		String firstName = myRs.getString("FirstName");
		String lastName = myRs.getString("LastName");
		int quantity = myRs.getInt("sum(Pr.Quantity)");

		PatientByDrugs tempPatient = new PatientByDrugs(firstName, lastName, quantity);

		return tempPatient;
	}
	
	private DoctorByPatients convertRowToDoctorByPatients(ResultSet myRs) throws SQLException {

		String firstName = myRs.getString("FirstName");
		String lastName = myRs.getString("LastName");
		int numPatients = myRs.getInt("COUNT(PATIENT.DoctorId)");

		DoctorByPatients tempPatient = new DoctorByPatients(firstName, lastName, numPatients);

		return tempPatient;
	}

	private SpecialityByExperience convertRowToSpecialityByExperience(ResultSet myRs) throws SQLException {

		String speciality = myRs.getString("Speciality");
		int numDoctors = myRs.getInt("COUNT(Speciality)");
		int avgExperience= myRs.getInt("AVG(ExperianceYears)");

		SpecialityByExperience tempSpeciality = new SpecialityByExperience(speciality, numDoctors, avgExperience);

		return tempSpeciality;
	}
	
	private PatientContract convertRowToPatientContract(ResultSet myRs) throws SQLException {

		String firstName = myRs.getString("FirstName");
		String lastName = myRs.getString("LastName");
		String date = myRs.getString("Date");
		String drug = myRs.getString("(select Name from DRUG where DRUG.DrugId = PR.DrugId)");

		PatientContract tempPatient = new PatientContract(firstName, lastName, date, drug);

		return tempPatient;
	}
	
	private PharmacyAvg convertRowToPharmacyAvg(ResultSet myRs) throws SQLException {

		String Name = myRs.getString("Name");
		int avg = myRs.getInt("avg(Price)");

		PharmacyAvg tempPharmacy = new PharmacyAvg(Name, avg);

		return tempPharmacy;
	}
	
	private PharmacyAvg convertRowToExpDrug(ResultSet myRs) throws SQLException {

		String Name = myRs.getString("Name");
		int avg = myRs.getInt("Price");

		PharmacyAvg tempPharmacy = new PharmacyAvg(Name, avg);

		return tempPharmacy;
	}

	private CompanyByDrug convertRowToCompanyByDrug(ResultSet myRs) throws SQLException {

		String Name = myRs.getString("Name");
		int numDrugs = myRs.getInt("COUNT(DRUG.PharmaceuticalCompanyId)");

		CompanyByDrug tempCompany = new CompanyByDrug(Name, numDrugs);

		return tempCompany;
	}
	
	private DrugByPrescription convertRowToDrugByPrescription(ResultSet myRs) throws SQLException {

		String Name = myRs.getString("Name");
		int numPrescriptions = myRs.getInt("COUNT(PRESCRIPTION.DrugId)");

		DrugByPrescription tempDrug = new DrugByPrescription(Name, numPrescriptions);

		return tempDrug;
	}
	
	private DrugByPrice convertRowToDrugByPrice(ResultSet myRs) throws SQLException {

		String Name = myRs.getString("Name");
		int price = myRs.getInt("Price");
		String pharmacyName = myRs.getString("(select Name from PHARMACY where PHARMACY.PharmacyId = s.PharmacyId)");

		DrugByPrice tempDrug = new DrugByPrice(Name, price, pharmacyName);

		return tempDrug;
	}
	
	private DoctorByExperience convertRowToDoctorByExperience(ResultSet myRs) throws SQLException {

		String firstName = myRs.getString("FirstName");
		String lastName = myRs.getString("LastName");
		int experienceYears = myRs.getInt("ExperianceYears");

		DoctorByExperience tempDoctor = new DoctorByExperience(firstName, lastName, experienceYears);

		return tempDoctor;
	}
	
	
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
	throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {

		}

		if (myConn != null) {
			myConn.close();
		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);
	}
	
	public List<Doctor> getAllDoctors() throws Exception{

		List<Doctor> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from DOCTOR");

			while(myRs.next()){
				Doctor tempDoctor = convertRowToDoctor(myRs);
				list.add(tempDoctor);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	
	public List<Pharmacy> getAllPharmacies() throws Exception{

		List<Pharmacy> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from PHARMACY");

			while(myRs.next()){
				Pharmacy tempPharmacy = convertRowToPharmacy(myRs);
				list.add(tempPharmacy);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	
	public List<Drug> getAllDrugs() throws Exception{

		List<Drug> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select DRUG.DrugId, DRUG.Name, DRUG.Formula, PHARMACEUTICALCOMPANY.Name from DRUG,PHARMACEUTICALCOMPANY where DRUG.PharmaceuticalCompanyId = PHARMACEUTICALCOMPANY.PharmaceuticalCompanyId");
			
			while(myRs.next()){
				Drug tempDrug = convertRowToDrug(myRs);
				list.add(tempDrug);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	
	public List<DrugByFormula> getDrugsByFormula() throws Exception{

		List<DrugByFormula> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select Name, Formula from DRUG order by Formula ASC");
			
			while(myRs.next()){
				DrugByFormula tempDrug = convertRowToDrugByFormula(myRs);
				list.add(tempDrug);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	
	public List<PatientByDrugs> getPatientByDrugs() throws Exception{

		List<PatientByDrugs> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select Pa.FirstName, Pa.LastName, sum(Pr.Quantity) from PATIENT as Pa, PRESCRIPTION as Pr where Pa.PatientId = Pr.PatientId group by Pa.PatientId having sum(Pr.Quantity) > 5 order by sum(Pr.Quantity) Desc;");
			
			while(myRs.next()){
				PatientByDrugs tempPatient = convertRowToPatientByDrug(myRs);
				list.add(tempPatient);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	
	public List<DoctorByPatients> getDoctorByPatients() throws Exception{

		List<DoctorByPatients> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select DOCTOR.FirstName,DOCTOR.LastName, COUNT(PATIENT.DoctorId) from DOCTOR RIGHT JOIN PATIENT ON DOCTOR.DoctorId = PATIENT.DoctorId group by DOCTOR.DoctorId order by COUNT(PATIENT.DoctorId) DESC;");
			
			while(myRs.next()){
				DoctorByPatients tempDoctor = convertRowToDoctorByPatients(myRs);
				list.add(tempDoctor);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	
	public List<SpecialityByExperience> getSpecialityByExperience() throws Exception{

		List<SpecialityByExperience> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select Speciality, COUNT(Speciality), AVG(ExperianceYears) from DOCTOR group by Speciality order by AVG(ExperianceYears) DESC;");
			
			while(myRs.next()){
				SpecialityByExperience tempSpeciality = convertRowToSpecialityByExperience(myRs);
				list.add(tempSpeciality);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	
	public List<PatientContract> getAllPatientContract() throws Exception{

		List<PatientContract> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select * from vTest1;");
			
			while(myRs.next()){
				PatientContract tempPatient = convertRowToPatientContract(myRs);
				list.add(tempPatient);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	
	public List<PharmacyAvg> getAllPharmacyAvg() throws Exception{

		List<PharmacyAvg> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select * from vTest2;");
			
			while(myRs.next()){
				PharmacyAvg tempPharmacy= convertRowToPharmacyAvg(myRs);
				list.add(tempPharmacy);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	
	public List<PharmacyAvg> getExpDrugs() throws Exception{

		List<PharmacyAvg> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select distinct d.Name, Price from SELL s INNER JOIN DRUG d ON d.DrugId=s.DrugId where Price> (select avg(Price) from SELL);");
			
			while(myRs.next()){
				PharmacyAvg tempPharmacy= convertRowToExpDrug(myRs);
				list.add(tempPharmacy);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	
	public List<CompanyByDrug> getCompanyByDrug() throws Exception{

		List<CompanyByDrug> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select PHARMACEUTICALCOMPANY.Name, COUNT(DRUG.PharmaceuticalCompanyId) from PHARMACEUTICALCOMPANY RIGHT JOIN DRUG ON PHARMACEUTICALCOMPANY.PharmaceuticalCompanyId = DRUG.PharmaceuticalCompanyId group by PHARMACEUTICALCOMPANY.PharmaceuticalCompanyId order by COUNT(DRUG.PharmaceuticalCompanyId) DESC;");
			
			while(myRs.next()){
				CompanyByDrug tempCompany= convertRowToCompanyByDrug(myRs);
				list.add(tempCompany);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	
	public List<DrugByPrescription> getDrugByPrescription() throws Exception{

		List<DrugByPrescription> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select DRUG.Name,COUNT(PRESCRIPTION.DrugId) from DRUG RIGHT JOIN PRESCRIPTION ON DRUG.DrugId = PRESCRIPTION.DrugId group by DRUG.DrugId order by COUNT(PRESCRIPTION.DrugId) DESC;");
			
			while(myRs.next()){
				DrugByPrescription tempDrug= convertRowToDrugByPrescription(myRs);
				list.add(tempDrug);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	
	public List<DrugByPrice> getDrugByPrice() throws Exception{

		List<DrugByPrice> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("SELECT Name,Price,(select Name from PHARMACY where PHARMACY.PharmacyId = s.PharmacyId) FROM  DRUG d INNER JOIN SELL s ON d.DrugId=s.DrugId order by Price desc;");
			
			while(myRs.next()){
				DrugByPrice tempDrug= convertRowToDrugByPrice(myRs);
				list.add(tempDrug);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}

	public List<Doctor> searchDoctors(String LastName) throws Exception{
		List<Doctor> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try{
			LastName += "%";
			myStmt = myConn.prepareStatement("select * from DOCTOR where LastName like ?");

			myStmt.setString(1, LastName);

			myRs = myStmt.executeQuery();

			while(myRs.next()){
				Doctor tempDoctor = convertRowToDoctor(myRs);
				list.add(tempDoctor);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}
	}
	
	public List<DrugByFormula> searchFormula(String formula) throws Exception{
		List<DrugByFormula> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try{
			formula += "%";
			myStmt = myConn.prepareStatement("select Name, Formula from DRUG where Formula like ?;");

			myStmt.setString(1, formula);

			myRs = myStmt.executeQuery();

			while(myRs.next()){
				DrugByFormula tempDrug = convertRowToDrugByFormula(myRs);
				list.add(tempDrug);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}
	}
	
	public List<DoctorByExperience> searchDoctorsByExperience(int experienceYears) throws Exception{
		List<DoctorByExperience> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try{
			//formula += "%";
			myStmt = myConn.prepareStatement("select distinct FirstName,LastName,ExperianceYears from DOCTOR group by DoctorId having ExperianceYears > ? order by ExperianceYears desc;");

			myStmt.setInt(1, experienceYears);

			myRs = myStmt.executeQuery();

			while(myRs.next()){
				DoctorByExperience tempDoctor = convertRowToDoctorByExperience(myRs);
				list.add(tempDoctor);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}
	}
	
	public List<String> searchDrugsBySpeciality(String speciality) throws Exception{
		List<String> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try{
			speciality += "%";
			myStmt = myConn.prepareStatement("select distinct d.Name from DRUG d where d.DrugId in (select p.DrugId from PRESCRIPTION p where p.DoctorId in (select d.DoctorId from DOCTOR d where d.speciality like ?) );");

			myStmt.setString(1, speciality);

			myRs = myStmt.executeQuery();

			while(myRs.next()){
				String tempString = myRs.getString("Name");
				list.add(tempString);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}
	}
	
	public List<String> getAllDrugsBySpeciality() throws Exception{
		List<String> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.prepareStatement("select DRUG.Name from DRUG;");

			myRs = myStmt.executeQuery();

			while(myRs.next()){
				String tempString = myRs.getString("Name");
				list.add(tempString);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}
	}
	
	public List<DoctorByExperience> getAllDoctorsByExperience() throws Exception{
		List<DoctorByExperience> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.prepareStatement("select DOCTOR.FirstName, DOCTOR.LastName, DOCTOR.ExperianceYears from DOCTOR;");

			myRs = myStmt.executeQuery();

			while(myRs.next()){
				DoctorByExperience tempDoctor = convertRowToDoctorByExperience(myRs);
				list.add(tempDoctor);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}
	}
	
	public void addDoctor(Doctor theDoctor) throws Exception{
		PreparedStatement myStmt = null;
		
		try{
			myStmt = myConn.prepareStatement("insert into DOCTOR"+
											 " (FirstName, LastName, Speciality, ExperianceYears)"+
											 " values (?,?,?,?)");
			
			myStmt.setString(1, theDoctor.getFirstName());
			myStmt.setString(2, theDoctor.getLastName());
			myStmt.setString(3, theDoctor.getSpeciality());
			myStmt.setInt(4, theDoctor.getExperienceYears());
			
			myStmt.executeUpdate();
			
		}
		finally{
			myStmt.close();
		}
	}
	
	public void addPharmacy(Pharmacy thePharmacy) throws Exception{
		PreparedStatement myStmt = null;
		
		try{
			myStmt = myConn.prepareStatement("insert into PHARMACY"+
											 " (Name, Town, StreetName, Number, PostalCode, PhoneNumber)"+
											 " values (?,?,?,?,?,?)");
			
			myStmt.setString(1, thePharmacy.getName());
			myStmt.setString(2, thePharmacy.getTown());
			myStmt.setString(3, thePharmacy.getStreetName());
			myStmt.setInt(4, thePharmacy.getNumber());
			myStmt.setInt(5, thePharmacy.getPostalCode());
			myStmt.setInt(6, thePharmacy.getPhoneNumber());
			myStmt.executeUpdate();
			
		}
		finally{
			myStmt.close();
		}
	}
	
	public void addDrug(Drug theDrug) throws Exception{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try{
			myStmt = myConn.prepareStatement("select PHARMACEUTICALCOMPANY.PharmaceuticalCompanyId from PHARMACEUTICALCOMPANY where PHARMACEUTICALCOMPANY.Name = ?");
			myStmt.setString(1, theDrug.getPharmaceuticalCompanyName());
			myRs = myStmt.executeQuery();
			myRs.next();
			int pharmaceuticalCompanyId = myRs.getInt("PharmaceuticalCompanyId");
			//System.out.println(pharmaceuticalCompanyId);
			myStmt.close();
			
			
			myStmt = myConn.prepareStatement("insert into DRUG"+
											 " (Name, Formula, PharmaceuticalCompanyId)"+
											 " values (?,?,?)");
			
			myStmt.setString(1, theDrug.getName());
			myStmt.setString(2, theDrug.getFormula());
			myStmt.setInt(3, pharmaceuticalCompanyId);
			myStmt.executeUpdate();
			myStmt.close();
			
			myStmt = myConn.prepareStatement("select last_insert_id();");
			myRs = myStmt.executeQuery();
			
			myRs.next();
			int drugId = myRs.getInt("last_insert_id()");
			theDrug.setDrugId(drugId);
			/*myStmt.close();
			
			myStmt = myConn.prepareStatement("insert into MAKE"+
					 " (PharmaceuticalCompanyId, DrugId)"+
					 " values (?,?)");
			myStmt.setInt(1, pharmaceuticalCompanyId);
			myStmt.setInt(2, drugId);
			myStmt.executeUpdate();*/
			
		}
		finally{
			myStmt.close();
		}
	}
	
	public void updateDoctor(Doctor theDoctor) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update DOCTOR"
					+ " set FirstName=?, LastName=?, Speciality=?, ExperianceYears=?"
					+ " where DoctorId=?");
			
			// set params
			myStmt.setString(1, theDoctor.getFirstName());
			myStmt.setString(2, theDoctor.getLastName());
			myStmt.setString(3, theDoctor.getSpeciality());
			myStmt.setInt(4, theDoctor.getExperienceYears());
			myStmt.setInt(5, theDoctor.getDoctorId());
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			myStmt.close();
		}
		
	}
	
	public void updatePharmacy(Pharmacy thePharmacy) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update PHARMACY"
					+ " set Name=?, Town=?, StreetName=?, Number=?, PostalCode=?, PhoneNumber=?"
					+ " where PharmacyId=?");
			
			// set params
			myStmt.setString(1, thePharmacy.getName());
			myStmt.setString(2, thePharmacy.getTown());
			myStmt.setString(3, thePharmacy.getStreetName());
			myStmt.setInt(4, thePharmacy.getNumber());
			myStmt.setInt(5, thePharmacy.getPostalCode());
			myStmt.setInt(6, thePharmacy.getPhoneNumber());
			myStmt.setInt(7, thePharmacy.getPharmacyId());
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			myStmt.close();
		}
		
	}
	
	public void updateDrug(Drug theDrug) throws SQLException {
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.prepareStatement("select PHARMACEUTICALCOMPANY.PharmaceuticalCompanyId from PHARMACEUTICALCOMPANY where PHARMACEUTICALCOMPANY.Name = ?");
			myStmt.setString(1, theDrug.getPharmaceuticalCompanyName());
			myRs = myStmt.executeQuery();
			myRs.next();
			int pharmaceuticalCompanyId = myRs.getInt("PharmaceuticalCompanyId");
			myStmt.close();
			
			// prepare statement
			myStmt = myConn.prepareStatement("update DRUG"
					+ " set Name=?, Formula=?, PharmaceuticalCompanyId=?"
					+ " where DrugId=?");
			
			// set params
			myStmt.setString(1, theDrug.getName());
			myStmt.setString(2, theDrug.getFormula());
			myStmt.setInt(3, pharmaceuticalCompanyId);
			myStmt.setInt(4, theDrug.getDrugId());
			
			// execute SQL
			myStmt.executeUpdate();
			myStmt.close();
		}
		finally {
			myStmt.close();
		}
		
	}
	
	public void deleteDoctor(int doctorId) throws SQLException{
		PreparedStatement myStmt = null;
		try{
			myStmt = myConn.prepareStatement("delete from DOCTOR where DoctorId=?");
			myStmt.setInt(1, doctorId);
			myStmt.executeUpdate();
		}
		finally{
			myStmt.close();
		}
	}
	
	public void deletePharmacy(int pharmacyId) throws SQLException{
		PreparedStatement myStmt = null;
		try{
			myStmt = myConn.prepareStatement("delete from PHARMACY where PharmacyId=?");
			myStmt.setInt(1, pharmacyId);
			myStmt.executeUpdate();
		}
		finally{
			myStmt.close();
		}
	}
	
	public void deleteDrug(int drugId) throws SQLException{
		PreparedStatement myStmt = null;
		try{
			myStmt = myConn.prepareStatement("delete from DRUG where DrugId=?");
			myStmt.setInt(1, drugId);
			myStmt.executeUpdate();
		}
		finally{
			myStmt.close();
		}
	}
	
	public static void main(String[] args) throws Exception {

		Driver dao = new Driver();
		List<Doctor> tempList = dao.getAllDoctors();
		for(int i = 0; i < tempList.size(); i++) {
			Doctor doc = tempList.get(i);
            System.out.println(doc.getDoctorId()+", "+doc.getFirstName()+", "+doc.getLastName()+", "+doc.getSpeciality()+", "+doc.getExperienceYears());
        }

	}

}
