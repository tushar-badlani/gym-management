import javax.swing.*;
import java.awt.*;

public class Staff {
    static JFrame mainbox;
    static JButton add;
    static JButton view;
    static JButton update;
    static JButton delete;
    static JButton back;
    static JButton salary;

    public static void create(){
        mainbox = new JFrame();
        mainbox.setSize(620,500);

        JLabel main = new JLabel("Staff");
        main.setBounds(207, 5, 250, 40);
        main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));

        add = new JButton("Add Staff");
        add.setBounds(120, 55, 370, 30);

        view = new JButton("View Staff");
        view.setBounds(120, 100, 370, 30);

        update = new JButton("Update Staff");
        update.setBounds(120, 145, 370, 30);

        delete = new JButton("Delete Staff");
        delete.setBounds(120, 190, 370, 30);

        salary = new JButton("Update Salary");
        salary.setBounds(120, 235, 370, 30);

        back = new JButton("Back");
        back.setBounds(120, 280, 370, 30);

        mainbox.add(main);
        mainbox.add(add);
        mainbox.add(view);
        mainbox.add(update);
        mainbox.add(delete);
        mainbox.add(salary);
        mainbox.add(back);

        mainbox.setLayout(null);
        mainbox.setVisible(true);

        add.addActionListener(e-> {
            //mainbox.dispose();
            AddStaff as = new AddStaff();
            as.create();
        });

        view.addActionListener(e-> {
            //mainbox.dispose();
            ViewAllStaff vs = new ViewAllStaff();
            vs.create();
        });

        update.addActionListener(e-> {
            //mainbox.dispose();
            UpdateStaff us = new UpdateStaff();
            us.create();
        });

        delete.addActionListener(e-> {
            //mainbox.dispose();
            DeleteStaff ds = new DeleteStaff();
            ds.create();
        });

        salary.addActionListener(e-> {
            //mainbox.dispose();
            UpdateSalary us = new UpdateSalary();
            us.create();
        });

        back.addActionListener(e-> {
            mainbox.dispose();
            Home h = new Home();
            h.create();
        });
    }

}
