package cn.caoler.offer;

/**
 * @author keji
 * @desc
 * @date 2020/11/25 10:56 上午
 */
public class Offer21 {
    /**
     * 奇数在前,挨个遍历
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        int[] res = new int[nums.length];
        int a = 0;
        int b = nums.length - 1;
        for (int num : nums) {
            //偶数
            if (num % 2 == 0) {
                res[b] = num;
                b--;
            } else {
                res[a] = num;
                a++;
            }
        }
        return res;
    }

    public static int[] exchange2(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int tmp;

        while (i < j) {
            //是奇数
            while(i < j && (nums[i] & 1) == 1) {
                i++;
            }
            //是偶数
            while(i < j && (nums[j] & 1) == 0) {
                j--;
            }
            //交换
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return null;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] exchange = exchange(nums);
        System.out.println(exchange);
    }
}
