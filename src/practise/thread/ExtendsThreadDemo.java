package practise.thread;

public class ExtendsThreadDemo {
	public static void main(String[] args) {
		Object object = new Object();
		TicketThread t1= new TicketThread(object);
		TicketThread t2= new TicketThread(object);
		TicketThread t3= new TicketThread(object);
		TicketThread t4= new TicketThread(object);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class TicketThread extends Thread {
	private int ticket = 100;
	private Object lock;
	public TicketThread(Object obj) {
		lock = obj;
	}
	@Override
	public void run() {
		while(true) {
			synchronized (lock) {
				if (ticket>0) {
					System.out.println(currentThread().getName()+"...sale..."+ticket--);
				}
			}
			
		}
	}
}