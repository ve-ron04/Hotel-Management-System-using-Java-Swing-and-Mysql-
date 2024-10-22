
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class DashBoard extends JFrame implements ActionListener {

    ImageIcon i7;
    JLabel DboardImg, Welcome;
    JMenuBar mb;
    JMenu hotel, admin;
    JMenuItem reception, addEmploye, addRooms, addDrivers;
    Color hotelClr,adminClr;
    JButton logOutBtn;
    DashBoard(){

        setTitle("Dash Board");
        setBounds(0,0,1280,720);

        i7 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/dashBoard.png")));
        DboardImg = new JLabel(i7);
        DboardImg.setBounds(0, 0, 1940, 1080);



        mb = new JMenuBar();
        mb.setBounds(0,0,340,30);

        hotelClr = new Color(242, 123, 48);

        hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setBackground(Color.WHITE);
        hotel.setForeground(Color.black);
        hotel.setOpaque(true);
        hotel.setFont(new Font("Serif", Font.BOLD,20));

        Welcome = new JLabel("WELCOME TO WYNN PALACE");
        Welcome.setFont(new Font("Serif",Font.BOLD,40));
        Welcome.setBounds(330,80,1000,100);
        Welcome.setForeground(Color.white);


        DboardImg.add(Welcome);
        admin = new JMenu("   ADMIN");
        hotel.setBackground(Color.WHITE);
        admin.setForeground(Color.BLACK);
        admin.setFont(new Font("Serif", Font.BOLD, 20));


        reception = new JMenuItem("Reception");
        reception.setFont(new Font("SansSerif", Font.ITALIC, 20));
        reception.addActionListener(this);

        addRooms = new JMenuItem("Add Rooms");
        addRooms.setFont(new Font("SansSerif", Font.ITALIC, 20));
        addRooms.addActionListener(this);

        addDrivers = new JMenuItem("Add Drivers");
        addDrivers.setFont(new Font("SansSerif", Font.ITALIC, 20));
        addDrivers.addActionListener(this);

        addEmploye = new JMenuItem("Add Employees");
        addEmploye.setFont(new Font("SansSerif", Font.ITALIC, 20));
        addEmploye.addActionListener(this);

        logOutBtn = new JButton("Log Out");
        logOutBtn.setBounds(530,550,150,40);
        logOutBtn.setForeground(Color.white);
        logOutBtn.setBackground(Color.black);
        logOutBtn.setFont(new Font("Serif",Font.BOLD,20));
        logOutBtn.addActionListener(this);
        logOutBtn.setFocusable(false);
        add(logOutBtn);

        admin.add(addRooms);
        admin.add(addDrivers);
        admin.add(addEmploye);

        hotel.add(reception);


        mb.add(hotel);
        mb.add(admin);
        DboardImg.add(mb);
        add(DboardImg);
        setVisible(true);

    }

    public static void main(String[] args){
        new DashBoard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Employees")) {

            new Add_Employee();
        } else if (e.getActionCommand().equals("Add Rooms")) {
            new Add_Rooms();
        } else if (e.getActionCommand().equals("Add Drivers")) {
            new Add_Driver();
        } else if (e.getActionCommand().equals("Reception")) {
            new Reception();
        } else if (e.getSource() == logOutBtn) {
            setVisible(false);
            new LogIn();
        }
    }
}
