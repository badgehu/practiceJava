package practise.exercise;

/**
 * DFS，BFS，包括其他递归方法，保证其完整正确性首先要具有递归出口； 其次，要考虑递归过程中是否携带
 * “状态记录”，若携带应注意记录的维护（自主维护还是递归栈“自己维护”）。
 * 由此引出一个，编程中的高效思想，即尽可能地不要直接使用形参。提倡方法内将参数进行拷贝，如此有利于
 * 状态与递归层次的对应关系（eg：下面代码中count+1优于count++，后者在回溯时需要--count）；
 * 当然，这不是一个“死规矩”，一些全局状态就需要我们在回溯的时候小心维护————恢复现场。其实操作系统本身
 * 也是如此工作的，保留现场出现在指令中断、函数调用等多种场合。
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