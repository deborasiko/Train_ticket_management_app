package mvc.controllers;

import mvc.views.*;
import mvc.models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import static java.lang.Integer.parseInt;

public class CustomerController {
    private CustomerWindow myCustomer;

    public CustomerController(CustomerWindow customer) {
        this.myCustomer = customer;
        this.myCustomer.addCCListener(new CreateListener());
        this.myCustomer.addLCListener(new CreateListener());
        this.myCustomer.addRCListener(new CreateListener());

    }

    class CreateListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (myCustomer.rcPushed(e)==true) {
                try {
                    RegisterWindow registration1 = new RegisterWindow();
                    RegistrationController regCtrl = new RegistrationController(registration1);
                } catch (Exception exc) {
                    System.out.println("nope");
                }
            }
            if(myCustomer.ccPushed(e)==true){
                myCustomer.dispose();
            }
            if(myCustomer.lcPushed(e)){
                try{
                    String username = myCustomer.getUserNameCustomer();
                    String password = myCustomer.getPassWordCustomer();
                    Connection1 customerConnect = new Connection1();
                    ResultSet result = customerConnect.userInfoQuery(username,password);
                    if(result.next()){
                        String customerIdText = result.getString("customerid");
                        int customerid = parseInt(customerIdText);
                        CustomerOptionWindow ticket1 = new CustomerOptionWindow();
                        CustomerOptionController ticket2 = new CustomerOptionController(ticket1, customerid);
                    }
                    else{
                        myCustomer.showMessage("incorrect username or password");
                    }
                }catch(Exception exception){
                    myCustomer.showMessage(exception.toString());

                }
            }
        }
    }
}
