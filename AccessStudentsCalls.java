package com.mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class AccessStudentsCalls {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	final private String host = "localhost:3306";
	final private String user = "mysqluser";
	final private String passwd = "crap2man";
	final private String database = "javatestdb1";

	public void connectToDB() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/"
					+ database + "?" + "user=" + user + "&password=" + passwd);
			System.out.println("Connected fine");
		} catch (Exception e) {
			throw e;
		}
	}

	public void readStudents() throws Exception {
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from " + database + ".students");
			while (resultSet.next()) {
				int Id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");

				System.out.println(String.format(
						"Id: %d name: %5s  phone: %5s", Id, name, phone));
			}
		} catch (Exception e) {
			System.out.println("some unknown error");
			throw e;
		}
	}

	// You need to close the resultSet
	public void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}
	
// below method is only	a place holder method for future ref
	public void addNewCall( int time, int Id1, int Id2, int length) throws Exception  {
		String query = "INSERT INTO `" + database + "`.`calls` (`Id`, `time`, `Id1`, `Id2`, `length`)"
				      + "VALUES (NULL, ?, ?, ?, ? )";
		try {
			preparedStatement = connect.prepareStatement( query );
			preparedStatement.setInt(1, time );
			preparedStatement.setInt(2, Id1 );
			preparedStatement.setInt(3, Id2 );
			preparedStatement.setInt(4, length );
			preparedStatement.executeUpdate();

		} catch ( Exception e) {
			throw e;
		}
	}
	
}
