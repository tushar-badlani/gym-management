
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class ViewAllStaff
{
	public static void create()
	{
		JFrame frame = new JFrame();
		String[] columns = {"Staff ID", "Name", "Address", "Age", "Phone Number", "Salary", "Role"};
		Object[][] data = new Object[12][7];

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
			Statement stat=conn.createStatement();
			ResultSet res=stat.executeQuery("select * from staff");
			int i = 0;
			while( res.next() )
			{
				data[i][0] = res.getInt("staff_id");
				data[i][1] = res.getString("name");
				data[i][2] = res.getString("address");
				data[i][3] = res.getInt("age");
				data[i][4] = res.getInt("phone_no");
				data[i][5] = res.getInt("salary");
				data[i][6] = res.getString("role");

				i++;
				System.out.println(res.getInt("staff_id")+" "+
						res.getString("name")+" "+
						res.getString("address")+" "+res.getInt("age")+" " +
						res.getInt("phone_no")+ " " + res.getInt("salary")+ " "
						+ res.getString("role"));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		JTable table = new JTable(data, columns);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setBounds(30, 75, 200, 300);

		JLabel lblHeading = new JLabel("Display All Staff Info");
		lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,30));
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setBounds(207, 5, 250, 40);

		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(lblHeading,BorderLayout.PAGE_START);
		frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
		frame.setSize(1000, 500);
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
