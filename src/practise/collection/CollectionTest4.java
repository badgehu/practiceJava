package practise.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionTest4 {
	public static void main(String[] args) {
		String[] str = {"user/add","user/get","user/list",
				"user/edit","role/add","role/get","role/list","staff/add","staff/edit",
				"staff/list"};
		List<String> list = new ArrayList<>();
		List<List<String>> listArray = new ArrayList<>();
		for (String string : str) {
			String[] strs = string.split("/");
			if(!(list.contains(strs[0]))) {
				list.add(strs[0]);
			}
		}
		System.out.println(list);
		for (int i = 0; i <list.size(); i++) {
			listArray.add(new ArrayList<String>());
			for (int j = 0; j < str.length; j++) {
				if(list.get(i).equals(str[j].split("/")[0])) {
					listArray.get(i).add(str[j]);
				}
			}
		}
		System.out.println(listArray.get(0));
		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < listArray.size(); i++) {
			String start = "";
			List<String> list2 = new ArrayList<>();
			for (int j = 0; j <  listArray.get(i).size(); j++) {
				start = listArray.get(i).get(j).split("/")[0];
				String end = listArray.get(i).get(j).split("/")[1];
				list2.add(end);
			}
			map.put(start, list2);
		}
		System.out.println(map);
	}
}
