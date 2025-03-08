package util;

public class PhoneNumberValidator {
    public static String extractCSP(String phoneNumber) {
        if (phoneNumber.length() >= 2) {
            return phoneNumber.substring(0, 2);
        } else {
            throw new IllegalArgumentException("Número de telefone inválido.");
        }
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{13}");
    }
}
