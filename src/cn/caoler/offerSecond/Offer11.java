package cn.caoler.offerSecond;

public class Offer11 {
    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    /**
     * 二分查找
     * @param numbers
     * @return
     */
    public int minArray2(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i != j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) {
                i = m + 1;
            } else if (numbers[m] < numbers[j]) {
                j = m;
            } else  {
                //如果二分点和J重合，那么逐渐的缩小范围
                j --;
            }
        }
        return numbers[i];
    }

    /**
     * 先用二分查找，如果到达范围之后二分点和J重合，那么直接改用线性查找，遍历起来更快
     * @param numbers
     * @return
     */
    public int minArray3(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else {
                int x = i;
                for(int k = i + 1; k < j; k++) {
                    if(numbers[k] < numbers[x]) x = k;
                }
                return numbers[x];
            }
        }
        return numbers[i];
    }

}
