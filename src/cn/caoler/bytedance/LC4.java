package cn.caoler.bytedance;

/**
 * @author keji
 * @desc 寻找两个正序数组的中位数
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 *
 * @date 2021/3/23 8:25 下午
 */
public class LC4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {

                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        //合并
        int count = 0;
        //i标记nums1的位置，j标记nums2的位置
        int i = 0, j = 0;
        while (count != (m + n)) {
            //如果i走到了nums1的最后一个位置
            if (i == m) {
                //如果j还没走动nums2的最后一个位置，直接全部把nums2遍历结束
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }

            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            //比较下哪个小 哪个放前面
            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            }else {
                nums[count++] = nums2[j++];
            }
        }

        //合并完求中位数
        if (count % 2 ==0) {
            return (nums[count/2 -1] + nums[count/2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }
}
