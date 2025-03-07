package api;

import model.SMS;

public interface SMSSender {
    boolean sendSMS(SMS sms);
}
