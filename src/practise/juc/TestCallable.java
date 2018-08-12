package practise.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 
 * @author HuXiaoHui
 *	一、创建线程的第三种方式：实现Callable接口。相较于实现Runnable接口的方式，方法可以有返回值，而且可以抛出异常
 *
 *	二、执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果。TutureTask是Future接口的实现类
 */
public class TestCallable {
	public static void main(String[] args) {
		CallableThreadDemo td = new CallableThreadDemo();
		
		//1.执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果
		FutureTask<Integer> result = new FutureTask<>(td);
		
		//FutureTask实现了Runnable，所以可当参数传入Thread的构造器
		new Thread(result).start();
		
		//2.接收线程运算后的结果
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