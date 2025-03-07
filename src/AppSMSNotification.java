
import api.SMSSender;
import api.SMSSenderFactory;
import model.SMS;
import translation.Translator;
import translation.TranslatorPadrao;


import java.time.LocalDateTime;
import java.util.Scanner;

public class AppSMSNotification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número de destino:");
        String destino = scanner.nextLine();

        System.out.println("Digite a mensagem:");
        String texto = scanner.nextLine();

        System.out.println("Deseja traduzir a mensagem para inglês? (S/N)");
        String traduzir = scanner.nextLine();

        if (traduzir.equalsIgnoreCase("S")) {
            Translator translator = new TranslatorPadrao();
            try {
                texto = translator.translate("pt", "en", texto);
                System.out.println("Texto traduzido: " + texto);
            } catch (Exception e) {
                System.out.println("Erro na tradução: " + e.getMessage());
            }
        }

        SMS sms = new SMS("41999998888", destino, texto, LocalDateTime.now());

        try {
            SMSSender sender = SMSSenderFactory.getSMSSender(destino);
            boolean enviado = sender.sendSMS(sms);
            System.out.println(enviado ? "Mensagem enviada com sucesso!" : "Falha no envio da mensagem.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
