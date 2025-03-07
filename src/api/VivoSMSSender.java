package api;

import model.SMS;
import java.time.LocalDateTime;

public class VivoSMSSender implements SMSSender {
    @Override
    public boolean sendSMS(SMS sms) {
        try {
            String[] mensagens = sms.getTexto().split("(?<=\\G.{120})");
            System.out.println("Enviando SMS via VIVO para " + sms.getDestino());
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao enviar SMS via VIVO: " + e.getMessage());
            return false;
        }
    }
}
