package Buoi1;

public class ConcreteFactoryX implements AbstractFactory {

    @Override
    public IProductA CreateProductA() {
        IProductA productA = new ProductAX("X");
        return productA;
    }

    @Override
    public IProductB CreateProductB() {
        IProductB productB = new ProductBX( "X");
        return productB;
    }

}
