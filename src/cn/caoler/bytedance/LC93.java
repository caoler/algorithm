package cn.caoler.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author keji
 * @desc
 * @date 2021/3/24 8:31 下午
 */
public class LC93 {

    //一共四层
    static final int SEG_COUNT = 4;
    //存储最后的结果
    List<String> list = new ArrayList<>();
    //用来存当前层的数字
    int[] seg = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        char[] array = s.toCharArray();
        int len = array.length;
        dfs(array, 0, 0, len);
        return list;
    }

    private void dfs(char[] array, int depth, int start, int len) {
        //IP地址的深度最多为4
        if (depth == SEG_COUNT) {
            StringBuilder sb = new StringBuilder();
            //遍历的长度刚好等于字符串的长度
            if (start == len) {
                for (int i = 0; i < SEG_COUNT; i++) {
                    sb.append(seg[i]);
                    //如果不是最后一个字符  那么拼上.
                    if (i != SEG_COUNT - 1) {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            return;
        }

        //如果还没有找到4短IP地址，就已经遍历完了，那直接返回，提前回溯
        if (start == len) return;

        //如果这一段以0开头，那么这一段就只能是0了
        if (array[start] == '0') {
            //当前层为0
            seg[depth] = 0;
            dfs(array, depth + 1, start + 1, len);
        }

        int tmp = 0;
        for (int i = start; i < len; i++) {
            //算一下当前位置的数字, 因为往后遍历要把前面数字乘10 加上
            tmp = tmp * 10 + (array[i] - '0');
            if (tmp > 0 && tmp < 256) {
                //当前层赋值
                seg[depth] = tmp;
                //下一层 要从i+ 1开始，因为i的位置已经算过了
                dfs(array, depth + 1, i + 1, len);
            } else {
                break;
            }
        }
    }

}
