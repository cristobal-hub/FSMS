import javax.swing.JOptionPane;
import java.security.SecureRandom;

public class StudentPassword {

    // This method creates a secure password with uppercase, lowercase, digits, and symbols
    public String generateSecurePassword(int length) {
        // Define arrays for each character type
        char[] upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] digits = "0123456789".toCharArray();
        char[] symbols = "!@#$%^&*()-_+=<>?".toCharArray();

        // Combine all character arrays into a single array
        char[] allChars = new char[upperCaseLetters.length + lowerCaseLetters.length + digits.length + symbols.length];
        System.arraycopy(upperCaseLetters, 0, allChars, 0, upperCaseLetters.length);
        System.arraycopy(lowerCaseLetters, 0, allChars, upperCaseLetters.length, lowerCaseLetters.length);
        System.arraycopy(digits, 0, allChars, upperCaseLetters.length + lowerCaseLetters.length, digits.length);
        System.arraycopy(symbols, 0, allChars, upperCaseLetters.length + lowerCaseLetters.length + digits.length, symbols.length);

        SecureRandom random = new SecureRandom(); // Used for secure random number generation
        StringBuilder password = new StringBuilder();

        // Ensure the password has at least one character from each group
        password.append(upperCaseLetters[random.nextInt(upperCaseLetters.length)]);
        password.append(lowerCaseLetters[random.nextInt(lowerCaseLetters.length)]);
        password.append(digits[random.nextInt(digits.length)]);
        password.append(symbols[random.nextInt(symbols.length)]);

        // Fill in the remaining characters randomly from the combined array
        for (int i = 4; i < length; i++) {
            password.append(allChars[random.nextInt(allChars.length)]);
        }

        // Convert StringBuilder to string and shuffle it
        char[] passwordArray = password.toString().toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            int j = random.nextInt(passwordArray.length);
            // Swap characters
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[j];
            passwordArray[j] = temp;
        }

        return new String(passwordArray); // Return the shuffled password
    }

    public static void main(String[] args) {
        // Create an instance of the StudentPassword class to call the password generation method
        StudentPassword generator = new StudentPassword();
        int length = 0;

        // Keep asking the user until a valid input is provided
        while (true) {
            // Prompt the student to enter the password length
            String input = JOptionPane.showInputDialog(null, "Enter a number more than or equal to 5:");

            // If the student clicks "Cancel", exit the program
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Cancelled.");
                return;
            }

            // Check if the input is actually a number
            boolean isNumber = input.matches("\\d+");

            if (!isNumber) {
                // If the input isn't a valid number, show an error and continue the loop
                JOptionPane.showMessageDialog(null, "Please enter a valid digit.");
                continue;
            }

            // Convert the valid numeric string into an integer
            
            length = Integer.parseInt(input);

            // If the number is too small, show a message and ask again
            if (length < 5) {
                JOptionPane.showMessageDialog(null, "Please enter a number 5 or greater.");
                continue; // Loop again
            }

            // If input is valid and long enough, generate and display the password
            String password = generator.generateSecurePassword(length);
            System.out.println("Generated password is secure: " + password); // Print to console
            JOptionPane.showMessageDialog(null, "Password created: " + password); // Show in dialog box

            break; // Exit the loop and end the program after successful generation
        }
    }
}



