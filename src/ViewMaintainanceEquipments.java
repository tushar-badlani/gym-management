
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewMaintainanceEquipments
{
	public static void create()
	{
		JFrame frame = new JFrame();
		String[] columns = {"Equipment ID","Equipment Name","Last Maintained"};
		Object[][] data = new Object[10][3];
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
			Statement stat=conn.createStatement();
			ResultSet res=stat.executeQuery("select * from equipment where (sysdate-last_maintained)>150");
			int i = 0;
			while(res.next()) 
			{
				data[i][0] = res.getInt("equipment_id");
				data[i][1] = res.getString("equipment_name");
				data[i][2] = res.getDate("last_maintained");
				//System.out.println(res.getInt("staff_id")+" "+res.getDouble("avg(age)"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	    
		JTable table = new JTable(data, columns);
	    JScrollPane scrollPane = new JScrollPane(table);
	    table.setFillsViewportHeight(true);
	 
	    JLabel lblHeading = new JLabel("Display Equipments that need maintenance");
	    lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,20));
	    
	    frame.getContentPane().setLayout(new BorderLayout());
	    frame.getContentPane().add(lblHeading,BorderLayout.PAGE_START);
	    frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
	    frame.setSize(800, 300);
	    frame.setVisible(true);
	}
	
	public static void main( String[] args )
	{
		create();
	}
	
}


/*
 * REFERECNES :-
 * http://www.zentut.com/java-swing/how-to-use-jtable-to-display-data/
 * 
 *
 */
