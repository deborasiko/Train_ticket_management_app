package mvc.controllers;

import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.*;

import static java.lang.Integer.parseInt;

public class Connection1 {
    String url = "jdbc:postgresql://localhost:5432/traininfo";
    String user = "postgres";
    String password = "12345678";
    Connection connection = DriverManager.getConnection(url,user,password);
    Statement statement = connection.createStatement();

    String tableTrain = "\"trains\"";
    String tableCustomer = "\"customer\"";
    String tableTicket = "\"tickets_reserved\"";

    public Connection1() throws SQLException {
    }

    public void infoQuery(int nr) throws SQLException {
        String q = "Select * from trains where trainnr ='" +nr+ "'";
        ResultSet result = this.statement.executeQuery(q);
        result.next();
        String line = result.getString("source") + " " + result.getString("destination") + " " + result.getString("date");
        System.out.println(line);
    }

    public String inforRet(int nr) throws SQLException{
        String q = "Select * from trains where trainnr ='" +nr+ "'";
        ResultSet result = this.statement.executeQuery(q);
        result.next();
        String line = result.getString("trainnr") + " " + result.getString("source") + " " + result.getString("destination") + " " + result.getString("date") + " " + result.getString("departure_time") + " " + result.getString("arrival_time");
        return line;
    }

    public void deleteQuery(int nr) throws SQLException{
        String deleteQuery = "delete from trains where trainnr ='"+nr+"'";
        this.statement.executeUpdate(deleteQuery);
        System.out.println("valami");
    }
    public void insertQuery(int ridenr, int trainnr, String source, String dest, LocalDate myDate, LocalTime dtime, LocalTime atime) throws SQLException{
        String insertTrainQuery = "insert into trains (rideid,trainnr, source, destination,date,departure_time,arrival_time) values ('" + ridenr + "','" + trainnr + "', '"+source+"', '"+dest+"', '"+myDate+"', '"+dtime+"', '"+atime+"')";
        this.statement.executeUpdate(insertTrainQuery);
    }
    public void updateQuery(int trainnr, LocalTime newAtime) throws SQLException{
        String updateQuery = "update trains set arrival_time='" + newAtime + "' where trainnr= '" +trainnr+ "'";
        this.statement.executeUpdate(updateQuery);
    }

    public void insertUserQuery(String email, String username, String password, int customerid)throws SQLException{
        String userQuery = "insert into customer(customerid, customername, email_address, password) values ('" + customerid + "' , '" + username + "','" + email + "','" + password + "')";
        this.statement.executeUpdate(userQuery);
    }

    public ResultSet userInfoQuery(String user, String password) throws SQLException{ //kerdeses
        String userInfoQuery = "select * from customer where customername = '" + user + "' and password='" + password + "'" ;
        //this.statement.executeQuery(userInfoQuery);
        ResultSet result = this.statement.executeQuery(userInfoQuery);
        return result;
    }

    public void insertTicket(int cid, int rideid, int ticketid, int nr)throws SQLException{
        String q = "insert into tickets_reserved(cid,rideid,ticketid,nrtickets) values('" + cid + "','" + rideid + "','" + ticketid + "','" + nr + "')";
        this.statement.executeUpdate(q);
    }

    public int retMaxTicket()throws SQLException{
        String q = "select MAX(ticketid) as maxi from tickets_reserved";
        ResultSet result = this.statement.executeQuery(q);
        result.next();
        int maxiTicket = result.getInt("maxi");
        return maxiTicket;
    }

    public int retRideId(String source, String dest, LocalDate date, LocalTime dtime)throws SQLException{
        String q = "select rideid from trains where source ='" + source + "' and destination='" + dest + "' and date='" + date + "' and departure_time='" + dtime + "'";
        ResultSet result = this.statement.executeQuery(q);
        result.next();
        String idText = result.getString("rideid");
        int id = parseInt(idText);
        return id;
    }
}
