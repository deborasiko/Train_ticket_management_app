package mvc.views;

import javax.swing.*;
import java.awt.*;

public class TrainShow extends JFrame{
    private JLabel info;
    public TrainShow()
    {
        this.setBounds(10, 100, 643, 432);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        this.info = new JLabel();
        this.info.setFont(new Font("Label", Font.PLAIN, 20));
        this.info.setBounds(50, 100, 400, 50);
        this.getContentPane().add(info);

        this.setVisible(true);
    }

    public void setInfo(String trainInfo){
        this.info.setText(trainInfo);
    }
}
