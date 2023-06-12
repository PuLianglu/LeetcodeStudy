/**
 * @program: LeetcodeStudy
 * @description: 替换空格
 * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 * @author: puLiangLu
 * @create: 2023-06-08 11:32
 **/
public class ReplaceSpace {

    public String replaceSpace(String s) {
        //先统计空格
        int n = 0;
        for (int i = 0; i < s.length(); i++){
            if (' ' == s.charAt(i)){
                n++;
            }
        }

        char[] str = new char[s.length() + 2 * n];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(i)){
                str[j++] = '%';
                str[j++] = '2';
                str[j++] = '0';
            }else {
                str[j++] = s.charAt(i);
            }
        }

        return String.copyValueOf(str);
    }


    public static void main(String[] args) {
        String s = "We are happy.";
        ReplaceSpace a = new ReplaceSpace();
        a.replaceSpace(s);

        System.out.println("==============");
    }


}
