
//5c. Develop a Swing program in Java to add the countries USA, India, Vietnam, Canada, Denmark, France, Great Britain, Japan,
// Africa, Greenland, Singapore into a JList and display the capital of the countries on console whenever the countries
// are selected on the list.



package Swings;




	import javax.swing.*;
	import javax.swing.event.*;
	import java.awt.*;
	import java.util.HashMap;

	public class lab5c {

	    JList<String> countryList;
	    JFrame frame;

	    lab5c() {

	        frame = new JFrame("Country List");
	        frame.setSize(300, 300);
	        frame.setLayout(new FlowLayout());
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Countries array
	        String countries[] = {
	            "USA", "India", "Vietnam", "Canada", "Denmark",
	            "France", "Great Britain", "Japan", "Africa",
	            "Greenland", "Singapore"
	        };

	        // Create JList
	        countryList = new JList<>(countries);
	        countryList.setVisibleRowCount(5);

	        // Scroll Pane
	        JScrollPane scrollPane = new JScrollPane(countryList);

	        // Map for country-capital
	        HashMap<String, String> capitals = new HashMap<>();
	        capitals.put("USA", "Washington, D.C.");
	        capitals.put("India", "New Delhi");
	        capitals.put("Vietnam", "Hanoi");
	        capitals.put("Canada", "Ottawa");
	        capitals.put("Denmark", "Copenhagen");
	        capitals.put("France", "Paris");
	        capitals.put("Great Britain", "London");
	        capitals.put("Japan", "Tokyo");
	        capitals.put("Africa", "No single capital (continent)");
	        capitals.put("Greenland", "Nuuk");
	        capitals.put("Singapore", "Singapore");

	        // Event Handling
	        countryList.addListSelectionListener(new ListSelectionListener() {
	            public void valueChanged(ListSelectionEvent e) {

	                if (!e.getValueIsAdjusting()) {
	                    String selectedCountry = countryList.getSelectedValue();

	                    System.out.println("Selected Country: " + selectedCountry);
	                    System.out.println("Capital: " + capitals.get(selectedCountry));
	                    System.out.println("------------------------");
	                }
	            }
	        });

	        frame.add(scrollPane);
	        frame.setVisible(true);
	    }

	    public static void main(String[] args) {
	        new lab5c();
	    }
	}

