package cn.caoler.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author keji
 * @desc
 * @date 2021/4/28 4:15 下午
 */
public class Thread9_2 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public static void main(String[] args) {
        new Thread(() -> doNum()).start();
        new Thread(() -> doNum()).start();
        new Thread(() -> doNum()).start();
    }

    private static void doNum() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println(i * 10 + j);
            }
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
