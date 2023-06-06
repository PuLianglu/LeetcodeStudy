import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetcodeStudy
 * @description: 快乐数,这个题的解法，可以用快慢指针，我直呼好家伙，太绝了
 * https://leetcode.cn/problems/happy-number/
 * @author: puLiangLu
 * @create: 2023-06-06 15:20
 **/
public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> a = new HashSet<>();
        while (n != 1 && !a.contains(n) ){
            a.add(n);
            n = getNumber(n);
        }
        return n==1;
    }

    int getNumber(int n){
        int sum = 0;
        while (n > 0){
            int temp = n % 10 ;
            n = n / 10;
            sum += temp * temp;
        }
        return sum;
    }

    /**
     * 快慢指针做法
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
        int slow = n, fast = n;
        do{
            slow = getNumber(slow);
            fast = getNumber(fast);
            fast = getNumber(fast);
        }while(slow != fast);

        return slow == 1;
    }


}
