package practise.exercise;

/**
 * DFS��BFS�����������ݹ鷽������֤��������ȷ������Ҫ���еݹ���ڣ� ��Σ�Ҫ���ǵݹ�������Ƿ�Я��
 * ��״̬��¼������Я��Ӧע���¼��ά��������ά�����ǵݹ�ջ���Լ�ά��������
 * �ɴ�����һ��������еĸ�Ч˼�룬�������ܵز�Ҫֱ��ʹ���βΡ��ᳫ�����ڽ��������п��������������
 * ״̬��ݹ��εĶ�Ӧ��ϵ��eg�����������count+1����count++�������ڻ���ʱ��Ҫ--count����
 * ��Ȼ���ⲻ��һ��������ء���һЩȫ��״̬����Ҫ�����ڻ��ݵ�ʱ��С��ά�����������ָ��ֳ�����ʵ����ϵͳ����
 * Ҳ����˹����ģ������ֳ�������ָ���жϡ��������õȶ��ֳ��ϡ�
 */

import java.util.Scanner;

public class AliTestMain {
	static final Point START = new Point(0, 0);
	static int minpath = Integer.MAX_VALUE;

	private static int min = 1000;
	public static final Point start = new Point(0, 0);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = Integer.valueOf(sc.nextLine());
		Point[] points = new Point[a];
		for (int i = 0; i < a; i++) {
			String pointXY = sc.nextLine();
			String[] split = pointXY.split(",");
			points[i] = new Point(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
		}
		int min = calculate(START, points, 0, 0);
		System.out.println(min);
	}
	
	public static int calculate(Point point, Point[] points, int sum, int count) {
		for (int i = 0; i < points.length; i++) {
			if (points[i].visited == false) {
				points[i].visited = true;
				count++;
				sum += point.getLength(points[i]);
				if (count == points.length) {
					sum += points[i].getLength(start);
					if (sum < min) {
						min = sum;
					}
				}
				calculate(points[i], points, sum, count);
				points[i].visited = false;
				sum -= point.getLength(points[i]);
				count--;
			}
		}
		return min;
	}
}
class Point {
	int px;
	int py;
	boolean visited;

	public Point(int px, int py) {
		this.px = px;
		this.py = py;
		this.visited = false;
	}

	public int getLength(Point p) {
		return Math.abs(px - p.px) + Math.abs(py - p.py);
	}
}