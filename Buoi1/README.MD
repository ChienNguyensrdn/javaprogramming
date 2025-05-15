# OOP va các tính chất 
    Ngôn ngữ thuần tuý hướng đối tượng
    Có đầy đủ các tính chất hướng đối tượng 
    Hướng đối tượng gồm có 4 tính chất 
        Đóng gói 
        Kế thừa 
        Đa hình 
        Trừu tượng 
        Interface :
        Absstract class 
        So sánh khác biệt Interface & Absstract class 

# Design Pattern
    1. Singleton Pattern
        Private constructor của class đó để đảm bảo rằng class lớp khác không thể truy cập vào constructor và tạo ra instance mới
        Tạo một biến private static là thể hiện của class đó để đảm bảo rằng nó là duy nhất và chỉ được tạo ra trong class đó thôi.
    ```java
        public class Singleton {

            private static Singleton instance;
        
            private Singleton(){}
        
            public static Singleton getInstance(){
                if(instance == null){
                    instance = new LazyInitializedSingleton();
                }
                return instance;
                }
        }
    ```
    Vì class dùng Singleton chỉ tồn tại 1 Instance (thể hiện) nên nó thường được dùng cho các trường hợp giải quyết các bài toán cần truy cập vào các ứng dụng như: Shared resource, Logger, Configuration, Caching, Thread pool
    1. 