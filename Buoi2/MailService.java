package Buoi2;

public class MailService {
    String Account;
    String Password;
    Logger _logger;
    // public MailService(){
    //     _logger = new Logger("MailService", 1   );
    // }


    public MailService(Logger logger){
       _logger = logger;
    }
    //SMTP {25, 557}
    int Port;
    public void SendMail(){
        //logic
        //Xac thuc tai khoan 
        //Port protocol....
        //bat dau ghi log 
      
        _logger.WriteLog("bat dau send mail");

    }
}
