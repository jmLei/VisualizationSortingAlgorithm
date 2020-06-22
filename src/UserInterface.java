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
import java.awt.*;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame{

    private static final int WIN_WIDTH =1500;
    private static final int WIN_HEIGHT =700;

    // The components in the JFrame
    private JLabel inputLabel = new JLabel("Please enter the numbers you want sorted: ");
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
        //create panels
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        //set up the frame
        this.setTitle("Sorting Algorithm");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIN_WIDTH,WIN_HEIGHT);


        // to set the box layout for each panel
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.X_AXIS));
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));


        //put the components on the panel
        panel1.add(inputLabel);
        panel1.add(inputNumbers);
        panel1.add(submit);
        panel2.add(outputLabel);
        panel2.add(algorithmLabel);
        panel2.add(bubble);
        panel2.add(selection);
        panel2.add(insertion);
        panel2.add(shell);
        panel2.add(merge);
        panel2.add(quick);
        panel2.add(heap);
        panel2.add(counting);
        panel2.add(bucket);
        panel2.add(radix);

        //put the panels on the JFrame
        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.CENTER);

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
