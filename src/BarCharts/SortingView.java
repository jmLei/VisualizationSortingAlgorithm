package BarCharts;

import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DatabaseMetaData;

/**
 * Projet: SortingAlgorithm
 * Class: SortigView
 * Description: This view will receive the data state change from SortingMpdel and
 *              it updates the view according to the state change.
 * Author: Jiemei Lei
 * Date:
 */

public class SortingView {

    private JPanel graphPanel;
    private JButton showGraph;

    public SortingView() {
        showGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
