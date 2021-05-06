package cn.caoler.thread.thread7;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author keji
 * @desc
 * @date 2021/4/28 3:52 下午
 */
public class Depot {
    //仓库的最大容量
    public static final int MAX = 10;

    //生产者和消费者都使用这个仓库里的商品
    public static final LinkedList<Object> list = new LinkedList<>();

    private final Lock lock = new ReentrantLock();
    //定义仓库状态
    private final Condition empty = lock.newCondition();
    private final Condition full = lock.newCondition();

    //生产者使用的方法
    public void profuce() {
        lock.lock();//上锁
        if (list.size() >= MAX) {
            //生产者进入阻塞状态
            try {
                full.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new Object());
            System.out.println(Thread.currentThread().getName() + "生产了一个商品，存入list中，list中的元素个数为：" + list.size());
        }
        //唤醒所有在list中等待的线程
        empty.signal();
        lock.unlock();
    }

    //消费者使用的方法
    public void consume() {
        lock.lock();
        if (list.size() == 0) {
            //消费者进入阻塞
            try {
                empty.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            list.remove();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "消费了一个商品，list中元素个数为：" + list.size());
        }
        //唤醒所有在list中等待的线程
        full.signalAll();
        lock.unlock();
    }

}
