package SOLID.demo;

public class Main {
    public static void  main (String[] args ){
        System.out.println("null");
        for(int i = 0; i<=10; i++){
            Config.getInstance();
        }
    }
}
