package tetsing.namespace;

public class Point {
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "x: " + x + " y: " + y;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return (this.x ==((Point)obj).x)&&(this.y==((Point)obj).y);
	}
}
