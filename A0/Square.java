public class Square {

    private MyPoint corner;
    private double length;

    public Square(MyPoint corner, double length){
        this.corner = corner;
        this.length = length;
    }

    public MyPoint getCorner(){
        return this.corner;
    }

    public double getLength(){
        return this.length;
    }

    public void translateX(double x){
        this.corner.translateX(x);
    }

}
