enum Color {
    WHITE, RED, BLUE
}

enum Type {
    RARE, ORDINARY
}

class ColorException extends Exception {
    public ColorException(String message) {
        super(message);
    }
}

class TypeException extends Exception {
    public TypeException(String name) {
        super(name);
    }

}
class Plant {
    
    private String name;
    private Color color;
    private Type type;
    
    public Plant(String type,String color, String name) throws TypeException, ColorException{
        try {
            
            this.type = Type.valueOf(type.toUpperCase());
            
        } catch (IllegalArgumentException e) {
            
            throw new TypeException("Invalid value " + type + " for field type");
        }
        try {
            
            this.color = Color.valueOf(color.toUpperCase());
            
        } catch (IllegalArgumentException e) {
            
            throw new ColorException("Invalid value " + color + " for field color");
            
        }
        
        this.name = name;
        
    }
    
     public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
    
    
    @Override
    public String toString() {
        return '{' + "type: " + type + ", color: " + color + ", name: " + name + '}';
    }
    
    
    public static Plant tryCreatePlant(String type, String color, String name) {
        Plant plant;
        try {
            plant = new Plant(type, color, name);
        } catch (ColorException e) {
            plant = tryCreatePlant(type, "Red", name);
        } catch (TypeException e) {
            plant = tryCreatePlant("Ordinary", color, name);
        }

        return plant;
    }
    
}
