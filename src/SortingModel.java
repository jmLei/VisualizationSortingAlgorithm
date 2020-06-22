import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Projet: SortingAlgorithm
 * Class: SortigModel
 * Description: The Model contains only the pure application data,
 *              it contains no logic describing how to present the data to a user.
 *              It will notify the state change to the SortingView.
 * Author: Jiemei Lei
 * Date:
 */

public class SortingModel extends JFrame implements SortingModelInterface {
    private ArrayList<ArrayObserver> ArrayObservers;
    private ArrayList<Integer> sortingArray;
    private static final long sleepTime = 1000;
    private SortingView theView ;
    private static final int WIN_WIDTH =1500;
    private static final int WIN_HEIGHT =700;

    public SortingModel(){
        //set up the frame
        this.setTitle("Visualization of Sorting Algorithm");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIN_WIDTH,WIN_HEIGHT);
        ArrayObservers = new ArrayList<ArrayObserver>();
    }

    @Override
    public void registerObserver(ArrayObserver newObserver) {
        ArrayObservers.add(newObserver);
        System.out.println("Create observer.");
    }

    @Override
    public void removeObserver(ArrayObserver deleteObserver) {
        int index = ArrayObservers.indexOf(deleteObserver);
        ArrayObservers.remove(index);
        System.out.println("Delete observer.");
    }

    @Override
    public void notifyObserver() {
        for(ArrayObserver observer: ArrayObservers){
            observer.update(sortingArray);
        }
    }

    public void bubbleSort(ArrayList<Integer> inputArray){
        this.setVisible(true);
        sortingArray = inputArray;
        theView = new SortingView(sortingArray);
        this.add(theView);
        theView.repaint();

        //Check the adjacent numbers, if the second number is greater than the first number,
        //then exchange their position. Repeat until the sorting end
        for (int i = 0; i< sortingArray.size()-1; i++)
            for (int j = 0; j < sortingArray.size() - 1 - i; j++) {
                if (sortingArray.get(j) > sortingArray.get(j + 1)) {
                    Collections.swap(sortingArray, j, j + 1);
                }
                System.out.println("The array in model" + " is: " + sortingArray);
                theView.setSortingArray(sortingArray);
                theView.repaint();
                setSleepTime(sleepTime);
                //setSortingArray(sortingArray);

            }
    }


    public void setSortingArray(ArrayList<Integer> sortingArray){
       this.sortingArray = sortingArray;
       notifyObserver();
    }

    public void setSleepTime(long sleepTime){
        final long startTime = System.currentTimeMillis();
        long endTime, timeTaken;
        do{
            endTime = System.currentTimeMillis();
            timeTaken = endTime-startTime;
        }while(timeTaken<sleepTime);
    }
}
