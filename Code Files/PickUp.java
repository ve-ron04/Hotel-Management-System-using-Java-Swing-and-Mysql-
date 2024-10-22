import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;
import net.proteanit.sql.*;

public class PickUp  extends JFrame implements ActionListener {

    JLabel roomsImg,ageLbl, genderLbl, brandLbl, modelBl,nameLbl,searchLbl, bedTypeLbl,avLbl,locationLbl;
    ImageIcon i13;
    JTable table;
    JButton backBtn,submitBtn;
    Choice CarChoice;


    PickUp(){

        setResizable(false);
        setBounds(0,60,1280,660);
        i13 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/roomS.png")));
        roomsImg = new JLabel(i13);

        table = new JTable();
        table.setBounds(170,165,900,380);
        add(table);

        searchLbl = new JLabel("PickUp Service");
        searchLbl.setBounds(520,5,300,40);
        searchLbl.setFont(new Font("Serif",Font.BOLD,30));
        add(searchLbl);

        bedTypeLbl = new JLabel("Select car Company");
        bedTypeLbl.setBounds(170,60,200,30);
        bedTypeLbl.setFont(new Font("Sans Serif",Font.BOLD,20));
        add(bedTypeLbl);

        CarChoice = new Choice();
        CarChoice.setBounds(400,65,100,30);
        CarChoice.setBackground(Color.white);
        CarChoice.setForeground(Color.black);
        add(CarChoice);
        try{
            DataBaseConnection c = new DataBaseConnection();
            ResultSet rs = c.s.executeQuery("select *from driver");
            while(rs.next()){
                CarChoice.add(rs.getString("company"));
            }
        }catch (Exception ee){
            ee.printStackTrace();
        }




        nameLbl = new JLabel("Name");
        nameLbl.setBounds(170, 135, 90, 14);
        add(nameLbl);

        ageLbl = new JLabel("Age");
        ageLbl.setBounds(300, 135, 69, 14);
        add(ageLbl);

        genderLbl = new JLabel("Gender");
        genderLbl.setBounds(428, 135, 76, 14);
        add(genderLbl);

        brandLbl = new JLabel("Company");
        brandLbl.setBounds(557, 135, 76, 14);
        add(brandLbl);

        modelBl = new JLabel("Model");
        modelBl.setBounds(687, 135, 76, 14);
        add(modelBl);

        avLbl = new JLabel("Available");
        avLbl.setBounds(817, 135, 76, 14);
        add(avLbl);

        locationLbl = new JLabel("Location");
        locationLbl.setBounds(947, 135, 76, 14);
        add(locationLbl);


        try{
            DataBaseConnection c = new DataBaseConnection();
            ResultSet rs = c.s.executeQuery("select *from driver");
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
        new PickUp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == submitBtn){
            try{
                String query1 = "select *from driver where company = '"+CarChoice.getSelectedItem()+"'";

                DataBaseConnection conne = new DataBaseConnection();
                ResultSet rs = conne.s.executeQuery(query1);


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

