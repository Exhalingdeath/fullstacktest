package com.blogspot.sqlboy;

import java.sql.*;

public class DatabaseHandler {
	public static String getResult() {
	 String url = "jdbc:sqlserver://jyme.database.windows.net:1433;database=movies;user=eiliv@jyme;"
				+ "password=Kr1LLkake;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		        Connection connection = null;
		        String temp = null;
				 try {
					 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		            connection = DriverManager.getConnection(url);
		            String schema = connection.getSchema();
		            System.out.println("Successful connection - Schema: " + schema);

		            System.out.println("Query data example:");
		            System.out.println("=========================================");

		            // Create and execute a SELECT SQL statement.
		            String selectSql = "SELECT * "
		                + "FROM dbo.movielist";  
		               
		         
		            try (Statement statement = connection.createStatement();
		            ResultSet resultSet = statement.executeQuery(selectSql)) {
		            	resultSet.next();
		            	temp = resultSet.getString(2);
		                // Print results from select statement
		                System.out.println("Top 20 categories:");
		                while (resultSet.next())
		                {
		                    System.out.println(resultSet.getString(1) + " "
		                        + resultSet.getString(2));
		                }
		                connection.close();
		            	//return temp;
		            }
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return "sock";
		        }
				return temp;
	
			
	}
				
}
