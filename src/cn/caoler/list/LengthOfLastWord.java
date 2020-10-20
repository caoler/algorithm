package cn.caoler.list;

/**
 * @author keji
 * @desc
 * @date 2020/10/20 2:22 下午
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                if (count == 0) {
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "a ";
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        int i = lengthOfLastWord.lengthOfLastWord(s);
        System.out.println(i    );
    }
}
