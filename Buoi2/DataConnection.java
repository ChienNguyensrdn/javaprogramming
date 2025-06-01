package Buoi2;

public class DataConnection {
    //Ten Constructor??
    //Khong gia tri tra ve
    //Ten gioongs với tên class 
    //có nhiều constructor 
    private DataConnection(){

    }
    //new ???
    //Static method, static ???
    private static DataConnection _connection; //-->Instance cua class DataConnection
    public static DataConnection getConnection(){
        if(_connection == null){
            _connection = new DataConnection();
        }
        return _connection;
    }
}
