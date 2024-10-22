import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.Date;

public class Add_NewCustomer extends JFrame implements ActionListener {


    JLabel newCustImg,IdLbl,numLbl,genderLbl,countryLbl,roomNumberLbl,CheckInLbl,depositLbl,titleLbl,nameLbl,checkTimeLbl;
    JTextField numTxt,countryTxt,depositTxt,nameTxt;
    Choice roomChoice;
    JButton addBtn,backBtn;
    ImageIcon i12;
    JComboBox idCombo;
    ButtonGroup bg;
    JRadioButton genderBtnMale, genderBtnFemale;
    Add_NewCustomer(){

        setBounds(0,60,1280,660);
        i12 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/customer.png")));
        newCustImg = new JLabel(i12);

        setResizable(false);

        titleLbl = new JLabel("New Customer Form");
        titleLbl.setBounds(400,50,400,50);
        titleLbl.setForeground(Color.BLACK);
        titleLbl.setFont(new Font("Serif",Font.BOLD,40));
        add(titleLbl);

        nameLbl = new JLabel("Name");
        nameLbl.setBounds(400,150,150,30);
        nameLbl.setFont(new Font("Tahoma",Font.BOLD,20));
        nameLbl.setForeground(Color.black);
        add(nameLbl);

        nameTxt = new JTextField();
        nameTxt.setBounds(600,150,150,30);
        add(nameTxt);

        IdLbl = new JLabel("ID");
        IdLbl.setBounds(400,200,150,30);
        IdLbl.setFont(new Font("Tahoma",Font.BOLD,20));
        IdLbl.setForeground(Color.black);
        add(IdLbl);

        idCombo = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving license"});
        idCombo.setBackground(Color.white);
        idCombo.setForeground(Color.black);
        idCombo.setBounds(600,200,150,30);
        add(idCombo);

        numLbl = new JLabel("Number");
        numLbl.setBounds(400,250,150,30);
        numLbl.setFont(new Font("Tahoma",Font.BOLD,20));
        numLbl.setForeground(Color.black);
        add(numLbl);

        numTxt = new JTextField();
        numTxt.setBounds(600,250,150,30);
        add(numTxt);

        genderLbl = new JLabel("Gender");
        genderLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
        genderLbl.setForeground(Color.black);
        genderLbl.setBounds(400, 300, 220, 30);
        add(genderLbl);

        genderBtnMale = new JRadioButton("Male");
        genderBtnMale.setBounds(600,300,70,30);
        genderBtnMale.setFocusable(false);
        genderBtnMale.setBackground(Color.white);
        genderBtnMale.setForeground(Color.black);
        add(genderBtnMale);

        genderBtnFemale = new JRadioButton("Female");
        genderBtnFemale.setBounds(670,300,80,30);
        genderBtnFemale.setFocusable(false);
        genderBtnFemale.setBackground(Color.white);
        genderBtnFemale.setForeground(Color.black);
        add(genderBtnFemale);

        bg = new ButtonGroup();
        bg.add(genderBtnFemale);
        bg.add(genderBtnMale);

        countryLbl = new JLabel("Country");
        countryLbl.setBounds(400,350,150,30);
        countryLbl.setFont(new Font("Tahoma",Font.BOLD,20));
        countryLbl.setForeground(Color.black);
        add(countryLbl);

        countryTxt = new JTextField();
        countryTxt.setBounds(600,350,150,30);
        add(countryTxt);


        roomNumberLbl = new JLabel("Room Number");
        roomNumberLbl.setBounds(400,400,150,30);
        roomNumberLbl.setFont(new Font("Tahoma",Font.BOLD,20));
        roomNumberLbl.setForeground(Color.black);
        add(roomNumberLbl);


        roomChoice = new Choice();
        try{
            DataBaseConnection con = new DataBaseConnection();
            String query = "SELECT* FROM room WHERE availability = 'Available'";
            ResultSet rs = con.s.executeQuery(query);
            while (rs.next()){
                roomChoice.add(rs.getString("roomnumber"));
            }
        }catch (Exception e2){
            e2.printStackTrace();
        }
        roomChoice.setBounds(600,400,150,30);
        add(roomChoice);

        CheckInLbl = new JLabel("Check In Time");
        CheckInLbl.setBounds(400,450,150,30);
        CheckInLbl.setFont(new Font("Tahoma",Font.BOLD,20));
        CheckInLbl.setForeground(Color.black);
        add(CheckInLbl);

        Date date = new Date();

        checkTimeLbl = new JLabel(String.valueOf(date));
        checkTimeLbl.setBounds(600,450,200,20);
        checkTimeLbl.setFont(new Font("Tahoma",Font.BOLD,12));
        checkTimeLbl.setForeground(Color.white);
        add(checkTimeLbl);


        depositLbl = new JLabel("Deposit");
        depositLbl.setBounds(400,500,150,30);
        depositLbl.setFont(new Font("Tahoma",Font.BOLD,20));
        depositLbl.setForeground(Color.black);
        add(depositLbl);

        depositTxt = new JTextField();
        depositTxt.setBounds(600,500,150,30);
        add(depositTxt);


        addBtn = new JButton("ADD");
        addBtn.setBounds(430,550,110,30);
        addBtn.setFocusable(false);
        addBtn.setBackground(Color.black);
        addBtn.setForeground(Color.white);
        addBtn.addActionListener(this);
        add(addBtn);

        backBtn = new JButton("CANCEL");
        backBtn.setBounds(580,550,105,30);
        backBtn.setFocusable(false);
        backBtn.setBackground(Color.black);
        backBtn.setForeground(Color.white);
        backBtn.addActionListener(this);
        add(backBtn);

        add(newCustImg);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Add_NewCustomer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addBtn){
            String name = nameTxt.getText();
            String document = (String) idCombo.getSelectedItem();
            String number = numTxt.getText();
            String gender = null;

            if(genderBtnMale.isSelected()){
                gender = "Male";
            } else {
                gender = "Female";
            }
            String country = countryTxt.getText();
            String room = roomChoice.getSelectedItem();
            String time = checkTimeLbl.getText();
            String deposit = depositTxt.getText();

            try{
                String query = "INSERT INTO customer VALUES('"+name+"','"+document+"','"+number+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2 = "update room set availability = 'Occupied' where roomnumber = '"+room+"'";

                DataBaseConnection con2 = new DataBaseConnection();
                con2.s.executeUpdate(query);
                con2.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                setVisible(false);
                new Reception();
            }catch (Exception ew){
                ew.printStackTrace();
            }
        } else if (e.getSource() == backBtn) {
            setVisible(false);
            new Reception();
        }
    }
}
