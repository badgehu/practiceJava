package practise.array;

public class ArrayDemo {
	
	public static void main(String[] args) {
		int[] array = new int[] {23,2,45,346,12,34,25};
		ArrayDemo arrayDemo = new ArrayDemo();
		//int[] a = arrayDemo.delDataByIndex(array, 2);
		int[] a = arrayDemo.bubbleSort(array);
		//int[] a = arrayDemo.reverseArray(array); 
		for (int i : a) {
			System.out.println(i);
		}
	}
	/**
	 * 删除指定位置数据
	 * @param a
	 * @param index
	 * @return
	 */
	public int[] delDataByIndex(int[] a,int index) {
		int[] b = new int[a.length-1];
		for (int i = index; i < a.length-1; i++) {
			a[i] = a[i+1]; 
		}
		for(int j=0;j<b.length;j++) {
			b[j] = a[j];
		}
		return b;
	}
	/**
	 * 冒泡排序
	 * @param a
	 * @return
	 */
	public int[] bubbleSort(int[] a) {
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j < a.length-1-i; j++) {
				int tmp=a[j];
				if(tmp>a[j+1]) {
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		}
		return a;
	}
	/**
	 * 数组逆序输出
	 * @param a
	 * @return
	 */
	public int[] reverseArray(int[] a) {	
		for (int start = 0,end = a.length-1; start < end; start++,end--) {
				int tmp=a[start];
				a[start] = a[end];
				a[end] = tmp;
		}
		return a;
	}
}
