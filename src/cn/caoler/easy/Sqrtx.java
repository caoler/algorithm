package cn.caoler.easy;

/**
 * @author keji
 * @desc
 * @date 2020/11/3 1:53 下午
 */
public class Sqrtx {
    public int mySqrt(int x) {
        int result = -1, l = 0, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Sqrtx sqrtx = new Sqrtx();
        int i = sqrtx.mySqrt(8);
        System.out.println(i);

    }
}
