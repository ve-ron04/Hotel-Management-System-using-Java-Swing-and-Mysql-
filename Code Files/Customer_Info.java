import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;
import net.proteanit.sql.*;

public class Customer_Info  extends JFrame implements ActionListener {

    JLabel roomsImg,nameLbl, documentLbl, numberLbl, genderLbl, CountryLbl,roomLbl,checkInLbl,depositLbl;;
    ImageIcon i14;
    JTable table;
    JButton backBtn;

    Customer_Info(){
        setTitle("Customer Info");
        setBounds(0,60,1280,660);
        i14 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/roomS.png")));
        roomsImg = new JLabel(i14);

        table = new JTable();
        table.setBounds(170,45,900,470);
        add(table);

        nameLbl = new JLabel("Name");
        nameLbl.setBounds(170, 15, 69, 14);
        add(nameLbl);

        documentLbl = new JLabel("ID");
        documentLbl.setBounds(285, 15, 76, 14);
        add(documentLbl);

        numberLbl = new JLabel("Number");
        numberLbl.setBounds(395, 15, 50, 14);
        add(numberLbl);

        genderLbl = new JLabel("Gender");
        genderLbl.setBounds(510, 15, 76, 14);
        add(genderLbl);


        CountryLbl = new JLabel("Country");
        CountryLbl.setBounds(620, 15, 90, 14);
        add(CountryLbl);

        roomLbl = new JLabel("Room Number");
        roomLbl.setBounds(735, 15, 90, 14);
        add(roomLbl);

        checkInLbl = new JLabel("Check In Time");
        checkInLbl.setBounds(845, 15, 90, 14);
        add(checkInLbl);

        depositLbl = new JLabel("Deposit");
        depositLbl.setBounds(960, 15, 90, 14);
        add(depositLbl);



        try{
            DataBaseConnection c = new DataBaseConnection();
            ResultSet rs = c.s.executeQuery("select *from customer");
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
        new Customer_Info();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        setVisible(false);
        new Reception();

    }
}


