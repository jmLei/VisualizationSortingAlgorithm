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

public class SortingView extends JFrame implements ArrayObserver {
    private SortingModel theModel;
    private Controller theController;
    //private Map<Integer, Integer> bars= new LinkedHashMap<Color,Integer>();
    private ArrayList<Integer> sortingArray;
    private Color color;
    private int observerID;
    private static int observerIDTracker =0;

    public SortingView(SortingModel theModel, Controller theController){
        this.theModel= theModel;
        this.theController = theController;
        this.observerID = ++observerIDTracker;
        theModel.registerObserver(this);

    }

    @Override
    public void update(ArrayList<Integer> sortingArray) {
        this.sortingArray = sortingArray;
        printArray();
        createView();
    }

    public void printArray(){
        System.out.println("The array "+ observerID+ " is: "+ sortingArray);
    }

    public void createView(){
        JPanel panel = new PaintPane();

        //set up the frame
        this.setTitle("Visualization of Sorting Algorithm");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.add(panel);
        panel.repaint();
        this.setVisible(true);
    }

    protected class PaintPane extends JPanel{
        protected void paintComponent(Graphics g){
            Graphics2D graphics = (Graphics2D)g;
            super.paintComponent(graphics);

            System.out.println(" ");
            System.out.println("Paint ");

            try{
                int max =0; // determine longest bar
                for(int value: sortingArray){
                    max = Math.max(max,value);
                }
                System.out.println("the max is "+ max );

                int width = (getWidth()/sortingArray.size())-2;
                int x =1;
                for(int i =0; i<sortingArray.size();i++){
                    int value = sortingArray.get(i); //the value for each bar
                    int height = ((getHeight()-5) * value/max);
                    System.out.println("the size is "+ sortingArray.size()+", the value is "+value );
                    System.out.println("the width is "+ width+", the height is "+height );
                    g.setColor(color);
                    g.fillRect(x, getHeight() - height, width, height);
                    g.drawRect(x, getHeight() - height, width, height);
                    x += (width+2);
                }

            }
            catch(ArithmeticException ex){
                JOptionPane.showMessageDialog(this,"There is no sorted array.");
            }

        }

    }



}
