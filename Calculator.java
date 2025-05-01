import java.awt.event.*;
import javax.swing.*;
public class Calculator {
    public static void main(String[] args) {
        MyFrame calcFrame = new MyFrame();
    }
}

class MyFrame extends JFrame{
    JTextField text1, text2, result;
    public MyFrame(){
        setTitle("Simple Calculator");
        setSize(500, 300);
        setLayout(null);

        text1 = new JTextField(); text2 = new JTextField(); result = new JTextField();

        text1.setBounds(90, 30, 300, 40);
        text2.setBounds(90, 80, 300, 40);
        result.setBounds(90, 130, 300, 40);
        result.setEditable(false);

        JButton addButton, subButton, mulButton, divButton;
        addButton = new JButton("Add");
        subButton = new JButton("Sub");
        mulButton = new JButton("Mul");
        divButton = new JButton("Div");

        addButton.setBounds(90, 190, 70, 40);
        subButton.setBounds(165, 190, 70, 40);
        mulButton.setBounds(325, 190, 70, 40);
        divButton.setBounds(245, 190, 70, 40);

        addButton.addActionListener(new action());
        subButton.addActionListener(new action());
        mulButton.addActionListener(new action());
        divButton.addActionListener(new action());

        add(text1); add(text2); add(result);
        add(addButton); add(subButton); add(mulButton); add(divButton);

        setVisible(true);
    }

    class action implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double num1 = Double.parseDouble(text1.getText());
            double num2 = Double.parseDouble(text2.getText());
            
            String op = ((JButton)(e.getSource())).getText();
            
            if(op.equalsIgnoreCase("add")){
                result.setText("Addition is: " + (num1+num2));
            }else if(op.equalsIgnoreCase("sub")){
                result.setText("Subtraction is: " + (num1-num2));
            }else if(op.equalsIgnoreCase("mul")){
                result.setText("Multiplication is: " + (num1*num2));
            }else if(op.equalsIgnoreCase("div")){
                if(num2 != 0){
                    result.setText("Division is: " + (num1 / num2));
                } else {
                    result.setText("Cannot divide by zero!");
                }
            }
        }
    }
}
