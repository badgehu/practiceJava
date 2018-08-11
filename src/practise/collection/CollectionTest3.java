package practise.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionTest3 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("张三", 66);
		map.put("李四", 59);
		map.put("王五", 69);
		map.put("赵六", 78);
		map.put("孙七", 77);
		Set<String> keySet = map.keySet();
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<>();
		list.addAll(entrySet);
		ValueComparator valueComparator = new ValueComparator();
		Collections.sort(list, valueComparator);
		Iterator<Entry<String, Integer>> iterator = list.iterator();
		for (Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey());
		}
		
	}
}
/**
 * Comparator升序降序实现 
 *	int compare(Object o1, Object o2) 返回一个基本类型的整型 
 * 1) 如果要按照升序排序， 
 * 		则o1 小于o2，返回-1（负数），相等返回0，01大于02返回1（正数） 
 * @author HuXiaoHui
 *
 */
class ValueComparator implements Comparator<Entry<String, Integer>>{

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		// TODO Auto-generated method stub
		return o2.getValue().compareTo(o1.getValue());
	}


	
}

