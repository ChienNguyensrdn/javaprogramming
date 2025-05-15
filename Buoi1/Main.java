package javaprogramming.Buoi1;
import javaprogramming.Buoi1.Singleton;
// File: Main.java
class Main {
    public static void main(String[] args) {
      AbstractFactory booking = new ConcreteFactoryX();
      var ax =  booking.CreateProductA();
    }
}