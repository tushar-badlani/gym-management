
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class updatemembership
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

		JLabel main = new JLabel("Update Membership");
		main.setBounds(207, 5, 250, 25);
		main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));

		JLabel id = new JLabel("Enter Customer ID");
		id.setBounds(120, 35, 400,20);
		idinp.setBounds(120, 55, 370,30);


		JLabel plan = new JLabel("Enter Your Plan");
		plan.setBounds(120, 100, 400,20);
		planinp.setBounds(120, 120 , 370,30);


		JLabel exp = new JLabel("Enter number of months for extention");
		exp.setBounds(120, 165, 400,20);
		expinp.setBounds(120, 185 , 370,30);


		JButton submit = new JButton("Submit");
		submit.setBounds(240, 420, 160,35);
		submit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if( nameinp.getText().isEmpty()
						|| (planinp.getText().isEmpty()) ||
						(expinp.getText().isEmpty()))
				{
					JOptionPane.showMessageDialog(null, "Data Missing");
				}
				else
				{

					did = Integer.parseInt(idinp.getText());
					dplan = planinp.getText();
					dexp = Integer.parseInt(expinp.getText());



					idinp.setText("");
					planinp.setText("");
					expinp.setText("");

					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
						Statement stat=conn.createStatement();

						ResultSet res = stat.executeQuery("select plan from membership where id = " + did);
						String cplan = res.getString("plan");
						if(dplan==cplan){
							Integer expf = 30*dexp;
							stat.executeUpdate("update membership set plan = '"+dplan+"', exp = exp+"+expf+" where id = "+did);

						}
						//stat.executeUpdate("update membership set plan = '"+dplan+"', exp = "+dexp+" where id = "+did);


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
		//mainbox.add(name);
		mainbox.add(nameinp);

		mainbox.add(plan);
		mainbox.add(planinp);
		mainbox.add(exp);
		mainbox.add(expinp);

		//mainbox.add(address);
		mainbox.add(addressinp);

		//mainbox.add(phone);
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