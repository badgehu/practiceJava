package practise.juc;
/**
 * 
 * @author HuXiaoHui
 *	模拟 CAS 算法
 *	
 *	CAS算法可称为无锁算法，不会设计到上下文切换，从用户态切换到核心态。
 *		节省资源	
 *
 *	使用  CAS（Compare-And-Swap）算法保证数据的原子性
 *				cas算法是硬件对于并发操作共享数据的支持
 *				CAS包含了三个操作数
 *					内存值V
 *					预估值A
 *					更新值B
 *					当且仅当V==A时，把B的值赋值给V（V=B），否则，不做任何操作
 */
public class TestCompareAndSwap {
	public static void main(String[] args) {
		final CompareAndSwap cas = new CompareAndSwap();
		//新建十个线程
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int expectedValue =  cas.get();
					boolean b = cas.compareAndSet(expectedValue, (int)(Math.random()*100));
					System.out.println(b);
				}
			}).start();
		}
	}
}
class CompareAndSwap{
	private int value;
	//获取内存中值
	public synchronized int get() {
		return value;
	}
	//比较然后交换
	public synchronized int compareAndSwap(int expectedValue,int newValue) {
		int oldValue = value;
		if(oldValue == expectedValue) {
			this.value = newValue;
		}
		return oldValue;
	}
	//设置
	public synchronized boolean compareAndSet(int expectedValue,int newValue) {
		return expectedValue == compareAndSwap(expectedValue, newValue);
	}
}