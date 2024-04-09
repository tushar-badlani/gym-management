
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class ViewAllPlans
{
	public static void create()
	{
		JFrame frame = new JFrame();
		String[] columns = {"Plan", "Price"};
		Object[][] data = new Object[12][2];

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
			Statement stat=conn.createStatement();
			ResultSet res=stat.executeQuery("select * from plans order by rate asc");
			int i = 0;
			while( res.next() )
			{
				data[i][0] = res.getString("name");
				data[i][1] = res.getInt("rate");


				i++;
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

		JLabel lblHeading = new JLabel("Display All Plans");
		lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,30));
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setBounds(207, 5, 250, 40);

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
