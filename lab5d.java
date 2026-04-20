//5d. Develop a Swing program in Java to create a Tabbed Pan of Cyan, Magenta and Yellow and display the concerned color 
//whenever the specific tab is selected in the Pan




package Swings;


	

	import javax.swing.*;
	import javax.swing.event.*;
	import java.awt.*;

	public class lab5d {

	    JFrame frame;
	    JTabbedPane tabbedPane;
	    JLabel label;

	    lab5d() {

	        frame = new JFrame("Tabbed Pane Example");
	        frame.setSize(400, 300);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Create Tabbed Pane
	        tabbedPane = new JTabbedPane();

	        // Panels for each tab
	        JPanel cyanPanel = new JPanel();
	        cyanPanel.setBackground(Color.CYAN);

	        JPanel magentaPanel = new JPanel();
	        magentaPanel.setBackground(Color.MAGENTA);

	        JPanel yellowPanel = new JPanel();
	        yellowPanel.setBackground(Color.YELLOW);

	        // Add tabs
	        tabbedPane.addTab("Cyan", cyanPanel);
	        tabbedPane.addTab("Magenta", magentaPanel);
	        tabbedPane.addTab("Yellow", yellowPanel);

	        // Label to display selected tab
	        label = new JLabel("Select a tab", JLabel.CENTER);

	        // Event handling
	        tabbedPane.addChangeListener(new ChangeListener() {
	            public void stateChanged(ChangeEvent e) {
	                int index = tabbedPane.getSelectedIndex();
	                String title = tabbedPane.getTitleAt(index);

	                label.setText(title + " color is selected");
	                System.out.println(title + " color is selected");
	            }
	        });

	        // Layout
	        frame.setLayout(new BorderLayout());
	        frame.add(tabbedPane, BorderLayout.CENTER);
	        frame.add(label, BorderLayout.SOUTH);

	        frame.setVisible(true);
	    }

	    public static void main(String[] args) {
	        new lab5d();
	    }
	}

