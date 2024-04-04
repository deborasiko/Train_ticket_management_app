package mvc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame{
    private JTextField trainNr;

    private JButton searchTrainButton;
    private JButton customerButton;
    private JButton adminButton;

    public View()
    {
        this.setBounds(100, 100, 643, 432);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel title = new JLabel("Train Station");
        title.setFont(new Font("Something",Font.PLAIN, 22));
        title.setBounds(251, 21, 150, 40);
        this.getContentPane().add(title);

        trainNr = new JTextField();
        trainNr.setBounds(256,75, 110, 25);
        this.getContentPane().add(trainNr);
        trainNr.setColumns(10);

        searchTrainButton = new JButton("Search for train");
        searchTrainButton.setBounds(250,105, 125, 20);
        //searchTrainButton.addActionListener(this);
        this.getContentPane().add(searchTrainButton);

        customerButton = new JButton("Customer");
        customerButton.setFont(new Font("Something", Font.PLAIN, 16));
        customerButton.setBounds(100, 200, 125, 30);
        //customerButton.addActionListener(this);
        this.getContentPane().add(customerButton);


        adminButton = new JButton("Admin");
        adminButton.setFont(new Font("Something", Font.PLAIN, 16));
        adminButton.setBounds(418, 200, 125, 30);
        //adminButton.addActionListener(this);
        this.getContentPane().add(adminButton);


        this.setVisible(true);
    }

    public String getTrainNR(){
        return trainNr.getText();
    }

    public void setTrainNR(String number) {
        this.trainNr.setText(number);
    }

    public void addSearchListener(ActionListener a){
        searchTrainButton.addActionListener(a);
    }

    public void addCustomerListener(ActionListener a){
        customerButton.addActionListener(a);
    }

    public void addAdminListener(ActionListener a){
        adminButton.addActionListener(a);
    }

    public boolean customerPushed(ActionEvent e){
        if(e.getSource()==customerButton){
            return true;
        }
        else return false;
    }

    public boolean adminPushed(ActionEvent e){
        if(e.getSource()==adminButton){
            return true;
        }
        else return false;
    }

    public boolean searchPushed(ActionEvent e){
        if(e.getSource()==searchTrainButton)
        {
            return true;
        }
        else return false;
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
