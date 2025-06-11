// Import necessary classes for event handling and GUI components
import java.awt.event.*;
import javax.swing.*;

// Main class containing the entry point of the program
public class Calculator {
    public static void main(String[] args) {
        // Create and show the calculator frame
        MyFrame calcFrame = new MyFrame();
    }
}

// Custom frame class that extends JFrame to create the calculator window
class MyFrame extends JFrame {
    // Declare text fields for input numbers and result display
    JTextField text1, text2, result;

    // Constructor for setting up the GUI
    public MyFrame() {
        setTitle("Simple Calculator");      // Set the title of the window
        setSize(500, 300);           // Set the size of the window
        setLayout(null);                  // Use null layout for manual component positioning

        // Initialize text fields
        text1 = new JTextField();
        text2 = new JTextField();
        result = new JTextField();

        // Set position and size for each text field
        text1.setBounds(90, 30, 300, 40);
        text2.setBounds(90, 80, 300, 40);
        result.setBounds(90, 130, 300, 40);
        result.setEditable(false);  // Make result field read-only

        // Create buttons for arithmetic operations
        JButton addButton, subButton, mulButton, divButton;
        addButton = new JButton("Add");
        subButton = new JButton("Sub");
        mulButton = new JButton("Mul");
        divButton = new JButton("Div");

        // Set position and size for each button
        addButton.setBounds(90, 190, 70, 40);
        subButton.setBounds(165, 190, 70, 40);
        divButton.setBounds(245, 190, 70, 40);
        mulButton.setBounds(325, 190, 70, 40);

        // Attach the same action listener to all buttons
        addButton.addActionListener(new action());
        subButton.addActionListener(new action());
        mulButton.addActionListener(new action());
        divButton.addActionListener(new action());

        // Add components to the frame
        add(text1);
        add(text2);
        add(result);
        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);

        setVisible(true); // Make the frame visible
    }

    // Inner class to handle button click events
    class action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Parse input numbers from the text fields
            double num1 = Double.parseDouble(text1.getText());
            double num2 = Double.parseDouble(text2.getText());

            // Get the text of the button that was clicked
            String op = ((JButton)(e.getSource())).getText();

            // Perform the corresponding operation
            if (op.equalsIgnoreCase("add")) {
                result.setText("Addition is: " + (num1 + num2));
            } else if (op.equalsIgnoreCase("sub")) {
                result.setText("Subtraction is: " + (num1 - num2));
            } else if (op.equalsIgnoreCase("mul")) {
                result.setText("Multiplication is: " + (num1 * num2));
            } else if (op.equalsIgnoreCase("div")) {
                // Handle divide-by-zero case
                if (num2 != 0) {
                    result.setText("Division is: " + (num1 / num2));
                } else {
                    result.setText("Can't divide by zero!");
                }
            }
        }
    }
}