package practise.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionDamn {
	public static void main(String[] args) {
		CollectionDamn collectionDamn = new CollectionDamn();
		//System.out.println(collectionDamn.getRandomString());
		System.out.println(collectionDamn.getRandomStrings().toString());
	}
	public List<Character> getCharacter(){
		List<Character> list = new ArrayList<>();
		for (char i = 'a'; i <= 'z'; i++) {
			list.add(i);
		}
		for (char i = 'A'; i <= 'Z'; i++) {
			list.add(i);
		}
		for (char i = '0'; i <= '9'; i++) {
			list.add(i);
		}
		return list;
	}
	public String getRandomString() {
		Set<Character> set = new HashSet<>();
		List<Character> list = getCharacter();
		while (set.size()<10) {
			Character ch = list.get((int) (Math.random()*list.size()));
			set.add(ch);
		}
		StringBuffer stringBuffer = new StringBuffer();
		for (Character character : set) {
			stringBuffer.append(character);
		}
		return stringBuffer.toString();
	}
	public List<String> getRandomStrings(){
		Set<String> set = new HashSet<>();
		
		while (set.size()<10) {
			String randomStr = getRandomString();
			set.add(randomStr);
		}
		List<String> list = new ArrayList<>();
		list.addAll(set);
		return list;
	}
}

