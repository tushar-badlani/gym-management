import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteStaff {
    static JFrame mainbox;
    static JTextField idinp;

    static int did = 0;

    public static void create(){
        mainbox = new JFrame();
        mainbox.setSize(620,500);

        idinp = new JTextField();

        JLabel main = new JLabel("Delete Staff");
        main.setBounds(207, 5, 250, 40);
        main.setFont(new Font("Arial", Font.TRUETYPE_FONT,35));

        JLabel id = new JLabel("Enter Staff ID");
        id.setBounds(120, 35, 400,20);
        idinp.setBounds(120, 55, 370,30);

        JButton submit = new JButton("Submit");
        submit.setBounds(220, 170, 160,35);
        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                if( idinp.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Data Missing");
                }
                else{
                    did = Integer.parseInt(idinp.getText());

                    idinp.setText("");
                    try{
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
                        Statement stat=conn.createStatement();
                        stat.executeUpdate("delete from staff where id = "+did);
                        JOptionPane.showMessageDialog(null, "Staff Deleted");
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
        mainbox.add(submit);

        mainbox.setLayout(null);
        mainbox.setVisible(true);
    }
}
