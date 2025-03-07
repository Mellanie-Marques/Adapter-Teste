package api;

import model.SMS;

public class TimSMSSender implements SMSSender {
    @Override
    public boolean sendSMS(SMS sms) {
        System.out.println("Enviando SMS via TIM para " + sms.getDestino());
        return true; // Simulação de envio bem-sucedido
    }
}

