import mvc.views.*;
import mvc.controllers.*;
//import mvc.models.*;
import javax.swing.*;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        View myView = new View();
       ViewController contr = new ViewController(myView);

        Connection1 myC = new Connection1();
        myC.infoQuery(1223);
        AWindowFunctionalities awindow = new AWindowFunctionalities();
        myC.updateQuery(1227,LocalTime.parse("10:15"));

        myC.insertQuery(4456,1226,"smth", "smwh", LocalDate.parse("2023-02-11"), LocalTime.of(6, 30), LocalTime.of(6, 40));
    }
}
