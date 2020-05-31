import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            int inputArray[] = new int[10];

            try{
                for (int i = 0; i < inputArray.length;i++){
                    inputArray[i]=theUI.getInput(); // put each input number into an array
                    theUI.setInputNumbers("");//clear textfield after entering a value
                    theUI.setOutput(inputArray[i]); //display the numbers in output textfield
                    theUI.displayErrorMessage("Successful");
                }
            }
            catch (NumberFormatException ex){ //if what the user enter is not integer
                theUI.displayErrorMessage("You need to enter Integers");
            }
        }
    }

    class BubbleListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
