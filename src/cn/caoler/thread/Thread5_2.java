package cn.caoler.thread;

import java.util.concurrent.*;

/**
 * @author keji
 * @desc
 * @date 2021/4/28 3:47 下午
 */
public class Thread5_2 {

    //call方法，有返回值，和run方法的区别，在于可以把子线程做的任务最终的结果返回
    private static class SubThread implements Callable<Long> {
        private int start;
        private int end;

        public SubThread(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Long call() throws Exception {
            long sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }

    }

    public static void main(String[] args) {
        try {
            //创建一个线程池，初始会有10个线程对象
            ExecutorService pool = Executors.newFixedThreadPool(10);
            System.out.println(pool);
            long total = 0;
            int start = 1;
            for (int i = 1; i <= 10; i++) {
                int end = start + 9;
                // System.out.println(start+","+end); //测试传入的参数是否正确
                Future<Long> future = pool.submit(new SubThread(start, end));
                start = end + 1;
                System.out.println(future.get());
                total += future.get();
            }
            System.out.println("最终的结果：" + total);
            pool.shutdown();//关闭线程池
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
