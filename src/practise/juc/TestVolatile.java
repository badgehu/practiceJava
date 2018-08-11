package practise.juc;

/**
 * 
 * @author HuXiaoHui
 *一、volatile关键字：当多个线程进行操作共享数据时，可以保存内存中数据的可见。
 *				  相对于synchronized 是以重较为轻量级的同步策略。
 *
 *注意：
 *	1、volatile 不具备“互斥性”
 *	2、volatile 不能保证变量的“原子性”
 */
public class TestVolatile {
	public static void main(String[] args) {
		ThreadDemo tDemo1=new ThreadDemo();
		new Thread(tDemo1).start();
		while(true) {
			if (tDemo1.isFlag()) {
				//当线程中flag用volatile修饰时，可运行
				System.out.println("---------------");
				break;
			}
		}
	}
}
class ThreadDemo implements Runnable{
	//volatile关键字可以保证共享变量的可见性，若在一个线程中修改该数据，另一个线程可以立马得知
	private volatile boolean flag = false;
	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		flag = true;
		System.out.println("Flag="+ isFlag());
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
