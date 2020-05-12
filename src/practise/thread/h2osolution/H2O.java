package practise.thread.h2osolution;

import java.util.concurrent.Semaphore;

/**
 * @author badgehu
 * @description: TODO
 * @date 2020-05-12 11:54
 */
class H2O {

    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(0);


    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        h.release(2);
    }

    public static void main(String[] args) {
        H2O h2O = new H2O();
        int n = 5;
        new Thread(() -> {
            for (int i = 0; i < 2 * n; i++) {
                try {
                    h2O.hydrogen(
                            () -> System.out.println("H")
                    );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < n; i++) {
                try {
                    h2O.oxygen(
                            () -> System.out.println("O")
                    );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
