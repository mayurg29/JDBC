package com.bl.dbAutomationTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.bl.dbAutomation.Base;

public class DB_Test extends Base{
	
	@Test
	public void getStudentData() {
		try (Connection connection = this.setUp()){
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from student_info");
			while (result.next()) {
				int id = result.getInt(1);
				String name = result.getString(2);
				String phone = result.getString(3);
				String dept = result.getString(4);
				String college = result.getString(5);
				System.out.println(id +" | "+ name +" | "+ phone +" | "+ dept +" | "+ college);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void insertIntoStudentTable() {
        try (Connection connection = this.setUp()) {
            PreparedStatement ps = connection.prepareStatement("insert into student_info values (?,?,?,?,?)");
            ps.setInt(1, 6);
            ps.setString(2, "Prajwal");
            ps.setString(3, "7483578743");
            ps.setString(4, "MECH");
            ps.setString(5, "BIT");
            ps.executeUpdate();
            getStudentData();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	@Test
	public void deleteStudentData() {
        try (Connection connection = this.setUp()) {
            PreparedStatement ps = connection.prepareStatement("delete from student_info where name = ?");
            ps.setString(1, "Prajwal");
            ps.executeUpdate();
            getStudentData();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	@Test
	public void updateStudentData() {
        try (Connection connection = this.setUp()) {
            PreparedStatement ps = connection.prepareStatement("update student_info set department = ? where name = ?");
            ps.setString(1, "MECH");
            ps.setString(2, "Mayur");
            ps.executeUpdate();
            getStudentData();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}