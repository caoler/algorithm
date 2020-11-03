package cn.caoler.easy;

/**
 * @author keji
 * @desc
 * @date 2020/11/3 1:41 下午
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int sum = Integer.valueOf(a,2) + Integer.valueOf(b,2);
        return Integer.toBinaryString(sum);
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String s = addBinary.addBinary("11", "1");
        System.out.println(s);
    }
}
