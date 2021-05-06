package cn.caoler.thread;

import java.util.concurrent.Semaphore;

/**
 * @author keji
 * @desc
 * @date 2021/4/28 3:33 下午
 */
public class Thread3_2 {

    Semaphore a = new Semaphore(2);
    Semaphore b = new Semaphore(0);
    char c = 'A'; // 打印数字

    public void printNumber() {
        try {
            for (int i = 1; i <= 52; i++) {
                a.acquire(1);
                System.out.println(i);
                b.release(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 打印字符
    public void printChar() {
        try {
            for (int i = 1; i <= 26; i++) {
                b.acquire(2);
                System.out.println((char) c++);
                a.release(2);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread3_2 obj = new Thread3_2();
        new Thread(() -> obj.printNumber()).start();
        new Thread(() -> obj.printChar()).start();

    }
}
