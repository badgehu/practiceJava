package practise.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionDemo {
	public static void main(String[] args) {
		Collection collection = new ArrayList();
		collection.add("girl");
		collection.add("boy");
		collection.add("man");
		collection.add("woman");
		collection.add("girl");
		collection.add("boy");
		collection.add("others");
		Iterator iterator = collection.iterator();
		/*iterator.hasNext() 
		iterator.next()
		iterator.remove();*/
		/*while(iterator.hasNext()) {
			String str = (String) iterator.next();
			
			System.out.println(str);
		}*/
		
		while(iterator.hasNext()) {
			String s = (String) iterator.next();
			if(s.equals("boy")) {
				iterator.remove();
			}
		}
		System.out.println(collection);
	}
	public List getSingleList(List list) {
		List temp = new ArrayList();
		Iterator iterator = list.iterator();
		while(iterator.hasNext()) {
			String str = (String) iterator.next();
			if(temp.contains(str)) {
				continue;
			}
			temp.add(str);
		}
		list.clear();
		list.addAll(temp);
		return list;
	}
}
