package cn.caoler.query;

/**
 * @author keji
 * @desc
 * @date 2020/11/3 1:55 下午
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;

        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) {
                return pivot;
            }
            if (target < nums[pivot]){
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {


    }
}
