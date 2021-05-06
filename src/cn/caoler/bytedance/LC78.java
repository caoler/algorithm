package cn.caoler.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author keji
 * @desc
 * @date 2021/3/28 9:42 上午
 */
public class LC78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //空集是所有集合的子集，先添加进去
        res.add(new ArrayList<>());

        for (int num : nums) {

            //创建一个res的拷贝
            List<List<Integer>> resCp = new ArrayList<>();
            //遍历res里面的所有list
            for (List<Integer> re : res) {

                //拷贝出来
                List<Integer> cpList = new ArrayList<>(re);
                //把当前字符加进去
                cpList.add(num);
                //往拷贝的resCp里面
                resCp.add(cpList);
            }
            res.addAll(resCp);
        }
        return res;
    }
}
