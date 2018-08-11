package practise.string;

public class StringDemo {
	public static void main(String[] args) {
		String str = "llevell";
		StringDemo stringDemo = new StringDemo();
		//1
		boolean isHuiWen = stringDemo.checkHuiWen(str);
		System.out.println(isHuiWen);
		//2
		String str1= "this is a test of java";
		int s = stringDemo.countChar(str1, 's');
		System.out.println(s);
		//(2)
		String test = str1.substring(10, 14);
		System.out.println(test);
		//(4)
		String[] strArray = str1.split(" ");
		for(String str2:strArray) {
			String str3 = str2.substring(0, 1).toUpperCase()+str2.substring(1);
			System.out.print(str3+" ");
		}
		System.out.println();
		//(5)
		System.out.println(new StringBuffer(str1).reverse());
		char[] ch1 = stringDemo.reverseStringArray(str1);
		System.out.println(ch1);
		//(6)
		String[] strArray1 = str1.split(" ");
		for(String str2:strArray1) {
			System.out.println(str2);
		}
		//3
		String str3 = "adsbyyfbyykabyydkfjabyydklfjabyylkdjf";
		String key ="byy";
		int count = stringDemo.countKey(str3, key);
		System.out.println(count);
	}
	public boolean checkHuiWen(String str) {
		char[] ch = str.toCharArray();
		for (int start = 0,end=ch.length-1; start < end; start++,end--) {
			if(ch[start]==ch[end]) {
				return true;
			}
			else
				return false;
		}
		return false;
	}
	public int countChar(String str,char s) {
		char[] ch = str.toCharArray();
		int count = 0;
		for(char c : ch) {
			if(c==s) {
				count++;
			}
		}
		return count;
	}
	public char[] reverseStringArray(String str) {	
		char[] ch = str.toCharArray();
		for (int start = 0,end = ch.length-1; start < end; start++,end--) {
				char tmp=ch[start];
				ch[start] = ch[end];
				ch[end] = tmp;
		}
		return ch;
	}
	public int countKey(String str,String key) {
		int count = 0 ; 
        int index = 0 ; 
        while ((index = str.indexOf(key)) != -1) {
            System.out.println(str);
            str = str.substring(index+key.length());
            count++;
        }
        return count ;
	}
}
