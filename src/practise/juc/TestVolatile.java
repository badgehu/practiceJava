package practise.juc;

/**
 * 
 * @author HuXiaoHui
 *һ��volatile�ؼ��֣�������߳̽��в�����������ʱ�����Ա����ڴ������ݵĿɼ���
 *				  �����synchronized �����ؽ�Ϊ��������ͬ�����ԡ�
 *
 *ע�⣺
 *	1��volatile ���߱��������ԡ�
 *	2��volatile ���ܱ�֤�����ġ�ԭ���ԡ�
 */
public class TestVolatile {
	public static void main(String[] args) {
		ThreadDemo tDemo1=new ThreadDemo();
		new Thread(tDemo1).start();
		while(true) {
			if (tDemo1.isFlag()) {
				//���߳���flag��volatile����ʱ��������
				System.out.println("---------------");
				break;
			}
		}
	}
}
class ThreadDemo implements Runnable{
	//volatile�ؼ��ֿ��Ա�֤��������Ŀɼ��ԣ�����һ���߳����޸ĸ����ݣ���һ���߳̿��������֪
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
