package cn.caoler.sort;

/**
 * @author keji
 * @desc
 * @date 2021/4/13 8:28 上午
 */
public class Sort {
    public static void quickSort(int[] nums, int l, int r) {
        if(l >= r) return;

        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[l]) {
                j--;
            }
            while (i < j && nums[i] <= nums[l]) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, i, l);
        quickSort(nums, l , i-1);
        quickSort(nums, i+1, r);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String[] args) {
        int[] array = new int[]{5,2,3,1,4};
//        int[] ints = MySort(array);
        quickSort(array, 0, 4);
        for (int anInt : array) {
            System.out.println(anInt);
        }
    }
}
