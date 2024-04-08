import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateStaff {

    static JFrame mainbox;
    static JTextField idinp;
    static JTextField nameinp;
    static JTextField ageinp;
    static JTextField addressinp;
    static JTextField roleinp;
    static JTextField phoneinp;

    static JButton submit;

    static int did = 0;
    static String dname = "";
    static int dage = 0;
    static String daddress = "";
    static String drole = "";
    static int dphone = 0;


    public static void create(){
        mainbox = new JFrame();
        mainbox.setSize(620,500);


        JLabel main = new JLabel("Update Staff");
        main.setBounds(207, 5, 250, 25);

        JLabel id = new JLabel("Enter Staff ID");
        idinp = new JTextField();
        id.setBounds(120, 55, 370,30);
        idinp.setBounds(120, 75, 370,30);

        JLabel name = new JLabel("Enter Your Name");
        nameinp = new JTextField();
        name.setBounds(120, 120, 370,30);
        nameinp.setBounds(120, 140, 370,30);

        JLabel age = new JLabel("Enter Your Age");
        ageinp = new JTextField();
        age.setBounds(120, 185 , 370,30);
        ageinp.setBounds(120, 205 , 370,30);

        JLabel address = new JLabel("Enter Your Address");
        addressinp = new JTextField();
        address.setBounds(120, 250 , 370,30);
        addressinp.setBounds(120, 270 , 370,30);

        JLabel role = new JLabel("Enter Your Role: ");
        roleinp = new JTextField();
        role.setBounds(120, 315 , 370,30);
        roleinp.setBounds(120, 335 , 370,30);

        JLabel phone = new JLabel("Enter Your Phone Number");
        phoneinp = new JTextField();
        phone.setBounds(120, 380 , 370,30);
        phoneinp.setBounds(120, 400 , 370,30);

        JButton submit = new JButton("Submit");
        submit.setBounds(240, 420, 160,35);

        mainbox.add(main);
        mainbox.add(id);
        mainbox.add(idinp);
        mainbox.add(name);
        mainbox.add(nameinp);
        mainbox.add(age);
        mainbox.add(ageinp);
        mainbox.add(address);
        mainbox.add(addressinp);
        mainbox.add(role);
        mainbox.add(roleinp);
        mainbox.add(phone);
        mainbox.add(phoneinp);
        mainbox.add(submit);

        mainbox.setLayout(null);
        mainbox.setVisible(true);


        submit.addActionListener(e -> {
            if( idinp.getText().isEmpty()
                    || (nameinp.getText().isEmpty()) ||
                    (ageinp.getText().isEmpty()) ||
                    (addressinp.getText().isEmpty()) ||
                    (roleinp.getText().isEmpty()) ||
                    (phoneinp.getText().isEmpty()))
            {
                JOptionPane.showMessageDialog(null, "Data Missing");
            }
            else
            {
                did = Integer.parseInt(idinp.getText());
                dname = nameinp.getText();
                dage = Integer.parseInt(ageinp.getText());
                daddress = addressinp.getText();
                drole = roleinp.getText();
                dphone = Integer.parseInt(phoneinp.getText());

                idinp.setText("");
                nameinp.setText("");
                ageinp.setText("");
                addressinp.setText("");
                roleinp.setText("");
                phoneinp.setText("");

                try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
                    Statement stat=conn.createStatement();
                    String query = "update staff set name = '" + dname + "', address = '" + daddress + "', age = " + dage + ", phone_no = " + dphone + ", role = '" + drole + "' where staff_id = " + did;
                    stat.execute(query);
                    JOptionPane.showMessageDialog(null, "Updated Staff Successfully");

                }
                catch (Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed");
            }
}
        });

    }
}
