package cn.caoler.offer;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * 旋转数组
 * @date 2020/11/23 10:18 上午
 */
public class Offer11 {
    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

}
