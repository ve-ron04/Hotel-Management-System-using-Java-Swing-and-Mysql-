
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Add_Rooms extends JFrame implements ActionListener {

    JLabel roomImg,titleLbl,roomNoLbl, availableLbl, cleanLbl,priceLbl, bedTypeLbl;
    JTextField roomTxt,priceTxt;
    JButton addRoomBtn, cancelBtn;
    JComboBox avlCombo,cleanCombo,bedCombo;
    ImageIcon i9;

    Add_Rooms() {

        setResizable(false);
        setBounds(0,60,1280,660);
        i9 = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/room.png")));
        roomImg = new JLabel(i9);

        titleLbl = new JLabel("Add Rooms");
        titleLbl.setBounds(500,70,400,50);
        titleLbl.setForeground(Color.black);
        titleLbl.setFont(new Font("Serif",Font.BOLD,40));
        add(titleLbl);

        roomNoLbl = new JLabel("Room Number");
        roomNoLbl.setBounds(400,200,150,30);
        roomNoLbl.setFont(new Font("Tahoma",Font.BOLD,20));
        roomNoLbl.setForeground(Color.black);
        add(roomNoLbl);

        roomTxt = new JTextField();
        roomTxt.setBounds(600,200,150,30);
        add(roomTxt);

        availableLbl = new JLabel("Available");
        availableLbl.setBounds(400,250,150,30);
        availableLbl.setFont(new Font("Tahoma",Font.BOLD,20));
        availableLbl.setForeground(Color.black);
        add(availableLbl);


        avlCombo = new JComboBox(new String[] { "Available", "Occupied"});
        avlCombo.setBackground(Color.WHITE);
        avlCombo.setForeground(Color.black);
        avlCombo.setBounds(600,250,150,30);
        add(avlCombo);

        cleanLbl = new JLabel("Cleaning Status");
        cleanLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
        cleanLbl.setForeground(Color.black);
        cleanLbl.setBounds(400, 300, 220, 30);
        add(cleanLbl);


        cleanCombo = new JComboBox(new String[] { "Cleaned", "Dirty" });
        cleanCombo.setBackground(Color.WHITE);
        cleanCombo.setForeground(Color.black);
        cleanCombo.setBounds(600,300,150,30);
        add(cleanCombo);


        priceLbl = new JLabel("Price");
        priceLbl.setBounds(400,350,150,30);
        priceLbl.setFont(new Font("Tahoma",Font.BOLD,20));
        priceLbl.setForeground(Color.black);
        add(priceLbl);


        priceTxt = new JTextField();
        priceTxt.setBounds(600,350,150,30);
        add(priceTxt);


        bedTypeLbl = new JLabel("Bed Type");
        bedTypeLbl.setBounds(400,400,150,30);
        bedTypeLbl.setFont(new Font("Tahoma",Font.BOLD,20));
        bedTypeLbl.setForeground(Color.black);
        add(bedTypeLbl);

        bedCombo = new JComboBox(new String[] {"Single Bed", "Double Bed" });
        bedCombo.setBackground(Color.WHITE);
        bedCombo.setForeground(Color.black);
        bedCombo.setBounds(600,400,150,30);
        add(bedCombo);


        addRoomBtn = new JButton("ADD ROOM");
        addRoomBtn.setBounds(430,470,105,30);
        addRoomBtn.setFocusable(false);
        addRoomBtn.setBackground(Color.BLACK);
        addRoomBtn.setForeground(Color.WHITE);
        addRoomBtn.addActionListener(this);
        add(addRoomBtn);

        cancelBtn = new JButton("CANCEL");
        cancelBtn.setBounds(580,470,105,30);
        cancelBtn.setFocusable(false);
        cancelBtn.setBackground(Color.BLACK);
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.addActionListener(this);
        add(cancelBtn);


        add(roomImg);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Add_Rooms();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addRoomBtn){

            String roomno = roomTxt.getText();
            String avai =(String) avlCombo.getSelectedItem();
            String status =(String) cleanCombo.getSelectedItem();
            String price = priceTxt.getText();
            String type =(String) bedCombo.getSelectedItem();

            try{
                DataBaseConnection connn = new DataBaseConnection();
                String str = "INSERT INTO room values( '"+roomno+"', '"+avai+"', '"+status+"','"+price+"', '"+type+"')";
                connn.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null,"New room added successfully!!");
                setVisible(false);
            }catch (Exception be){
                be.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }
}