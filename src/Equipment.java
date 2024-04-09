import javax.swing.*;
import java.awt.*;

public class Equipment {

    static JFrame mainbox;
    static JButton add;
    static JButton view;
    static JButton delete;
    static JButton update;
    static JButton maintain;
    static JButton needmaintain;

    static JButton back;

    public void create(){

        mainbox = new JFrame();
        mainbox.setSize(620,500);

        JLabel main = new JLabel("Equipment");
        main.setBounds(207, 5, 250, 40);
        main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));

        add = new JButton("Add Equipment");
        add.setBounds(120, 55, 370, 30);

        view = new JButton("View Equipment");
        view.setBounds(120, 100, 370, 30);

        delete = new JButton("Delete Equipment");
        delete.setBounds(120, 145, 370, 30);



        maintain = new JButton("Maintain Equipment");
        maintain.setBounds(120, 190, 370, 30);

        needmaintain = new JButton("Equipments that need Maintainance");
        needmaintain.setBounds(120, 235, 370, 30);

        back = new JButton("Back");
        back.setBounds(120, 325, 370, 30);


        add.addActionListener(e-> {
            //mainbox.dispose();
            AddEquipment ae = new AddEquipment();
            ae.create();
        });

        view.addActionListener(e-> {
            //mainbox.dispose();
            ViewAllEquipment ve = new ViewAllEquipment();
            ve.create();
        });

        delete.addActionListener(e-> {
            //mainbox.dispose();
            DeleteEquipment de = new DeleteEquipment();
            de.create();
        });



        maintain.addActionListener(e-> {
            //mainbox.dispose();
            MaintainEquipment me = new MaintainEquipment();
            me.create();
        });


        needmaintain.addActionListener(e-> {
            //mainbox.dispose();
            ViewMaintainanceEquipments vme = new ViewMaintainanceEquipments();
            vme.create();
        });

        back.addActionListener(e-> {
            mainbox.dispose();
            Home h = new Home();
            h.create();
        });

        mainbox.add(main);
        mainbox.add(add);
        mainbox.add(view);
        mainbox.add(delete);
        mainbox.add(maintain);
        mainbox.add(needmaintain);

        mainbox.add(back);

        mainbox.setLayout(null);
        mainbox.setVisible(true);
    }
}
