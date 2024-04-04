package mvc.controllers;

import mvc.views.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class ViewController{
    private View myView;

    public ViewController(View view){

        this.myView = view;

        //this.myView.addCustomerListener(new CreateListener());
        this.myView.addCustomerListener(new CreateListener());
        this.myView.addAdminListener(new CreateListener());
        this.myView.addSearchListener(new CreateListener());
    }

    class CreateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(myView.customerPushed(e)){
                //myView.dispose();
                CustomerWindow customer1 = new CustomerWindow();
                CustomerController customControll = new CustomerController(customer1);
            }
            if(myView.adminPushed(e)){
                AdminWindow admin1 = new AdminWindow();
                AdminController adminCont = new AdminController(admin1);
            }
            if(myView.searchPushed(e)) {
                try {
                    String numberTrainS = myView.getTrainNR();
                    int nrTrain = parseInt(numberTrainS);
                    try {
                        Connection1 myQTrainNr = new Connection1();
                            myQTrainNr.infoQuery(nrTrain);
                            TrainShow trainShow1 = new TrainShow();
                            trainShow1.setInfo(myQTrainNr.inforRet(nrTrain));
                    } catch (Exception ex) {
                        System.out.println(ex);
                        myView.showMessage("The train was not found.");

                    }

                } catch (Exception exception) {
                    System.out.println(exception);
                    myView.showMessage("The input is not a number");
                }
            }
        }
    }

}