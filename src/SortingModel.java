import java.awt.*;
import java.util.ArrayList;
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
    private static final long sleepTime = 500;

    public void clearArray(){
        sortingArray.clear();
    }
    public void bubbleSort(ArrayList<Integer> inputArray){
        System.out.println("Bubble array "+ sortingArray);
        sortingArray = inputArray;
        int size = sortingArray.size();
        theView = new SortingView(sortingArray);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //initialized bars
                for(int value : sortingArray){
                    theView.setBars(Color.white,value);
                }

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
            }
        };
        new Thread(runnable).start();
        System.out.println("After Bubble array "+ sortingArray);
    }

    public void selectionSort(ArrayList<Integer> inputArray){
        System.out.println("selection array "+ sortingArray);
        sortingArray = inputArray;
        int size = sortingArray.size();
        theView = new SortingView(sortingArray);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int temp, minIndex, tempIndex;

                //initialized bars
                for(int value : sortingArray){
                    theView.setBars(Color.white,value);
                }

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
            }
        };
        new Thread(runnable).start();
    }

    public void insertionSort(ArrayList<Integer> inputArray) {
        //inputArray = inputArray;
        int size = inputArray.size();
        theView = new SortingView(inputArray);

        Runnable runnable = new Runnable(){

            @Override
            public void run() {
                //initialized bars
                for(int value : inputArray){
                    theView.setBars(Color.white,value);
                }

                //selection sort
                for (int i = 0; i< size-1; i++){

                }

            }
        };
        new Thread(runnable).start();
    }
}
