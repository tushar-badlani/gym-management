import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ChangePassword {
    static JFrame frame;
    static JPasswordField password;
    static JPasswordField cpassword;
    static JButton submit;
    static JButton back;
    static String dpass;
    static String dcpass;

    public void create(){
        frame = new JFrame();
        frame.setSize(620,500);

        JLabel main = new JLabel("Change Password");
        main.setBounds(207, 5, 250, 40);
        main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));

        JLabel pass = new JLabel("Enter Password");
        pass.setBounds(120, 55, 400,20);
        password = new JPasswordField();
        password.setBounds(120, 75, 370,30);

        JLabel cpass = new JLabel("Confirm Password");
        cpass.setBounds(120, 120, 400,20);
        cpassword = new JPasswordField();
        cpassword.setBounds(120, 140, 370,30);

        submit = new JButton("Submit");
        submit.setBounds(120, 205, 370, 30);

        back = new JButton("Back");
        back.setBounds(120, 250, 370, 30);

        frame.add(main);
        frame.add(pass);
        frame.add(password);
        frame.add(cpass);
        frame.add(cpassword);
        frame.add(submit);
        frame.add(back);

        frame.setLayout(null);
        frame.setVisible(true);

        submit.addActionListener(e-> {
            if( password.getText().isEmpty()
                    || (cpassword.getText().isEmpty()) ){
                JOptionPane.showMessageDialog(frame, "Please fill all fields");
            }
            else if( !password.getText().equals(cpassword.getText()) ){
                JOptionPane.showMessageDialog(frame, "Passwords do not match");
            }
            else{
                dpass = password.getText();
                dcpass = cpassword.getText();
                try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
                    Statement stat=conn.createStatement();
                    String query = "update admins set password = '"+dpass+"' where username = '"+ForgotPassword.duser+"'";
                    stat.executeUpdate(query);
                    JOptionPane.showMessageDialog(frame, "Password changed successfully");
                    frame.dispose();
                    new Login().create();
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
            }
        });

        back.addActionListener(e-> {
            frame.dispose();
            //new Login().create();
        });
    }
}
