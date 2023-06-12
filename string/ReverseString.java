/**
 * @program: LeetcodeStudy
 * @description: 反转字符串
 * https://leetcode.cn/problems/reverse-string/
 * @author: puLiangLu
 * @create: 2023-06-08 10:35
 **/
public class ReverseString {

    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length -1;
        while (l < r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }


    public static void main(String[] args) {

    }

}
