package practise.thread.leetcodesolution;

/**
 * @author badgehu
 * @description: TODO
 * @date 2020-05-13 16:22
 */
class FooBar {

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(2);
        new Thread(()-> {
            try {
                fooBar.foo(()-> System.out.println("foo"));
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                fooBar.bar(()-> System.out.println("bar"));
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }).start();
    }

    private int n;
    boolean flag =true;
    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (!flag){
                this.wait();
            }
            flag = !flag;
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            this.notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            if (flag){
                this.wait();
            }
            flag = !flag;
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            this.notifyAll();
        }
    }
}