import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.CardLayout;

public class ClientGUI implements ActionListener {

    static BidHandler suite;
    static BidHandler deluxe;
    static BidHandler standard;
    static JTextField jTextField;
    static JFrame jFrame;
    ClientGUI(){
        suite = new Suite();
        deluxe = new Deluxe();
        standard = new Standard();
        //set deluxe as successor of suite
        suite.setSuccessor(deluxe);
        //set standard as successor of deluxe
        deluxe.setSuccessor(standard);
    }
    public static void main(String[] args) {

        ClientGUI gui = new ClientGUI();

            //create a layout of GUI screen
            jFrame = new JFrame("Hotel Room Bidding System");
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //set the GUI screen size
            jFrame.setSize(600,300);

            //create a container
            JPanel jpanel = new JPanel();
            JTextArea jtextArea = new JTextArea();
            JLabel jlabel = new JLabel("Enter bid price ($): ");
            jTextField = new JTextField(5);
            JButton submitButton = new JButton("Submit");

            //add text field, button to the container
            jpanel.add(jlabel);
            jpanel.add(jTextField);
            jpanel.add(submitButton);

            //when user clicks submit button, listen to the action and call a method to response to the action
            submitButton.addActionListener(gui);

            //add the container to the top side of the GUI screen layout
            jFrame.getContentPane().add(BorderLayout.NORTH, jpanel);
            jFrame.setVisible(true);


        }

        //called when user clicks submit button
        public void actionPerformed(ActionEvent e){

        //retrieve input of bid price from user and convert it into double type from string.
        double bidPrice = Double.parseDouble(jTextField.getText());

        //make a request to bidhandler
        String output = suite.bidRequest(bidPrice, 0);

        //create a popup message to show bid result
        JOptionPane jpane = new JOptionPane();
        jpane.showMessageDialog(jFrame, output, "Bid Result", JOptionPane.PLAIN_MESSAGE);

        }




    }
