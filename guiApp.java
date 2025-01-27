// imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// create GUI frame/window (everything within this is what is running)
public class gameApp extends JFrame {
    // start at level 1 or starting point when loading 
    // set to private so only accesable in this class not outside 
    private int currentLevel = 1;
    private JTextField answerField;
    private JLabel questionLabel;
    private JLabel statusLabel;
    private JButton submitButton;

    public gameApp() {
        setTitle("Are you smarter than a 5th grader?");
        setSize(500, 125);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        // Create the riddle label
        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(questionLabel, BorderLayout.NORTH);

        // Create the text field for the user to input their answer
        answerField = new JTextField(20);
        answerField.setFont(new Font("Arial", Font.PLAIN, 18));
        add(answerField, BorderLayout.CENTER);

        // Create the status label
        statusLabel = new JLabel("Enter your answer above.", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(statusLabel, BorderLayout.SOUTH);

        // Create the submit button
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        add(submitButton, BorderLayout.EAST);

        // Add action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRiddleAnswer();
            }
        });

        // Start the game
        displayNextLevel();
    }

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

    private void handleRiddleAnswer() {
        String userAnswer = answerField.getText().toLowerCase().trim();
        boolean correctAnswer = false;

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

        if (correctAnswer) {
            if (currentLevel < 6) {
                currentLevel++;
                displayNextLevel();
                statusLabel.setText("Congrats! You've passed Grade " + (currentLevel - 2) + "!");
            } else {
                JOptionPane.showMessageDialog(this, "Congratulations! You are at the very least as smart as a 5th grader!");
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "GAME OVER! The correct answer was " + getCorrectAnswerForLevel(currentLevel));
            System.exit(0);
            // resetGame();
        }
    }

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new gameApp().setVisible(true);
            }
        });
    }
}

