package cn.caoler.easy;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/plus-one/
 * @date 2020/10/20 2:36 下午
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int jin = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                digits[i] = ++digits[i];
            }
            digits[i] = digits[i] + jin;
            if (digits[i] > 9) {
                jin = 1;
                digits[i] = 0;
            } else {
                jin = 0;
            }
        }
        if (jin == 1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9,9,9,8};
        PlusOne plusOne = new PlusOne();
        int[] ints = plusOne.plusOne(nums);
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }
    }
}
