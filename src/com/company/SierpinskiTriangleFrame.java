package com.company;

import java.awt.*;
import javax.swing.*;

public class SierpinskiTriangleFrame extends JFrame {

    private int n;

    private final SierpinskiTrianglePanel trianglePanel = new SierpinskiTrianglePanel(); // To display the pattern
    private final JLabel currOrder;

    public SierpinskiTriangleFrame() {

        JPanel panel = new JPanel();
        currOrder = new JLabel("Current order: " + n);
        panel.add(currOrder);

        JButton plus = new JButton("+");
        plus.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(plus);

        JButton minus = new JButton("-");
        minus.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(minus);

        add(trianglePanel);
        add(panel, BorderLayout.SOUTH);

        plus.addActionListener(e -> {
            trianglePanel.setOrder(++n);
            currOrder.setText("Current order: " + n);
        });
        minus.addActionListener(e -> {
            trianglePanel.setOrder(--n);
            currOrder.setText("Current order: " + n);
        });

    }

}