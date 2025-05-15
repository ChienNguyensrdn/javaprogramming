package Buoi1;

public class Singleton {
    // tao ra ADT 
    private static Singleton instance;
    private Singleton(){
        System.err.println("Singleton constructor");
    }
    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
