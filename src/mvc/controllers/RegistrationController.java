package mvc.controllers;

import mvc.views.*;
import mvc.models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class RegistrationController {
    private RegisterWindow myRegistration;
    public RegistrationController(RegisterWindow registration){
        this.myRegistration = registration;
        this.myRegistration.addRegisterListener(new CreateListener());
        this.myRegistration.addBackListener(new CreateListener());
    }
    class CreateListener implements ActionListener{

        public void actionPerformed(ActionEvent e){
            if(myRegistration.backPushed(e)){
                myRegistration.dispose();
            }
            if(myRegistration.regPushed(e)){
                try{
                    String customerid = myRegistration.getID();
                    int id = parseInt(customerid);
                    String email = myRegistration.getEmail();
                    String username = myRegistration.getUser();
                    String password = myRegistration.getPass();
                    String repeated = myRegistration.getRepeated();
                    if(password.equals(repeated)){
                        try {
                            Connection1 regCntrl = new Connection1();
                            regCntrl.insertUserQuery(email,username,password,id);
                            myRegistration.showMessage("Done!");
                        }catch(Exception exception){
                            myRegistration.showMessage("registration failed / id taken");
                        }

                    }
                    else{
                        myRegistration.showMessage("passwords not match");
                    }

                }catch(Exception exc){
                    System.out.println("something went wrong");
                }
            }

        }
    }
}
