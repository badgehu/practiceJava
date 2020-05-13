package practise.thread.按序打印;

/**
 * @author badgehu
 * @description: TODO
 * @date 2020-05-13 10:14
 */
class Foo {

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        foo.first(()-> System.out.println("first"));
        foo.second(()-> System.out.println("second"));
        foo.third(()-> System.out.println("third"));
    }

    private volatile int flag=1;
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        flag++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (true){
            if (flag ==2){
                printSecond.run();
                flag++;
                break;
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (true){
            if (flag ==3){
                printThird.run();
                break;
            }
        }
    }
}