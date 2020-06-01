import java.util.ArrayList;

/**
 * Projet: SortingAlgorithm
 * Class: SortigModel
 * Description: The Model contains only the pure application data,
 *              it contains no logic describing how to present the data to a user.
 * Author: Jiemei Lei
 * Date:
 */

public class SortingModel {
    private ArrayList<Integer> sortedArray;

    public void bubbleSort(ArrayList<Integer> inputArray){
        sortedArray = inputArray;
        int temp; //temporary number

        //Check the adjacent numbers, if the second number is greater than the first number,
        //then exchange their position. Repeat until the sorting end
        for (int i = 0; i< sortedArray.size()-1; i++){
            for(int j = 0; j<sortedArray.size()-1-i;j++)
                if(sortedArray.get(j)>sortedArray.get(j+1)){
                    temp = sortedArray.get(j+1);
                    sortedArray.set(j+1,sortedArray.get(j));
                    sortedArray.set(j,temp);
                }
        }
    }

    public ArrayList<Integer> getSortedArray(){
        return sortedArray;
    }
}
