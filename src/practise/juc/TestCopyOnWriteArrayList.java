package practise.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * 
 * @author HuXiaoHui
 *	CopyOnWriteArrayList/CopyOnWriteArraySet	“写入并复制”
 *	注意：添加操作多时，效率低，因为每次添加都会进行赋值。开销非常大。
 *	所以，在并发迭代操作多时可以选择，可以提高效率
 */
public class TestCopyOnWriteArrayList {
	public static void main(String[] args) {
		HelloThread ht = new HelloThread();
		for (int i = 0; i < 10; i++) {
			new Thread(ht).start();
		}
	}
}
class HelloThread implements Runnable{
	
	//当使用普通的List时，在迭代时，进行增加操作。会抛ConcurrentModificationException
	//private static List<String> list = Collections.synchronizedList(new ArrayList<String>());
	
	//使用CopyOnWriteArrayList时不会抛出异常
	private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
	static {
		list.add("AA");
		list.add("BB");
		list.add("CC");
	}
	@Override
	public void run() {
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			list.add("AA");
		}
	}
	
}