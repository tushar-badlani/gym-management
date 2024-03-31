
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;

public class addcustomer
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
		mainbox.setSize(620,500);
		
		nameinp = new JTextField();
		ageinp = new JTextField();
		addressinp = new JTextField();
		planinp = new JTextField();
		phoneinp = new JTextField();
		expinp = new JTextField();
		
		JLabel main = new JLabel("Add Customer");
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
		
		JLabel plan = new JLabel("Enter Your Plan ( Regular/VIP ) ");
		plan.setBounds(120, 230, 400,20);
		planinp.setBounds(120, 250 , 370,30);

		JLabel phone = new JLabel("Enter Your Phone Number");
		phone.setBounds(120, 295, 400,20);
		phoneinp.setBounds(120, 315 , 370,30);

		JLabel exp = new JLabel("Enter number of months of membership");
		exp.setBounds(120, 350, 400,20);
		expinp.setBounds(120, 370 , 370,30);

		
		JButton submit = new JButton("Submit");
		submit.setBounds(220, 400, 160,35);
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

					JOptionPane.showMessageDialog(null, "Data Submitted");
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
						//ResultSet res=stat.executeQuery("insert into customer values(customerno,'dname',dage,'daddress','7');");
						//ResultSet res2 = stat.executeQuery("insert into membershipplan values('dplan',10,customerno);");
						//stat.execute("insert into customer values(9,'vipul',20,'Nehru Place',7)");
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
						//stat.execute("commit");
						//boolean res=stat.execute("insert into customer values("+customerno+","+"'"+dname+"'"+","+dage+","+"'"+daddress+"'"+","+trainerid+");\"");
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
		mainbox.add(plan);
		mainbox.add(planinp);
		mainbox.add(phone);
		mainbox.add(phoneinp);
		mainbox.add(exp);
		mainbox.add(expinp);
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