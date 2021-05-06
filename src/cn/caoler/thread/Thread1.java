package cn.caoler.thread;

/**
 * @author keji
 * @desc 两个线程轮流打印数字，一直到100
 * @date 2021/4/28 3:22 下午
 */
public class Thread1 {
    private static boolean flag = true;
    private static int num = 0;

    public synchronized void print1() {
        while (true)//flag为true时打印
        {
            if (!flag) {
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
            flag = !flag;
            this.notifyAll();
        }
    }

    public synchronized void print2() {
        while (true)//flag为false时打印
        {
            if (flag) {
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
            flag = !flag;
            this.notifyAll();
        }
    }

    public static void main(String[] args) {
        Thread1 obj = new Thread1();
        new Thread(() -> obj.print1()).start();
        new Thread(() -> obj.print2()).start();
    }
}
