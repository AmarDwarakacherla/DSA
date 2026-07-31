package Practice;



//Tight Coupling
/*
public class Main {
    public static void main(String[] args) {
        EmailNotification emailNotification = new EmailNotification();
        emailNotification.notifyUser("Welcome Amar");

        SmsNotification smsNotification = new SmsNotification();
        smsNotification.notifyUser("Welcome Harsh");
    }
}
class EmailService{
    public void sendEmail(String message){
        System.out.println("Email send : "+message);
    }
}
class EmailNotification{
    private final EmailService emailService = new EmailService();
    public void notifyUser(String message){
        emailService.sendEmail(message);
    }
}
class SmsService{
    public void sendSMS(String message){
        System.out.println("SMS send : "+message);
    }
}
class SmsNotification{
    private final SmsService smsService = new SmsService();
    public void notifyUser(String message){
        smsService.sendSMS(message);
    }
}
 */


//Loose Couplings
public class Main{
    public static void main(String[] args) {
        NotificationService notificationService = new SmsNotification();
        Notification notification = new Notification(notificationService);
        notification.notifyUser("Welcome...");
    }
}
interface NotificationService{
    void sendMessage(String message);
}
class EmailNotification implements NotificationService{
    @Override
    public void sendMessage(String message){
        System.out.println("Email sent : " + message);
    }
}
class SmsNotification implements NotificationService{
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS sent : " + message);
    }
}
class Notification{
    private NotificationService notificationService;
    public Notification(NotificationService notificationService){
        this.notificationService = notificationService;
    }
    public void notifyUser(String message){
        notificationService.sendMessage(message);
    }
}
