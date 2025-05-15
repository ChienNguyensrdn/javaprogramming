package Buoi1;

public class ProductAX implements IProductA {
    private String code;
    public String getCode(){
        return code;
    }

    public void setCode(String _code){
        code = _code;
    }
    public ProductAX (String _code){
        setCode(_code);
    }
    @Override
    public IProductA CreateProductA(String code) {
        IProductA productA = new ProductAX(code);
        return productA;
    }

}
