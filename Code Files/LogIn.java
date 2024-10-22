import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;
import javax.swing.*;

public class LogIn extends JFrame implements ActionListener {

    JPanel panel;
    JLabel LogImage,user,pass,employeeImg;
    JTextField username;
    JButton logInBtn,cancelBtn;
    ImageIcon i3,i4,i5,i6;
    JPasswordField password;

    LogIn() {

        setTitle("Login");
        setBounds(0,0,1280,720);

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        i3 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/Log.png")));
        i4 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/login.png")));
        i5 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/cancel.png")));
        i6 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/worker.png")));


        LogImage = new JLabel(i3);
        LogImage.setBounds(0,0,1280,720);

        employeeImg = new JLabel(i6);
        employeeImg.setBounds(480,180,350,350);

        user=new JLabel("Username");
        user.setBounds(900, 280, 150, 40);
        user.setFont(new Font("Serif",Font.PLAIN,30));
        user.setForeground(Color.BLACK);

        username=new JTextField();
        username.setBounds(1100,280,250,40);

        pass = new JLabel("Password");
        pass.setBounds(900,350,150,40);
        pass.setFont(new Font("Serif", Font.PLAIN, 30));
        pass.setForeground(Color.BLACK);

        password = new JPasswordField();
        password.setBounds(1100,350,250,40);

        logInBtn = new JButton("Log In");
        logInBtn.setBounds(950,470,150,45);
        logInBtn.setBackground(Color.white);
        logInBtn.setForeground(Color.BLACK);
        logInBtn.setFont(new Font("Serif",Font.PLAIN,20));
        logInBtn.setFocusable(false);
        logInBtn.setIcon(i4);
        logInBtn.addActionListener(this);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(1170,470, 150, 45);
        cancelBtn.setBackground(Color.white);
        cancelBtn.setForeground(Color.BLACK);
        cancelBtn.setFont(new Font("Serif", Font.PLAIN, 20));
        cancelBtn.setFocusable(false);
        cancelBtn.addActionListener(this);
        cancelBtn.setIcon(i5);


        LogImage.add(user);
        LogImage.add(pass);
        LogImage.add(password);
        LogImage.add(username);
        LogImage.add(logInBtn);
        LogImage.add(cancelBtn);
        LogImage.add(employeeImg);

        panel.add(LogImage);

        getContentPane().add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {

        new LogIn();
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==logInBtn){
            try{
                DataBaseConnection c1 = new DataBaseConnection();
                String u = username.getText();
                String v = password.getText();

                String q = "select * from login where username='"+u+"' and password='"+v+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    new DashBoard().setVisible(true);
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==cancelBtn){
            System.exit(0);
        }
    }

}

