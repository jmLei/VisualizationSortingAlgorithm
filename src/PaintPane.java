import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PaintPane extends JPanel  {
    private ArrayList<Integer> sortingArray;
    private static final int BAR_WIDTH =10;
    private boolean sorted = false;

    public PaintPane(ArrayList<Integer> sortingArray) {
        setBackground(Color.BLACK);
        this.sortingArray = sortingArray;
        repaint();
        System.out.println("Drawing!!!!!");
        System.out.println("The drawing array is: " + this.sortingArray);

    }


    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        super.paintComponent(graphics);

        System.out.println(" ");
        System.out.println("Paint ");
        System.out.println("The paint array is: " + sortingArray);

        try {
            int max = 0; // determine longest bar
            for (int value : sortingArray) {
                max = Math.max(max, value);
            }
            for (int i = 0; i < sortingArray.size(); i++) {
                int value = sortingArray.get(i); //the value for each bar
                int height = ((getHeight() - 30) * value / max);
                graphics.setColor(Color.white);
                graphics.fillRect(i * (BAR_WIDTH + 2), getHeight() - height, BAR_WIDTH, height);
            }
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, "There is no sorted array.");
        }

    }


}
