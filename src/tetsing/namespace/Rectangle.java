package tetsing.namespace;
import java.util.ArrayList;


public class Rectangle {
	Point point;
	int width;
	int height;
	
	public Rectangle(int width, int height, Point p) {
		point = new Point(p.x, p.y);
		this.width = width;
		this.height =height;	
	}
	public Rectangle(int width, int height) {
		this(width, height, new Point(0,0));
	}
	
	public int square() {
		return width*height;	
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" +width + ", " + height + " ) point:" +point;
	}
	
	public void printVacancyMask(ArrayList<Point> vac) {
		boolean isVacancy = false;
		for(int i=this.point.y; i< this.point.y + height; i++) {
			for(int j=this.point.x; j< this.point.x + width; j++) {
				for(Point v: vac) {
					if(v.x ==j && v.y == i) isVacancy = true;
				}
				System.out.print(isVacancy?"0":".");
				isVacancy = false;
			}
			System.out.println();
		}
	}

}
