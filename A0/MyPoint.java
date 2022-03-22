public class MyPoint {

	private double x;
	private double y;
	
	public MyPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void translateX(double x) {
		this.x += x;
	}
	
}
