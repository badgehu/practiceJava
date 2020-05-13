package practise.thread.demo;

public class BankDemo {
	public static void main(String[] args) {
		Cus cus = new Cus();
		Thread t1 = new Thread(cus);
		Thread t2 = new Thread(cus);
		t1.start();
		t2.start();
	}
}
class Bank{
	private int sum;
	public void add(int n) {
		sum = sum + n;
		System.out.println("sum="+sum);
	}
}
class Cus implements Runnable{
	private Bank b = new Bank();
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			b.add(100);
		}
	}
}
