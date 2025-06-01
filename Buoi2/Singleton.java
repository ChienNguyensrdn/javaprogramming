package Buoi2;

public class Singleton {
    private Singleton(){}
    private static Singleton _instance;

    public static Singleton GetInstance(){
        if (_instance == null){
            _instance = new Singleton();
        }
        return _instance;
    }
    //Constructor co the co nhieu trong class 
    //private ?? khoi tao mot doi tuong??
    //new --> Constructor 

    //Quan ly viec goi khoi tao doi tuong 
    //Instance khong cho phia ben ngoai khoi tao mot cach o at 
    //Co su kiem xoat tu ben trong.
}
