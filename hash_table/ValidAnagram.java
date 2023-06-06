/**
 * @program: LeetcodeStudy
 * @description: 有效的字母异位词
 * https://leetcode.cn/problems/valid-anagram/
 * @author: puLiangLu
 * @create: 2023-06-06 14:19
 **/
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int[] a = new int[26];
        boolean flag = true;

        if (s.length() != t.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
            a[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (a[i] != 0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        String s ="nl";
        String t = "cx";
        validAnagram.isAnagram(s,t);
        System.out.println("======================");
    }
}
