
package userregistrationapplication;

public class LOGIN {
   
    // Variables to store user data once successfully registered
    private String storedUsername = "";
    private String storedPassword = "";
    private String firstName = "";
    private String lastName = "";
    private String cellNumber = "";

    // Setters for the names so we can use them in the welcome message later
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // 1. Check Username Condition: Contains '_' and is <= 5 characters
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // 2. Check Password Condition: >= 8 chars, 1 uppercase, 1 number, 1 special character
    public boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) {
            return false;
        }
        
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasNumber = password.matches(".*\\d.*");
        // Regex to check for special characters
        boolean hasSpecial = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
        
        return hasUppercase && hasNumber && hasSpecial;
    }

    // 3. Check Cellphone Condition: Contains +27 followed by 9 digits
    public boolean checkCellPhoneNumber(String cellPhoneNumber) {
        // Regex ensures it starts with +27 and is followed exactly by 9 digits
        return cellPhoneNumber.matches("^\\+27\\d{9}$");
    }

    // 4. Register User: Returns specific messages based on the checks above
    public String registerUser(String username, String password, String cellPhoneNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        // If all checks pass, save the data
        this.storedUsername = username;
        this.storedPassword = password;
        this.cellNumber = cellPhoneNumber;

        return "Password successfully captured."; // Message from the Image 1 true condition
    }

    // 5. Verify Login Details
    public boolean loginUser(String username, String password) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    // 6. Return Login Status Messaging
    public String returnLoginStatus(boolean loginSuccessful) {
        if (loginSuccessful) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
