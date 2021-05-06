package cn.caoler.bytedance;

import java.util.Arrays;

/**
 * @author keji
 * @desc
 * @date 2021/3/25 8:46 下午
 */
public class LC135 {
    public int candy(int[] ratings) {
        //记录从左到右要发的糖果数量
        int[] left = new int[ratings.length];
        //记录从右到左的
        int[] right = new int[ratings.length];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        //从左往右
        for (int i = 1; i < ratings.length; i++) {
            //如果下一个比前一个的成绩高  那么就要多发一个
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        //记录最后一个孩子发的数量
        int count = left[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
            //既要满足从左往右的需求，又要满足从右往左的需求
            //所以这边必须取最大值，否则只能满足一方面的
            count += Math.max(left[i], right[i]);
        }
        return count;
    }
}
