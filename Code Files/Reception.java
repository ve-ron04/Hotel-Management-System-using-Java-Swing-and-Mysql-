import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Objects;

public class Reception extends JFrame implements ActionListener{


    JLabel receptionImg;
    ImageIcon i11;
    JButton custBtn,roonBtn, deptBtn, AllEmBtn, CinfoBtn,MinfoBtn,checkOutBtn,USbtn,URBtn,PickBtn,SerachBtn,LogOutBtn;
    public Reception(){

        setResizable(false);
        setBounds(0,60,1280,660);
        i11 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/reception.png")));
        receptionImg = new JLabel(i11);

        custBtn = new JButton("New Customer Check In");
        custBtn.setBounds(150,100,200,25);
        custBtn.setFocusable(false);
        custBtn.setBackground(Color.white);
        custBtn.setForeground(Color.black);
        custBtn.addActionListener(this);
        add(custBtn);

        roonBtn = new JButton("Rooms Info");
        roonBtn.setBounds(150,140,200,25);
        roonBtn.setFocusable(false);
        roonBtn.setBackground(Color.white);
        roonBtn.setForeground(Color.black);
        roonBtn.addActionListener(this);
        add(roonBtn);

        deptBtn = new JButton("Department & Budget Info");
        deptBtn.setBounds(150,180,200,25);
        deptBtn.setFocusable(false);
        deptBtn.setBackground(Color.white);
        deptBtn.setForeground(Color.black);
        deptBtn.addActionListener(this);
        add(deptBtn);

        AllEmBtn = new JButton("All Employee");
        AllEmBtn.setBounds(150,220,200,25);
        AllEmBtn.setFocusable(false);
        AllEmBtn.setBackground(Color.white);
        AllEmBtn.setForeground(Color.black);
        AllEmBtn.addActionListener(this);
        add(AllEmBtn);

        CinfoBtn = new JButton("Customer Info");
        CinfoBtn.setBounds(150,260,200,25);
        CinfoBtn.setFocusable(false);
        CinfoBtn.setBackground(Color.white);
        CinfoBtn.setForeground(Color.black);
        CinfoBtn.addActionListener(this);
        add(CinfoBtn);

        MinfoBtn = new JButton("Manager Info");
        MinfoBtn.setBounds(150,300,200,25);
        MinfoBtn.setFocusable(false);
        MinfoBtn.setBackground(Color.white);
        MinfoBtn.setForeground(Color.black);
        MinfoBtn.addActionListener(this);
        add(MinfoBtn);

        checkOutBtn = new JButton("Checkout");
        checkOutBtn.setBounds(150,420,200,25);
        checkOutBtn.setFocusable(false);
        checkOutBtn.setBackground(Color.white);
        checkOutBtn.setForeground(Color.black);
        checkOutBtn.addActionListener(this);
        add(checkOutBtn);

        USbtn = new JButton("Status Update");
        USbtn.setBounds(150, 380,200,25);
        USbtn.setFocusable(false);
        USbtn.setBackground(Color.white);
        USbtn.setForeground(Color.black);
        USbtn.addActionListener(this);
        add(USbtn);

        URBtn = new JButton("Room Status Update");
        URBtn.setBounds(150,340,200,25);
        URBtn.setFocusable(false);
        URBtn.setBackground(Color.white);
        URBtn.setForeground(Color.black);
        URBtn.addActionListener(this);
        add(URBtn);

        PickBtn = new JButton("Pick Up Service");
        PickBtn.setBounds(150,460,200,25);
        PickBtn.setFocusable(false);
        PickBtn.setBackground(Color.white);
        PickBtn.setForeground(Color.black);
        PickBtn.addActionListener(this);
        add(PickBtn);

        SerachBtn = new JButton("Search Rooms");
        SerachBtn.setBounds(150,500,200,25);
        SerachBtn.setFocusable(false);
        SerachBtn.setBackground(Color.white);
        SerachBtn.setForeground(Color.black);
        SerachBtn.addActionListener(this);
        add(SerachBtn);

        LogOutBtn = new JButton("Log Out");
        LogOutBtn.setBounds(150,540,200,25);
        LogOutBtn.setFocusable(false);
        LogOutBtn.setBackground(Color.white);
        LogOutBtn.setForeground(Color.black);
        LogOutBtn.addActionListener(this);
        add(LogOutBtn);

        add(receptionImg);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }

    @Override
    public void actionPerformed(ActionEvent aae) {
        if(aae.getSource() == custBtn){
            setVisible(false);
            new Add_NewCustomer();
        } else if (aae.getSource() == roonBtn) {
            setVisible(false);
            new Room();
        }else if (aae.getSource() == deptBtn) {
            setVisible(false);
            new Department();
        }else if (aae.getSource() == AllEmBtn) {
            setVisible(false);
            new Employee_Info();
        }else if (aae.getSource() == MinfoBtn) {
            setVisible(false);
            new Manager_Info();
        }
        else if (aae.getSource() == CinfoBtn) {
            setVisible(false);
            new Customer_Info();
        }else if (aae.getSource() == SerachBtn) {
            setVisible(false);
            new Search_Room();
        }else if (aae.getSource() == USbtn) {
            setVisible(false);
            new Status_Update();
        }else if (aae.getSource() == URBtn) {
            setVisible(false);
            new Room_StatusUpdate();
        }else if (aae.getSource() == PickBtn) {
            setVisible(false);
            new PickUp();
        }else if (aae.getSource() == checkOutBtn) {
            setVisible(false);
            new CheckOut();
        }else if (aae.getSource() == LogOutBtn) {
            setVisible(false);
            System.exit(0);
       }
    }
}
