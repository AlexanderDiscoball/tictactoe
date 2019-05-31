
import javax.swing.*;
import java.awt.*;

public class Kostil extends JFrame  {
    MainField mn;
    public Kostil(){
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void paint(Graphics g){
        super.paint(g);
        String h = mn.getStr();
        g.setFont(new Font("Arial", Font.PLAIN, 80));
        g.drawString(h,150,300);
    }




}

