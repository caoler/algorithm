package cn.caoler.thread.thread7;

/**
 * @author keji
 * @desc
 * @date 2021/4/28 3:54 下午
 */
public class SCZ implements Runnable {
    private Depot ck;

    SCZ(Depot ck) {
        this.ck = ck;
    }

    @Override
    public void run() {
        //不断生产
        while (true) {
            ck.profuce();
        }
    }

}
