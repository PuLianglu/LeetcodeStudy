/**
 * @program: LeetcodeStudy
 * @description: 找出字符串中第一个匹配项的下标
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * @author: puLiangLu
 * @create: 2023-06-12 16:56
 **/
public class StrStr {

    public static void main(String[] args) {
        String hastack = "aabaaabaaac";
        String needle = "aabaaac";
        StrStr str = new StrStr();
        int c = str.strStr(hastack,needle);
        System.out.println("==================");
    }

    public int strStr(String haystack, String needle) {

        int i = 0;
        while (i <= haystack.length() - needle.length()){
            //如果needle第一个字母与haystack的某个字母匹配上了，就往后面一直匹配
            if (needle.charAt(0) != haystack.charAt(i)){
                i++;
                continue;
            }

            //记录字母a在haystack中的位置
            int b = i;
            //只记录第一次遇到的更新
            boolean flag = true;
            int indexJ = 0;
            for (;indexJ < needle.length(); indexJ++) {

                if(( i >= haystack.length())
                    ||
                    needle.charAt(indexJ) != haystack.charAt(i)
                ){
                    break;
                }
                //只记录第一次遇到的
                if (indexJ != 0 &&
                    needle.charAt(0) == haystack.charAt(i) &&
                    flag){
                    b = i;
                    flag = false;
                }
                i++;
            }

            if (indexJ == needle.length()){
                return i - needle.length();
            }

            //如果needle的首字母在字符串中遇到过，下次就直接从遇到的地方进行遍历
            if (!flag){
                i = b;
            }
        }
        return -1;
    }


}
