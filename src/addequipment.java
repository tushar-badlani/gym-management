
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;

public class addequipment
{
	static JFrame mainbox;
	static JTextField nameinp;


	static String dname = "";

	public static void create()
	{
		mainbox = new JFrame();
		mainbox.setSize(620,500);

		nameinp = new JTextField();



		JLabel main = new JLabel("Add Plan");
		main.setBounds(207, 5, 250, 25);
		main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));

		JLabel name = new JLabel("Enter plan Name");
		name.setBounds(120, 35, 400,20);
		nameinp.setBounds(120, 55, 370,30);



		JButton submit = new JButton("Submit");
		submit.setBounds(220, 100, 160,35);
		submit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if( nameinp.getText().isEmpty() )

				{
					JOptionPane.showMessageDialog(null, "Data Missing");
				}
				else
				{
					dname = nameinp.getText();



					nameinp.setText("");

					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
						Statement stat=conn.createStatement();


						System.out.println("insert into equipment values(equipment_id_seq"+",'"+dname+"',"+"sysdate"+",sysdate"+")");

						stat.executeUpdate("insert into equipment values(equipment_id_seq.NEXTVAL"+",'"+dname+"',"+"sysdate"+",sysdate"+")");
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