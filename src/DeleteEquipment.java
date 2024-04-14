import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteEquipment {
    static JFrame mainbox;
    static JTextField idinp;


    static JButton delete;

    static JButton back;

    static int did;
    public void create(){

        mainbox = new JFrame();
        mainbox.setSize(620,500);

        JLabel main = new JLabel("Delete Equipment");
        main.setBounds(207, 5, 250, 40);
        main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));

        JLabel id = new JLabel("Enter ID of Equipment to Delete");
        id.setBounds(120, 55, 400,20);
        JTextField idinp = new JTextField();
        idinp.setBounds(120, 75, 370,30);

        delete = new JButton("Delete");
        delete.setBounds(120, 120, 370, 30);

        back = new JButton("Back");
        back.setBounds(120, 165, 370, 30);

        mainbox.add(main);
        mainbox.add(id);
        mainbox.add(idinp);
        mainbox.add(delete);
        mainbox.add(back);

        mainbox.setLayout(null);
        mainbox.setVisible(true);

        delete.addActionListener(e-> {


            if(idinp.getText().equals("")){
                JOptionPane.showMessageDialog(mainbox, "Enter ID");
            }
            else{
                did = Integer.parseInt(idinp.getText());
                idinp.setText("");
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
                    Statement stat=conn.createStatement();
                    stat.executeQuery("delete from equipment where equipment_id = "+did);
                    JOptionPane.showMessageDialog(mainbox, "Equipment Deleted");
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(mainbox, "Error");
                }
            }



        });

        back.addActionListener(e-> {
            this.mainbox.dispose();
            Equipment eq = new Equipment();
            eq.create();
        });
    }
}
