package javaprogramming.Buoi1;

public class ProductBX implements IProductB {
    private String code;
    public String getCode(){
        return code;
    }

    public void setCode(String _code){
        code = _code;
    }
    public ProductBX (String _code){
        setCode(_code);
    }
    @Override
    public IProductB CreateProductB(String code) {
        IProductB productB = new ProductBX(code);
        return productB;
    }

}
