
import javax.swing.*;
import java.awt.*;


public class Home {
    static JFrame frame;
    static JButton customer;
    static JButton staff;
    static JButton plan;
    static JButton equipment;

    static JButton logout;



    public static void create(){


        frame = new JFrame();
        frame.setSize(620,500);

        JLabel main = new JLabel("Home");
        main.setBounds(207, 5, 250, 40);
        main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));

        customer = new JButton("Customer");
        customer.setBounds(120, 55, 370, 30);

        staff = new JButton("Staff");
        staff.setBounds(120, 100, 370, 30);

        plan = new JButton("Plan");
        plan.setBounds(120, 145, 370, 30);

        equipment = new JButton("Equipment");
        equipment.setBounds(120, 190, 370, 30);

        logout = new JButton("Logout");
        logout.setBounds(120, 235, 370, 30);


        customer.addActionListener(e-> {
            frame.dispose();
            Customer c = new Customer();
            c.create();
        });

        staff.addActionListener(e-> {
            frame.dispose();
            Staff s = new Staff();
            s.create();
        });

        plan.addActionListener(e-> {
            frame.dispose();
            Plan p = new Plan();
            p.create();
        });

        equipment.addActionListener(e-> {
                frame.dispose();
                Equipment eq = new Equipment();
                eq.create();
        });

        logout.addActionListener(e-> {
            frame.dispose();
            Login l = new Login();
            l.create();
        });

        frame.add(main);
        frame.add(customer);
        frame.add(staff);
        frame.add(plan);
        frame.add(equipment);
        frame.add(logout);

        frame.setLayout(null);
        frame.setVisible(true);


    }

    public static void main(String[] args){
        Home h = new Home();
        h.create();
    }
}
