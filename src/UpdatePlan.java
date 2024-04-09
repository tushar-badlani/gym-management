import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdatePlan {

    static JFrame frame;
    static JTextField nameinp;
    static JTextField rateinp;

    static String dname;
    static int drate;

    public static void create(){
        frame = new JFrame();
        frame.setSize(620,500);



        JLabel name = new JLabel("Enter Plan Name");
        name.setBounds(120, 35, 400,20);
        nameinp.setBounds(120, 55, 370,30);

        JLabel rate = new JLabel("Enter Plan Rate");
        rate.setBounds(120, 100, 400,20);
        rateinp.setBounds(120, 120 , 370,30);

        JButton submit = new JButton("Submit");
        submit.setBounds(220, 170, 160,35);


        submit.addActionListener(e -> {
            if( nameinp.getText().isEmpty() || rateinp.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Data Missing");
            }
            else
            {
                dname = nameinp.getText();
                drate = Integer.parseInt(rateinp.getText());

                nameinp.setText("");
                rateinp.setText("");
                try
                {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
                    Statement stat = conn.createStatement();

                    stat.executeUpdate("update plans set rate = " + drate + " where name = '" + dname + "'");
                    JOptionPane.showMessageDialog(null, "Data Submitted");
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });


    }

}
