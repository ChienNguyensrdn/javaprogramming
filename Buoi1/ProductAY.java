package javaprogramming.Buoi1;

public class ProductAY implements IProductA{
    private String code;
    public String getCode(){
        return code;
    }
    public void setCode(String _code){
        code = _code;
    }
    public ProductAY(String _code ){
        setCode(_code);
    }
    @Override
    public IProductA CreateProductA(String code) {
        IProductA productA = new ProductAY(code);
        return productA;
    }

}
