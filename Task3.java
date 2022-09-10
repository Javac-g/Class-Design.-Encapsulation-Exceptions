class Operation{
    public static  int squareRectangle (int a, int b) throws IllegalArgumentException{
        if(a <= 0 || b <= 0){
            
            throw new IllegalArgumentException("both arguments should be more than zero");
        }
        else if(a >=0 || b >= 0){
            return a * b ;
        }
        
        return 0;
         
    }
    public static int trySquareRectangle(int a, int b) {
        try{
           if(a <=0 || b<=0){
               return -1;
           }
           return squareRectangle(a,b);
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
        return squareRectangle(a,b);
    }  

    
}
