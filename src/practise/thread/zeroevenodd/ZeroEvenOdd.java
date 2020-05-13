package practise.thread.zeroevenodd;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author badgehu
 * @description: TODO
 * @date 2020-05-13 10:39
 */
class ZeroEvenOdd {
    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd o = new ZeroEvenOdd(6);
        new Thread(()-> {
            try {
                o.zero(x-> System.out.println(x));
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                o.even(x-> System.out.println(x));
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                o.odd(x-> System.out.println(x));
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }).start();
    }

    Semaphore zero = new Semaphore(1);
    Semaphore even = new Semaphore(0);
    Semaphore odd = new Semaphore(0);

    private int n;
    // flag标识执行下一步奇数还是偶数
    boolean flag = true;
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                zero.acquire();
                printNumber.accept(0);
                if (flag){
                    odd.release();
                }else {
                    even.release();
                }
                flag = !flag;
            }
    }
    //偶数
    public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n;i+=2) {
                even.acquire();
                printNumber.accept(i);
                zero.release();
            }
    }
    //奇数
    public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <=n; i+=2) {
                odd.acquire();
                printNumber.accept(i);
                zero.release();
            }
    }
}