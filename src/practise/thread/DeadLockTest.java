package practise.thread;

public class DeadLockTest {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Test(true));
		Thread t2 = new Thread(new Test(false));
		t1.start();
		t2.start();
	}
}
class MyLock{
	static Object locka = new Object();
	static Object lockb = new Object();
}
class Test implements Runnable{
	boolean flag = true;
	Test(boolean flag){
		this.flag = flag;
	}
	@Override
	public void run() {
		if (flag) {
			synchronized (MyLock.locka) {
				System.out.println("if locka");
				synchronized (MyLock.lockb) {
					System.out.println("if lockb");
				}
			}
		}else {
			synchronized (MyLock.lockb) {
				System.out.println("else lockb");
				synchronized (MyLock.locka) {
					System.out.println("else locka");
				}
			}
		}
	}
}

