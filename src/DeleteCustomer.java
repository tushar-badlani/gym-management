import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteCustomer {
    static JFrame frame;
    static JButton delete;
    static JButton back;
    static JTextField idinp;
    static String did;

    public static void create(){
        frame = new JFrame();
        frame.setSize(620,500);

        JLabel main = new JLabel("Delete Customer");
        main.setBounds(207, 5, 250, 40);
        main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));

        idinp = new JTextField();
        idinp.setBounds(120, 55, 370, 30);

        delete = new JButton("Delete");
        delete.setBounds(120, 100, 370, 30);

        back = new JButton("Back");
        back.setBounds(120, 145, 370, 30);

        frame.add(main);
        frame.add(idinp);
        frame.add(delete);
        frame.add(back);

        frame.setLayout(null);
        frame.setVisible(true);

        delete.addActionListener(e-> {
            if(idinp.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please fill all fields");
            }
            else{
                did = idinp.getText();
                try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
                    Statement stat=conn.createStatement();
                    String query = "delete from customer where customer_id = "+did;
                    java.sql.ResultSet rs = stat.executeQuery(query);
                    if(rs.next()){
                        JOptionPane.showMessageDialog(frame, "Customer Deleted Successfully");

                    }
                    else{
                        JOptionPane.showMessageDialog(frame, "Customer not found");
                    }

                } catch (ClassNotFoundException | SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        back.addActionListener(e-> {
            frame.dispose();
        });
    }
}
