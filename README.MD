# Create console app c#    with vscdoe
    Ctrl+Shift+P (Command+Shift+P on MacOS)
# Single Pattern là một design pattern
1. Đảm bảo rằng một class chỉ có duy nhất một instance
2. Kiểm xoát quá trình tạo ra instance

    ```aspx-csharp
    class Singleton{
        private Singleton() { }
        private static Singleton _instance;
        public static Singleton GetInstance()
        {
            if (_instance == null)
            {
                _instance = new Singleton();
            }
            return _instance;
        }
    }
    ```
    
# Lập trình CSDL 
1. Connectstring : chuỗi kết nối vào cơ sở dữ liệu
2. Openconnect : HQT CSDL khi cài đặt setup limit connect --> database 
