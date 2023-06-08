import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetcodeStudy
 * @description: 两数之和
 * https://leetcode.cn/problems/two-sum/
 * @author: puLiangLu
 * @create: 2023-06-07 09:15
 **/
public class TwoSum {

    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j){
                    continue;
                }else {
                    if (nums[i] + nums[j] == target){
                        int[] a = new int[2];
                        a[0] = i;
                        a[1] = j;
                        return a;
                    }
                }

            }
        }
        int[] a = new int[2];
        a[0] = 0;
        a[1] = 1;
        return a;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] a = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                a[0] = i;
                a[1] = map.get(target-nums[i]);
            }else {
                map.put(nums[i],i);
            }
        }

        return a;
    }



}
