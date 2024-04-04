package mvc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerOptionWindow extends JFrame{

    private JTextField source;
    private JTextField destination;
    private JTextField date;
    private JTextField dtime;
    private JButton submitButtom;
    private JButton back;
    private JTextField nrTickets;

    public CustomerOptionWindow() {
        this.setBounds(100, 100, 643, 432);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        back = new JButton("Back");
        back.setBounds(30,30,100,25);
        back.setFont(new Font("del", Font.PLAIN, 16));
        this.getContentPane().add(back);

        JLabel nrticketsLabel = new JLabel("Nr. tickets:");
        nrticketsLabel.setFont(new Font("del", Font.PLAIN, 16));
        nrticketsLabel.setBounds(30,150,130,25);
        this.getContentPane().add(nrticketsLabel);

        nrTickets = new JTextField();
        nrTickets.setBounds(150,150,120,25);
        this.getContentPane().add(nrTickets);

        JLabel sourceLabel = new JLabel("Source:");
        sourceLabel.setFont(new Font("del", Font.PLAIN, 16));
        sourceLabel.setBounds(30,175,100, 25);
        this.getContentPane().add(sourceLabel);

        source = new JTextField();
        source.setBounds(150, 175, 120, 25);
        this.getContentPane().add(source);

        JLabel destLabel = new JLabel("Destination:");
        destLabel.setFont(new Font("del", Font.PLAIN, 16));
        destLabel.setBounds(30,200,100, 25);
        this.getContentPane().add(destLabel);

        destination = new JTextField();
        destination.setBounds(150,200, 120, 25);
        this.getContentPane().add(destination);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("del", Font.PLAIN, 16));
        dateLabel.setBounds(30,225,100,25);
        this.getContentPane().add(dateLabel);

        date = new JTextField();
        date.setBounds(150,225,120,25);
        this.getContentPane().add(date);

        JLabel dtimeLabel = new JLabel("Departure time:");
        dtimeLabel.setFont(new Font("del", Font.PLAIN, 16));
        dtimeLabel.setBounds(30,250, 120, 25);
        this.getContentPane().add(dtimeLabel);

        dtime = new JTextField();
        dtime.setBounds(150,250, 120, 25);
        this.getContentPane().add(dtime);

        submitButtom = new JButton("Submit reservation");
        submitButtom.setBounds(30,275,240,25);
        submitButtom.setFont(new Font("del", Font.PLAIN, 16));
        this.getContentPane().add(submitButtom);

        this.setVisible(true);
    }

    public void addSubmitListener(ActionListener a){submitButtom.addActionListener(a);}
    public boolean isSubmitted(ActionEvent e){
        if(e.getSource()==submitButtom) return true;
        else return false;
    }
    public void addBackListener(ActionListener a){back.addActionListener(a);}
    public boolean backPushed(ActionEvent e){
        if(e.getSource()==back) return true;
        else return false;
    }

    public String getSource(){
        return this.source.getText();
    }
    public String getDest(){
        return this.destination.getText();
    }
    public String getDate(){
        return this.date.getText();
    }
    public String getDTime(){
        return this.dtime.getText();
    }
    public String getNrTicket(){return this.nrTickets.getText();}

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
