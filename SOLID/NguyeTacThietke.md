# Lập trình hướng đối tượng 
1. Đóng gói 
Các từ khoá truy cập private, public, proteted 

getter, setter. Đôi khi có thể che dấu đi một vài phương thức, phơi bày ra ngoài một vài thuộc tính (tuỳ vào mục đích sử dụng)

    ```csharp
        class Config {
            //Nạp chồng hàm --> 1 class --> constructor.
            private Config(){}
            private static Config  _instance;
            public static  Config getInstance(){
                if (_instance == null){
                    _instance = new Config();
                }
                return _instance;
            }
        }
        class Main{
            public static main(String[] agrs){
                //Client 
                Config.getInstance();
                
            }
        }
    ```
2. Ke thua: (Đơn kế thừa, Đa kế thừa)
class kế thừa 1 class, nhưng nó có kế thừa (implements) nhiều interface 

- Interface 
- Abstract class ()

3. Tính đa hình 
4. Tính trừu tượng 

# SOLID 
1. S is single responsibility principle (SRP)
1 class thì chỉ chịu trách nhiệm công việc duy nhất, muốn thay đổi class chỉ có 1 lý do duy nhất 

    ```csharp
        class ReadData {
            public void ReadDataXml();
            public void ReadDataJson();
            public void ReadDataExcel();
        }
    ```
2. # O stands for open/closed principle (OCP)
Có thể thoái mái mở rộng 1 class, nhưng không được phép sửa đổi class đó.

    ```csharp
        interface IReadDataExcel{
            public void ReadDataExcel();
        }
        interface IReadDataXml{
            public void ReadDataXml();
        }
        class ReadData implements IReadDataExcel, IReadDataXml{
            @overide 
            public void ReadDataExcel(){
                //logic 
            }
            @overide 
            public void ReadDataXml(){
                //logic 
            }
        }
    ```
3. L Liskov substitution principle (LSP) 
Các lớp con kế thừa từ lớp cha, nhưng không được phép phá vỡ đi các thuộc tính và hành vi của lớp cha.

    ```csharp
        class abstract Employee{
            private String FullName;
            private String EmployeeCode;
            public abstract void Working();
        }
        class Developer extends Employee{
            @overide 
            public void Working(){
                System.out.println("programing");
            }
        }
        //Sai logic không nên tồn tại thiết kế như thế này!
        class BotDevloper extends Employee{
        }
    ```
4. I interface segregation principle (ISP)
Thay vì xây đựng với số lương methods quá lớn, tại sao không chia nhỏ ra thành nhiều interfaces.

    ```csharp
        interface IReadData{
            void ReadDataXml();
            void ReadDataExcel();
            void ReadDataCsv();
            void ReadDataJson();
        }
        //->Slution tạo nhiều Interfaces nhỏ hơn 
        interface IReadDataExcel{
            public void ReadDataExcel();
        }
        interface IReadDataXml{
            public void ReadDataXml();
        } 
        class ReadData implements IReadDataXml{
            
        }
    ```
5. D Dependency injection principle (DIP)

    ```csharp
        //Module MailService Send mail ghi lại log quá trình xử lý. 
        //+ Module MailService 
        class MailService{
            private Logger _logger;
            public MailService(Logger logger){
                _logger = logger;
            }
            //logger ---> ghi lai log thao tác
            void SendMail(){
                //<!-- Logger logger = new Logger(); -->
                logger.WriteLog("Begin start service mail");
            }
            
        }
        class Logger {
            private int mode; //0 logInfo, 1: log debug, 2 log error.
            public Logger (){
            }
            public void WriteLog(String log){
                //Ghi thông tin log --> file 
            }
        }
        class Main{
            void satic main(String [] args){
                Logger logger = new Logger();
                MailService mail = new MailService(logger);
            }
        }
    ```
    
      
    