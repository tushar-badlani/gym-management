
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class ViewAllEquipment
{
	public static void create()
	{
		JFrame frame = new JFrame();
		String[] columns = {"Equipment ID", "Name", "Date Purchased", "Last Maintained"};
		Object[][] data = new Object[12][4];

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
			Statement stat=conn.createStatement();
			ResultSet res=stat.executeQuery("select * from equipment");
			int i = 0;
			while( res.next() )
			{
				data[i][0] = res.getInt("equipment_id");
				data[i][1] = res.getString("equipment_name");
				data[i][2] = res.getDate("date_added");
				data[i][3] = res.getDate("last_maintained");


				i++;
				//System.out.println(res.getInt("customer_id")+" "+res.getString("name")+" "+res.getString("address")+" "+res.getInt("age")+" " + res.getInt("phone_no"));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		JTable table = new JTable(data, columns);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);

		JLabel lblHeading = new JLabel("Display All Customer Info");
		lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,30));

		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(lblHeading,BorderLayout.PAGE_START);
		frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
		frame.setSize(600, 300);
		frame.setVisible(true);
	}

/*	public static void main( String[] args )
	{
		create();
	}*/
}


/*
 * REFERECNES :-
 * http://www.zentut.com/java-swing/how-to-use-jtable-to-display-data/
 *
 *
 */
