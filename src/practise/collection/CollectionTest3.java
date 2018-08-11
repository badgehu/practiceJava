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
		map.put("����", 66);
		map.put("����", 59);
		map.put("����", 69);
		map.put("����", 78);
		map.put("����", 77);
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
 * Comparator������ʵ�� 
 *	int compare(Object o1, Object o2) ����һ���������͵����� 
 * 1) ���Ҫ������������ 
 * 		��o1 С��o2������-1������������ȷ���0��01����02����1�������� 
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

