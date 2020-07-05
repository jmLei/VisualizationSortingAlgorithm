import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Projet: SortingAlgorithmInterface
 * Class: SortigModel
 * Description: The Model contains only the pure application data,
 *              it contains no logic describing how to present the data to a user.
 *              It will notify the state change to the SortingView.
 * Author: Jiemei Lei
 * Date:
 */

public class SortingModel  {
    private ArrayList<Integer> sortingArray;
    private SortingView theView;
    private static final long sleepTime = 2000;


    public void bubbleSort(ArrayList<Integer> inputArray){
        sortingArray = inputArray;
        theView = new SortingView(sortingArray);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int value : sortingArray){
                    theView.setBars(Color.white,value);
                }
                //Check the adjacent numbers, if the second number is greater than the first number,
                //then exchange their position. Repeat until the sorting end
                for (int i = 0; i< sortingArray.size()-1; i++) {
                    for (int j = 0; j < sortingArray.size() - 1 - i; j++) {
                        theView.setBars(Color.RED,sortingArray.get(j));
                        theView.setBars(Color.GRAY,sortingArray.get(j+1));
                        if (sortingArray.get(j) > sortingArray.get(j + 1)) {
                            Collections.swap(sortingArray, j, j + 1);
                        }
                        theView.renew();
                        try {
                            Thread.sleep(sleepTime);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        theView.setBars(Color.WHITE,sortingArray.get(j));
                        theView.setBars(Color.WHITE,sortingArray.get(j+1));
                    }
                }
                theView.renew();
            }
        };
        new Thread(runnable).start();
    }



}
