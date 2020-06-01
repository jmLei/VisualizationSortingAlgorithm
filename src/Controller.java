import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Projet: SortingAlgorithm
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
        this.theUI.bubbleListener(new BubbleListener());
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
        }
    }

    /**
     * After click bubble button, the bubble sorting of thr number will be shown
     */
    class BubbleListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           theModel.bubbleSort(inputArray);

        }
    }
}
