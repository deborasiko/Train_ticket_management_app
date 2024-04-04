package mvc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWindowFunctionalities extends JFrame{

    private JTextField toDeleteNR;
    private JButton deleteButton;

    private JTextField rideNr;
    private JTextField trainNr;
    private JTextField source;
    private JTextField destination;
    private JTextField myDate;
    private JTextField dtime;
    private JTextField atime;
    private JButton submitButton;

    private JTextField updateTrainNr;
    private JTextField myAtime;
    private JButton updateButton;

    private JButton closeButton;

    public AWindowFunctionalities(){
        this.setBounds(100, 50, 700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel deleteLabel = new JLabel("Delete:");
        deleteLabel.setFont(new Font("del", Font.PLAIN, 18));
        deleteLabel.setBounds(30, 30, 130, 30);
        this.getContentPane().add(deleteLabel);

        toDeleteNR = new JTextField();
        toDeleteNR.setBounds(30, 55, 100, 25);
        this.getContentPane().add(toDeleteNR);


        deleteButton = new JButton("Delete");
        deleteButton.setBounds(140, 55, 80, 25);
        this.getContentPane().add(deleteButton);

        JLabel insert = new JLabel("Add new train:");
        insert.setFont(new Font("del", Font.PLAIN, 18));
        insert.setBounds(30, 90, 130, 30);
        this.getContentPane().add(insert);

        JLabel rideNrLabel = new JLabel("Ride Nr.:");
        rideNrLabel.setFont(new Font("del", Font.PLAIN, 16));
        rideNrLabel.setBounds(30, 125, 100, 25);
        this.getContentPane().add(rideNrLabel);

        rideNr = new JTextField();
        rideNr.setBounds(150, 125, 120, 25);
        this.getContentPane().add(rideNr);

        JLabel trainNrLabel = new JLabel("Train Nr.:");
        trainNrLabel.setFont(new Font("del", Font.PLAIN, 16));
        trainNrLabel.setBounds(30, 150, 100, 25);
        this.getContentPane().add(trainNrLabel);

        trainNr = new JTextField();
        trainNr.setBounds(150, 150, 120, 25);
        this.getContentPane().add(trainNr);

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

        myDate = new JTextField("YYYY-MM-DD");
        myDate.setBounds(150,225,120,25);
        this.getContentPane().add(myDate);

        JLabel dtimeLabel = new JLabel("Departure time:");
        dtimeLabel.setFont(new Font("del", Font.PLAIN, 16));
        dtimeLabel.setBounds(30,250, 120, 25);
        this.getContentPane().add(dtimeLabel);

        dtime = new JTextField();
        dtime.setBounds(150,250, 120, 25);
        this.getContentPane().add(dtime);

        JLabel atimeLabel = new JLabel("Arrival time:");
        atimeLabel.setFont(new Font("del", Font.PLAIN, 16));
        atimeLabel.setBounds(30, 275, 120, 25);
        this.getContentPane().add(atimeLabel);

        atime = new JTextField();
        atime.setBounds(150, 275,120, 25);
        this.getContentPane().add(atime);

        submitButton = new JButton("Submit");
        submitButton.setBounds(280, 275, 100, 25);
        this.getContentPane().add(submitButton);

        JLabel updateLabel = new JLabel("Update arrival time:");
        updateLabel.setFont(new Font("del", Font.PLAIN, 18));
        updateLabel.setBounds(30, 320, 200, 25);
        this.getContentPane().add(updateLabel);

        JLabel updateTrainNrLabel = new JLabel("Train Nr.:");
        updateTrainNrLabel.setFont(new Font("del", Font.PLAIN, 16));
        updateTrainNrLabel.setBounds(30,350, 120, 25);
        this.getContentPane().add(updateTrainNrLabel);

        updateTrainNr = new JTextField();
        updateTrainNr.setBounds(150,350, 120, 25);
        this.getContentPane().add(updateTrainNr);

        JLabel newAtimeLabel = new JLabel("New arrival time:");
        newAtimeLabel.setFont(new Font("del", Font.PLAIN, 16));
        newAtimeLabel.setBounds(30, 375, 120,25);
        this.getContentPane().add(newAtimeLabel);

        myAtime = new JTextField();
        myAtime.setBounds(150,375, 120,25);
        this.getContentPane().add(myAtime);

        updateButton = new JButton("Update");
        updateButton.setBounds(30, 410, 120, 25);
        this.getContentPane().add(updateButton);

        closeButton = new JButton("Back");
        closeButton.setBounds(30, 440, 80, 25);
        this.getContentPane().add(closeButton);

        this.setVisible(true);

    }
    public void addCloseListener(ActionListener a){
        closeButton.addActionListener(a);
    }
    public boolean closeWindow(ActionEvent e){
        if(e.getSource()==closeButton) {
            return true;
        }
        else return false;
    }

    public void addDeleteListener(ActionListener a){
        deleteButton.addActionListener(a);
    }
    public boolean deletePushed(ActionEvent e){
        if(e.getSource()==deleteButton){
            return true;
        }
        else return false;
    }

    public String getDeleteNr(){
        return toDeleteNR.getText();
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    public void addSubmitListener(ActionListener a){submitButton.addActionListener(a);}

    public boolean submitPushed(ActionEvent e){
        if(e.getSource()==submitButton){
            return true;
        }
        else return false;
    }

    public String getRideNr(){
        return rideNr.getText();
    }
    public String getTrainNr(){
        return trainNr.getText();
    }
    public String getSource(){
        return source.getText();
    }
    public String getDest(){
        return destination.getText();
    }
    public String getDate(){
        return myDate.getText();
    }
    public String getDTime(){
        return dtime.getText();
    }
    public String getATime(){
        return atime.getText();
    }

    public String getUpdateTrainNr(){
        return updateTrainNr.getText();
    }
    public String getMyAtime(){
        return myAtime.getText();
    }
    public void addUpdateListener(ActionListener a){
        updateButton.addActionListener(a);
    }
    public boolean updatePushed(ActionEvent e){
        if(e.getSource()==updateButton)
            return true;
        else return false;
    }

}
