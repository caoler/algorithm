package cn.caoler.bytedance;

/**
 * @author keji
 * @desc
 * @date 2021/4/1 6:18 上午
 */
public class LC88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        m--;
        n--;
        while(n >= 0) {
            while(m >= 0 && nums1[m] > nums2[n]) {
                swap(nums1[i--], nums1[m--]);
            }
            swap(nums1[i--],nums2[n--]);
        }
    }

    public void swap(int i, int j) {
        int tmp = i;
        i = j;
        j = tmp;
    }
}
