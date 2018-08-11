package practise.collection;

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
		set.add("ÆëÌì´óÊ¥");
		set.add("Öí¸Õ÷à");
		set.add("É³Ê¦µÜ");
		set.add("°×ÁúÂí");
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println(set);
		Map<String, String> map = new HashMap<String,String>();
		map.put("´óÊ¦ĞÖ", "ËïÎò¿Õ");
		map.put("¶şÊ¦ĞÖ", "Öí¸Õ÷à");
		map.put("ÈıÊ¦µÜ", "É³Îò¾»");
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
