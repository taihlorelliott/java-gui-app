// imports
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// create GUI frame/window (everything within this is what is running)
public class gameApp extends JFrame {
    // start at level 1 or starting point when loading 
    // set to private so only accesable in this class not outside 
    private int currentLevel = 1;
    // set answer text field 
    private JTextField answerField;
    // set question labels 
    private JLabel questionLabel;
    // set status label
    private JLabel statusLabel;
    // set button
    private JButton submitButton;

    // game constructor same name as the class/file
    public gameApp() {
        // set display title
        setTitle("Are you smarter than a 5th grader?");
        // size in px
        setSize(500, 125); 
        // set exit button to stop app from running
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

        // Create the question label as an empty string and center it with swing
        questionLabel = new JLabel("", SwingConstants.CENTER);
        // format the font of the label
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        // add the label to the gui on the top
        add(questionLabel, BorderLayout.NORTH);

        // Create the text field for the user to input their answer
        answerField = new JTextField(20);
        // format the text field
        answerField.setFont(new Font("Arial", Font.PLAIN, 18));
        // add the text field to display in the gui in the middle
        add(answerField, BorderLayout.CENTER);

        // Create the status label
        statusLabel = new JLabel("Enter your answer above.", SwingConstants.CENTER);
        // format the status label
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        // display the status label on the bottom of the GUI
        add(statusLabel, BorderLayout.SOUTH);

        // Create the submit button
        submitButton = new JButton("Submit");
        // format the button
        submitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        // display the button on the left side of the gui
        add(submitButton, BorderLayout.EAST);

        // Add action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            // accecible from anywhere, void to not return anything but the method called
            // called for button click functions
            // contains an object that tells you this event is an action (like clicking a button)
            public void actionPerformed(ActionEvent e) {
                // run this function
                handleQuestionAnswer();
            }
        });

        // Start the switch statement
        displayNextLevel();
    }
    // switch statement for current level questions
    private void displayNextLevel() {
        switch (currentLevel) {
            case 1:
                questionLabel.setText("Do you think you are smarter than the average 10 year old?");
                break;
            case 2:
                questionLabel.setText("Grade 1: How many colors are in the rainbow?");
                break;
            case 3:
                questionLabel.setText("Grade 2: What is the main source of energy for the human body?");
                break;
            case 4:
                questionLabel.setText("Grade 3: What country is Nelson Mandela from?");
                break;
            case 5:
                questionLabel.setText("Grade 4: 'Carefully' is an example of what type of word?");
                break;
            case 6:
                questionLabel.setText("Grade 5: Who painted the Mona Lisa?");
                break;

        }
        answerField.setText(""); // clears the previous answer 
    }
    // switch statement to handle answers
    private void handleQuestionAnswer() {
        // read the user input as a string 
        String userAnswer = answerField.getText().toLowerCase().trim();

        // the user input is automatically set to false unless the boolean is changes below in the switch statement
        boolean correctAnswer = false;

        // correct answers switch statement 
        switch (currentLevel) {
            case 1:
                if ("yes".equals(userAnswer)) {
                    correctAnswer = true;
                }
                break;
            case 2:
                if (userAnswer.contains("seven") || userAnswer.contains("7")) {
                    correctAnswer = true;
                }
                break;
            case 3:
                if (userAnswer.contains("carb")) {
                    correctAnswer = true;
                }
                break;
            case 4:
                if (userAnswer.contains("south africa")) {
                    correctAnswer = true;
                }
                break;
            case 5:
                if (userAnswer.contains("adverb")) {
                    correctAnswer = true;
                }
                break;
            case 6:
                if (userAnswer.contains("da vinci") || userAnswer.contains("davinci")) {
                    correctAnswer = true;
                }
                break;
        }
        // create dialog popup box
        if (correctAnswer) {
            // display current status messages at bottom of gui
            if (currentLevel == 1) {
                currentLevel++;
                displayNextLevel();
                statusLabel.setText("Enter answer above.");
            } else if (currentLevel < 6) {
                currentLevel++;
                displayNextLevel();
                statusLabel.setText("Yay! You graduated grade " + (currentLevel - 2) + "!");
            } else {
                // jOptionPane is the dialog box that pops up
                JOptionPane.showMessageDialog(this, "Congratulations! You are at the very least as smart as a 5th grader!");
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "GAME OVER! The correct answer was " + getCorrectAnswerForLevel(currentLevel));
            System.exit(0);
            // resetGame();
        }
    }

    // correct answers for game over message
    private String getCorrectAnswerForLevel(int level) {
        switch (level) {
            case 1: return "Yes";
            case 2: return "7";
            case 3: return "Carbohydrates";
            case 4: return "South Africa";
            case 5: return "an Adverb";
            case 6: return "Leonardo Da Vinci";
            default: return "unknown";
        }
    }

// main function 
    public static void main(String[] args) {
        // set game to show up aka visible
        new gameApp().setVisible(true);
    }
}

