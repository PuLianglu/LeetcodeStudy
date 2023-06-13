/**
 * @program: LeetcodeStudy
 * @description: 左旋转字符串
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * @author: puLiangLu
 * @create: 2023-06-12 16:44
 **/
public class ReverseLeftWords {
    public static void main(String[] args) {

    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }


}
