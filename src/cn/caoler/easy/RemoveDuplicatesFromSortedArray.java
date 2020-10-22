package cn.caoler.easy;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @date 2020/10/16 10:39 上午
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * 前后指针法
     * 先让i j 指向 0，1 位置
     * 比较，如果ij 不同了，那么i++ 把j位置的数字换到i的位置，  最后会生成一个在前面排列的新数组
     *
     * 描述比较抽象， 还是需要看一下动画解析
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }

        }
        return i + 1;
    }







    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int i = removeDuplicatesFromSortedArray.removeDuplicates1(nums);
        System.out.println(i);
    }

    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

}
