import javax.swing.*;
import java.awt.*;

public class Customer {

    static JFrame frame;
    static JButton add;
    static JButton view;
    static JButton update;
    static JButton delete;
    static JButton back;
    static JButton membership;

    static JButton expiring;


    public static void create(){
        frame = new JFrame();
        frame.setSize(620,500);

        JLabel main = new JLabel("Customer");
        main.setBounds(207, 5, 250, 40);
        main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));

        add = new JButton("Add Customer");
        add.setBounds(120, 55, 370, 30);

        view = new JButton("View Customer");
        view.setBounds(120, 100, 370, 30);

        update = new JButton("Update Customer");
        update.setBounds(120, 145, 370, 30);

        delete = new JButton("Delete Customer");
        delete.setBounds(120, 190, 370, 30);

        membership = new JButton("Update Membership");
        membership.setBounds(120, 235, 370, 30);

        expiring = new JButton("Expiring Membership");
        expiring.setBounds(120, 280, 370, 30);



        back = new JButton("Back");
        back.setBounds(120, 325, 370, 30);

        frame.add(main);
        frame.add(add);
        frame.add(view);
        frame.add(update);
        frame.add(delete);
        frame.add(membership);
        frame.add(back);
        frame.add(expiring);

        frame.setLayout(null);
        frame.setVisible(true);

        add.addActionListener(e-> {
            //frame.dispose();
            AddCustomer ac = new AddCustomer();
            ac.create();
        });

        view.addActionListener(e-> {
            //frame.dispose();
            ViewAllCustomer vc = new ViewAllCustomer();
            vc.create();
        });

        update.addActionListener(e-> {
            //frame.dispose();
            UpdateCustomer uc = new UpdateCustomer();
            uc.create();
        });

        delete.addActionListener(e-> {
            //frame.dispose();
            DeleteCustomer dc = new DeleteCustomer();
            dc.create();
        });

        membership.addActionListener(e-> {
            //frame.dispose();
            UpdateMembership um = new UpdateMembership();
            um.create();
        });

        back.addActionListener(e-> {
            frame.dispose();
            Home h = new Home();
            h.create();
        });

        expiring.addActionListener(e-> {
            //frame.dispose();
            ViewExpiring ve = new ViewExpiring();
            ve.create();
        });
    }
}
