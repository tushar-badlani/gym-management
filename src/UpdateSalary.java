import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateSalary {

    static JFrame mainbox;
    static JTextField idinp;
    static JTextField salaryinp;

    static int did = 0;
    static int dsal = 0;


    public static void create(){
        mainbox = new JFrame();
        mainbox.setSize(620,500);

        idinp = new JTextField();
        salaryinp = new JTextField();

        JLabel main = new JLabel("Update Salary");
        main.setBounds(207, 5, 250, 40);
        main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));

        JLabel id = new JLabel("Enter Staff ID");
        id.setBounds(120, 35, 400,20);
        idinp.setBounds(120, 55, 370,30);

        JLabel salary = new JLabel("Enter new salary");
        salary.setBounds(120, 100, 400,20);
        salaryinp.setBounds(120, 120 , 370,30);

        JButton submit = new JButton("Submit");
        submit.setBounds(220, 170, 160,35);
        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                if( idinp.getText().isEmpty() || salaryinp.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Data Missing");
                }
                else{
                    did = Integer.parseInt(idinp.getText());
                    dsal = Integer.parseInt(salaryinp.getText());

                    idinp.setText("");
                    salaryinp.setText("");
                    try{
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
                        Statement stat=conn.createStatement();
                        stat.executeUpdate("update staff set salary = "+dsal+" where id = "+did);


                        JOptionPane.showMessageDialog(null, "Salary Updated");
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
        });

        mainbox.add(main);
        mainbox.add(id);
        mainbox.add(idinp);
        mainbox.add(salary);
        mainbox.add(salaryinp);
        mainbox.add(submit);

        mainbox.setLayout(null);
        mainbox.setVisible(true);
    }
}
