package SOLID.demo;

public class Config {
    private Config(){}
    private static Config _instance;
    public static Config getInstance(){
        if(_instance == null)
            _instance = new Config();
        return _instance;
    }
}
