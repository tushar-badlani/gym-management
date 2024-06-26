
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;

public class AddCustomer
{
	static JFrame mainbox;
	static JTextField nameinp;
	static JTextField ageinp;
	static JTextField addressinp;
	static JTextField planinp;
	static JTextField phoneinp;
	static JTextField expinp;
	
	static int customerno = 100;
	static String dname = "";
	static int dage = 0;
	static String daddress = "";
	static String dplan = "";
	static int dphone = 0;
	static int dexp = 0;
	public static void create()
	{
		mainbox = new JFrame();
		mainbox.setSize(620,600);
		
		nameinp = new JTextField();
		ageinp = new JTextField();
		addressinp = new JTextField();
		planinp = new JTextField();
		phoneinp = new JTextField();
		expinp = new JTextField();
		
		JLabel main = new JLabel("Add Customer");
		main.setBounds(207, 5, 250, 40);
		main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));
		
		JLabel name = new JLabel("Enter Your Name");
		name.setBounds(120, 55, 400,20);
		nameinp.setBounds(120, 75, 370,30);
		
		JLabel age = new JLabel("Enter Your Age");
		age.setBounds(120, 120, 400,20);
		ageinp.setBounds(120, 140 , 370,30);
		
		JLabel address = new JLabel("Enter Your Address");
		address.setBounds(120, 185, 400,20);
		addressinp.setBounds(120, 205 , 370,30);
		
		JLabel plan = new JLabel("Enter Your Plan ( Regular/VIP ) ");
		plan.setBounds(120, 250, 400,20);
		planinp.setBounds(120, 270 , 370,30);

		JLabel phone = new JLabel("Enter Your Phone Number");
		phone.setBounds(120, 315, 400,20);
		phoneinp.setBounds(120, 335 , 370,30);

		JLabel exp = new JLabel("Enter number of months of membership");
		exp.setBounds(120, 380, 400,20);
		expinp.setBounds(120, 400 , 370,30);

		
		JButton submit = new JButton("Submit");
		submit.setBounds(240, 450, 160,35);
		submit.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if( nameinp.getText().isEmpty() || (ageinp.getText().isEmpty()) 
						|| (addressinp.getText().isEmpty()) ||
						(planinp.getText().isEmpty()) || (phoneinp.getText().isEmpty()) ||
						(expinp.getText().isEmpty()))
				{
						JOptionPane.showMessageDialog(null, "Data Missing");
				}
				else
				{
					dname = nameinp.getText();
					dage = Integer.parseInt(ageinp.getText());
					daddress = addressinp.getText();
					dplan = planinp.getText();
					dphone = Integer.parseInt(phoneinp.getText());
					dexp = Integer.parseInt(expinp.getText());


					nameinp.setText("");
					ageinp.setText("");
					addressinp.setText("");
					planinp.setText("");
					phoneinp.setText("");
					expinp.setText("");
					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
						Statement stat=conn.createStatement();
						customerno++;
						System.out.println(customerno);
						System.out.println("insert into customer values("+customerno+","+"'"+dname+"'"+","+ "'"+daddress+ "'"+","+
								dage+","+dphone+");");
						stat.execute("insert into customer values("+"customer_id_seq.NEXTVAL" + "," + "'" +
								dname + "'" + "," + "'" + daddress + "'" + "," +
								dage + "," + dphone + ")");
						dexp = dexp * 30;
						stat.execute("insert into membership values(" + "customer_id_seq.CURRVAL" + "," + "'" +
								dplan + "'" + "," + "sysdate"+ "+"+ dexp + ")");

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

		JButton back = new JButton("Back");
		back.setBounds(10, 10, 80, 30);
		back.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				mainbox.dispose();
				Customer c= new Customer();
				c.create();
			}
		});
	
		mainbox.add(main);
		mainbox.add(name);
		mainbox.add(nameinp);
		mainbox.add(age);
		mainbox.add(ageinp);
		mainbox.add(address);
		mainbox.add(addressinp);
		mainbox.add(plan);
		mainbox.add(planinp);
		mainbox.add(phone);
		mainbox.add(phoneinp);
		mainbox.add(exp);
		mainbox.add(expinp);
		mainbox.add(submit);
		//mainbox.add(back);
		
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