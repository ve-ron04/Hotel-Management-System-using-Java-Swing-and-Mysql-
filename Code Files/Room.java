import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;
import net.proteanit.sql.*;

public class Room  extends JFrame implements ActionListener {

    JLabel roomsImg,avlLbl, cleanLbl, newLbl, bedLbl,rnLbl;;
    ImageIcon i13;
    JTable table;
    JButton backBtn;

    Room(){
        setTitle("Rooms Info");
        setResizable(false);
        setBounds(0,60,1280,660);
        i13 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/roomS.png")));
        roomsImg = new JLabel(i13);

        table = new JTable();
        table.setBounds(170,45,900,470);
        add(table);

        rnLbl = new JLabel("Room Number");
        rnLbl.setBounds(170, 15, 90, 14);
        add(rnLbl);

        avlLbl = new JLabel("Availability");
        avlLbl.setBounds(350, 15, 69, 14);
        add(avlLbl);

        cleanLbl = new JLabel("Clean Status");
        cleanLbl.setBounds(530, 15, 76, 14);
        add(cleanLbl);

        newLbl = new JLabel("Price");
        newLbl.setBounds(712, 15, 46, 14);
        add(newLbl);

        bedLbl = new JLabel("Bed Type");
        bedLbl.setBounds(890, 15, 76, 14);
        add(bedLbl);


        try{
            DataBaseConnection c = new DataBaseConnection();
            ResultSet rs = c.s.executeQuery("select *from room");
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
        new Room();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            setVisible(false);
            new Reception();

    }
}
