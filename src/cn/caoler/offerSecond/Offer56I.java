package cn.caoler.offerSecond;

/**
 * @author keji
 * @desc
 * @date 2021/3/19 7:00 上午
 */
public class Offer56I {
    /**
     * 看看题解就懂了
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int k = 0;
        //用于将所有的数异或起来
        //异或后的值  就变成了 a^b的值
        for (int num : nums) {
            k ^= num;
        }

        int mask = 1;
        //找到a和b最低不同的那一位
        //所以用&  如果相同就左移一位
        //如果不同  那么就跳出循环
        while ((mask & k) == 0) {
            mask <<= 1;
        }

        int a = 0, b = 0;
        for (int num : nums) {
            //根据ab不同的那一位，吧所有书分为两组进行异或
            //最后就只剩下了 a,b
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
