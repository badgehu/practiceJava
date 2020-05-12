package practise.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		  map.put("1", "value1");
		  map.put("2", "value2");
		  map.put("3", "value3");
		  
		  //???????????ã???????
		  System.out.println("???Map.keySet????key??value??");
		  for (String key : map.keySet()) {
		   System.out.println("key= "+ key + " and value= " + map.get(key));
		  }
		  
		  //?????
		  System.out.println("???Map.entrySet???iterator????key??value??");
		  Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		  while (it.hasNext()) {
		   Map.Entry<String, String> entry = it.next();
		   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		  }
		  
		  //?????????????????????????
		  System.out.println("???Map.entrySet????key??value");
		  for (Map.Entry<String, String> entry : map.entrySet()) {
		   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		  }
		 
		  //??????
		  System.out.println("???Map.values()?????????value???????????key");
		  for (String v : map.values()) {
		   System.out.println("value= " + v);
		  }

	}
}
