import java.util.Scanner;
public class UserInfoLab {

    public static void main(String[] args) {
        // Part 1
        // Create a Scanner for keyboard input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter your first name");
        String lastName = scanner.nextLine();

        // Ask the user to enter their first and last name and pass these
        // values to the generateUsername method and save the returned result.
        String save = generateUsername(firstName , lastName);
        System.out.println("Username: " +  save);
        // Part 2
        // Ask the user to enter a password and pass this value to the validatePassword method.
        System.out.println("Enter your password ");
        String password = scanner.nextLine();
        // The validatePassword method will check if the password meets the criteria:
        boolean isValid = validatePassword(password);
        System.out.println("This is a valid password");
        // Part 3
        // If the user entered a valid password in step 2, then ask the user to enter their credit card number and pass this value to the maskCreditCard method.
        if (isValid){
            String cardNumber = scanner.nextLine();
            System.out.println("Enter your credit card number");
            String masked = maskCreditCard(cardNumber);
            if (masked.equals("invalid credit card number")){
                System.out.println(masked);
            }
            else {
                System.out.println("Username: " + save + "Credit Card: " + masked);
            }
        }

        // Part 4
        // If the user entered a valid password AND valid credit card number, display the output
        // as shown in the demo video
        // https://drive.google.com/file/d/1sMOw5wkOgSfuUcvQhFyZ5flnv_d9qQd3/view?usp=sharing

    }

    public static String generateUsername(String firstName, String lastName) {
        // Fill in this method and return an appropriate username
        String output = "";
        if (firstName.length() < 3){
            output += firstName;
        }
        else {
            for (int i = 0; i < 3; i++) {
                output += firstName.substring(i, i + 1);
            }
        }
        if (lastName.length() < 3){
            output += lastName;
        }
        else {
            for (int i = 0; i < 3; i++) {
                output += lastName.substring(i, i + 1);
            }
        }
        return output;
    }
    public static boolean validatePassword(String password) {
        if (password.length() <8){
            System.out.print("The password needs to be 8 characters long and it is less than that");
            return false;
        }
        String uppercaseTest = password.toLowerCase();
        if (password == uppercaseTest){
            System.out.println("Make sure there is at least one uppercase letter ");
            return false;
        }
        if (!containsDigit(password)){
            System.out.print("The password does not have a number");
            return false;
        }
        // Fill in this method and return true/false if the password is valid
        return true;
    }
    public static String maskCreditCard(String creditCardNumber) {
        String output = "";
        if (!allDigits(creditCardNumber)){
            return "The credit card needs to be all numbers";
        }
        else if (creditCardNumber.length() == 16){
            for (int i=0; i<3; i++){
                for (int j=0; j<4; j++){
                    output += "*";
                }
                output += " ";
            }
            output += creditCardNumber.substring(creditCardNumber.length()-4);
            return output;
        }
        else {
            return "The card must be 16 digits long";
        }

    }

    /**
     This method verifies that the string contains at least one numeric digit
     @param str The string to check
     @return true or false if a digit is present
     */
    public static boolean containsDigit(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    /**
     * Checks if the entire String is all numerical
     * @param str The string to check
     * @return true or false if the string is ALL digits
     */
    public static boolean allDigits(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}
