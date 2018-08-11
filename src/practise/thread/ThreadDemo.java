package practise.thread;

public class ThreadDemo {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Thread1());
		Thread t2 = new Thread(new Thread2());
		t1.start();
		t2.start();
	
	}
	
}
class Thread1 implements Runnable{

	@Override
	public synchronized void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + "..." + i);
			if (i==25) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
class Thread2 implements Runnable{

	@Override
	public synchronized void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName()+"..."+i);
			if (i==25) {
				notifyAll();
			}
			
		}
	}
	
}