package mvc.controllers;

import mvc.views.*;
import mvc.models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.*;

import static java.lang.Integer.parseInt;

public class CustomerOptionController {
    CustomerOptionWindow myOptions;
    int myCid;
    public CustomerOptionController(CustomerOptionWindow option, int cid){
        this.myOptions = option;
        this.myCid = cid;
        this.myOptions.addBackListener(new CreateListener());
        this.myOptions.addSubmitListener(new CreateListener());

    }
    class CreateListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(myOptions.backPushed(e)){
                myOptions.dispose();
            }
            if(myOptions.isSubmitted(e)){
                try{
                    String nrTicketText = myOptions.getNrTicket();
                    int nrTicket = parseInt(nrTicketText);
                    String source = myOptions.getSource();
                    String destination = myOptions.getDest();
                    String dateText = myOptions.getDate();
                    String dtimeText = myOptions.getDTime();
                    Connection1 optionCtrl = new Connection1();
                    int rideid=0;
                    try {
                        rideid = optionCtrl.retRideId(source, destination, LocalDate.parse(dateText), LocalTime.parse(dtimeText));
                    }catch(Exception newExc){
                        myOptions.showMessage(newExc.toString());
                    }
                    int maxiTicket=0;
                    try {
                        maxiTicket = optionCtrl.retMaxTicket();
                    }catch(Exception maxiExc){
                        myOptions.showMessage("not good");
                    }
                    optionCtrl.insertTicket(myCid,rideid,maxiTicket+1,nrTicket);
                    myOptions.showMessage("Successful reservation!");
                }catch(Exception exc){
                    myOptions.showMessage(exc.toString());
                }
            }

        }
    }
}
