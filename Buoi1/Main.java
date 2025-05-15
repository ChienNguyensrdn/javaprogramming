package Buoi1;
import Buoi1.Singleton;
// File: Main.java
class Main {
    public static void main(String[] args) {
      AbstractFactory booking = new ConcreteFactoryX();
      var ax =  booking.CreateProductA();
    }
}