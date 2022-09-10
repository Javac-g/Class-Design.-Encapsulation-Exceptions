class Circle{
    
    private double radius;
    private String color;
    private float scale;
    
    public Circle(double radius){
        this.radius = radius;
    }
    
    public void draw(){
        
    }
    public void draw(String color){
        this.color = color;
        
    }
    public void draw(float scale){
        this.scale = scale;
    }
    public void draw(String color,float scale){
        this.color = color;
        this.scale = scale;
        
        
    }
   
    
}
