package tetsing.namespace;

import java.util.ArrayList;
import java.util.HashSet;

public class Utils {

	public static HashSet<Integer> factorization(int val, int x, int y) {
		HashSet<Integer> res = new HashSet<>();
		// res.add(1);
		for (int i = 2; i <= Math.max(x, y); i++) {
			if (val % i == 0) {
				res.add(i);
				res.add(val / i);
			}
		}
		return res;
	}

	public static int[]  leftUpperCorner(boolean[][] mas) {
		int[] luc = null;
		for (int j = 0; j < mas[0].length; j++) {
			for (int i =0; i< mas.length;i++) {
				if (!mas[i][j]) {
					luc = new int[] { j, i };
					return luc;
				}
			}
		}
		return luc;
	}

	public static  boolean includeOneVacancy(boolean[][] mas, ArrayList<Point> vacancies, Rectangle rec) {
		boolean result = false;
		byte count = 0;
		for (Point p : vacancies) {
			if (p.x >= rec.point.x && p.x < rec.point.x + rec.width && p.y >= rec.point.y
					&& p.y < rec.point.y + rec.height)

				count++;
		}
		if (count == 1)
			result = true;
		return result;
	}

	public static void paint(boolean[][] mas, Rectangle r, boolean color) {
		for (int i = r.point.y; i < r.point.y + r.height; i++) {
			for (int j = r.point.x; j < r.point.x + r.width; j++) {
				mas[i][j] = color;
			}
		}
	}

	public static  boolean fill(boolean mas[][], ArrayList<Rectangle> rect, ArrayList<Rectangle> answer, ArrayList<Point> vacansies) {
		int[] corner = new int[2];
		int[] innerCorner = new int[2];
		corner = leftUpperCorner(mas);
		innerCorner = corner;

		if (corner == null)
			return true;

		for (Rectangle r : rect) {
			r.point = new Point(innerCorner[0], innerCorner[1]);
			if (corner[0] + r.width <= mas[0].length && corner[1] + r.height <= mas.length
					&& includeOneVacancy(mas, vacansies, r)) {
				
				paint(mas, r, true);
				if (fill(mas, rect, answer, vacansies)) {

					Point p = new Point(innerCorner[0], innerCorner[1]);

					answer.add(new Rectangle(r.width, r.height, p));
					return true;
				}else {
					r.point = new Point(innerCorner[0], innerCorner[1]);
					paint(mas,r , false);
				}
			}	
		}
		return false;
		

	}
}
