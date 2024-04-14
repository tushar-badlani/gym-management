import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MaintainEquipment {

    static JFrame mainbox;
    static JTextField idinp;

    static JButton maintain;

    static JButton back;

    static int mid;

    public void create(){

        mainbox = new JFrame();
        mainbox.setSize(620,500);

        JLabel main = new JLabel("Maintain Equipment");
        main.setBounds(207, 5, 250, 40);

        JLabel id = new JLabel("Enter ID of Equipment to Maintain");
        id.setBounds(120, 55, 400,20);
        JTextField idinp = new JTextField();
        idinp.setBounds(120, 75, 370,30);

        maintain = new JButton("Maintain");
        maintain.setBounds(120, 120, 370, 30);

        back = new JButton("Back");
        back.setBounds(120, 165, 370, 30);

        mainbox.add(main);
        mainbox.add(id);
        mainbox.add(idinp);
        mainbox.add(maintain);
        mainbox.add(back);

        mainbox.setLayout(null);
        mainbox.setVisible(true);

        maintain.addActionListener(e-> {


            if(idinp.getText().equals("")){
                JOptionPane.showMessageDialog(mainbox, "Enter ID");
            }
            else{
                mid = Integer.parseInt(idinp.getText());
                idinp.setText("");
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
                    Statement stat=conn.createStatement();
                    stat.executeQuery("update equipment set last_maintained = sysdate where equipment_id = "+mid);
                    JOptionPane.showMessageDialog(mainbox, "Equipment Maintained");
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(mainbox, "Error");
                }
            }



        });

        back.addActionListener(e-> {
            mainbox.dispose();
            Equipment eq = new Equipment();
            eq.create();
        });
    }
}
