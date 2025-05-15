package Buoi1;

public class ConcreteFactoryY implements AbstractFactory {

    @Override
    public IProductA CreateProductA() {
        IProductA productA = new ProductAY("Y");
        return productA;
    }

    @Override
    public IProductB CreateProductB() {
        IProductB productB = new ProductBY( "Y");
        return productB;
    }


}
