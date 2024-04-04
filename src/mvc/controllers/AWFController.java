package mvc.controllers;

import mvc.views.*;
import mvc.models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;

import static java.lang.Integer.parseInt;

public class AWFController {
    private AWindowFunctionalities myAWF;

    public AWFController(AWindowFunctionalities awf){
        this.myAWF = awf;
        this.myAWF.addCloseListener(new CreateListener());
        this.myAWF.addDeleteListener(new CreateListener());
        this.myAWF.addSubmitListener(new CreateListener());
        this.myAWF.addUpdateListener(new CreateListener());

    }
    class CreateListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(myAWF.closeWindow(e)){
                myAWF.dispose();
            }
            if(myAWF.deletePushed(e)){
                try{
                    Connection1 deleteCon = new Connection1();
                    String text = myAWF.getDeleteNr();
                    int number = parseInt(text);
                    deleteCon.deleteQuery(number);
                }catch(Exception exc){
                    myAWF.showMessage(exc.toString());
                    myAWF.showMessage("something went wrong:((");
                }
            }
            if(myAWF.submitPushed(e)){
                try{
                    String ride = myAWF.getRideNr();
                    int rnr = parseInt(ride);
                    String train = myAWF.getTrainNr();
                    int tnr = parseInt(train);
                    String source = myAWF.getSource();
                    String dest = myAWF.getDest();
                    String date = myAWF.getDate();
                    String dtime = myAWF.getDTime();
                    String atime = myAWF.getATime();
                    Connection1 insertCon = new Connection1();
                    insertCon.insertQuery(rnr,tnr,source,dest,LocalDate.parse(date), LocalTime.parse(dtime), LocalTime.parse(atime));

                }catch(Exception exc){
                    myAWF.showMessage(exc.toString());
                }
            }
            if(myAWF.updatePushed(e)){
                try{
                    String trainText = myAWF.getUpdateTrainNr();
                    int train = parseInt(trainText);
                    String newAtime = myAWF.getMyAtime();
                    Connection1 updateCon = new Connection1();
                    updateCon.updateQuery(train,LocalTime.parse(newAtime));

                }catch(Exception exc){
                    myAWF.showMessage(exc.toString());
                }
            }
        }
    }
}
