
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;


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
		banner.setFont(new Font("ARIAL",3,25));
		banner.setVisible( true );
		banner.setBounds(100,7,800,50);

		JRadioButton op1 =new JRadioButton("Display All Customer Info ");
		JRadioButton op2 =new JRadioButton("Add Staff into Database  ");
		JRadioButton op3 =new JRadioButton("Display All Staff Info ");
		JRadioButton op4 =new JRadioButton("Add Customer into Database ");
		JRadioButton op5 =new JRadioButton("Add Plan into Database ");
		JRadioButton op6 =new JRadioButton("Display All Plan Info ");
		JRadioButton op7 =new JRadioButton("Add equipment ");
		JRadioButton op8 =new JRadioButton("Display All Equipment Info ");
		JRadioButton op9 =new JRadioButton("Display Customers whose Membership Plan is Expiring in 1 month  ");
		JRadioButton op10 =new JRadioButton("Display Equipments that need maintenance");
		JRadioButton op11 =new JRadioButton("Update customer ");
		JRadioButton op12 =new JRadioButton("Update Membership ");
//		JRadioButton op13 =new JRadioButton("Add Customer into Database - (SIMPLE) ");
//		JRadioButton op14 =new JRadioButton("Update Staff's Salary - (SIMPLE) ");
//		//JRadioButton op15 =new JRadioButton(" - (COMPLEX) ");

		op1.setBounds(25,50,400,30);
		op2.setBounds(25,80,400,30);
		op3.setBounds(25,110,400,30);
		op4.setBounds(25,140,600,30);
		op5.setBounds(25,170,530,30);
		op6.setBounds(25,200,550,30);
		op7.setBounds(25,230,550,30);
		op8.setBounds(25,260,550,30);
		op9.setBounds(25,290,530,30);
		op10.setBounds(25,320,570,30);
		op11.setBounds(25,350,610,30);
		op12.setBounds(25,380,590,30);
//		op13.setBounds(25,410,590,30);
//		op14.setBounds(25,440,590,30);
		//op15.setBounds(25,470,590,30);

		bg = new ButtonGroup();
		bg.add(op1);bg.add(op3);
		bg.add(op5);
		bg.add(op2);bg.add(op4);
		bg.add(op6);
		bg.add(op7);bg.add(op9);bg.add(op11);
		bg.add(op8);bg.add(op10);bg.add(op12);
//		bg.add(op13);bg.add(op14);
		//bg.add(op15);

		JButton button = new JButton("Select");
		button.setBounds(75,500,200,30);

		mainbox.add(banner);
		mainbox.add(op1);mainbox.add(op3);mainbox.add(op5);
		mainbox.add(op2);mainbox.add(op4);mainbox.add(op6);
		mainbox.add(op7);mainbox.add(op9);mainbox.add(op11);
		mainbox.add(op8);
		mainbox.add(op10);
		mainbox.add(op12);
//		mainbox.add(op13);mainbox.add(op14);
//		mainbox.add(op15);

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
	      	            	ViewAllCustomer gc = new ViewAllCustomer();
							  gc.create();
	      	            }
	      	            else if ( disy == 80 )
	      	            {
	      	            	AddStaff as = new AddStaff();
	      	            	as.create();
	      	            }
	      	            else if ( disy == 110 )
	      	            {
	      	            	ViewAllStaff gs = new ViewAllStaff();
							  gs.create();
	      	            }
	      	            else if ( disy == 140 )
	      	            {
							AddCustomer ac = new AddCustomer();
							ac.create();
	      	            }
	      	            else if ( disy == 170 )
	      	            {
	      	            	AddPlan ap = new AddPlan();
	      	            	ap.create();
	      	            }
	      	            else if ( disy == 200 )
	      	            {
	      	            	ViewAllPlans gp = new ViewAllPlans();
							  gp.create();
	      	            }
	      	            else if ( disy == 230 )
	      	            {
							  AddEquipment ad = new AddEquipment();
							  ad.create();

	      	            }
	      	            else if ( disy == 260 )
	      	            {
	      	            	ViewAllEquipment ge = new ViewAllEquipment();
							  	      	            	ge.create();
	      	            }
	      	            else if ( disy == 290 )
	      	            {
	      	            	ViewExpiring e = new ViewExpiring();
							  	      	            	e.create();
	      	            }
	      	            else if ( disy == 320 )
	      	            {
	      	            	ViewMaintainanceEquipments nm = new ViewMaintainanceEquipments();
	      	            	nm.create();
	      	            }
	      	            else if ( disy == 350 )
	      	            {
	      	            	UpdateCustomer uc = new UpdateCustomer();
							  	      	            	uc.create();
	      	            }
	      	            else if ( disy == 380 )
	      	            {
	      	            	UpdateMembership um = new UpdateMembership();
							  	      	            	um.create();
	      	            }
	      	            else if ( disy == 410 )
	      	            {
	      	            	AddCustomer ac = new AddCustomer();
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


}
