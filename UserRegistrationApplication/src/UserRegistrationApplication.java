

import java.util.Scanner;

public class UserRegistrationApplication {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        System.out.println("=== REGISTER NEW ACCOUNT ===");
        
        System.out.print("Enter First Name: ");
        login.setFirstName(scanner.nextLine());
        
        System.out.print("Enter Last Name: ");
        login.setLastName(scanner.nextLine());

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Cell Phone (+27...): ");
        String cell = scanner.nextLine();

        // Attempt Registration
        String registrationResult = login.registerUser(username, password, cell);
        System.out.println("\n" + registrationResult);

        // Only proceed to login if registration was successful
        if (registrationResult.equals("Password successfully captured.")) {
            System.out.println("\n=== LOGIN ===");
            System.out.print("Enter Username: ");
            String loginUser = scanner.nextLine();
            
            System.out.print("Enter Password: ");
            String loginPass = scanner.nextLine();

            // Attempt Login
            boolean isLoggedIn = login.loginUser(loginUser, loginPass);
            String loginMessage = login.returnLoginStatus(isLoggedIn);
            System.out.println("\n" + loginMessage);
        }
        
        scanner.close();
    }
    
}
