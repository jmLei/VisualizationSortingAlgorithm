/**
 * Projet: SortingAlgorithm
 * Class: VisualizationSorting
 * Description: This class contains the main method and run the program
 * Author: Jiemei Lei
 * Date:
 */
public class VisualizationSorting {
    public static void main(String[] args){
        SortingModel theModel = new SortingModel();
        UserInterface theUI = new UserInterface();
        Controller theController = new Controller(theUI,theModel);

        theUI.setVisible(true);
    }
}
