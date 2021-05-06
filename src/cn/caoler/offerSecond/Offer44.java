package cn.caoler.offerSecond;

/**
 * @author keji
 * @desc
 * @date 2021/3/17 8:46 下午
 */
public class Offer44 {
    /**
     * https://blog.csdn.net/YouMing_Li/article/details/114580092
     * 直接看题解吧
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        //1.第n位是一个几位数中的某一位
        //i表示是几位数，s表示该位数的数有多少个，如1位数9个，2位数的有90个...
        //base表示一个几位数的起点，如一位数起点是1,二位数起点是10...
        //当输入的n是int的最大值时，位数为9位，此时s *= 10执行九次的话会int越界的，故用long接收
        long i = 1,s = 9,base = 1;
        while(n > i * s){
            n -= i * s;
            i++;
            s *= 10;
            base *= 10;
        }

        //2.看它是几位数的第几个数,然后就可以知道它的数值了(n + i - 1) / i为n/i上取整公式
        long num = base + (n + i - 1) / i - 1;

        //3.确定属于那个数的第几位
        //求余数即可，r = 0 表示是最后一位（也就是 i，几位数就是几），r != 0,则r是几就是第几位
        long r = n % i == 0 ? i : n % i;

        //取出num的第r位，去掉后面的i - r位即可
        //如12345的第三位，后面还有两位45，我们将这两位去掉才好取出顺数的第三位
        for(int j = 1; j <= i - r;j++){
            num /= 10;
        }

        return (int)num % 10;//取出现在的个位就是我们的结果
    }
}
