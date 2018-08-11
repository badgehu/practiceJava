package practise.juc;
/**
 * 
 * @author HuXiaoHui
 *	ģ�� CAS �㷨
 *	
 *	CAS�㷨�ɳ�Ϊ�����㷨��������Ƶ��������л������û�̬�л�������̬��
 *		��ʡ��Դ	
 *
 *	ʹ��  CAS��Compare-And-Swap���㷨��֤���ݵ�ԭ����
 *				cas�㷨��Ӳ�����ڲ��������������ݵ�֧��
 *				CAS����������������
 *					�ڴ�ֵV
 *					Ԥ��ֵA
 *					����ֵB
 *					���ҽ���V==Aʱ����B��ֵ��ֵ��V��V=B�������򣬲����κβ���
 */
public class TestCompareAndSwap {
	public static void main(String[] args) {
		final CompareAndSwap cas = new CompareAndSwap();
		//�½�ʮ���߳�
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
	//��ȡ�ڴ���ֵ
	public synchronized int get() {
		return value;
	}
	//�Ƚ�Ȼ�󽻻�
	public synchronized int compareAndSwap(int expectedValue,int newValue) {
		int oldValue = value;
		if(oldValue == expectedValue) {
			this.value = newValue;
		}
		return oldValue;
	}
	//����
	public synchronized boolean compareAndSet(int expectedValue,int newValue) {
		return expectedValue == compareAndSwap(expectedValue, newValue);
	}
}