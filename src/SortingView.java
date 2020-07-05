import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Projet: SortingAlgorithmInterface
 * Class: SortigView
 * Description: This view will receive the data state change from SortingMpdel and
 *              it updates the view according to the state change.
 * Author: Jiemei Lei
 * Date:
 */

public class SortingView extends JPanel {
    private ArrayList<Integer> sortingArray  ;
    private static final int BAR_WIDTH =10;
    private Color color;
    private HashMap<Integer,Color> bars = new HashMap<>();
    private JFrame frame;
    private static final int WIN_WIDTH =1500;
    private static final int WIN_HEIGHT =700;

    public SortingView(ArrayList<Integer> sortedArray){
        sortingArray=sortedArray;
        setBackground(Color.BLACK);

        //set up the frame
        frame = new JFrame();
        frame.setTitle("Visualization of Sorting Algorithm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIN_WIDTH,WIN_HEIGHT);
        frame.setVisible(true);
        frame.getContentPane().add(this);
    }

    public void renew(){
        repaint();
    }

    public void setBars(Color color, int value){
        bars.put(value,color);
    }

    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        super.paintComponent(graphics);

        try {
            int max = 0; // determine longest bar
            for (int value : sortingArray) {
                max = Math.max(max, value);
            }
            for (int i = 0; i < sortingArray.size(); i++) {
                int value = sortingArray.get(i); //the value for each bar
                int height = ((getHeight() - 30) * value / max);
                color = bars.get(value);
                graphics.setColor(color);
                graphics.fillRect(i * (BAR_WIDTH + 2), getHeight() - height, BAR_WIDTH, height);
            }
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, "There is no sorted array.");
        }

    }

}


