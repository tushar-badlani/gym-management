
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Enumeration;
import java.awt.event.KeyEvent;


public class homepage 
{
	static JFrame mainbox;
	static ButtonGroup bg;
	static int disy = 0;
	public static void create()
	{
		mainbox = new JFrame();
		mainbox.setSize(760,600);
		
		JLabel banner = new JLabel("PCCOE GYM DATABASE MANAGEMENT SYSTEM");
		banner.setFont(new Font("JokerMan",3,25));
		banner.setVisible( true );
		banner.setBounds(100,7,280,50);
		
		JRadioButton op1 =new JRadioButton("Display All Customer Info ");
		JRadioButton op2 =new JRadioButton("Add Staff into Database  ");
		JRadioButton op3 =new JRadioButton("Display All Staff Info ");
		JRadioButton op4 =new JRadioButton("Add Customer into Database ");
		JRadioButton op5 =new JRadioButton("Add Plan into Database ");
		JRadioButton op6 =new JRadioButton("Display All Plan Info ");
//		JRadioButton op7 =new JRadioButton("Display Customer Names whose Trainer's Salary > 40000 - (COMPLEX) ");
//		JRadioButton op8 =new JRadioButton("Display Brand Names with average prices of their equipment - (COMPLEX) ");
//		JRadioButton op9 =new JRadioButton("Display Staff IDs with average age of their customers - (COMPLEX) ");
//		JRadioButton op10 =new JRadioButton("Display Equipment Names whose Weights > 30 and Color = 'RED' - (SIMPLE) ");
//		JRadioButton op11 =new JRadioButton("Display Customer IDs whose Membership Plan is 'Regular' with Duration Left(in months) - (SIMPLE) ");
//		JRadioButton op12 =new JRadioButton("Display Brand Names whose equipment's color = 'RED' and has total products > 3 - (COMPLEX) ");
//		JRadioButton op13 =new JRadioButton("Add Customer into Database - (SIMPLE) ");
//		JRadioButton op14 =new JRadioButton("Update Staff's Salary - (SIMPLE) ");
//		//JRadioButton op15 =new JRadioButton(" - (COMPLEX) ");
		
		op1.setBounds(25,50,400,30);    
		op2.setBounds(25,80,400,30);
		op3.setBounds(25,110,400,30);
		op4.setBounds(25,140,600,30);
		op5.setBounds(25,170,530,30);
		op6.setBounds(25,200,550,30);
//		op7.setBounds(25,230,550,30);
//		op8.setBounds(25,260,550,30);
//		op9.setBounds(25,290,530,30);
//		op10.setBounds(25,320,570,30);
//		op11.setBounds(25,350,610,30);
//		op12.setBounds(25,380,590,30);
//		op13.setBounds(25,410,590,30);
//		op14.setBounds(25,440,590,30);
		//op15.setBounds(25,470,590,30);
		
		bg = new ButtonGroup();    
		bg.add(op1);bg.add(op3);
		bg.add(op5);
		bg.add(op2);bg.add(op4);
		bg.add(op6);
//		bg.add(op7);bg.add(op9);bg.add(op11);
//		bg.add(op8);bg.add(op10);bg.add(op12);
//		bg.add(op13);bg.add(op14);
		//bg.add(op15);
		
		JButton button = new JButton("Select");
		button.setBounds(75,500,200,30);
		
		mainbox.add(banner);
		mainbox.add(op1);mainbox.add(op3);mainbox.add(op5);
		mainbox.add(op2);mainbox.add(op4);mainbox.add(op6);
//		mainbox.add(op7);mainbox.add(op9);mainbox.add(op11);
//		mainbox.add(op8);mainbox.add(op10);mainbox.add(op12);
//		mainbox.add(op13);mainbox.add(op14);
//		//mainbox.add(op15);
		
		mainbox.add(button);
		mainbox.setLayout(null);
		mainbox.setVisible(true);
		
	    button.addActionListener(new ActionListener() 
	    {
	        @Override 
	        public void actionPerformed(ActionEvent arg0) 
	        {
	          ButtonModel buttonModel = bg.getSelection();
	          if (buttonModel == null) {
	            System.out.println("No radio button is selected");
	          }
	          else
	          {
	        	for (Enumeration buttons = bg.getElements(); buttons.hasMoreElements();) 
	      		{
	      	        AbstractButton button = (AbstractButton) buttons.nextElement();
	      	        if (button.isSelected()) 
	      	        {
	      	            System.out.println(button.getText());
	      	            disy = button.getY();
	      	            if ( disy == 50 )
	      	            {
	      	            	get_customer gc = new get_customer();
							  gc.create();
	      	            }
	      	            else if ( disy == 80 )
	      	            {
	      	            	addstaff as = new addstaff();
	      	            	as.create();
	      	            }
	      	            else if ( disy == 110 )
	      	            {
	      	            	get_staff gs = new get_staff();
							  gs.create();
	      	            }
	      	            else if ( disy == 140 )
	      	            {
							addcustomer ac = new addcustomer();
							ac.create();
	      	            }
	      	            else if ( disy == 170 )
	      	            {
	      	            	addplan ap = new addplan();
	      	            	ap.create();
	      	            }
	      	            else if ( disy == 200 )
	      	            {
	      	            	get_plan gp = new get_plan();
							  gp.create();
	      	            }
	      	            else if ( disy == 230 )
	      	            {
	      	            	query7 q7 = new query7();
	      	            	q7.create();
	      	            }
	      	            else if ( disy == 260 )
	      	            {
	      	            	query8 q8 = new query8();
	      	            	q8.create();
	      	            }
	      	            else if ( disy == 290 )
	      	            {
	      	            	query9 q9 = new query9();
	      	            	q9.create();
	      	            }	
	      	            else if ( disy == 320 )
	      	            {
	      	            	query10 q10 = new query10();
	      	            	q10.create();
	      	            }
	      	            else if ( disy == 350 )
	      	            {
	      	            	query11 q11 = new query11();
	      	            	q11.create();
	      	            }
	      	            else if ( disy == 380 )
	      	            {
	      	            	query12 q12 = new query12();
	      	            	q12.create();
	      	            }
	      	            else if ( disy == 410 )
	      	            {
	      	            	addcustomer ac = new addcustomer();
	      	            	ac.create();
	      	            }
	      	            else if ( disy == 440 )
	      	            {
	      	            	query14 q14 = new query14();
	      	            	q14.create();
	      	            }
	      	            break;
	      	        }
	      	    }
	          }
	        }
	    });
	}
			    
	public static void main( String[] args )
	{
		create();
	}
}
