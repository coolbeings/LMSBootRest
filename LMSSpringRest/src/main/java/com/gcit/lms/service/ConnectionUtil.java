/**
 * 
 */
package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ppradhan
 *
 */
public class ConnectionUtil {
	public String driver = "com.mysql.cj.jdbc.Driver";
	public String userName = "root";
	public String password = "Apoo1990@My";
	public String url = "jdbc:mysql://localhost/library?useSSL=false&serverTimezone=EDT&useLegacyDatetimeCode=false&serverTimezone=America/New_York";
	
	/**
	 *  Method to get MYSQL Database COnnection based on params.
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, userName, password);
		conn.setAutoCommit(Boolean.FALSE);
		return conn;
	}
}
