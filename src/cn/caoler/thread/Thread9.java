package cn.caoler.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author keji
 * @desc
 * @date 2021/4/28 3:58 下午
 */
public class Thread9 {
    int num1 = 0,num2 = 0,num3 = 0;

    Semaphore a = new Semaphore(1);
    Semaphore b = new Semaphore(0);
    Semaphore c = new Semaphore(0);

    public void printA() {
        try {
            a.acquire();
            for (int i = 1; i <= 10 && num1 <= 100; i++) {
                System.out.println("A:"+ i);
                num1 += 1;
            }
            b.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printB() {
        try {
            b.acquire();
            for (int i = 1; i <= 10 && num2 <= 100; i++) {
                System.out.println("B:"+ i);
                num2 += 1;
            }
            c.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printC() {
        try {
            c.acquire();
            for (int i = 1; i <= 10 && num2 <= 100; i++) {
                System.out.println("c:"+ i);
                num2 += 1;
            }
            a.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Thread9 obj = new Thread9();

        // 参数1：Runnable接口 参数2：线程名称
        new Thread(() -> obj.printA()).start();
        new Thread(() -> obj.printB()).start();
        new Thread(() -> obj.printC()).start();
    }
}
