package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentModify {
	public static List<Student> findAll() {
		List<Student> studentList = new ArrayList<>();
		Connection conn = JDBCUtil.connect();
		Statement statement = null;
		
		try {
			String sql = "SELECT * FROM student";
			statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				String id = result.getString("id");
				String fullname = result.getString("fullname");
				String gender = result.getString("gender");
				int age = result.getInt("age");
				String email = result.getString("email");
				String address = result.getString("address");
				
				Student std = new Student(id, fullname, address, gender, email, age);
				
				studentList.add(std);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			JDBCUtil.disConnect(conn);
		}
		
		return studentList;
	}
	
	public static void insert(Student std) {
		Connection conn = JDBCUtil.connect();
		PreparedStatement prepare = null;
		
		try {
			String sql = "INSERT INTO student VALUES(?, ?, ?, ?, ?, ?)";
			prepare = conn.prepareStatement(sql);
			
			prepare.setString(1, std.getID());
			prepare.setString(2, std.getFullname());
			prepare.setString(3, std.getGender());
			prepare.setInt(4, std.getAge());
			prepare.setString(5, std.getEmail());
			prepare.setString(6, std.getAddress());
			
			prepare.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(prepare != null) {
				try {
					prepare.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			JDBCUtil.disConnect(conn);
		}
	}
	
	public static void update(Student std) {
		Connection conn = JDBCUtil.connect();
		PreparedStatement prepare = null;
		
		try {
			String sql = "UPDATE student SET fullname=?, gender=?, age=?, email=?, address=? WHERE id=?";
			prepare = conn.prepareStatement(sql);
			
			prepare.setString(1, std.getFullname());
			prepare.setString(2, std.getGender());
			prepare.setInt(3, std.getAge());
			prepare.setString(4, std.getEmail());
			prepare.setString(5, std.getAddress());
			prepare.setString(6, std.getID());
			
			prepare.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(prepare != null) {
				try {
					prepare.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			JDBCUtil.disConnect(conn);
		}
	}
	
	public static void remove(String id) {
		Connection conn = JDBCUtil.connect();
		PreparedStatement prepare = null;
		
		try {
			String sql = "DELETE FROM student WHERE id=?";
			prepare = conn.prepareStatement(sql);
			
			prepare.setString(1, id);
			
			prepare.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(prepare != null) {
				try {
					prepare.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			JDBCUtil.disConnect(conn);
		}
	}
	
	public static List<Student> searchByName(String name) {
		List<Student> studentList = new ArrayList<>();
		Connection conn = JDBCUtil.connect();
		PreparedStatement prepare = null;
		
		try {
			String sql = "SELECT * FROM student WHERE fullname like ?";
			prepare = conn.prepareStatement(sql);
			
			prepare.setString(1, "%"+name+"%");
			
			ResultSet result = prepare.executeQuery();
			
			while(result.next()) {
				String id = result.getString("id");
				String fullname = result.getString("fullname");
				String gender = result.getString("gender");
				int age = result.getInt("age");
				String email = result.getString("email");
				String address = result.getString("address");
				
				Student std = new Student(id, fullname, address, gender, email, age);
				
				studentList.add(std);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(prepare != null) {
				try {
					prepare.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			JDBCUtil.disConnect(conn);
		}
		
		return studentList;
	}
}
