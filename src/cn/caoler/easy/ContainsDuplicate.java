package cn.caoler.easy;


import java.util.HashSet;
import java.util.Set;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/contains-duplicate/
 * @date 2020/10/22 2:06 下午
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            boolean add = set.add(num);
            if (!add) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        System.out.println(set.add(1));
        System.out.println(set.add(1));
    }
}
