package cn.caoler.thread;

/**
 * @author keji
 * @desc 交替打印自己
 * @date 2021/4/28 3:36 下午
 */
public class Thread4 {

    private int flag = 0;

    public synchronized void printA() {
        for (int i = 0; i < 5; i++) {
            if (flag == 1 || flag == 2) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName());
            flag = 1;
            this.notifyAll();
        }
    }

    public synchronized void printB() {
        for (int i = 0; i < 5; i++) {
            if (flag == 0 || flag == 2) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName());
            flag = 2;
            this.notifyAll();
        }
    }

    public synchronized void printC() {
        for (int i = 0; i < 5; i++) {
            if (flag == 0 || flag == 1) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName());
            flag = 0;
            this.notifyAll();
        }
    }


    public static void main(String[] args) {
        Thread4 obj = new Thread4(); //参数1：Runnable接口  参数2：线程名称
        new Thread(() -> obj.printA(), "线程A").start();
        new Thread(() -> obj.printB(), "线程B").start();
        new Thread(() -> obj.printC(), "线程C").start();
    }
}
