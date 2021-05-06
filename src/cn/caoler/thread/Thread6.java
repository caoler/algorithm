package cn.caoler.thread;

/**
 * @author keji
 * @desc 三个窗口同时卖票
 * @date 2021/4/28 3:48 下午
 */
public class Thread6 {
    String name;
    int num = 100;

    public Thread6(String name, int num) {
        super();
        this.name = name;
        this.num = num;
    }

    public void sale() {
        while (true) {
            synchronized (this) {
                if (num <= 0) {
                    System.out.println("卖完了");
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + "卖出了一张票");
                    System.out.println("剩余" + --num + "张票");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


class Window implements Runnable {
    private Thread6 ticket;


    public Window(Thread6 ticket) {
        super();
        this.ticket = ticket;
    }


    @Override
    public void run() {
        ticket.sale();
    }
}

class T6 {
    public static void main(String[] args) {
        //创建一场电影票
        Thread6 t = new Thread6("hk", 100);

        new Thread(new Window(t), "窗口A").start();
        new Thread(new Window(t), "窗口B").start();
        new Thread(new Window(t), "窗口C").start();
    }

}
