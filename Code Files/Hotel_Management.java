import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Hotel_Management extends JFrame implements ActionListener {

    ImageIcon i1,i2;
    JLabel image;
    JButton next;
    Hotel_Management(){

        setTitle("HSM");
        setBounds(0,0,1280,720);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        i1 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/hotel.png")));
        i2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/next.png")));
        image = new JLabel(i1);
        image.setBounds(0, 0, 1280, 720);


        next = new JButton("Next");
        next.setBounds(1050,560,130,40);
        next.setBackground(Color.white);
        next.setForeground(Color.black);
        next.setIcon(i2);
        next.addActionListener(this);
        next.setFocusable(false);
        image.add(next);

        add(image);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new LogIn();
    }

    public static void main(String[] args) {
        new Hotel_Management();
    }


}
