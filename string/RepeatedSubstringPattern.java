/**
 * @program: LeetcodeStudy
 * @description: 重复的子字符串
 * https://leetcode.cn/problems/repeated-substring-pattern/
 * @author: puLiangLu
 * @create: 2023-06-13 10:42
 **/
public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        String str = "ababa";
        RepeatedSubstringPattern a = new RepeatedSubstringPattern();
        boolean b = a.repeatedSubstringPattern(str);

        System.out.println("===============");
    }

    public boolean repeatedSubstringPattern(String s) {
        boolean b = false;
        if (s.length() <= 1){
            return false;
        }
        char a = s.charAt(0);

        StringBuilder stringBuilder = new StringBuilder(s.substring(0,1));
        for (int i = 1; i <= s.length() / 2; ) {
            if (a != s.charAt(i)){
                stringBuilder.append(s.charAt(i));
                i++;
                continue;
            }
            //遇到相同字符了，就可能是重复字符串了,然后就从这里继续往后遍历
            int indexj = 0;
            boolean flag = true;
            while (i < s.length()){
                if (s.charAt(i) != stringBuilder.charAt(indexj)){
                    flag = false;
                    break;
                }
                i++;
                if (indexj == stringBuilder.length() - 1){
                    indexj = 0;
                }else {
                    indexj++;
                }
            }
            if (flag && stringBuilder.length() != s.length() && indexj == 0){
                return true;
            }
            i = stringBuilder.length();
            stringBuilder.append(s.charAt(i));
            i++;
        }
        return b;
    }
}
