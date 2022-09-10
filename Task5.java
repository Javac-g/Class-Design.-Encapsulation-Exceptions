import static java.lang.Math.sqrt;
class Point {

    private int x,y;
    Point point;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getXYPair(){
        return new int[]{x,y};
    }
    public double distance(int x, int y){
        return Math.sqrt( (this.x-x)*(this.x -x) + (this.y -y)*(this.y - y));
    }
    public double distance(Point point){
        this.point = point;
        int[] xy = point.getXYPair();
        return distance(xy[0],xy[1]);
    }
    public double distance(){
        return distance(0,0);
    }

}
