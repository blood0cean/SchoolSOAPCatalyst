package soap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.jws.WebService;

import models.Teacher;

@WebService(endpointInterface = "soap.Teacher")
public class TeacherImpl implements soap.Teacher {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/SchoolServiceSOAP";

	static final String USER = "root";
	static final String PASS = "root";

	@Override
	public String addTeacher(String firstName, String lastName) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);

			String insertTableSQL = "INSERT INTO Teacher(firstName, lastName) VALUES(?,?)";
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return String.format("Teacher %s %s added", firstName, lastName);
	}

	@Override
	public ArrayList<Teacher> getTeachers(String getAll) {
		Connection dbConnection = null;
		Statement stmt = null;
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = dbConnection.createStatement();

			String query="SELECT * FROM Teacher";
		     ResultSet rs=stmt.executeQuery(query);
		     while(rs.next())
		     {
					Teacher teacher = new Teacher();
					teacher.setId(rs.getLong("idTeacher"));
					teacher.setFirstName(rs.getString("firstName"));
					teacher.setLastName(rs.getString("lastName"));
					teachers.add(teacher);
		     }    
		     rs.close();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		
		return teachers;
	}

	@Override
	public String updateTeacher(int idTeacher, String firstName, String lastName) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);

			String insertTableSQL = "UPDATE Teacher SET firstName = ?, lastName = ? WHERE idTeacher = ?";
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setInt(3, idTeacher);
			
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return String.format("Teacher %s %s with ID %d updated", firstName, lastName, idTeacher);
	}

	@Override
	public Teacher getTeacher(int idTeacher) {
		Connection dbConnection = null;
		Statement stmt = null;
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = dbConnection.createStatement();

			String query="SELECT * FROM Teacher WHERE idTeacher = " + idTeacher;
		     ResultSet rs=stmt.executeQuery(query);
		     while(rs.next())
		     {
					Teacher teacher = new Teacher();
					teacher.setId(rs.getLong("idTeacher"));
					teacher.setFirstName(rs.getString("firstName"));
					teacher.setLastName(rs.getString("lastName"));
					teachers.add(teacher);
		     }    
		     rs.close();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		
		return !teachers.isEmpty() ? teachers.get(0) : null;
	}

}
