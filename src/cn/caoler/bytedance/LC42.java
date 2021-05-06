package cn.caoler.bytedance;

/**
 * @author keji
 * @desc
 * @date 2021/3/23 3:29 下午
 */
public class LC42 {

    /**
     * 按列求
     * <p>
     * * 1. 较矮的墙的高度大于当前列的墙的高度
     * * 当前的存水值 = 较矮墙的高度减去当前高度
     * *
     * * 2. 较矮的墙的高度小于当前列的墙的高度
     * * 当前的存水值 = 0
     * *
     * * 3. 较矮的墙的高度等于当前列的墙的高度
     * * 当前的存水值 = 0
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum = 0;
        //最左边的列和最右边的列不可能存水 所以直接跳过了，从0-（length-1）
        for (int i = 1; i < height.length - 1; i++) {
            int cur = height[i];

            //找出左边比自己高的列
            int leftMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            //找出右边比自己高的列
            int rightMax = 0;
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            //比较左右 取的较矮的墙，和当前墙做比较
            int min = Math.min(leftMax, rightMax);
            if (min > cur) {
                sum += (min - cur);
            }
        }
        return sum;
    }

    /**
     * 动态规划
     *
     * @param height
     * @return
     */
    public int trapDP(int[] height) {
        int sum = 0;
        //提前把当前位置左边最高的列和右边最高的列存下来，后面就不需要一遍一遍的遍历了
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        //一定要注意下，第 i 列左（右）边最高的墙，是不包括自身的
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 动态规划
     *
     * @param height
     * @return
     */
    public int trapDP2(int[] height) {
        int sum = 0;
        //同方向 优化掉这个数组
        int maxLeft = 0;
        int[] maxRight = new int[height.length];

        //一定要注意下，第 i 列左（右）边最高的墙，是不包括自身的
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            maxLeft = Math.max(maxLeft, height[i - 1]);
            int min = Math.min(maxLeft, maxRight[i]);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }


    /**
     * 双指针
     *
     * @param height
     * @return
     */
    public int trapDP3(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }

}
