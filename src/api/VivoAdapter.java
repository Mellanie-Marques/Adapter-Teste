package api;

import model.SMS;

public class VivoAdapter implements SMSSender{
    private final VivoService vivoService = new VivoService();

    @Override
    public boolean sendSMS (SMS sms) {
        try {
            String[] msgs = sms.getTexto().split("(/<=\\G.{120})");
            vivoService.enviarSMS(sms.getOrigem(), sms.getDestino(), sms.getTimestamp(), msgs);
            return true;
        } catch (SMSException e) {
            System.out.println("Erro ao enviar SMS pela Vivo: " + e.getMessage());
            return false;
        }
    }
}
