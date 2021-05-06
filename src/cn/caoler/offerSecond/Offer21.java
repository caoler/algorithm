package cn.caoler.offerSecond;

public class Offer21 {
    public int[] exchange(int[] nums) {
        int[] res = new int[nums.length];
        int a = 0;
        int b = nums.length - 1;

        for (int num : nums) {
            //如果是偶数
            if ((num & 1) == 0) {
                res[b] = num;
                b--;
            } else {
                res[a] = num;
                a++;
            }
        }
        return res;
    }
}
