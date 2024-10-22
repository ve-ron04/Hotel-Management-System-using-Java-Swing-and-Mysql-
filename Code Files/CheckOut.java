 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
 import java.util.Date;
 import java.util.Objects;

public class CheckOut extends JFrame implements ActionListener {

    JLabel checkImg;
    JLabel Uplbl,IDlbl,RNLbl,checkInLbl,checkOutLbl;
    Choice IDChoice;
    JTextField RnTxt, checkInTxt, CheckOutTxt, PaidTxt, PendingTxt;
    JButton checkOutBtn,BackBtn,submitBtn;
    ImageIcon i14;
    CheckOut(){

        setBounds(0,60,1280,660);

        i14 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/chekout.png")));
        checkImg = new JLabel(i14);
        checkImg.setBounds(0,0,1280,660);

        Uplbl = new JLabel("Check Out");
        Uplbl.setFont(new Font("Serif",Font.BOLD,40));
        Uplbl.setForeground(Color.black);
        Uplbl.setBounds(500,40,300,50);
        add(Uplbl);


        IDlbl = new JLabel("Customer ID");
        IDlbl.setFont(new Font("Serif",Font.BOLD,20));
        IDlbl.setForeground(Color.black);
        IDlbl.setBounds(400,150,150,30);
        add(IDlbl);

        IDChoice = new Choice();
        IDChoice.setBounds(660,150,200,45);
        add(IDChoice);


        RNLbl = new JLabel("Room Number ");
        RNLbl.setFont(new Font("Serif",Font.BOLD,20));
        RNLbl.setForeground(Color.black);
        RNLbl.setBounds(400,200,150,30);
        add(RNLbl);

        RnTxt = new JTextField();
        RnTxt.setBackground(Color.white);
        RnTxt.setForeground(Color.black);
        RnTxt.setBounds(660,200,200,30);
        add(RnTxt);


        checkInLbl = new JLabel("Check In Time");
        checkInLbl.setFont(new Font("Serif",Font.BOLD,20));
        checkInLbl.setForeground(Color.black);
        checkInLbl.setBounds(400,250,150,30);
        add(checkInLbl);

        checkInTxt = new JTextField();
        checkInTxt.setBackground(Color.white);
        checkInTxt.setForeground(Color.black);
        checkInTxt.setBounds(660,250,200,30);
        add(checkInTxt);


        checkOutLbl = new JLabel("Check Out Time");
        checkOutLbl.setFont(new Font("Serif",Font.BOLD,20));
        checkOutLbl.setForeground(Color.black);
        checkOutLbl.setBounds(400,300,300,30);
        add(checkOutLbl);

        Date date = new Date();
        CheckOutTxt = new JTextField(String.valueOf(date));
        CheckOutTxt.setBackground(Color.white);
        CheckOutTxt.setForeground(Color.black);
        CheckOutTxt.setBounds(660,300,200,30);
        add(CheckOutTxt);


        checkOutBtn = new JButton("Check Out");
        checkOutBtn.setBackground(Color.BLACK);
        checkOutBtn.setForeground(Color.white);
        checkOutBtn.setBounds(570,450,140,30);
        checkOutBtn.setFocusable(false);
        checkOutBtn.addActionListener(this);
        checkOutBtn.setFont(new Font("Serif",Font.BOLD,20));
        add(checkOutBtn);


        submitBtn = new JButton("Get Details");
        submitBtn.setBackground(Color.BLACK);
        submitBtn.setForeground(Color.white);
        submitBtn.setBounds( 400,450,140,30);
        submitBtn.setFocusable(false);
        submitBtn.addActionListener(this);
        submitBtn.setFont(new Font("Serif",Font.BOLD,20));
        add(submitBtn);


        BackBtn = new JButton("Back");
        BackBtn.setBackground(Color.BLACK);
        BackBtn.setForeground(Color.white);
        BackBtn.setBounds(730,450,140,30);
        BackBtn.setFocusable(false);
        BackBtn.addActionListener(this);
        BackBtn.setFont(new Font("Serif",Font.BOLD,20));
        add(BackBtn);

        try{
            DataBaseConnection db = new DataBaseConnection();
            ResultSet rs = db.s.executeQuery("select *from customer");
            while (rs.next()){
                IDChoice.add(rs.getString("number"));
//                RnTxt.setText(rs.getString("roomnumber"));
//                checkInTxt.setText(rs.getString("checkInTime"));
            }
        }catch (Exception er){
            er.printStackTrace();
        }

        add(checkImg);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckOut();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == checkOutBtn) {
            String id = IDChoice.getSelectedItem();
            String query = "delete from customer where number = '"+id+"'";
            String query2  = "update room set availability = 'Available' where roomnumber = '"+RNLbl.getText()+"'";
            try {
                DataBaseConnection c = new DataBaseConnection();
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Checkout Done");
                setVisible(false);
                new Reception();
            } catch (Exception ee){
                ee.printStackTrace();
            }

        } else if (e.getSource() == submitBtn) {
            try{
                DataBaseConnection db1 = new DataBaseConnection();
                ResultSet rs = db1.s.executeQuery("select *from customer");
                while (rs.next()){
                    //IDChoice.add(rs.getString("number"));
                    RnTxt.setText(rs.getString("roomnumber"));
                    checkInTxt.setText(rs.getString("checkInTime"));
                }
            }catch (Exception er){
                er.printStackTrace();
            }
        } else if (e.getSource() == BackBtn) {
            setVisible(false);
            new Reception();
        }

    }
}

