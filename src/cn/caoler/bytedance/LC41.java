package cn.caoler.bytedance;


/**
 * @author keji
 * @desc 缺失的第一个正数
 * <p>
 * https://leetcode-cn.com/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/
 * <p>
 * 题解 视频一看就懂
 * @date 2021/3/26 7:36 上午
 */
public class LC41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
       /*
       只有在 nums[i] 是 [1, len] 之间的数，并且不在自己应该呆的位置， nums[i] != i + 1 ，
        并且 它应该呆的位置没有被同伴占有（即存在重复值占有）	nums[nums[i] - 1] != nums[i] 的时候才进行交换

        为什么使用 while ？ 因为交换后，原本 i 位置的 nums[i] 已经交换到了别的地方，
        交换后到这里的新值不一定是适合这个位置的，因此需要重新进行判断交换
        如果使用 if，那么进行一次交换后，i 就会 +1 进入下一个循环，那么交换过来的新值就没有去找到它该有的位置
         比如 nums = [3, 4, -1, 1] 当 3 进行交换后， nums 变成 [-1，4，3，1]，
         此时 i == 0，如果使用 if ，那么会进入下一个循环， 这个 -1 就没有进行处理
        */
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    private void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



}
