package practise.thread.leetcodesolution;

import java.util.concurrent.Semaphore;

/**
 * @author badgehu
 * @description: TODO
 * @date 2020-05-13 15:15
 */
class DiningPhilosophers {

    public DiningPhilosophers() {

    }
    private volatile Semaphore[] forks = new Semaphore[]{
            new Semaphore(1),
            new Semaphore(1),
            new Semaphore(1),
            new Semaphore(1),
            new Semaphore(1),
    };
    //同时只允许4个哲学家吃饭，防止死锁
    Semaphore semaphore = new Semaphore(4);

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        // 左边叉子位置
        int leftfork = philosopher;
        // 右边叉子位置
        int rightfork = (philosopher+1) % 5;

        semaphore.acquire();
        forks[leftfork].acquire();
        forks[rightfork].acquire();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();

        putLeftFork.run();
        putRightFork.run();

        forks[leftfork].release();
        forks[rightfork].release();
        semaphore.release();
    }
}