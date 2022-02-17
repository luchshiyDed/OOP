import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.InputMismatchException;

import static java.awt.Color.BLUE;
import static java.awt.Color.RED;
public class Diag extends JFrame{
    private double y[];
    private static String col[] = {"BLUE", "RED", "GREEN","BLACK","YELLOW","ORANGE"};
    private ArrayList<String> names;
    public Diag (ArrayList<Long> arr,ArrayList<String> names) {
        super("TIME");
        if(arr.size()!=names.size()&&names.size()!=1){
            throw new InputMismatchException("Can't create this diagram");
        }
        this.names=names;
        y=new double[arr.size()];
        for(int i=0;i<arr.size();i++)
        {
            y[i]=arr.get(i)/10;
        }
        JPanel jcp = new JPanel(new BorderLayout());
        setContentPane(jcp);
        jcp.add(new Graph(), BorderLayout.CENTER);
        jcp.setBackground(Color.gray);
        setSize(100*y.length, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private class Graph extends JPanel {
        @Override
        protected void paintComponent(Graphics gh) {
            Graphics2D drp = (Graphics2D)gh;

            for (int i = -6; i < 9; i++) {
                drp.drawLine(50, 300 + 50 * i, 100*y.length-100, 300 + 50 * i);
                int vs = 800-i * 100;
                drp.drawString(vs + "", 30, 300 + 50 * i);
            }
            for(int i=0;i<names.size();i++)
            {
                try {
                    try {
                        drp.setColor((Color)(Class.forName("java.awt.Color").getField(Diag.col[i].toLowerCase()).get(null)));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                drp.fillRect(80, 20*i+30, 10, 10);
                drp.drawString(names.get(i),100,20*i+40);
            }

            for (int i = 0; i < y.length; i++) {
                Color color=RED;
                if(names.size()==1)
                    color = BLUE;
                else{
                try {
                    Field field = Class.forName("java.awt.Color").getField(Diag.col[i].toLowerCase());
                    color = (Color) field.get(null);
                } catch (Exception e) {
                }

            }
                drp.setColor(color);
                int realY =  (int)(700-5*y[i]);
                drp.fillRect(50 + 20 + 50 * i, realY, 20, (int)(y[i]*5.0));
                drp.drawString((i+1)+"",50 + 20 + 50 * i,realY-10);
            }

        }
    }
}
