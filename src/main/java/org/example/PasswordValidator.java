package org.example;

import java.security.SecureRandom;
public class PasswordValidator {
        public static boolean isLengthValid(String password) {
            return password.length() >= 8;
        }
        public static boolean containsDigits(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsUppercaseAndLowercase(String password) {
        boolean containsUppercase = false;
        boolean containsLowercase = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                containsUppercase = true;
            } else if (Character.isLowerCase(c)) {
                containsLowercase = true;
            }

            // Wenn beides gefunden wurde, können wir aufhören zu suchen
            if (containsUppercase && containsLowercase) {
                break;
            }
        }

        return containsUppercase && containsLowercase;
    }
    public static boolean containsCommonPasswords(String password) {
        String[] commonPasswords = {"password1", "123456", "qwerty", "lassmichrein", "Geheim1", "admin"};

        for (String commonPassword : commonPasswords) {
            if (password.equalsIgnoreCase(commonPassword)) {
                return true;
            }
        }

        return false;
    }
    public static boolean containsSpecialCharacters(String password) {
        String specialCharacters = "!@#$%^&*()-_=+[{]};:'\",<.>/?";

        for (char c : password.toCharArray()) {
            if (specialCharacters.contains(String.valueOf(c))) {
                return true;
            }
        }

        return false;
    }
    public static String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[{]};:'\",<.>/?";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }
    }

