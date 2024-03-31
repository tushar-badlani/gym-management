
import java.sql.*;
public class Driver {

	public static void main(String[] args) 
	{
		try
		{
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			Statement stat=conn.createStatement();
			ResultSet res=stat.executeQuery("select * from customer");
			while(res.next()) 
			{
				System.out.println(res.getInt("customer_id")+" "+res.getString("customer_name")+" "+res.getString("address")+" "+res.getInt("age"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
