import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel number;
  JLabel factorial;

  JTextField userNum;
  JTextField resultNum;

  JButton calculate;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    //initialize main panel 
    mainPanel = new JPanel();
    //not disabling layout to it defaults to flow

    //initialize the 2 labels
    number = new JLabel("n");
    factorial = new JLabel("Factorial(n)");

    //initialize the 2 text fields and set size 
    userNum = new JTextField();
    resultNum = new JTextField();

    userNum.setPreferredSize(new Dimension(100, 20));
    resultNum.setPreferredSize(new Dimension(100, 20));

    //disable the result fields
    resultNum.setEnabled(false);

    //initialize button
    calculate = new JButton("CALC");

    //sets action listener and action command to button
    calculate.addActionListener(this);
    calculate.setActionCommand("calc");

    //adds everything to main panel
    mainPanel.add(number);
    mainPanel.add(userNum);
    mainPanel.add(factorial);
    mainPanel.add(resultNum);
    mainPanel.add(calculate);

    //adds main panel to frame
    frame.add(mainPanel);
 
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    //gets user input
    String userInputString = userNum.getText();

    //converts string to int
    int userInput = Integer.parseInt(userInputString);

    //variables that will store factorial and accumulate
    int fac = 0;
    int acc = userInput;

    //loop that calculates factorial
    for(int i = userInput; i > 1; i--){
      fac = acc * (i - 1);
      acc = fac;
    }
    
    //displays factorial to user
    resultNum.setText("" + acc);

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
