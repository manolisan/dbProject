package jdbcdemo;

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

		Doctor tempEmployee = new Doctor(id, lastName, firstName, speciality, experienceYears);

		return tempEmployee;
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
	
	public static void main(String[] args) throws Exception {

		Driver dao = new Driver();
		List<Doctor> tempList = dao.getAllDoctors();
		for(int i = 0; i < tempList.size(); i++) {
			Doctor doc = tempList.get(i);
            System.out.println(doc.getDoctorId()+", "+doc.getFirstName()+", "+doc.getLastName()+", "+doc.getSpeciality()+", "+doc.getExperienceYears());
        }

	}

}
