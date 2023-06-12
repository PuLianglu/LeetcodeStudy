/**
 * @program: LeetcodeStudy
 * @description: 反转字符串II
 * https://leetcode.cn/problems/reverse-string-ii/
 * @author: puLiangLu
 * @create: 2023-06-08 10:40
 **/
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] str = s.toCharArray();
        //轮数
        int n = 0;
        //当前阶段
        int flag = n * 2 * k;
        while (flag < len){
            int l = 0;
            int r = 0;
            l = flag;
            //剩余量
            int surplus = len - 2 * n * k;
            if (k <= surplus){
                //余量大于k时，就能取整段
                r = flag + k -1;
            }else {
                //余量小于k时，就直接取余量
                r = flag + surplus - 1;
            }
            while (l < r){
                char temp = str[l];
                str[l] = str[r];
                str[r] = temp;
                l++;
                r--;
            }
            n++;
            flag = n * 2 * k;
        }

        return String.copyValueOf(str);
    }

    public static void main(String[] args) {
        ReverseStringII a = new ReverseStringII();
        String s = "abcdefg";
        int k = 2;

        a.reverseStr(s,k);

        System.out.println("=================");
    }
}
