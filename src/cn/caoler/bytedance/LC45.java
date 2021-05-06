package cn.caoler.bytedance;

/**
 * @author keji
 * @desc  跳跃游戏
 *
 * 思路是从右往左找，最远能够到达最后一个位置的  向左循环直到到达0
 *
 * https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
 *
 * 第二种解法
 *
 * @date 2021/3/26 9:13 下午
 */
public class LC45 {
    public int jump(int[] nums) {
        //当前指针所在的位置，从最后一位到0
        int position = nums.length - 1;
        
        int step = 0;
        //当前位置是否到0了
        while (position != 0) {

            //从0的位置往当前位置找，找到里当前最远的可以到达当前位置的i
            for (int i = 0; i < position; i++) {

                //如果说i往右可以到达的位置已经超过当前位置了,那么就是找到了
                if (nums[i] >= position - i) {
                    //把当前位置替换成i，继续从头开始找
                    position = i;
                    step++;
                    break;
                }

            }
        }
        return step;
    }
}
