

import javax.swing.*;
import java.awt.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {

    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;

    MyFrame() throws IOException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Java Digital Clock Program by Alex Shea");
        this.setLayout(new FlowLayout());
        this.setSize(350, 200);
        this.setResizable(false);


        timeFormat = new SimpleDateFormat("hh:mm:ss a"); //Hours, Minutes, seconds AM/PM format.
        dayFormat = new SimpleDateFormat("EEEE"); //day of the week.
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy"); //month day, year.


        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
        timeLabel.setForeground(new Color(0x00CCFF));
        timeLabel.setBackground(Color.darkGray);
        timeLabel.setOpaque(true);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free", Font.PLAIN,25));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Ink Free", Font.PLAIN,25));


        this.add(timeLabel);
        this.setVisible(true);
        this.add(dayLabel);
        this.add(dateLabel);

        setTime();
    }
    //Time function
    public void setTime() {
        while (true) { //continue until program is closed.
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);
            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);
            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);
            try {
                //time will update every 1 second by using a thread to sleep for every 1000 milliseconds
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}

