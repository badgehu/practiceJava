package practise.thread.demo;


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
 * ����ԭ��
	��������� �ڲ�����ͬһ���̹߳������ݣ�ʱ��һ���̶߳Զ������ִֻ����һ���֣���û��ִ����
	��һ���߳̾Ͳ������ִ�У����¹������ݵĴ���
����취��
	�Զ��������������ݵ���䣬ֻ����һ���̶߳�ִ���ꡣ��ִ�й����У������̲߳����Բ���ִ�С�
Java�ṩ�Ľ���ķ�ʽ��
	ͬ�������
	synchronized������{
		��Ҫ��ͬ���Ĵ���
	}
ͬ����ǰ�᣺
	1������Ҫ�����������������ϵ��̡߳�
	2���������߳�ʹ��ͬһ����
���뱣֤ͬ����ֻ����һ���߳�������

�ô���
	������̰߳�ȫ������
�׶ˣ�
	����߳���Ҫ�ж�������Ϊ������Դ
	
*/
class Ticket implements Runnable{
	private int ticket = 100;//���̹߳�������
	Object obj = new Object();
	@Override
	public void run() {
		while (true) {
			//����ͬ������Ҳ�м�����
			//û�г��������̣߳���ʹ��ȡ��cpuִ��Ȩ��Ҳ����ȥ����Ϊû�л�ȡ������������
			synchronized (obj) {
				if (ticket>0) {
					try {
						//��ӡ��0��-1�ȴ�Ʊ
						//�����̰߳�ȫ����
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

