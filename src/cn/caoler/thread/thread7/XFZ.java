package cn.caoler.thread.thread7;

/**
 * @author keji
 * @desc
 * @date 2021/4/28 3:54 下午
 */
public class XFZ implements Runnable {
    private Depot ck;

    XFZ(Depot ck) {
        this.ck = ck;
    }

    @Override
    public void run() {
        //不断消费
        while (true) {
            ck.consume();
        }
    }

}