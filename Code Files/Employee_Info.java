import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;
import net.proteanit.sql.*;

public class Employee_Info  extends JFrame implements ActionListener {

    JLabel roomsImg,nameLbl, ageLbl, genderLbl, jobLbl, salaryLbl,phoneLbl,emailLbl,aadharLbl;;
    ImageIcon i14;
    JTable table;
    JButton backBtn;

    Employee_Info(){
        setResizable(false);
        setTitle("All Employe Info");
        setBounds(0,60,1280,660);
        i14 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/roomS.png")));
        roomsImg = new JLabel(i14);

        table = new JTable();
        table.setBounds(170,45,900,470);
        add(table);

        nameLbl = new JLabel("Name");
        nameLbl.setBounds(170, 15, 69, 14);
        add(nameLbl);

        ageLbl = new JLabel("Age");
        ageLbl.setBounds(285, 15, 76, 14);
        add(ageLbl);

        genderLbl = new JLabel("Gender");
        genderLbl.setBounds(395, 15, 46, 14);
        add(genderLbl);

        jobLbl = new JLabel("Job");
        jobLbl.setBounds(510, 15, 76, 14);
        add(jobLbl);


        salaryLbl = new JLabel("Salary");
        salaryLbl.setBounds(620, 15, 90, 14);
        add(salaryLbl);

        phoneLbl = new JLabel("Phone");
        phoneLbl.setBounds(735, 15, 90, 14);
        add(phoneLbl);

        emailLbl = new JLabel("Email");
        emailLbl.setBounds(845, 15, 90, 14);
        add(emailLbl);

        aadharLbl = new JLabel("Aadhar");
        aadharLbl.setBounds(960, 15, 90, 14);
        add(aadharLbl);



        try{
            DataBaseConnection c = new DataBaseConnection();
            ResultSet rs = c.s.executeQuery("select *from employee");
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
        new Employee_Info();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        setVisible(false);
        new Reception();

    }
}

