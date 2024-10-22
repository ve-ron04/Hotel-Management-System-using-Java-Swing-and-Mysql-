import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Add_Employee extends JFrame implements ActionListener {
    JLabel image,nameLbl,ageLbl,genderLbl,jobLbl,salaryLbl,phoneLbl,emailLbl,aadharLbl,emlpoyeLbl;
    JTextField nameTxt,ageTxt,salaryTxt,phoneTxt,emailTxt,aadharTxt;
    JButton submitBtn;
    JRadioButton genderBtnMale, genderBtnFemale;
    JComboBox cbjob;
    ButtonGroup bg;
    ImageIcon i8;
    Add_Employee(){

        setLayout(null);
        setBounds(0,60,1280,660);
        setResizable(false);

        emlpoyeLbl = new JLabel("Add Employee");
        emlpoyeLbl.setBounds(450,30,400,50);
        emlpoyeLbl.setForeground(Color.black);
        emlpoyeLbl.setFont(new Font("Serif",Font.BOLD,40));
        add(emlpoyeLbl);

        i8 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/staff.png")));
        image = new JLabel(i8);
        image.setBounds(0,0,1280,660);
        nameLbl = new JLabel("Name");
        nameLbl.setBounds(400,100,150,30);
        nameLbl.setFont(new Font("Tahoma",Font.BOLD,20));
        nameLbl.setForeground(Color.black);
        add(nameLbl);

        nameTxt = new JTextField();
        nameTxt.setBounds(600,100,150,30);
        add(nameTxt);

        ageLbl = new JLabel("Age");
        ageLbl.setBounds(400,150,150,30);
        ageLbl.setFont(new Font("Tahoma",Font.BOLD,20));
        ageLbl.setForeground(Color.black);
        add(ageLbl);

        ageTxt = new JTextField();
        ageTxt.setBounds(600,150,150,30);
        add(ageTxt);

        genderLbl = new JLabel("Gender");
        genderLbl.setBounds(400,200,150,30);
        genderLbl.setFont(new Font("Tahoma",Font.BOLD,20));
        genderLbl.setForeground(Color.black);
        add(genderLbl);

        genderBtnMale = new JRadioButton("Male");
        genderBtnMale.setBounds(600,200,70,30);
        genderBtnMale.setFocusable(false);
        genderBtnMale.setBackground(Color.white);
        genderBtnMale.setForeground(Color.black);
        add(genderBtnMale);

        genderBtnFemale = new JRadioButton("Female");
        genderBtnFemale.setBounds(670,200,80,30);
        genderBtnFemale.setFocusable(false);
        genderBtnFemale.setBackground(Color.white);
        genderBtnFemale.setForeground(Color.black);
        add(genderBtnFemale);

        bg = new ButtonGroup();
        bg.add(genderBtnFemale);
        bg.add(genderBtnMale);

        jobLbl = new JLabel("Job");
        jobLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
        jobLbl.setForeground(Color.black);
        jobLbl.setBounds(400, 250, 150, 30);
        add(jobLbl);

        String str[] = {"Front Desk Clearks", "Porters","House Keeping","Kitchen Staff","Room Service","Chefs","Waiter/Waitres", "Manager","Accountant"};

        cbjob = new JComboBox(str);
        cbjob.setBackground(Color.WHITE);
        cbjob.setForeground(Color.black);
        cbjob.setBounds(600,250,150,30);
        add(cbjob);

        salaryLbl = new JLabel("Salary");
        salaryLbl.setBounds(400,300,150,30);
        salaryLbl.setFont(new Font("Tahoma",Font.BOLD,20));
        salaryLbl.setForeground(Color.black);
        add(salaryLbl);

        salaryTxt = new JTextField();
        salaryTxt.setBounds(600,300,150,30);
        add(salaryTxt);


        phoneLbl = new JLabel("Phone");
        phoneLbl.setBounds(400,350,150,30);
        phoneLbl.setFont(new Font("Tahoma",Font.BOLD,20));
        phoneLbl.setForeground(Color.black);
        add(phoneLbl);

        phoneTxt = new JTextField();
        phoneTxt.setBounds(600,350,150,30);
        add(phoneTxt);

        emailLbl = new JLabel("Email");
        emailLbl.setBounds(400,400,150,30);
        emailLbl.setFont(new Font("Tahoma",Font.BOLD,20));
        emailLbl.setForeground(Color.black);
        add(emailLbl);

        emailTxt = new JTextField();
        emailTxt.setBounds(600,400,150,30);
        add(emailTxt);

        aadharLbl = new JLabel("Aadhar");
        aadharLbl.setBounds(400,450,150,30);
        aadharLbl.setFont(new Font("Tahoma",Font.BOLD,20));
        aadharLbl.setForeground(Color.black);
        add(aadharLbl);

        aadharTxt = new JTextField();
        aadharTxt.setBounds(600,450,150,30);
        add(aadharTxt);

        submitBtn = new JButton("SUBMIT");
        submitBtn.setBounds(510,530,100,30);
        submitBtn.setFocusable(false);
        submitBtn.setBackground(Color.BLACK);
        submitBtn.setForeground(Color.WHITE);
        submitBtn.addActionListener(this);
        add(submitBtn);


        add(image);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Add_Employee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameTxt.getText();
        String age = ageTxt.getText();
        String salary = salaryTxt.getText();
        String phone = phoneTxt.getText();
        String email = emailTxt.getText();
        String aadhar = aadharTxt.getText();

        String gender = null;

        if(genderBtnMale.isSelected()){
            gender = "Male";
        } else if (genderBtnFemale.isSelected()) {
            gender = "Female";
        }

        String job = (String) cbjob.getSelectedItem();

        try{
            DataBaseConnection conn = new DataBaseConnection();
            String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Employe added Successfully");
            setVisible(false);
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }
}



