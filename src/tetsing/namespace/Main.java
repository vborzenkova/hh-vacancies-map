package tetsing.namespace;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	static byte mainWidth = 0;
	static byte mainHeight = 0;
	static ArrayList<Rectangle> answer = new ArrayList<>();

	public static void main(String[] args) {
		ArrayList<Point> vacansies = new ArrayList<>(10);
		try (Scanner scan = new Scanner(System.in)) {
			int i = 0;
			String s;
			
			while (((s = scan.nextLine()).length() != 0)) {
				int k = -1;
				while ((k = s.indexOf('0', k + 1)) != -1) {
					vacansies.add(new Point( k, i));
				}
				i++;
				mainWidth = (byte) s.length();
				mainHeight = (byte) i;
			}		
			
		}
		
		boolean[][] boolMas = new boolean[mainHeight][mainWidth];


		Rectangle mainRec = new Rectangle(mainWidth, mainHeight, new Point((byte)0,(byte)0));
		
		
		if(mainRec.square()%vacansies.size()!=0) {
			return;
			}
		
		int square = mainRec.square()/vacansies.size();
		HashSet<Integer> factorization = Utils.factorization(square,mainWidth, mainHeight);
		Integer[] mas = new Integer[factorization.size()];
		factorization.toArray(mas);
		
		ArrayList<Rectangle> rects = new ArrayList<>();
		
		for(int i=0; i<mas.length/2; i++) {
			Rectangle r = new Rectangle(mas[mas.length -i-1].intValue(), mas[i].intValue());
			rects.add(r);
		}
		for(int i=mas.length/2-1; i>=0; i--) {
			Rectangle r1 = new Rectangle(mas[i].intValue(),mas[mas.length -i-1].intValue());
			rects.add(r1);
		}
		
		Utils.fill(boolMas, rects, answer, vacansies);
		
		for(int i=answer.size()-1; i>=0; i--) {
			answer.get(i).printVacancyMask(vacansies);
			System.out.println();
		}
		
		
		
		
	}
	


}
