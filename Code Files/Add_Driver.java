import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Add_Driver extends JFrame implements ActionListener{


        JLabel driverImg,nameLbl,ageLbl, genderLbl, companyLbl,modelLbl, avaiLbl,locationLbl,titleLbl;
        JTextField nameTxt,ageTxt,companyTxt,modelTxt,locationTxt;
        JButton addDriverBtn, cancelBtn;
        JComboBox genderCombo,avaiCombo;
        ImageIcon i10;

        Add_Driver(){

        setBounds(0,60,1280,660);
        i10 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/driver.png")));
        driverImg = new JLabel(i10);

            titleLbl = new JLabel("Add Driver");
            titleLbl.setBounds(500,70,400,50);
            titleLbl.setForeground(Color.BLACK);
            titleLbl.setFont(new Font("Serif",Font.BOLD,40));
            add(titleLbl);

            nameLbl = new JLabel("Name");
            nameLbl.setBounds(400,200,150,30);
            nameLbl.setFont(new Font("Tahoma",Font.BOLD,20));
            nameLbl.setForeground(Color.black);
            add(nameLbl);

            nameTxt = new JTextField();
            nameTxt.setBounds(600,200,150,30);
            add(nameTxt);

            ageLbl = new JLabel("Age");
            ageLbl.setBounds(400,250,150,30);
            ageLbl.setFont(new Font("Tahoma",Font.BOLD,20));
            ageLbl.setForeground(Color.black);
            add(ageLbl);

            ageTxt = new JTextField();
            ageTxt.setBounds(600,250,150,30);
            add(ageTxt);

            genderLbl = new JLabel("Gender");
            genderLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
            genderLbl.setForeground(Color.black);
            genderLbl.setBounds(400, 300, 220, 30);
            add(genderLbl);


            genderCombo = new JComboBox(new String[] { "Male", "Female" });
            genderCombo.setBackground(Color.white);
            genderCombo.setForeground(Color.black);
            genderCombo.setBounds(600,300,150,30);
            add(genderCombo);


            companyLbl = new JLabel("Car Company");
            companyLbl.setBounds(400,350,150,30);
            companyLbl.setFont(new Font("Tahoma",Font.BOLD,20));
            companyLbl.setForeground(Color.black);
            add(companyLbl);


            companyTxt = new JTextField();
            companyTxt.setBounds(600,350,150,30);
            add(companyTxt);


            modelLbl = new JLabel("Car Model");
            modelLbl.setBounds(400,400,150,30);
            modelLbl.setFont(new Font("Tahoma",Font.BOLD,20));
            modelLbl.setForeground(Color.black);
            add(modelLbl);

            modelTxt = new JTextField();
            modelTxt.setBounds(600,400,150,30);
            add(modelTxt);

            avaiLbl = new JLabel("Available");
            avaiLbl.setBounds(400,450,150,30);
            avaiLbl.setFont(new Font("Tahoma",Font.BOLD,20));
            avaiLbl.setForeground(Color.black);
            add(avaiLbl);

            avaiCombo = new JComboBox(new String[] {"Yes", "No" });
            avaiCombo.setBackground(Color.white);
            avaiCombo.setForeground(Color.black);
            avaiCombo.setBounds(600,450,150,30);
            add(avaiCombo);

            locationLbl = new JLabel("Location");
            locationLbl.setBounds(400,500,150,30);
            locationLbl.setFont(new Font("Tahoma",Font.BOLD,20));
            locationLbl.setForeground(Color.black);
            add(locationLbl);

            locationTxt = new JTextField();
            locationTxt.setBounds(600,500,150,30);
            add(locationTxt);


            addDriverBtn = new JButton("ADD DRIVER");
            addDriverBtn.setBounds(430,550,110,30);
            addDriverBtn.setFocusable(false);
            addDriverBtn.setBackground(Color.black);
            addDriverBtn.setForeground(Color.white);
            addDriverBtn.addActionListener(this);
            add(addDriverBtn);

            cancelBtn = new JButton("CANCEL");
            cancelBtn.setBounds(580,550,105,30);
            cancelBtn.setFocusable(false);
            cancelBtn.setBackground(Color.black);
            cancelBtn.setForeground(Color.white);
            cancelBtn.addActionListener(this);
            add(cancelBtn);


            add(driverImg);
            setVisible(true);


    }

    public static void main(String[] args) {
        new Add_Driver();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{

            if(ae.getSource() == addDriverBtn){
                try{

                    DataBaseConnection c = new DataBaseConnection();
                    String name = nameTxt.getText();
                    String age = ageTxt.getText();
                    String gender = (String)genderCombo.getSelectedItem();
                    String company  = companyTxt.getText();
                    String brand = modelTxt.getText();
                    String available = (String)avaiCombo.getSelectedItem();
                    String location = locationTxt.getText();
                    String str = "INSERT INTO driver values( '"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+brand+"', '"+available+"','"+location+"')";


                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Driver Successfully Added");
                    this.setVisible(false);

                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == cancelBtn){
                this.setVisible(false);
            }
        }catch(Exception eee){

        }
    }
    }
