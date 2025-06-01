package SOLID.demo;

public class DataConnect {
    private DataConnect(){}
    private static DataConnect _instance;
    //Business client ---> database 
    // chi tao ra 1 connection duy nhat 
    public static DataConnect  getInstance (){
        if (_instance == null){
            _instance = new DataConnect();
        }
        return _instance;
    }
}
