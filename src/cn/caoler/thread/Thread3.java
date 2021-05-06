package cn.caoler.thread;

import java.util.concurrent.Semaphore;

/**
 * @author keji
 * @desc 写两个线程，一个线程打印1~ 52，另一个线程打印A~Z，打印顺序是12A34B...5152Z
 * @date 2021/4/28 3:28 下午
 */
public class Thread3 {
    private int count = 2;

    private int num = 1;

    private char a = 'A';

    // 打印数字
    public synchronized void printNumble() {
        for (int i = 1; i < 53; i++) {
            while (true) {
                while (count == 0) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(num++);
                count--;// 输出两次
                this.notifyAll();
            }
        }
    }

    // 打印数字
    public synchronized void printChar() {
        while (true) {
            while (count != 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println((char) a++);
            count += 2;
            this.notifyAll();
        }
    }

    public static void main(String[] args) {
        Thread3 obj = new Thread3();
        new Thread(() -> obj.printNumble()).start();
        new Thread(() -> obj.printChar()).start();

    }




}
