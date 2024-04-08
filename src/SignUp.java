import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SignUp {

    static JFrame frame;
    static JTextField username;
    static JPasswordField password;
    static JTextField email;
    static JTextField phone;
    static JTextField address;
    static JTextField name;
    static JTextField age;
    static JTextField answer;

    static String duser;
    static String dpass;
    static String dmail;
    static String dph;
    static String dadd;
    static String dnm;
    static String dag;
    static String dans;

    public static void create(){
        frame = new JFrame();
        frame.setSize(620,650);

        JLabel main = new JLabel("Sign Up");
        main.setBounds(207, 5, 250, 40);
        main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));

        JLabel user = new JLabel("Enter Username");
        user.setBounds(120, 55, 400,20);
        username = new JTextField();
        username.setBounds(120, 75, 370,30);


        JLabel pass = new JLabel("Enter Password");
        pass.setBounds(120, 120, 400,20);
        password = new JPasswordField();
        password.setBounds(120, 140, 370,30);

        JLabel mail = new JLabel("Enter Email");
        mail.setBounds(120, 185, 400,20);
        email = new JTextField();
        email.setBounds(120, 205, 370,30);

        JLabel ph = new JLabel("Enter Phone Number");
        ph.setBounds(120, 250, 400,20);
        phone = new JTextField();
        phone.setBounds(120, 270, 370,30);

        JLabel add = new JLabel("Enter Address");
        add.setBounds(120, 315, 400,20);
        address = new JTextField();
        address.setBounds(120, 335, 370,30);

        JLabel nm = new JLabel("Enter Name");
        nm.setBounds(120, 380, 400,20);
        name = new JTextField();
        name.setBounds(120, 400, 370,30);

        JLabel question = new JLabel("Which school did you attend?");
        question.setBounds(120, 445, 400,20);

        JLabel ans = new JLabel("Enter Security Answer");
        ans.setBounds(120, 490, 400,20);
        answer = new JTextField();
        answer.setBounds(120, 510, 370,30);

        JButton signup = new JButton("Sign Up");
        signup.setBounds(120, 555, 370, 30);

        frame.add(main);
        frame.add(user);
        frame.add(username);
        frame.add(pass);
        frame.add(password);
        frame.add(mail);
        frame.add(email);
        frame.add(ph);
        frame.add(phone);
        frame.add(add);
        frame.add(address);
        frame.add(nm);
        frame.add(name);
        frame.add(question);

        frame.add(ans);
        frame.add(answer);
        frame.add(signup);

        frame.setLayout(null);
        frame.setVisible(true);

        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if( username.getText().isEmpty()
                        || (password.getText().isEmpty()) ||
                        (email.getText().isEmpty()) ||
                        (phone.getText().isEmpty()) ||
                        (address.getText().isEmpty()) ||
                        (name.getText().isEmpty()) ||
                        (answer.getText().isEmpty()))
                {
                    JOptionPane.showMessageDialog(null, "Data Missing");
                }
                else{
                    duser = username.getText();
                    dpass = password.getText();
                    dmail = email.getText();
                    dph = phone.getText();
                    dadd = address.getText();
                    dnm = name.getText();

                    dans = answer.getText();

                    username.setText("");
                    password.setText("");
                    email.setText("");
                    phone.setText("");
                    address.setText("");
                    name.setText("");

                    answer.setText("");

                    try
                    {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
                        Statement stat=conn.createStatement();

                        stat.executeUpdate("INSERT INTO admins (admin_id, username, password, email, phone_no, address, name, answer) VALUES (admin_id_seq.NEXTVAL,'" + duser + "','" + dpass + "','" + dmail + "','" + dph + "','" + dadd + "','" + dnm + "','" + dans + "')");

                        JOptionPane.showMessageDialog(null, "Success");
                        frame.dispose();
                        Login.create();

                    }
                    catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(null, "Failed");
                        e.printStackTrace();
                    }
                }

            }
        });
    }


}
