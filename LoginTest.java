package userregistrationapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    Login login = new Login();

    public LoginTest() {
        // Setup dummy data for login tests
        login.setFirstName("Kyle");
        login.setLastName("Smith");
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
    }

    // --- ASSERT EQUALS TESTS (Messages) ---

    @Test
    public void testUsernameCorrectlyFormattedMessage() {
        // Simulating the expected output from a successful login using valid username data
        boolean isValid = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        String expected = "Welcome Kyle, Smith it is great to see you again.";
        assertEquals(expected, login.returnLoginStatus(isValid));
    }

    @Test
    public void testUsernameIncorrectlyFormattedMessage() {
        String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        assertEquals(expected, login.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976"));
    }

    @Test
    public void testPasswordMeetsComplexityMessage() {
        // Note: I am checking the register method's true state here based on instructions
        String expected = "Password successfully captured.";
        assertEquals(expected, login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexityMessage() {
        String expected = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        assertEquals(expected, login.registerUser("kyl_1", "password", "+27838968976"));
    }

    @Test
    public void testCellIncorrectlyFormattedMessage() {
        String expected = "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        assertEquals(expected, login.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553"));
    }

    // --- ASSERT TRUE/FALSE TESTS (Booleans) ---

    @Test
    public void testLoginSuccessful() {
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        assertFalse(login.loginUser("kyl_1", "wrongpassword"));
    }

    @Test
    public void testUsernameCorrectlyFormatted() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testPasswordMeetsComplexity() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCellPhoneCorrectlyFormatted() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
}