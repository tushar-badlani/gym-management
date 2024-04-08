import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ForgotPassword {
    static JFrame frame;
    static JTextField username;
    static JTextField answer;
    static JButton submit;
    static JButton back;

    static String duser;
    static String dans;

    public static void create(){
        frame = new JFrame();
        frame.setSize(620,500);

        JLabel main = new JLabel("Forgot Password");
        main.setBounds(207, 5, 250, 40);
        main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));

        JLabel user = new JLabel("Enter Username");
        user.setBounds(120, 55, 400,20);
        username = new JTextField();
        username.setBounds(120, 75, 370,30);

        JLabel ans = new JLabel("Enter Answer");
        ans.setBounds(120, 120, 400,20);
        answer = new JTextField();
        answer.setBounds(120, 140, 370,30);

        submit = new JButton("Submit");
        submit.setBounds(120, 205, 370, 30);

        back = new JButton("Back");
        back.setBounds(120, 250, 370, 30);

        frame.add(main);
        frame.add(user);
        frame.add(username);
        frame.add(ans);
        frame.add(answer);
        frame.add(submit);
        frame.add(back);

        frame.setLayout(null);
        frame.setVisible(true);

        submit.addActionListener(e-> {

            if( username.getText().isEmpty()
                    || (answer.getText().isEmpty()) ){
                JOptionPane.showMessageDialog(frame, "Please fill all fields");
            }
            else{
                duser = username.getText();
                dans = answer.getText();
                username.setText("");
                answer.setText("");

                try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
                    Statement stat=conn.createStatement();
                    String sql = "select * from admins where username = '"+duser+"' and answer = '"+dans+"'";
                    java.sql.ResultSet rs = stat.executeQuery(sql);
                    if(rs.next()){
                        frame.dispose();
                        new ChangePassword().create();
                    }
                    else{
                        JOptionPane.showMessageDialog(frame, "Invalid Username or Answer");
                    }


                }
                catch(Exception ex){
                    System.out.println(ex);
                }
            }

        });

        back.addActionListener(e-> {
            frame.dispose();
            new Login().create();
        });
    }
}
