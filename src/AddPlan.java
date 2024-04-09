
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;

public class AddPlan
{
	static JFrame mainbox;
	static JTextField nameinp;

	static JTextField priceinp;

	static String dname = "";
	static int dprice = 0;
	public static void create()
	{
		mainbox = new JFrame();
		mainbox.setSize(620,500);

		nameinp = new JTextField();
		priceinp = new JTextField();


		JLabel main = new JLabel("Add Plan");
		main.setBounds(207, 5, 250, 40);
		main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));

		JLabel name = new JLabel("Enter plan Name");
		name.setBounds(120, 35, 400,20);
		nameinp.setBounds(120, 55, 370,30);

		JLabel price = new JLabel("Enter plan price");
		price.setBounds(120, 100, 400,20);
		priceinp.setBounds(120, 120 , 370,30);



		JButton submit = new JButton("Submit");
		submit.setBounds(220, 170, 160,35);
		submit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if( nameinp.getText().isEmpty() || priceinp.getText().isEmpty())

				{
					JOptionPane.showMessageDialog(null, "Data Missing");
				}
				else
				{
					dname = nameinp.getText();
					dprice = Integer.parseInt(priceinp.getText());


					nameinp.setText("");
					priceinp.setText("");
					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
						Statement stat=conn.createStatement();


						stat.executeUpdate("insert into plans values('"+dname+"',"+dprice+")");
						JOptionPane.showMessageDialog(null, "Data Submitted");
					}
					catch (Exception e)
					{
						JOptionPane.showMessageDialog(null, "Failed");
						e.printStackTrace();
					}
				}
			}
		});

		mainbox.add(main);
		mainbox.add(name);
		mainbox.add(nameinp);
		mainbox.add(price);
		mainbox.add(priceinp);
		mainbox.add(submit);

		mainbox.setLayout(null);
		mainbox.setVisible(true);
	}

/*	public static void main( String[] args )
	{
		create();
	}*/
}

//REFERENCES:_
//https://examples.javacodegeeks.com/desktop-java/swing/java-swing-form-example/