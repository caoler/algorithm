package cn.caoler.bytedance;

/**
 * @author keji
 * @desc
 * @date 2021/3/26 9:35 下午
 */
public class LC176 {

    /**
     * ifnull(a,b)
     *
     * 如果value1不是空，结果返回a
     *
     * 如果value1是空，结果返回b
     */

    /**
     *
        SELECT IFNULL(
            (SELECT DISTINCT salary
            FROM Employee
            ORDER BY Salary DESC
            LIMIT 1,1),NULL
        ) AS SecondHighestSalary
     *
     */
}
