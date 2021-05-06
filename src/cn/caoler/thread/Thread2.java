package cn.caoler.thread;

/**
 * @author keji
 * @desc 要求线程a执行完才开始线程b, 线程b执行完才开始主线程
 * @date 2021/4/28 3:26 下午
 */
public class Thread2 {
    public static void main(String[] args) {
        Thread a = new Thread("A线程") {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(getName() + ":" + i);
                }
            }
        };
        Thread b = new Thread("b线程") {
            @Override
            public void run() {
                try {
                    a.join();
                } catch (InterruptedException e) {
                }
                for (int i = 1; i <= 10; i++) {
                    System.out.println(getName() + ":" + i);
                }
            }
        };
        a.start();
        b.start();
        try {
            b.join();
        } catch (InterruptedException e) {
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println("main:" + i);
        }
    }
}
