/**
 * Projet: SortingAlgorithm
 * Class: UserInterface
 * Description: The View presents the model’s data to the user. The view knows how to access
 *            the model’s data, but it does not know what this data means or what the user
 *            can do to manipulate it.
 * Author: Jiemei Lei
 * Date:
 */

import javax.swing.*;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame{

     // The components in the JFrame
    private JLabel inputLabel = new JLabel("Please enter the numbers you want sorted with maximum 10 numbers : ");
    private JLabel outputLabel = new JLabel("The input numbers: ");
    private JLabel algorithmLabel = new JLabel("Select  a sorting algorithm in the follow option: ");
    private JTextField inputNumbers = new JTextField(10);
    private JButton submit = new JButton("submit");
    private JButton bubble = new JButton("Bubble Sort");
    private JButton selection = new JButton("Selection Sort");
    private JButton insertion = new JButton("Insertion Sort");
    private JButton shell = new JButton("Shell Sort");
    private JButton merge = new JButton("Merge Sort");
    private JButton quick = new JButton("Quick Sort");
    private JButton heap = new JButton("Heap Sort");
    private JButton counting = new JButton("Counting Sort");
    private JButton bucket = new JButton("Bucket Sort");
    private JButton radix = new JButton("Radix Sort");

    /**
     * constructor
     */
    UserInterface(){
        //
        JPanel panel = new JPanel();

        //set up the frame
        this.setTitle("Visualization of Sorting Algorithm");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
       // this.setUndecorated(true);

        //put the components on the panel
        panel.add(inputLabel);
        panel.add(inputNumbers);
        panel.add(submit);
        panel.add(outputLabel);
        panel.add(algorithmLabel);
        panel.add(bubble);
        panel.add(selection);
        panel.add(insertion);
        panel.add(shell);
        panel.add(merge);
        panel.add(quick);
        panel.add(heap);
        panel.add(counting);
        panel.add(bucket);
        panel.add(radix);

        this.add(panel); //put the panel on the JFrame
    }

    /**
     * @return the input number
     */
    public int getInput(){
        return Integer.parseInt(inputNumbers.getText());
    }

    /**
     * Set the
     * @param text
     */
    public void setInputNumbers(String text){
        inputNumbers.setText(text);
    }

    /**
     * Display the numbers that user enter
     * @param number the entered integer
     */
    public void setOutput(int number){
        outputLabel.setText(outputLabel.getText()+ " "+ number);
    }

    /**
     * ActionListener for submit button
     * @param listenForSubmit
     */
    void submitListener(ActionListener listenForSubmit){
        submit.addActionListener(listenForSubmit);
    }

    /**
     * ActionListener for bubble sorting
     * @param listenForBubble
     */
    void bubbleListener(ActionListener listenForBubble){
        bubble.addActionListener(listenForBubble);
    }

    /**
     * ActionListener for selection sorting
     * @param listenForSelection
     */
    void selectionListener(ActionListener listenForSelection){
        selection.addActionListener(listenForSelection);
    }

    /**
     * ActionListener for insertion sorting
     * @param listenForInsertion
     */
    void insertioneListener(ActionListener listenForInsertion){
        insertion.addActionListener(listenForInsertion);
    }

    /**
     * ActionListener for shell sorting
     * @param listenForShell
     */
    void shellListener(ActionListener listenForShell){
        shell.addActionListener(listenForShell);
    }

    /**
     * ActionListener for merge sorting
     * @param listenForMerge
     */
    void mergeListener(ActionListener listenForMerge){
        merge.addActionListener(listenForMerge);
    }

    /**
     * ActionListener for quick sorting
     * @param listenForQuick
     */
    void quickListener(ActionListener listenForQuick){
        quick.addActionListener(listenForQuick);
    }

    /**
     * ActionListener for heap sorting
     * @param listenForHeap
     */
    void heapListener(ActionListener listenForHeap){
        heap.addActionListener(listenForHeap);
    }

    /**
     * ActionListener for counting sorting
     * @param listenForCounting
     */
    void countingListener(ActionListener listenForCounting){
        counting.addActionListener(listenForCounting);
    }

    /**
     * ActionListener for bucket sorting
     * @param listenForBucket
     */
    void bucketListener(ActionListener listenForBucket){
        bucket.addActionListener(listenForBucket);
    }

    /**
     * ActionListener for radix sorting
     * @param listenForRadix
     */
    void radixListener(ActionListener listenForRadix){
        radix.addActionListener(listenForRadix);
    }

    /**
     * Display the error message
     * @param error the context of the error
     */
    void displayErrorMessage(String error){
        JOptionPane.showMessageDialog(this,error);
    }
}
