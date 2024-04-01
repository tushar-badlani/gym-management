
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;

public class addstaff
{
	static JFrame mainbox;
	static JTextField nameinp;
	static JTextField ageinp;
	static JTextField addressinp;
	static JTextField roleinp;
	static JTextField phoneinp;
	static JTextField salaryinp;

	static String dname = "";
	static int dage = 0;
	static String daddress = "";
	static String drole = "";
	static int dphone = 0;
	static int dsal = 0;
	public static void create()
	{
		mainbox = new JFrame();
		mainbox.setSize(620,500);

		nameinp = new JTextField();
		ageinp = new JTextField();
		addressinp = new JTextField();
		roleinp = new JTextField();
		phoneinp = new JTextField();
		salaryinp = new JTextField();

		JLabel main = new JLabel("Add Staff");
		main.setBounds(207, 5, 250, 25);
		main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));

		JLabel name = new JLabel("Enter Your Name");
		name.setBounds(120, 35, 400,20);
		nameinp.setBounds(120, 55, 370,30);

		JLabel age = new JLabel("Enter Your Age");
		age.setBounds(120, 100, 400,20);
		ageinp.setBounds(120, 120 , 370,30);

		JLabel address = new JLabel("Enter Your Address");
		address.setBounds(120, 165, 400,20);
		addressinp.setBounds(120, 185 , 370,30);

		JLabel role = new JLabel("Enter Your Role: ");
		role.setBounds(120, 230, 400,20);
		roleinp.setBounds(120, 250 , 370,30);

		JLabel phone = new JLabel("Enter Your Phone Number");
		phone.setBounds(120, 295, 400,20);
		phoneinp.setBounds(120, 315 , 370,30);

		JLabel sal = new JLabel("Enter current salary");
		sal.setBounds(120, 350, 400,20);
		salaryinp.setBounds(120, 370 , 370,30);


		JButton submit = new JButton("Submit");
		submit.setBounds(220, 420, 160,35);
		submit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if( nameinp.getText().isEmpty() || (ageinp.getText().isEmpty())
						|| (addressinp.getText().isEmpty()) ||
						(roleinp.getText().isEmpty()) || (phoneinp.getText().isEmpty()) ||
						(salaryinp.getText().isEmpty()))
				{
					JOptionPane.showMessageDialog(null, "Data Missing");
				}
				else
				{
					dname = nameinp.getText();
					dage = Integer.parseInt(ageinp.getText());
					daddress = addressinp.getText();
					drole = roleinp.getText();
					dphone = Integer.parseInt(phoneinp.getText());
					dsal = Integer.parseInt(salaryinp.getText());

					JOptionPane.showMessageDialog(null, "Data Submitted");
					nameinp.setText("");
					ageinp.setText("");
					addressinp.setText("");
					roleinp.setText("");
					phoneinp.setText("");
					salaryinp.setText("");
					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
						Statement stat=conn.createStatement();


						stat.execute("insert into staff values(" + "staff_id_seq.NEXTVAL" + "," + "'" +
								dname + "'" + "," + "'" + daddress + "'" + "," + dage + "," + dphone + "," + dsal + "," + "'" + drole + "'" + ")");


					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		});

		mainbox.add(main);
		mainbox.add(name);
		mainbox.add(nameinp);
		mainbox.add(age);
		mainbox.add(ageinp);
		mainbox.add(address);
		mainbox.add(addressinp);
		mainbox.add(role);
		mainbox.add(roleinp);
		mainbox.add(phone);
		mainbox.add(phoneinp);
		mainbox.add(sal);
		mainbox.add(salaryinp);
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