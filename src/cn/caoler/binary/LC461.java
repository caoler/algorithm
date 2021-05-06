package cn.caoler.binary;

/**
 * @author keji
 * @desc
 * @date 2021/3/22 9:27 下午
 */
public class LC461 {
    public int hammingDistance(int x, int y) {
        int xoy = x ^ y;
        int distance = 0;
        while (xoy != 0) {
            if ((xoy & 1) == 1) {
                distance++;
            }
            xoy >>= 1;
        }
        return distance;
    }
}
