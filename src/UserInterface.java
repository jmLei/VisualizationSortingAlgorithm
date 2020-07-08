/**
 * Projet: SortingAlgorithmInterface
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

    private static final int WIN_WIDTH =1450;
    private static final int WIN_HEIGHT =700;

    // The components in the JFrame
    private JLabel inputLabel = new JLabel("Please enter the numbers you want sorted: ");
    private JLabel outputLabel = new JLabel("The input numbers: ");
    private JLabel outputNumbers = new JLabel();
    private JLabel algorithmLabel = new JLabel("Select  a sorting algorithm in the follow option: ");
    private JTextField inputNumbers = new JTextField();
    private JButton submit = new JButton("submit");
    private JButton clear = new JButton("clear");
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
        JPanel inputPanel = new JPanel();
        JPanel outputPanel = new JPanel(new GridLayout(4,1));
        JPanel buttonPanel = new JPanel(new GridLayout(2,5));

        //set up the frame
        this.setTitle("Sorting Algorithm");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIN_WIDTH,WIN_HEIGHT);


        // to set the box layout for input panel
        inputPanel.setLayout(new BoxLayout(inputPanel,BoxLayout.X_AXIS));
        //outputPanel.setLayout(new BoxLayout(outputPanel,BoxLayout.Y_AXIS));


        //Define components
        inputPanel.setPreferredSize(new Dimension(1400,30));
        outputPanel.setPreferredSize(new Dimension(1400,150));
        buttonPanel.setPreferredSize(new Dimension(1400,500));
        //clear.setPreferredSize(new Dimension(50,20));
        inputLabel.setFont(new Font("Dialog",Font.BOLD,15));
        outputLabel.setFont(new Font("Dialog",Font.BOLD,15));
        inputNumbers.setFont(new Font("Serif",Font.BOLD,15));
        outputNumbers.setFont(new Font("Serif",Font.BOLD,15));
        algorithmLabel.setFont(new Font("Dialog",Font.BOLD,15));


        //put the components on the panel
        inputPanel.add(inputLabel);
        inputPanel.add(inputNumbers);
        inputPanel.add(submit);
        outputPanel.add(outputLabel);
        outputPanel.add(outputNumbers);
        outputPanel.add(clear);
        outputPanel.add(algorithmLabel);
        buttonPanel.add(bubble);
        buttonPanel.add(selection);
        buttonPanel.add(insertion);
        buttonPanel.add(shell);
        buttonPanel.add(merge);
        buttonPanel.add(quick);
        buttonPanel.add(heap);
        buttonPanel.add(counting);
        buttonPanel.add(bucket);
        buttonPanel.add(radix);

        //put the panels on the JFrame
        this.add(inputPanel,BorderLayout.NORTH);
        this.add(outputPanel,BorderLayout.CENTER);
        this.add(buttonPanel,BorderLayout.SOUTH);

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
        outputNumbers.setText(outputNumbers.getText()+ " "+ number);
    }

    public void clearOutput(){
        outputNumbers.setText("");
    }

    /**
     * ActionListener for submit button
     * @param listenForSubmit
     */
    void submitListener(ActionListener listenForSubmit){
        submit.addActionListener(listenForSubmit);
    }

    /**
     * ActionListener for clear button
     * @param listenForClear
     */
    void clearListener(ActionListener listenForClear){
        clear.addActionListener(listenForClear);
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
