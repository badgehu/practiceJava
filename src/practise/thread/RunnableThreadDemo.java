package practise.thread;


public class RunnableThreadDemo{
	public static void main(String[] args) {
		
		Ticket t = new Ticket();
		Thread thread1 = new Thread(t);
		Thread thread2 = new Thread(t);
		Thread thread3 = new Thread(t);
		Thread thread4 = new Thread(t);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}

/*
 *
 * 问题原因：
	当多条语句 在操作（同一个线程共享数据）时，一个线程对多条语句只执行了一部分，还没有执行完
	另一个线程就参与进来执行，导致共享数据的错误
解决办法：
	对多条操作共享数据的语句，只能让一个线程都执行完。在执行过程中，其他线程不可以参与执行。
Java提供的解决的方式：
	同步代码块
	synchronized（对象）{
		需要被同步的代码
	}
同步的前提：
	1、必须要有两个或这两个以上的线程。
	2、必须多个线程使用同一个锁
必须保证同步中只能有一个线程在运行

好处：
	解决了线程安全的问题
弊端：
	多个线程需要判断锁，较为消耗资源
	
*/
class Ticket implements Runnable{
	private int ticket = 100;//多线程共享数据
	Object obj = new Object();
	@Override
	public void run() {
		while (true) {
			//加了同步锁、也叫监视器
			//没有持有锁的线程，即使获取了cpu执行权，也进不去。因为没有获取锁（监视器）
			synchronized (obj) {
				if (ticket>0) {
					try {
						//打印出0，-1等错票
						//出现线程安全问题
						Thread.sleep(10);
						System.out.println(Thread.currentThread().getName()+".....sale..."+ticket--);

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
	}
}

