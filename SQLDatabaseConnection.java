import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


		public class SQLDatabaseConnection {  

			 Connection connection;
			 Statement statement;
             ResultSet resultSet;
			 
			public SQLDatabaseConnection(){
            	
            	try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
                String connectionString = "jdbc:sqlserver://BLACIO-PC:1433;"
                		+ "databaseName=AgentieFotomodele;"
                		+ "integratedSecurity=true;";
 
                connection = null;  
                statement = null;   
                resultSet = null;
                
                conectare(connectionString);
                
			}

			
			public void conectare(String connectionString){
                try {
					connection = DriverManager.getConnection(connectionString);
	                statement = connection.createStatement();  
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}

              
			public ResultSet Query(String query){

		        try {
		            statement = connection.createStatement();
		            resultSet = statement.executeQuery(query);
		        }
		        catch (Exception e) {
		            System.out.println("Exception in query method:\n" + e.getMessage());
		        }
		        return resultSet;
		    }
		           
			
		    public boolean Update (String update) {

		        try {
		            statement = connection.createStatement();
		            statement.executeUpdate(update);

		        }
		        catch (SQLException e) {
		            System.out.println("Exception in update method:\n" + e.getMessage());
		            return false;
		        }

		        return true;
		    }

                 
            public void closeConnection() {  
                    if (connection != null) try { 
                    	connection.close(); } catch(Exception e) {}  
                    if (statement != null) try { 
                    	connection.close(); } catch(Exception e) {}  
                    if (resultSet != null) try { 
                    	connection.close(); } catch(Exception e) {}  
                }  
        }  