package cn.caoler.thread;

import java.util.concurrent.Semaphore;

/**
 * @author keji
 * @desc
 * @date 2021/4/28 3:45 下午
 */
public class Thread4_2 {
    private int flag = 0;

    Semaphore a = new Semaphore(1);
    Semaphore b = new Semaphore(0);
    Semaphore c = new Semaphore(0);

    public void printA() {
        try {
            for (int i = 1; i <= 5; i++) {
                a.acquire();
                System.out.println(Thread.currentThread().getName());
                b.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printB() {
        try {
            for (int i = 1; i <= 5; i++) {
                b.acquire();
                System.out.println(Thread.currentThread().getName());
                c.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printC() {
        try {
            for (int i = 1; i <= 5; i++) {
                c.acquire();
                System.out.println(Thread.currentThread().getName());
                a.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Thread4_2 obj = new Thread4_2();

        // 参数1：Runnable接口 参数2：线程名称
        new Thread(() -> obj.printA(), "线程A").start();
        new Thread(() -> obj.printB(), "线程B").start();
        new Thread(() -> obj.printC(), "线程C").start();
    }

}
