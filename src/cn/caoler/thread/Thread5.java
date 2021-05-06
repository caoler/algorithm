package cn.caoler.thread;

/**
 * @author keji
 * @desc 编写10个线程，第一个线程从1加到10，第二个线程从11加20…第十个线程从91加到100，最后再把10个线程结果相加。
 * @date 2021/4/28 3:47 下午
 */
public class Thread5 {

    private static int total;

    private static class SubThread extends Thread {
        private int start;
        private int end;

        public SubThread(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            System.out.println(sum);
            total += sum;
        }
    }

    public static void main(String[] args) {
        int start = 1;
        for (int i = 1; i <= 10; i++) {
            int end = start + 9;
            SubThread t = new SubThread(start, end);//System.out.println(start+","+end); //测试传入的参数是否正确
            t.start();
            start = end + 1;
            try {
                t.join(); //main线程让所有的子线程全部执行完了，才输出结果
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("最后的总和:" + total);
    }
}
