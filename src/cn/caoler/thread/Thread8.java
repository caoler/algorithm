package cn.caoler.thread;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

/**
 * @author keji
 * @desc 交替打印两个数组
 * @date 2021/4/28 3:56 下午
 */
public class Thread8 {

    static int[] arr1 = new int[10];
    static int[] arr2 = new int[10];

    static {
        int x = 0;
        int y = 1;
        for (int i = 0; i < 10; i++) {
            arr1[i] = x;
            x += 2;
            arr2[i] = y;
            y += 2;
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    Semaphore arr11 = new Semaphore(1);
    Semaphore arr22 = new Semaphore(0);

    public void printArr1() {
        try {
            for (int i = 0; i < arr1.length; i++) {
                arr11.acquire(1);
                System.out.println(arr1[i]);
                arr22.release(1);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void printArr2() {
        try {
            for (int i = 0; i < arr2.length; i++) {
                arr22.acquire(1);
                System.out.println(arr2[i]);
                arr11.release(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread8 obj = new Thread8();
        new Thread(() -> obj.printArr1(), "arr1").start();
        new Thread(() -> obj.printArr2(), "arr2").start();
    }

}
