
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.*;

public class updatecustomer
{
	static JFrame mainbox;
	static JTextField idinp;
	static JTextField nameinp;
	static JTextField ageinp;
	static JTextField addressinp;
	static JTextField planinp;
	static JTextField phoneinp;
	static JTextField expinp;

	static int did = 0;
	static String dname = "";
	static int dage = 0;
	static String daddress = "";
	static String dplan = "";
	static int dphone = 0;
	static int dexp = 0;
	public static void create()
	{
		mainbox = new JFrame();
		mainbox.setSize(620,500);


		idinp = new JTextField();
		nameinp = new JTextField();
		ageinp = new JTextField();
		addressinp = new JTextField();
		planinp = new JTextField();
		phoneinp = new JTextField();
		expinp = new JTextField();

		JLabel main = new JLabel("Update Customer");
		main.setBounds(207, 5, 250, 25);
		main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));

		JLabel id = new JLabel("Enter Customer ID");
		id.setBounds(120, 35, 400,20);
		idinp.setBounds(120, 55, 370,30);

		JLabel name = new JLabel("Enter Your Name");
		name.setBounds(120, 100, 400,20);
		nameinp.setBounds(120, 120, 370,30);



		JLabel address = new JLabel("Enter Your Address");
		address.setBounds(120, 165, 400,20);
		addressinp.setBounds(120, 185 , 370,30);



		JLabel phone = new JLabel("Enter Your Phone Number");
		phone.setBounds(120, 230, 400,20);
		phoneinp.setBounds(120, 250 , 370,30);




		JButton submit = new JButton("Submit");
		submit.setBounds(240, 420, 160,35);
		submit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if( nameinp.getText().isEmpty()
						|| (addressinp.getText().isEmpty()) ||
						 (phoneinp.getText().isEmpty()) ||
						(idinp.getText().isEmpty()))
				{
					JOptionPane.showMessageDialog(null, "Data Missing");
				}
				else
				{
					dname = nameinp.getText();
					did = Integer.parseInt(idinp.getText());
					daddress = addressinp.getText();

					dphone = Integer.parseInt(phoneinp.getText());



					nameinp.setText("");
					idinp.setText("");
					addressinp.setText("");

					phoneinp.setText("");

					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
						Statement stat=conn.createStatement();


						stat.execute("update customer set name = '" + dname + "', address = '" + daddress + "', phone_no = " + dphone + " where customer_id = " + did);



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
		mainbox.add(id);
		mainbox.add(idinp);
		mainbox.add(name);
		mainbox.add(nameinp);

		mainbox.add(address);
		mainbox.add(addressinp);

		mainbox.add(phone);
		mainbox.add(phoneinp);

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