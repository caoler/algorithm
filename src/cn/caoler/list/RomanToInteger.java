package cn.caoler.list;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/roman-to-integer/
 * @date 2020/10/15 4:01 下午
 */
public class RomanToInteger {

    //把可能出现的特殊情况 提前减了，之后扫描做累加就好了
    public int romanToInt(String s) {
        int sum = 0;
        if (s.indexOf("IV") != -1) {
            sum -= 2;
        }
        if (s.indexOf("IX") != -1) {
            sum -= 2;
        }
        if (s.indexOf("XL") != -1) {
            sum -= 20;
        }
        if (s.indexOf("XC") != -1) {
            sum -= 20;
        }
        if (s.indexOf("CD") != -1) {
            sum -= 200;
        }
        if (s.indexOf("CM") != -1) {
            sum -= 200;
        }

        //处理完特殊的了之后，扫描累加
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'I') {
                sum += 1;
            }
            if (array[i] == 'V') {
                sum += 5;
            }
            if (array[i] == 'X') {
                sum += 10;
            }
            if (array[i] == 'L') {
                sum += 50;
            }
            if (array[i] == 'C') {
                sum += 100;
            }
            if (array[i] == 'D') {
                sum += 500;
            }
            if (array[i] == 'M') {
                sum += 1000;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }
}
