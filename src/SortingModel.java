import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

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
    //private ArrayList<Integer> sortingArray;
    private ArrayList<Integer> inputArray;
    private SortingView theView;
    private static final long sleepTime = 1000;

    public void clearArray(){
        inputArray.clear();
    }

    public void setSortingArray(ArrayList<Integer> inputArray){
        this.inputArray = inputArray;
    }

    public void bubbleSort(){
        ArrayList<Integer> sortingArray;
        sortingArray = inputArray;
        System.out.println("Bubble array "+ inputArray);
        int size = sortingArray.size();
        theView = new SortingView(sortingArray);

        Runnable runnable = () -> {

            //Check the adjacent numbers, if the second number is greater than the first number,
            //then exchange their position. Repeat until the sorting end
            for (int i = 0; i< size-1; i++) {
                for (int j = 0; j < size - 1 - i; j++) {
                    theView.setBars(Color.RED,sortingArray.get(j));
                    theView.setBars(Color.GREEN,sortingArray.get(j+1));
                    theView.renew();
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    if (sortingArray.get(j) > sortingArray.get(j + 1)) {
                        Collections.swap(sortingArray, j, j + 1);
                        theView.setBars(Color.RED,sortingArray.get(j));
                        theView.setBars(Color.GREEN,sortingArray.get(j+1));
                        theView.renew();
                        try {
                            Thread.sleep(sleepTime);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    theView.setBars(Color.WHITE,sortingArray.get(j));
                    theView.setBars(Color.WHITE,sortingArray.get(j+1));
                }
                theView.setBars(Color.YELLOW,sortingArray.get( size - 1 - i));
            }
            theView.renew();
        };
        new Thread(runnable).start();
        System.out.println("After Bubble array "+ sortingArray);
    }

    public void selectionSort(){
        ArrayList<Integer> sortingArray;
        sortingArray = inputArray;
        System.out.println("Selection array "+ inputArray);
        int size = sortingArray.size();
        theView = new SortingView(sortingArray);

        Runnable runnable = () -> {
            int temp, minIndex, tempIndex;

            //selection sort
            for (int i = 0; i< size-1; i++) {
                minIndex =i;
                theView.setBars(Color.RED,sortingArray.get(i));
                theView.renew();
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                for (int j = i+1; j < size ; j++) {
                    theView.setBars(Color.GREEN,sortingArray.get(j));
                    theView.renew();
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    if (sortingArray.get(minIndex) > sortingArray.get(j)) {
                        tempIndex = minIndex;
                        minIndex = j;
                        theView.setBars(Color.WHITE,sortingArray.get(tempIndex));
                        theView.setBars(Color.RED,sortingArray.get(minIndex));
                        theView.renew();
                        try {
                            Thread.sleep(sleepTime);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }else{
                        theView.setBars(Color.WHITE,sortingArray.get(j));
                        theView.renew();
                        try {
                            Thread.sleep(sleepTime);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                temp = sortingArray.get(i);
                sortingArray.set(i,sortingArray.get(minIndex));
                sortingArray.set(minIndex,temp);
                theView.setBars(Color.YELLOW,sortingArray.get(i));
            }
            theView.renew();
        };
        new Thread(runnable).start();
        System.out.println("After Selection array "+ sortingArray);
    }

    public void insertionSort() {
        ArrayList<Integer> sortingArray;
        sortingArray = inputArray;
        int size = sortingArray.size();
        theView = new SortingView(sortingArray);

        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                int preIndex, current;

                //insertion sort
                for (int i = 1; i< size; i++){
                    preIndex =i-1;
                    current=sortingArray.get(i);
                    theView.setBars(Color.GREEN,sortingArray.get(preIndex));
                    theView.setBars(Color.RED,sortingArray.get(i));
                    theView.renew();
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    while(preIndex>=0 && sortingArray.get(preIndex)>current){
                        theView.setBars(Color.GREEN,sortingArray.get(preIndex));
                        theView.setBars(Color.RED,sortingArray.get(preIndex+1));
                        theView.renew();
                        try {
                            Thread.sleep(sleepTime);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }

                        Collections.swap(sortingArray, preIndex, preIndex + 1);
                        theView.setBars(Color.RED,sortingArray.get(preIndex));
                        theView.setBars(Color.YELLOW,sortingArray.get(preIndex+1));
                        theView.renew();
                        try {
                            Thread.sleep(sleepTime);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        preIndex--;
                        if(preIndex>=0){
                            theView.setBars(Color.GREEN,sortingArray.get(preIndex));
                        }
                        theView.renew();
                        try {
                            Thread.sleep(sleepTime);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    if(preIndex>=0){
                        theView.setBars(Color.YELLOW,sortingArray.get(preIndex));
                    }
                    sortingArray.set(preIndex+1,current);
                    theView.setBars(Color.YELLOW,sortingArray.get(preIndex+1));
                    theView.renew();
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }

            }
        };
        new Thread(runnable).start();
    }
}
