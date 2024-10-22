import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;
import net.proteanit.sql.*;

public class Department  extends JFrame implements ActionListener {

    JLabel roomsImg,departmentLbl,budgetLbl, lblCleanStatus, lblNewLabel, lblNewLabel_1, lblDepartmentNumber,lblId;;
    ImageIcon i14;
    JTable table;
    JButton backBtn;

    Department(){

        setResizable(false);
        setTitle("Department info");
        setBounds(0,60,1280,660);
        i14 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/roomS.png")));
        roomsImg = new JLabel(i14);

        departmentLbl = new JLabel("Department");
        departmentLbl.setBounds(340, 15, 69, 14);
        add(departmentLbl);

        budgetLbl = new JLabel("Budget");
        budgetLbl.setBounds(640, 15, 69, 14);
        add(budgetLbl);



        table = new JTable();
        table.setBounds(340,45,600,470);
        add(table);


        try{
            DataBaseConnection c = new DataBaseConnection();
            ResultSet rs = c.s.executeQuery("select *from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        backBtn = new JButton("Back");
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.white);
        backBtn.setBounds(570,530,100,30);
        backBtn.setFocusable(false);
        backBtn.addActionListener(this);
        backBtn.setFont(new Font("Serif",Font.BOLD,20));
        add(backBtn);


        add(roomsImg);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Department();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        setVisible(false);
        new Reception();

    }
}
