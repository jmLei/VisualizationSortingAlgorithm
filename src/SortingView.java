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
    private JPanel panel;
    private ArrayList<Integer> sortingArray  ;
    private int observerID;
    private static final long sleepTime = 1000;

    private static int observerIDTracker =0;

    private static final int BAR_WIDTH =10;
    private static final int WIN_WIDTH =1500;
    private static final int WIN_HEIGHT =700;


    public SortingView(ArrayList<Integer> sortingArray, SortingModel theModel){
        this.theModel= theModel;
        this.theController = theController;
        this.observerID = ++observerIDTracker;
        this.theModel.registerObserver(this);
        this.sortingArray=sortingArray;

        //set up the frame
        this.setTitle("Visualization of Sorting Algorithm");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIN_WIDTH,WIN_HEIGHT);
        createView();
        this.setVisible(true);
    }

    @Override
    public void update(ArrayList<Integer> sortingArray) {
        //this.sortingArray = sortingArray;
        System.out.println("3 ");
        createView();
    }

    public void createView(){
        System.out.println(" ");
        System.out.println("The array view is: "+ sortingArray);
        System.out.println("4 ");
        //add the panel
        panel = new PaintPane(sortingArray);
        this.add(panel);
        new Thread((Runnable) panel).start();
        //panel.repaint();

    }


    }


