import javax.swing.*;
import java.awt.*;

public class Plan {

    static JFrame mainbox;
    static JButton add;
    static JButton view;
    static JButton delete;
    static JButton update;


    public void create(){

        mainbox = new JFrame();
        mainbox.setSize(620,500);

        JLabel main = new JLabel("Plan");
        main.setBounds(207, 5, 250, 40);
        main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));

        add = new JButton("Add Plan");
        add.setBounds(120, 55, 370, 30);

        view = new JButton("View Plan");
        view.setBounds(120, 100, 370, 30);

        delete = new JButton("Delete Plan");
        delete.setBounds(120, 145, 370, 30);

        update = new JButton("Update Plan");
        update.setBounds(120, 190, 370, 30);

        add.addActionListener(e-> {
            AddPlan ap = new AddPlan();
            ap.create();
        });

        view.addActionListener(e-> {
            ViewAllPlans vp = new ViewAllPlans();
            vp.create();
        });

        delete.addActionListener(e-> {
            DeletePlan dp = new DeletePlan();
            dp.create();
        });

        update.addActionListener(e-> {
            UpdatePlan up = new UpdatePlan();
            up.create();
        });

        mainbox.add(main);
        mainbox.add(add);
        mainbox.add(view);
        mainbox.add(delete);
        mainbox.add(update);

        mainbox.setLayout(null);
        mainbox.setVisible(true);
    }

}
