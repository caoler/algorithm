package cn.caoler.offerSecond;

/**
 * @author keji
 * @desc
 * @date 2021/3/18 7:53 上午
 */
public class Offer46 {


    /**
     * 动态规划
     *
     * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/mian-shi-ti-46-ba-shu-zi-fan-yi-cheng-zi-fu-chua-6/
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String s = num + "";
        char[] chs = s.toCharArray();
        int[] dp = new int[chs.length + 1];//ch

        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i <= chs.length;i++){
            dp[i] = dp[i - 1];
            //把两字符拼起来
            int n = (chs[i - 2] - '0') * 10 + (chs[i - 1] - '0');
            if(10 <= n && n <=25 ){
                dp[i] += dp[i -2];
            }
        }
        return dp[chs.length];
    }


    /**
     * 先看这里  先看这里  先看这里  先看这里
     * 看官方的例子
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     * 也就是数字搭配可以是一位，可以是两位（两位情况下要小于26），也就是0-25取值范围
     */
    public int translateNum2(int num) {
//如果num小于10了，也就没有得拆分了，只有一种情况，例如数字 5 ，只有 f 这个字母表示
        if (num < 10) {
            return 1;
        }
        //大于10的情况，就要分情况讨论了
        int re = num % 100;
        if (re < 10) {
            //情况1.：128105 % 100 = 5，那么5这个数字和无法和0合体的。那么去掉他 （num / 10），继续下一轮递归
            return translateNum2(num / 10);
        } else if (re < 26) {
            //情况2.：12810 % 100 = 10 ，可以分成两种情况进行讨论，就是1281 和 128 进行下一轮的递归，也就是对10这两位数选择，可以选择成为ba和k。两种情况
            return translateNum2(num / 10) + translateNum2(num / 100);
        } else {
            //情况.：128 % 100 = 28，这种情况比26大，因为题目要求是字母，28明显比z大了，所以不能像情况2哪样进行拆分成两个递归进行相加
            return translateNum2(num / 10);
        }
    }
}
