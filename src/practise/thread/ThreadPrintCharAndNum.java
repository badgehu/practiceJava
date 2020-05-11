package practise.thread;

/**
 * @auther: badgehu
 * @date: 2020/4/19 13:06
 * @description: 多线程打印
 */
public class ThreadPrintCharAndNum {
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        Object o = new Object();
//        t1 = new Thread(()->{
//            for (int i=1;i<=10;i++){
//                System.out.println(i);
//                LockSupport.unpark(t2);
//                LockSupport.park();
//            }
//        });
//        t2 = new Thread(()->{
//            for (int i=65;i<=75;i++){
//                LockSupport.park();
//                System.out.println((char)i);
//                LockSupport.unpark(t1);
//            }
//        });
//        t1.start();
//        t2.start();
        new Thread(()->{
            synchronized (o){
                for (int i=0;i<=100;i++){
                    if (i%2==0){
                        try {
                            System.out.println("threadA:"+i);
                            o.notifyAll();
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(()->{
            synchronized (o){
                for (int i=0;i<=100;i++){
                    if (i%2==1){
                        System.out.println("threadB:"+i);
                        o.notifyAll();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(new CharacterThread(o)).start();
        new Thread(new NumberThread(o)).start();
    }

    static class CharacterThread implements Runnable {
        private Object lock;

        CharacterThread(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 65; i <= 75; i++) {
                    System.out.println((char) i);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 否则无法停止
                lock.notify();
            }
        }
    }

    static class NumberThread implements Runnable {
        private Object lock;

        NumberThread(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 否则无法停止
                lock.notify();
            }
        }
    }

}
