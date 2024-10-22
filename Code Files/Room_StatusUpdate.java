import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;

public class Room_StatusUpdate extends JFrame implements ActionListener {

    JLabel checkImg;
    JLabel Uplbl,IDlbl,RNLbl,avlLbl,cleanLbl,paidLbl,PendingLbl;
    Choice IDChoice;
    JTextField RnTxt, avlTxt, cleanTxt, PaidTxt, PendingTxt;
    JButton checkBtn,updateBtn,BackBtn;
    ImageIcon i15;
    Room_StatusUpdate(){

        setResizable(false);
        setBounds(0,60,1280,660);

        i15 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/clean.png")));
        checkImg = new JLabel(i15);
        checkImg.setBounds(0,0,1280,660);

        Uplbl = new JLabel("Room Status Update ");
        Uplbl.setFont(new Font("Serif",Font.BOLD,40));
        Uplbl.setForeground(Color.black);
        Uplbl.setBounds(460,40,500,50);
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
        RnTxt.setEditable(false);
        add(RnTxt);



        avlLbl = new JLabel("Availability");
        avlLbl.setFont(new Font("Serif",Font.BOLD,20));
        avlLbl.setForeground(Color.black);
        avlLbl.setBounds(400,250,150,30);
        add(avlLbl);

        avlTxt = new JTextField();
        avlTxt.setBackground(Color.white);
        avlTxt.setForeground(Color.black);
        avlTxt.setBounds(660,250,200,30);
        add(avlTxt);


        cleanLbl = new JLabel("Cleaning Status");
        cleanLbl.setFont(new Font("Serif",Font.BOLD,20));
        cleanLbl.setForeground(Color.black);
        cleanLbl.setBounds(400,300,300,30);
        add(cleanLbl);

        cleanTxt = new JTextField();
        cleanTxt.setBackground(Color.white);
        cleanTxt.setForeground(Color.black);
        cleanTxt.setBounds(660,300,200,30);
        add(cleanTxt);


        checkBtn = new JButton("Check");
        checkBtn.setBackground(Color.BLACK);
        checkBtn.setForeground(Color.white);
        checkBtn.setBounds(430,420,100,30);
        checkBtn.setFocusable(false);
        checkBtn.addActionListener(this);
        checkBtn.setFont(new Font("Serif",Font.BOLD,20));
        add(checkBtn);



        updateBtn = new JButton("Update");
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setForeground(Color.white);
        updateBtn.setBounds(580,420,100,30);
        updateBtn.setFocusable(false);
        updateBtn.addActionListener(this);
        updateBtn.setFont(new Font("Serif",Font.BOLD,20));
        add(updateBtn);


        BackBtn = new JButton("Back");
        BackBtn.setBackground(Color.BLACK);
        BackBtn.setForeground(Color.white);
        BackBtn.setBounds(730,420,100,30);
        BackBtn.setFocusable(false);
        BackBtn.addActionListener(this);
        BackBtn.setFont(new Font("Serif",Font.BOLD,20));
        add(BackBtn);


        add(checkImg);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room_StatusUpdate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == updateBtn){

            String number = IDChoice.getSelectedItem();
            String room = RnTxt.getText();
            String availablee = avlTxt.getText();
            String cleaning = cleanTxt.getText();

            try{

                DataBaseConnection cv = new DataBaseConnection();
                cv.s.executeUpdate("update room set availability = '"+availablee+"',cleaning_status = '"+cleaning+"' WHERE roomnumber = '" + room +"'");

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
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber= '"+RnTxt.getText()+"'");
                while (rs2.next()){
                    avlTxt.setText(rs2.getString("availability"));
                    cleanTxt.setText(rs2.getString("cleaning_status"));
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

