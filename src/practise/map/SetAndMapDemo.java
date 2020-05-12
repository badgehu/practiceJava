package practise.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SetAndMapDemo {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("??????");
		set.add("?????");
		set.add("????");
		set.add("??????");
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println(set);
		Map<String, String> map = new HashMap<String,String>();
		map.put("?????", "?????");
		map.put("?????", "?????");
		map.put("?????", "???");
		//1
		Set<String> keySet = map.keySet();
		for(String str:keySet) {
			System.out.println("key is "+str);
			System.out.println("value is "+map.get(str));
		}
		//2
		Set<Entry<String,String>> entrySet = map.entrySet();
		for(Entry<String, String> entry:entrySet) {
			System.out.println("key is "+entry.getKey()+"value is "+entry.getValue());
		}
		//3
		Collection<String> values = map.values();
		for (String string : values) {
			System.out.println(string);
		}
	}
}
