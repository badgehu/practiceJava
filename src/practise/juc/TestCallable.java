package practise.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 
 * @author HuXiaoHui
 *	һ�������̵߳ĵ����ַ�ʽ��ʵ��Callable�ӿڡ������ʵ��Runnable�ӿڵķ�ʽ�����������з���ֵ�����ҿ����׳��쳣
 *
 *	����ִ��Callable��ʽ����ҪFutureTaskʵ�����֧�֣����ڽ�����������TutureTask��Future�ӿڵ�ʵ����
 */
public class TestCallable {
	public static void main(String[] args) {
		CallableThreadDemo td = new CallableThreadDemo();
		
		//1.ִ��Callable��ʽ����ҪFutureTaskʵ�����֧�֣����ڽ���������
		FutureTask<Integer> result = new FutureTask<>(td);
		
		//FutureTaskʵ����Runnable�����Կɵ���������Thread�Ĺ�����
		new Thread(result).start();
		
		//2.�����߳������Ľ��
		try {
			Integer sum = result.get();
			System.out.println(sum);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
class CallableThreadDemo implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			System.out.println(i);
			sum += i;
		}
		return sum;
	}
	
}