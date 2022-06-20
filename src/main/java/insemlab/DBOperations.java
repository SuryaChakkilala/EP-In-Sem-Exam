package insemlab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBOperations {
	public static void createTable() {
		try {
			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			st.execute("create table hospital(patientid int primary key, name varchar(255), age int, contactno varchar(255))");
			System.out.println("hospital table has been created");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void insertRecord(int id, String name, int age, String contactno) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con.prepareStatement("insert into hospital values(?, ?, ?, ?)");
			st.setInt(1, id);
			st.setString(2, name);
			st.setInt(3, age);
			st.setString(4, contactno);
			int i = st.executeUpdate();
			if(i > 0) {
				System.out.println("Inserted one entry");
			} else {
				System.out.println("Failed to insert");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void displayRecords() {
		try {
			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from hospital");
			while(rs.next()) {
				System.out.println("PATIENT ID: " + rs.getInt(1) + "  NAME: " + rs.getString(2) + "  AGE: " + rs.getInt(3) + "  CONTACTNO: " + rs.getString(4));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void deleteRecord(int id) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con.prepareStatement("select * from hospital where patientid=?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				System.out.println("PATIENT ID: " + rs.getInt(1) + "  NAME: " + rs.getString(2) + "  AGE: " + rs.getInt(3) + "  CONTACTNO: " + rs.getString(4));
			}
			PreparedStatement st2 = con.prepareStatement("delete from hospital where patientid=?");
			st2.setInt(1, id);
			int i = st2.executeUpdate();
			if(i > 0) {
				System.out.println("Entry has been deleted");
			} else {
				System.out.println("Entry not deleted");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void updateRecord(int id, String newName, int newAge) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con.prepareStatement("update hospital set name=?, age=? where patientid=?");
			st.setString(1, newName);
			st.setInt(2, newAge);
			st.setInt(3, id);
			int i = st.executeUpdate();
			if(i > 0) {
				System.out.println(i + " Entries updated");
			} else {
				System.out.println("No entries updated");
			}
			Statement st2 = con.createStatement();
			ResultSet rs = st2.executeQuery("select * from hospital");
			while(rs.next()) {
				System.out.println("PATIENT ID: " + rs.getInt(1) + "  NAME: " + rs.getString(2) + "  AGE: " + rs.getInt(3) + "  CONTACTNO: " + rs.getString(4));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
