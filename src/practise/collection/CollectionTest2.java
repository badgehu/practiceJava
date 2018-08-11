package practise.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CollectionTest2 {
	public static void main(String[] args) {
		
		CollectionTest2 collectionTest2 = new CollectionTest2();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			int random = (int) (Math.random()*10)+1;
			list.add(random);
		}
		System.out.println(list);
		List<Integer> sortList = collectionTest2.sortList(list);
		for (Integer integer : sortList) {
			System.out.println(integer);
		}
	}
	public List<Integer> sortList(List<Integer> list){
		int[] a = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			a[i] = list.get(i);
		}
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j < a.length-1-i; j++) {
				int tmp=a[j];
				if(tmp>a[j+1]) {
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		}
		list.clear();
		for (int i = 0; i < a.length; i++) {
			list.add(a[i]);
		}
		return list;
	}
}


