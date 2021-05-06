package cn.caoler.bytedance;

/**
 * @author keji
 * @desc
 * @date 2021/3/28 3:02 下午
 */
public class LC9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String str = String.valueOf(x);
        int left = 0, right = str.length() - 1;
        while (left <= right) {
            char l = str.charAt(left++);
            char r = str.charAt(right--);
            if (l != r) return false;
        }
        return true;
    }
}
