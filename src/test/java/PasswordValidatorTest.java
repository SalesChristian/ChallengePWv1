import org.example.PasswordValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PasswordValidatorTest {

    @Test
    public void testValidPasswordLength() {
        assertTrue(PasswordValidator.isLengthValid("SecurePwd123"));
    }

    @Test
    public void testInvalidPasswordLength() {
        assertFalse(PasswordValidator.isLengthValid("Short"));
    }
    @Test
    public void testContainsDigits() {
        assertTrue(PasswordValidator.containsDigits("SecurePwd123"));
        assertFalse(PasswordValidator.containsDigits("NoDigitsHere"));
    }
    @Test
    public void testContainsUppercaseAndLowercase() {
        assertTrue(PasswordValidator.containsUppercaseAndLowercase("SecurePwd123"));
        assertFalse(PasswordValidator.containsUppercaseAndLowercase("nocapitals"));
        assertFalse(PasswordValidator.containsUppercaseAndLowercase("NOLOWER"));
    }
    @Test
    public void testContainsCommonPasswords() {
        assertTrue(PasswordValidator.containsCommonPasswords("password1"));
        assertTrue(PasswordValidator.containsCommonPasswords("LassMichRein"));
        assertTrue(PasswordValidator.containsCommonPasswords("Geheim1"));
        assertFalse(PasswordValidator.containsCommonPasswords("SecurePwd123"));
    }
    @Test
    public void testContainsSpecialCharacters() {
        assertTrue(PasswordValidator.containsSpecialCharacters("SecurePwd!"));
        assertTrue(PasswordValidator.containsSpecialCharacters("@NoSpecialCharacters"));
        assertFalse(PasswordValidator.containsSpecialCharacters("NoSpecialCharactersHere"));
    }
    @Test
    public void testGenerateRandomPassword() {
        String randomPassword = PasswordValidator.generateRandomPassword(12);
        assertTrue(randomPassword.length() == 12);
        assertTrue(PasswordValidator.isLengthValid(randomPassword));
        assertTrue(PasswordValidator.containsDigits(randomPassword));
        assertTrue(PasswordValidator.containsUppercaseAndLowercase(randomPassword));
        assertFalse(PasswordValidator.containsCommonPasswords(randomPassword));
    }
}