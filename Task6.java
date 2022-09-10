public class Product{
    private String name;
    private double price;
    public static int counter = 0;
    
    public Product(){
        counter++;
    }
    
    public Product(String name,double price){
        this.name = name;
        this.price = price;
        counter++;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    
    public static int count(){
        
        return counter;
        
    }
