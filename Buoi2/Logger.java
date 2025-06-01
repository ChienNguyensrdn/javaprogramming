package Buoi2;

public class Logger {
    ///Info :1
    /// Debug : 2
    /// Error : 3
    /// 
    int Mode ;
    String Class_path;
    public Logger(String __class__, int mode ){
        this.Mode = mode;
        Class_path = __class__;
    }
    public void WriteLog(String messString){
        //histor ...
    }
}
