package practise.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author HuXiaoHui
 *	һ��i++��ԭ�������⣺i++ �Ĳ���ʵ���Ϸ�Ϊ�������衰��-��-д��
 *			int i = 10;
 *			i = i++;//10
 *
 *			int temp = i;
 *			i = i+1;
 *			i = temp;
 *����ԭ�ӱ�����jdk1.5�Ժ� java.util.concurrent.atomic�����ṩ�˳��õ�ԭ�ӱ�����
 *			1������volatile����   ��֤�ڴ�ɼ���
 *			2��ʹ��  CAS��Compare-And-Swap���㷨��֤���ݵ�ԭ����
 *				cas�㷨��Ӳ�����ڲ��������������ݵ�֧��
 *				CAS����������������
 *					�ڴ�ֵV
 *					Ԥ��ֵA
 *					����ֵB
 *					���ҽ���V==Aʱ��V=B�����򣬲����κβ���
 */
public class TestAtomicDemo {
	public static void main(String[] args) {
		AtomicDemo ad = new AtomicDemo();
		for (int i = 0; i < 10; i++) {
			new Thread(ad).start();
		}
	}
}
class AtomicDemo implements Runnable{
		
	//private int serialNum = 0;
	private AtomicInteger serialNum = new AtomicInteger();
	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}
		System.out.println(getSerialNum());
	}
	public int getSerialNum() {
		return serialNum.getAndIncrement();
	}

	
}
