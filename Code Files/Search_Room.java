import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;
import net.proteanit.sql.*;

public class Search_Room  extends JFrame implements ActionListener {

    JLabel roomsImg,avlLbl, cleanLbl, newLbl, bedLbl,rnLbl,searchLbl, bedTypeLbl;
    ImageIcon i13;
    JTable table;
    JButton backBtn,submitBtn;
    JComboBox bedtypeCombo;
    JCheckBox available;

    Search_Room(){

        setResizable(false);

        setBounds(0,60,1280,660);
        i13 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/roomS.png")));
        roomsImg = new JLabel(i13);

        table = new JTable();
        table.setBounds(170,165,900,380);
        add(table);

        searchLbl = new JLabel("Search Rooms");
        searchLbl.setBounds(520,5,300,40);
        searchLbl.setFont(new Font("Serif",Font.BOLD,30));
        add(searchLbl);

        bedTypeLbl = new JLabel("Select Bed Type");
        bedTypeLbl.setBounds(170,60,200,30);
        bedTypeLbl.setFont(new Font("Sans Serif",Font.BOLD,20));
        add(bedTypeLbl);

        bedtypeCombo = new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedtypeCombo.setBounds(350,60,100,30);
        bedtypeCombo.setBackground(Color.white);
        bedtypeCombo.setForeground(Color.black);
        add(bedtypeCombo);

        available = new JCheckBox("Only display Available");
        available.setBounds(900,60,160,25);
        available.setBackground(Color.white);
        available.setFocusable(false);
        add(available);


        rnLbl = new JLabel("Room Number");
        rnLbl.setBounds(170, 135, 90, 14);
        add(rnLbl);

        avlLbl = new JLabel("Availability");
        avlLbl.setBounds(350, 135, 69, 14);
        add(avlLbl);

        cleanLbl = new JLabel("Clean Status");
        cleanLbl.setBounds(530, 135, 76, 14);
        add(cleanLbl);

        newLbl = new JLabel("Price");
        newLbl.setBounds(712, 135, 46, 14);
        add(newLbl);

        bedLbl = new JLabel("Bed Type");
        bedLbl.setBounds(890, 135, 76, 14);
        add(bedLbl);


        try{
            DataBaseConnection c = new DataBaseConnection();
            ResultSet rs = c.s.executeQuery("select *from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        submitBtn = new JButton("Submit");
        submitBtn.setBackground(Color.BLACK);
        submitBtn.setForeground(Color.white);
        submitBtn.setBounds(450,550,135,30);
        submitBtn.setFocusable(false);
        submitBtn.addActionListener(this);
        submitBtn.setFont(new Font("Serif",Font.BOLD,20));
        add(submitBtn);

        backBtn = new JButton("Back");
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.white);
        backBtn.setBounds(700,550,135,30);
        backBtn.setFocusable(false);
        backBtn.addActionListener(this);
        backBtn.setFont(new Font("Serif",Font.BOLD,20));
        add(backBtn);


        add(roomsImg);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Search_Room();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == submitBtn){
            try{
                String query1 = "select *from room where bed_type = '"+bedtypeCombo.getSelectedItem()+"'";
                String query2 = "select *from room where availability = 'Available' AND bed_type = '"+bedtypeCombo.getSelectedItem()+"'";

                DataBaseConnection conne = new DataBaseConnection();
                ResultSet rs = conne.s.executeQuery(query2);
                if(available.isSelected()){

                }else {
                    rs = conne.s.executeQuery(query1);
                }

                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception eee){
                eee.printStackTrace();
            }
        }else {
            setVisible(false);
            new Reception();
        }


    }
}
