import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Projet: SortingAlgorithm
 * Class: SortigView
 * Description: This view will receive the data state change from SortingMpdel and
 *              it updates the view according to the state change.
 * Author: Jiemei Lei
 * Date:
 */

public class SortingView extends JPanel implements ArrayObserver {
    private SortingModel theModel;
    private Controller theController;
    private ArrayList<Integer> sortingArray  ;
    private int observerID;
    private static final long sleepTime = 1000;

    private static int observerIDTracker =0;

    private static final int BAR_WIDTH =10;


    public SortingView(ArrayList<Integer> sortingArray){
        /*this.theModel= theModel;
        this.theController = theController;
        this.observerID = ++observerIDTracker;*/
        //theModel.registerObserver(this);

        this.sortingArray=sortingArray;
        setBackground(Color.BLACK);
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
                g.setColor(Color.white);
                g.fillRect(i * (BAR_WIDTH + 2), getHeight() - height, BAR_WIDTH, height);
            }
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, "There is no sorted array.");
        }

    }


    public void setSortingArray(ArrayList<Integer> sortingArray){
        this.sortingArray = sortingArray;
        //repaint();
        System.out.println("The array view is: "+ this.sortingArray);
    }

    public ArrayList<Integer> getSortingArray(){
        return sortingArray;
    }


    @Override
    public void update(ArrayList<Integer> sortingArray) {
        this.sortingArray = sortingArray;
        System.out.println("The array "+  " is: "+ sortingArray);
        createView();



    }

    public void createView(){
        System.out.println(" ");
        System.out.println("The array view is: "+ sortingArray);
        //add the panel
        this.setVisible(true);
        System.out.println("1 ");
       // panel = new PaintPane(sortingArray);
        System.out.println("2 ");
        //this.add(panel);
        System.out.println("3 ");
        //panel.repaint();
        System.out.println("4 ");
        theController.setSleepTime(sleepTime);
    }


    }


