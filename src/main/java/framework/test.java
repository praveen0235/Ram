package framework;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
	
	private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://Users/Praveen/Desktop/138684.db3";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    
    /**
     * select all rows in the warehouses table
     */
    public void selectAll(){
        String sql = "SELECT * FROM Image";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet data    = stmt.executeQuery(sql)){
            
            // loop through the result set
//            while (rs.next()) {
//                System.out.println(rs.getInt("imageid") +  "\t" + 
//                                   rs.getInt("ImageName"));
//            }
        	
        	ResultSetMetaData table = data.getMetaData();

        	int coulmncount =table.getColumnCount();

        	for(int i=1;i<=coulmncount;i++)
        	{
        	System.out.print(table.getColumnName(i)+" , ");
        	}
        	System.out.println();
        	while(data.next())
        	{
        	for(int j=1;j<=coulmncount;j++)
        	{
        	System.out.print(data.getObject(j)+" , ");

        	}
        	System.out.println();
        	}

        	System.out.println(data);
        	
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test app = new test();
        app.selectAll();
	}

}
