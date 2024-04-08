import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeletePlan {

    static JFrame mainbox;
    static JLabel name;
    static JTextField nameinp;
    static JButton delete;

    static String dname = "";

    public void create(){

        mainbox = new JFrame();
        mainbox.setSize(620,500);

        JLabel main = new JLabel("Delete Plan");
        main.setBounds(207, 5, 250, 40);
        main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));

        name = new JLabel("Enter Plan Name");
        name.setBounds(120, 55, 400,20);
        nameinp.setBounds(120, 75, 370,30);


        delete = new JButton("Delete Plan");
        delete.setBounds(120, 205, 370, 30);

        delete.addActionListener(e-> {
            if( nameinp.getText().isEmpty() ){
                JOptionPane.showMessageDialog(null, "Data Missing");
            }
            else{
                dname = nameinp.getText();

                nameinp.setText("");


                try
                {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
                    Statement stat=conn.createStatement();

                    stat.execute("delete from plans where name = " + dname);

                    JOptionPane.showMessageDialog(null, "Data Deleted");

                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Failed");
                    ex.printStackTrace();
                }
            }
        });

        mainbox.add(main);
        mainbox.add(name);
        mainbox.add(nameinp);
        mainbox.add(delete);

        mainbox.setLayout(null);
        mainbox.setVisible(true);
    }
}
