package cn.caoler.easy;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/search-insert-position/
 * @date 2020/10/20 1:40 下午
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,6};
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int i = searchInsertPosition.searchInsert(nums, 7);
        System.out.println(i);
    }
}
