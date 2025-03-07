package api;

import util.PhoneNumberValidator;

public class SMSSenderFactory {
    public static SMSSender getSMSSender(String phoneNumber) {
        String csp = PhoneNumberValidator.extractCSP(phoneNumber);
        return switch (csp) {
            case "41" -> new TimSMSSender();
            case "15" -> new VivoSMSSender();
            default -> throw new IllegalArgumentException("Operadora desconhecida.");
        };
    }
}


