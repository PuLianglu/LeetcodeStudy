import java.util.HashMap;

/**
 * @program: LeetcodeStudy
 * @description:赎金信
 * https://leetcode.cn/problems/ransom-note/
 * @author: puLiangLu
 * @create: 2023-06-07 10:26
 **/
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] a = new int[26];

        for (int i = 0; i <magazine.length(); i++) {
            a[magazine.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int x = ransomNote.charAt(i) - 'a';
            if (a[x] < 1){
                return false;
            }else {
                a[x]--;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String ransomNote ="aa";
        String magazine = "aab";

        RansomNote a = new RansomNote();
        boolean b = a.canConstruct(ransomNote,magazine);

        System.out.println("===============");
    }
}
