import java.util.Scanner;
public class PasswordStrengthIndicator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        int length = password.length();
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        for (int i = 0; i < length; i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSpecialChar = true;
            }
        }
        int strength = 0;
        if (length > 8 && hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
            strength = 3; // Strong
        } else if (length >= 6 && hasDigit && (hasUppercase || hasLowercase)) {
            strength = 2; // Medium
        } else {
            strength = 1; // Weak
        }
        String strengthLabel = "";
        String visualIndicator = "";
        switch (strength) {
            case 3:
                strengthLabel = "Strong";
                visualIndicator = "🟢🟢🟢"; // Green circles or any other visual symbol
                break;
            case 2:
                strengthLabel = "Medium";
                visualIndicator = "🟡🟡"; // Yellow circles or any other visual symbol
                break;
            case 1:
                strengthLabel = "Weak";
                visualIndicator = "🔴"; // Red circle or any other visual symbol
                break;
        }
        System.out.println("Password Strength: " + strengthLabel);
        System.out.println("Visual Indicator: " + visualIndicator);
    }
}
