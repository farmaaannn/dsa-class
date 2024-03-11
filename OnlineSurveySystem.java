import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineSurveySystem extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public OnlineSurveySystem() {
        setTitle("Online Survey System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel loginPanel = new JPanel(new GridLayout(3, 1));
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (authenticateUser(username, password)) {
                    openSurveyCreation(); // Open survey creation window
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        add(loginPanel);
    }

    private boolean authenticateUser(String username, String password) {
        // Perform authentication logic, e.g., check against database
        // Return true if authentication is successful, false otherwise
        return true; // Placeholder for demonstration
    }

    private void openSurveyCreation() {
        JFrame surveyFrame = new JFrame("Survey Creation");
        surveyFrame.setSize(400, 300);
        surveyFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1));
        JLabel titleLabel = new JLabel("Survey Title:");
        JTextField titleField = new JTextField(20);
        JButton addButton = new JButton("Add Question");

        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAddQuestionDialog();
            }
        });

        surveyFrame.add(panel);
        surveyFrame.setVisible(true);
    }

    private void openAddQuestionDialog() {
        JDialog dialog = new JDialog(this, "Add Question", true);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new FlowLayout());
        JLabel questionLabel = new JLabel("Question:");
        JTextField questionField = new JTextField(20);
        JButton addButton = new JButton("Add");

        panel.add(questionLabel);
        panel.add(questionField);
        panel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add question logic here
                dialog.dispose();
            }
        });

        dialog.add(panel);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                OnlineSurveySystem system = new OnlineSurveySystem();
                system.setVisible(true);
            }
        });
    }
}

