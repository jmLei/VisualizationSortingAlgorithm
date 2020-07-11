import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Projet: SortingAlgorithmInterface
 * Class: Controller
 * Description: The Controller exists between the view and the model. It listens to events triggered
 *            by the view and executes the appropriate reaction to these events.
 * Author: Jiemei Lei
 * Date:
 */

public class Controller {
    private UserInterface theUI;
    private  SortingModel theModel;
    private ArrayList<Integer> inputArray = new ArrayList<Integer>();

    /**
     * Constructor
     * @param theUI
     * @param theModel
     */
    public Controller(UserInterface theUI, SortingModel theModel){
        this.theUI = theUI;
        this.theModel = theModel;

        this.theUI.submitListener(new SubmitListener());
        this.theUI.clearListener(new ClearListener());
        this.theUI.bubbleListener(new BubbleListener());
        this.theUI.selectionListener(new SelectionListener());
        this.theUI.insertioneListener(new InsertionListener());
    }

    /**
     * After click submit button, the entered number will be shown
     */
    class SubmitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int input;
            try{
                input = theUI.getInput();
                inputArray.add(input);// put each input number into an array
                theUI.setInputNumbers("");//clear textfield after entering a value
                theUI.setOutput(input); //display the numbers in output textfield
            }
            catch (NumberFormatException ex){ //if what the user enter is not integer
                theUI.displayErrorMessage("You need to enter Integers");
            }
            theModel.setSortingArray(inputArray);
        }
    }

    class ClearListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            theUI.clearOutput();
            theModel.clearArray();
        }
    }
    /**
     * After click bubble button, the bubble sorting of thr number will be shown
     */
    class BubbleListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Controller Bubble array "+ inputArray);
            theModel.bubbleSort();
            System.out.println("After Controller Bubble array "+ inputArray);
        }
    }

    class SelectionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Controller selection array "+ inputArray);
            theModel.selectionSort();

        }
    }

    class InsertionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            theModel.insertionSort();
        }
    }
}
