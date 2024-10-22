import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;

public class Status_Update extends JFrame implements ActionListener {

    JLabel checkImg;
    JLabel Uplbl,IDlbl,RNLbl,NameLbl,cheInLbl,paidLbl,PendingLbl;
    Choice IDChoice;
    JTextField RnTxt, NameTxt, CheckInTxt, PaidTxt, PendingTxt;
    JButton checkBtn,updateBtn,BackBtn;
    ImageIcon i14;
    Status_Update(){

        setBounds(0,60,1280,660);

        setResizable(false);
        i14 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/checkUpdate.png")));
        checkImg = new JLabel(i14);
        checkImg.setBounds(0,0,1280,660);

        Uplbl = new JLabel("Status Update ");
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

        try{
            DataBaseConnection db = new DataBaseConnection();
            ResultSet rs = db.s.executeQuery("select *from customer");
            while (rs.next()){
                IDChoice.add(rs.getString("number"));
            }
        }catch (Exception er){
            er.printStackTrace();
        }


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



        NameLbl = new JLabel("Name");
        NameLbl.setFont(new Font("Serif",Font.BOLD,20));
        NameLbl.setForeground(Color.black);
        NameLbl.setBounds(400,250,150,30);
        add(NameLbl);

        NameTxt = new JTextField();
        NameTxt.setBackground(Color.white);
        NameTxt.setForeground(Color.black);
        NameTxt.setBounds(660,250,200,30);
        add(NameTxt);


        cheInLbl = new JLabel("Check In Time");
        cheInLbl.setFont(new Font("Serif",Font.BOLD,20));
        cheInLbl.setForeground(Color.black);
        cheInLbl.setBounds(400,300,300,30);
        add(cheInLbl);

        CheckInTxt = new JTextField();
        CheckInTxt.setBackground(Color.white);
        CheckInTxt.setForeground(Color.black);
        CheckInTxt.setBounds(660,300,200,30);
        add(CheckInTxt);


        paidLbl = new JLabel("Amount Paid");
        paidLbl.setFont(new Font("Serif",Font.BOLD,20));
        paidLbl.setForeground(Color.black);
        paidLbl.setBounds(400,350,150,30);
        add(paidLbl);

        PaidTxt = new JTextField();
        PaidTxt.setBackground(Color.white);
        PaidTxt.setForeground(Color.black);
        PaidTxt.setBounds(660,350,200,30);
        add(PaidTxt);


        PendingLbl = new JLabel("Pending Amount");
        PendingLbl.setFont(new Font("Serif",Font.BOLD,20));
        PendingLbl.setForeground(Color.black);
        PendingLbl.setBounds(400,400,150,30);
        add(PendingLbl);

        PendingTxt = new JTextField();
        PendingTxt.setBackground(Color.white);
        PendingTxt.setForeground(Color.black);
        PendingTxt.setBounds(660,400,200,30);
        add(PendingTxt);


        checkBtn = new JButton("Check");
        checkBtn.setBackground(Color.BLACK);
        checkBtn.setForeground(Color.white);
        checkBtn.setBounds(430,530,100,30);
        checkBtn.setFocusable(false);
        checkBtn.addActionListener(this);
        checkBtn.setFont(new Font("Serif",Font.BOLD,20));
        add(checkBtn);



        updateBtn = new JButton("Update");
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setForeground(Color.white);
        updateBtn.setBounds(580,530,100,30);
        updateBtn.setFocusable(false);
        updateBtn.addActionListener(this);
        updateBtn.setFont(new Font("Serif",Font.BOLD,20));
        add(updateBtn);


        BackBtn = new JButton("Back");
        BackBtn.setBackground(Color.BLACK);
        BackBtn.setForeground(Color.white);
        BackBtn.setBounds(730,530,100,30);
        BackBtn.setFocusable(false);
        BackBtn.addActionListener(this);
        BackBtn.setFont(new Font("Serif",Font.BOLD,20));
        add(BackBtn);


        add(checkImg);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Status_Update();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == updateBtn){

            String number = IDChoice.getSelectedItem();
            String room = RnTxt.getText();
            String name = NameTxt.getText();
            String Checkin = CheckInTxt.getText();
            String deposit = PaidTxt.getText();

            try{

                DataBaseConnection cv = new DataBaseConnection();
                cv.s.executeUpdate("update customer set roomnumber = '"+room+"', name = '"+name+"', checkInTime = '"+Checkin+"', Deposit = '"+deposit+ "' WHERE number = '" + number +"'");

                JOptionPane.showMessageDialog(null, "Data Updated Successfully");

                setVisible(false);
                new Reception();
            }catch (Exception ec){
                ec.printStackTrace();
            }

        } else if (e.getSource() == checkBtn) {
            String id = IDChoice.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";
            try{
                DataBaseConnection c = new DataBaseConnection();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){

                    RnTxt.setText(rs.getString("roomnumber"));
                    NameTxt.setText(rs.getString("name"));
                    CheckInTxt.setText(rs.getString("CheckInTime"));
                    PaidTxt.setText(rs.getString("Deposit"));
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber= '"+RnTxt.getText()+"'");
                while (rs2.next()){
                      String price = rs2.getString("price");
                      int amountPaid = Integer.parseInt(price) - Integer.parseInt(PaidTxt.getText());
                      PendingTxt.setText(" "+amountPaid);
                }
            }catch (Exception ee){
                ee.printStackTrace();
            }
        } else if (e.getSource() == BackBtn) {
            setVisible(false);
            new Reception();
        }

    }
}
